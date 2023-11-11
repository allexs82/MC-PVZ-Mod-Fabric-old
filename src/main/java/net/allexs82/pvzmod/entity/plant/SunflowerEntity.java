package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SunflowerEntity extends PVZPlantEntity<SunflowerEntity> implements IAnimatable {

    @Override
    protected String getIdleAnimName() {
        return "animation.sunflower.idle";
    }

    private int entityTick = -1;

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public SunflowerEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
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
        entityTick++;
        if (entityTick >= 4800 && world.isDay()){
            entityTick = -1;
            ItemStack itemStack = new ItemStack(ModItems.SUN);
            ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), itemStack);
            //TODO: Add sound
            world.spawnEntity(itemEntity);
            world.emitGameEvent(null, GameEvent.ENTITY_PLACE, this.getBlockPos());
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
