package net.allexs82.pvzmod.entity.plant;

import net.allexs82.pvzmod.entity.projectile.thrown.PVZProjectileEntity;
import net.allexs82.pvzmod.entity.projectile.thrown.PeaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class PeashooterEntity extends AbstractRangedAttackPlant<PeashooterEntity> {

    @Override
    protected String getIdleAnimName() {
        return "animation.peashooter.idle";
    }

    public PeashooterEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected PVZProjectileEntity creteProjectileEntity() {
        return new PeaEntity(this.world, this);
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
}
