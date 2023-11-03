package net.allexs82.pvzmod.entity.projectile.thrown;

import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.allexs82.pvzmod.init.ModEntities;
import net.allexs82.pvzmod.init.ModItems;
import net.allexs82.pvzmod.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class PeaEntity extends ThrownItemEntity {

    public PeaEntity(EntityType<? extends PeaEntity> entityType, World world) {
        super((EntityType<? extends ThrownItemEntity>)entityType, world);
    }

    public PeaEntity(World world, LivingEntity owner) {
        super((EntityType<? extends ThrownItemEntity>)ModEntities.PEA, owner, world);
    }

    public PeaEntity(World world, double x, double y, double z) {
        super((EntityType<? extends ThrownItemEntity>)ModEntities.PEA, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.PEA_ITEM;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int damage = 2;
        if (entityHitResult.getEntity() instanceof PVZPlantEntity || entityHitResult.getEntity() instanceof PlayerEntity || this.getOwner() instanceof PlayerEntity) damage = 0;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), damage);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult) hitResult;
            Entity entity = entityHitResult.getEntity();
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ZOMBIE_SPLAT, SoundCategory.NEUTRAL, 0.5f, 1.0f);
            if (entity instanceof PVZPlantEntity || entity instanceof PlayerEntity) return;
        }
        if (!this.world.isClient) {
            this.discard();
        }
    }
}
