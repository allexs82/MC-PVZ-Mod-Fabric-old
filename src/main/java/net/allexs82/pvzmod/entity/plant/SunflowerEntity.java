package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.init.ModItems;
import net.allexs82.pvzmod.util.PlantType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SunflowerEntity extends PVZPlantEntity implements IAnimatable {

    private static final String idleAnimName = "animation.sunflower.idle";

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

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<SunflowerEntity> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation(idleAnimName, ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<SunflowerEntity>(this,
                "controller", 0, this::predicate));
    }

    @Override
    public void tick() {
        super.tick();
        entityTick++;
        if (entityTick >= 4800 && world.isDay()){
            entityTick = -1;
            ItemStack itemStack = new ItemStack(ModItems.SUN);
            ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), itemStack);
            //TODO: Add sound
            world.spawnEntity(itemEntity);
            world.emitGameEvent((Entity) null, GameEvent.ENTITY_PLACE, this.getBlockPos());
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
