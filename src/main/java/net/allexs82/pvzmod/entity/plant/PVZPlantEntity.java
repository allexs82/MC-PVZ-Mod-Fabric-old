package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.util.PlantType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class PVZPlantEntity extends MobEntity {

    protected final PlantType plantType;


    protected PVZPlantEntity(EntityType<? extends MobEntity> entityType, World world, PlantType plantType) {
        super(entityType, world);
        this.plantType = plantType;
    }

    public PVZPlantEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        this.plantType = PlantType.DEFAULT;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    @Override
    public void addVelocity(double deltaX, double deltaY, double deltaZ) {}

    @Override
    protected boolean shouldDropXp() {
        return false;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        Entity attacker = source.getAttacker();
        return !(attacker instanceof PlayerEntity || attacker instanceof PVZPlantEntity) && super.damage(source, amount);
    }

    @Override
    protected void tickCramming() {
        List<Entity> list = this.world.getOtherEntities(this, this.getBoundingBox(), EntityPredicates.canBePushedBy(this));
        if (!list.isEmpty()) {
            int j;
            int i = this.world.getGameRules().getInt(GameRules.MAX_ENTITY_CRAMMING);
            for (Entity value : list) {
                if (value instanceof PVZPlantEntity) {
                    i = 1;
                    if (((PVZPlantEntity) value).plantType == PlantType.PROTECTING) i = 2;
                    break;
                }
            }
            if (i > 0 && list.size() > i - 1 && this.random.nextInt(4) == 0) {
                j = 0;
                for (Entity entity : list) {
                    if (entity.hasVehicle()) continue;
                    ++j;
                }
                if (j > i - 1) {
                    this.damage(DamageSource.CRAMMING, 6.0f);
                }
            }
            for (j = 0; j < list.size(); ++j) {
                Entity entity = list.get(j);
                this.pushAway(entity);
            }
        }
    }
}
