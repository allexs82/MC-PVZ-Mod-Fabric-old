package net.allexs82.pvzmod.entity.projectile.thrown;

import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public abstract class PVZProjectileEntity extends ThrownItemEntity {
    public PVZProjectileEntity(EntityType<? extends PVZProjectileEntity> entityType, World world) {
        super((EntityType<? extends ThrownItemEntity>)entityType, world);
    }

    public PVZProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, double d, double e, double f, World world) {
        super(entityType, d, e, f, world);
    }

    public PVZProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }


    protected SoundEvent getHitSound() {
        return null;
    }

    protected int getDamage() {
        return 0;
    }

    protected void applyEffects(LivingEntity livingEntity){}

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int damage = getDamage();
        if (entityHitResult.getEntity() instanceof PVZPlantEntity || entityHitResult.getEntity() instanceof PlayerEntity || this.getOwner() instanceof PlayerEntity) damage = 0;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), damage);
        if (entity instanceof LivingEntity livingEntity){
            applyEffects(livingEntity);
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult) hitResult;
            Entity entity = entityHitResult.getEntity();
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), getHitSound(), SoundCategory.NEUTRAL, 0.5f, 1.0f);
            if (entity instanceof PVZPlantEntity || entity instanceof PlayerEntity) return;
        }
        if (!this.world.isClient) {
            this.discard();
        }
    }
}
