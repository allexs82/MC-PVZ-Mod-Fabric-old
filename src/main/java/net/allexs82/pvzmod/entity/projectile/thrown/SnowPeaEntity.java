package net.allexs82.pvzmod.entity.projectile.thrown;

import net.allexs82.pvzmod.init.ModEntities;
import net.allexs82.pvzmod.init.ModItems;
import net.allexs82.pvzmod.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class SnowPeaEntity extends PVZProjectileEntity {
    public SnowPeaEntity(EntityType<? extends SnowPeaEntity> entityType, World world) {
        super((EntityType<? extends SnowPeaEntity>) entityType, world);
    }

    public SnowPeaEntity(World world, LivingEntity owner) {
        super((EntityType<? extends ThrownItemEntity>)ModEntities.SNOW_PEA, owner, world);
    }

    public SnowPeaEntity(World world, double x, double y, double z) {
        super((EntityType<? extends ThrownItemEntity>)ModEntities.SNOW_PEA, x, y, z, world);
    }
    protected Item getDefaultItem() {
        return ModItems.SNOW_PEA_ITEM;
    }

    @Override
    protected SoundEvent getHitSound() {
        return ModSounds.ZOMBIE_SPLAT;
    }

    @Override
    protected void applyEffects(LivingEntity livingEntity) {
        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 1));
    }

    @Override
    protected int getDamage() {
        return 2;
    }
}
