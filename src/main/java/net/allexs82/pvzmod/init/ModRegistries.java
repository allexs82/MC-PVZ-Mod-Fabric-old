package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.entity.plant.PeashooterEntity;
import net.allexs82.pvzmod.entity.plant.SunflowerEntity;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerAttributes();
    }

    private static void registerAttributes() {
        //noinspection DataFlowIssue
        FabricDefaultAttributeRegistry.register(ModEntities.BASIC_ZOMBIE, BasicZombieEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PEASHOOTER, PeashooterEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SUNFLOWER, SunflowerEntity.setAttributes());
    }
}
