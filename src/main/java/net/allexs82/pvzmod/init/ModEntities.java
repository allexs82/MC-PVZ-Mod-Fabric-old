package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.PeashooterEntity;
import net.allexs82.pvzmod.entity.projectile.thrown.PeaEntity;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BasicZombieEntity> BASIC_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(PVZMod.MOD_ID, "basic_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BasicZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());

    public static final EntityType<PeashooterEntity> PEASHOOTER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(PVZMod.MOD_ID, "peashooter"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, PeashooterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.0f)).build());
    public static final EntityType<PeaEntity> PEA = Registry.register(Registry.ENTITY_TYPE, new Identifier(PVZMod.MOD_ID, "pea"),
            FabricEntityTypeBuilder.<PeaEntity>create(SpawnGroup.MISC, PeaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());
}
