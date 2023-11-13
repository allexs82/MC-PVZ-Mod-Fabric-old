package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.entity.projectile.thrown.PeaEntity;
import net.allexs82.pvzmod.entity.zombie.PVZZombieEntity;
import net.allexs82.pvzmod.init.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
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

public class PeashooterEntity extends PVZPlantEntity<PeashooterEntity> implements IAnimatable, RangedAttackMob {

    @Override
    protected String getIdleAnimName(){
       return "animation.peashooter.idle";
    }

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public PeashooterEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }


    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    protected void initGoals(){
        this.goalSelector.add(0, new ProjectileAttackGoal(this, 0, 20, 10.0f));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));

        this.targetSelector.add(0, new ActiveTargetGoal<PVZZombieEntity>(this, PVZZombieEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<MobEntity>(this, MobEntity.class,
                10, true, false, entity -> entity instanceof Monster));
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        EntityNavigation entityNavigation = super.createNavigation(world);
        entityNavigation.setRangeMultiplier(0);
        return entityNavigation;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        PeaEntity peaEntity = new PeaEntity(this.world, this);
        double d = target.getEyeY() - 2.0D;
        double e = target.getX() - this.getX();
        double f = d - peaEntity.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * (double)0.2f;
        peaEntity.setVelocity(e, f + h, g, 1.6f, 1.0f);
        this.playSound(ModSounds.PROJECTILE_THROW, 0.5f, 1.0f);
        this.world.spawnEntity(peaEntity);
    }
}
