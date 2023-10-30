package net.allexs82.pvzmod.entity.zombie;

import net.allexs82.pvzmod.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class PVZZombieEntity extends HostileEntity implements Monster {
    public PVZZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
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

    @Nullable
    protected SoundEvent getKillSound(){
        return ModSounds.GULP;
    }

    protected SoundEvent getAttackSound(){
        return ModSounds.ZOMBIE_CHOMP;
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (!this.world.isClient() && ((LivingEntity) target).getHealth() >= this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)){
            this.world.playSound(null, this.getX(), this.getY(), this.getZ(), this.getAttackSound(),
                    SoundCategory.HOSTILE, 0.5f, 1.0f);
        }
        return super.tryAttack(target);
    }

    @Override
    public void onKilledOther(ServerWorld world, LivingEntity other) {
        world.playSound(null, this.getX(), this.getY(), this.getZ(), this.getKillSound(), SoundCategory.HOSTILE, 0.5f, 1.0f);
        super.onKilledOther(world, other);
    }
}
