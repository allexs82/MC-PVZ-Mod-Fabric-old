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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class PeaEntity extends PVZProjectileEntity {

    public PeaEntity(EntityType<? extends PeaEntity> entityType, World world) {
        super((EntityType<? extends PeaEntity>) entityType, world);
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
    protected SoundEvent getHitSound() {
        return ModSounds.ZOMBIE_SPLAT;
    }

    @Override
    protected int getDamage() {
        return 2;
    }
}
