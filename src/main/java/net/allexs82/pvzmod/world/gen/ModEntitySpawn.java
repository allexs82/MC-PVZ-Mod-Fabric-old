package net.allexs82.pvzmod.world.gen;

import net.allexs82.pvzmod.init.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.UNDERGROUND,
                        Biome.Category.FOREST, Biome.Category.EXTREME_HILLS), SpawnGroup.MONSTER,
                ModEntities.BASIC_ZOMBIE, 100, 4, 6);

        SpawnRestrictionAccessor.callRegister(ModEntities.BASIC_ZOMBIE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }
}
