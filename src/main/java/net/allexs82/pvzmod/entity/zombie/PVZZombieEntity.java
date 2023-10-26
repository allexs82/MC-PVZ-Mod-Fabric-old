package net.allexs82.pvzmod.entity.zombie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.world.World;

public abstract class PVZZombieEntity extends HostileEntity implements Monster {
    public PVZZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


}
