package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SunflowerEntity extends PVZPlantEntity<SunflowerEntity> implements IAnimatable {

    @Override
    protected String getIdleAnimName() {
        return "animation.sunflower.idle";
    }

    private int sunDropTime;

    private static final String NBT_KEY = "sunDropTime";

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public SunflowerEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        sunDropTime = this.getRandom().nextInt(3600) + 3600;
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new LookAroundGoal(this));
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        if (!this.getWorld().isClient() && this.getWorld().isDay() && --this.sunDropTime <= 0) {
            // TODO: Add sounds
            this.dropItem(ModItems.SUN);
            sunDropTime = this.getRandom().nextInt(3600) + 3600;
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt(NBT_KEY, sunDropTime);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains(NBT_KEY)){
            sunDropTime = nbt.getInt(NBT_KEY);
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
