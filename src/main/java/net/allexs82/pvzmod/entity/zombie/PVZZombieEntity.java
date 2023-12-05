package net.allexs82.pvzmod.entity.zombie;

import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.util.EAnimType;
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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

import javax.annotation.Nullable;

public abstract class PVZZombieEntity<E extends PVZZombieEntity<?> & IAnimatable> extends HostileEntity implements Monster, IAnimatable {
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
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<E>((E)this, "controller", 0, this::predicate));
    }

    private <T extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation(getAnimName(EAnimType.walk), ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation(getAnimName(EAnimType.idle), ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    protected abstract String getAnimName(EAnimType AnimType);

}
