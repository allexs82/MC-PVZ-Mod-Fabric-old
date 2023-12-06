package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.entity.projectile.thrown.PVZProjectileEntity;
import net.allexs82.pvzmod.entity.zombie.PVZZombieEntity;
import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.util.EPlantType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public abstract class AbstractRangedAttackPlant<E extends AbstractRangedAttackPlant<?>> extends PVZPlantEntity<E> implements RangedAttackMob {
    public AbstractRangedAttackPlant(EntityType<? extends MobEntity> entityType, World world, EPlantType EPlantType) {
        super(entityType, world, EPlantType);
    }

    public AbstractRangedAttackPlant(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new ProjectileAttackGoal(this, 0, 20, 10.0f));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));

        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PVZZombieEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, MobEntity.class,
                10, true, false, entity -> entity instanceof Monster));
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        EntityNavigation entityNavigation = super.createNavigation(world);
        entityNavigation.setRangeMultiplier(0);
        return entityNavigation;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        PVZProjectileEntity projectileEntity = creteProjectileEntity();
        double d = target.getEyeY() - 2.0D;
        double e = target.getX() - this.getX();
        double f = d - projectileEntity.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * 0.2D;
        projectileEntity.setVelocity(e, f + h, g, 1.6f, 1.0f);
        this.playSound(ModSounds.PROJECTILE_THROW, 0.5f, 1.0f);
        this.world.spawnEntity(projectileEntity);
    }

    protected abstract PVZProjectileEntity creteProjectileEntity();
}
