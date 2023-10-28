package net.allexs82.pvzmod.entity.zombie;

import net.allexs82.pvzmod.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class PVZZombieEntity extends HostileEntity implements Monster {
    public PVZZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean hurtByWater() {
        return true;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ZOMBIE_GROAN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ZOMBIE_SPLAT;
    }

}
