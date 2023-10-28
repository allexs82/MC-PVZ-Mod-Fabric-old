package net.allexs82.pvzmod.entity.zombie;

import net.allexs82.pvzmod.entity.ai.goal.BasicZombieAttackGoal;
import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

@SuppressWarnings({"SameReturnValue"})
public class BasicZombieEntity extends PVZZombieEntity implements IAnimatable, Monster {

    private static final String walkAnimName = "animation.basic_zombie.walk";
    private static final String idleAnimName = "animation.basic_zombie.idle";

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public BasicZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f);
    }

    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new BasicZombieAttackGoal(this, 1.0, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1));

        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PVZPlantEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<BasicZombieEntity>(this, "controller", 0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<BasicZombieEntity> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(walkAnimName, ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(idleAnimName, ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
