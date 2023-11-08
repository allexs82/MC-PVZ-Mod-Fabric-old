package net.allexs82.pvzmod;

import net.allexs82.pvzmod.entity.client.armor.ConeArmorRenderer;
import net.allexs82.pvzmod.entity.client.plant.PeashooterRenderer;
import net.allexs82.pvzmod.init.ModEntities;
import net.allexs82.pvzmod.entity.client.zombie.BasicZombieRenderer;
import net.allexs82.pvzmod.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PVZModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BASIC_ZOMBIE, BasicZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.PEASHOOTER, PeashooterRenderer::new);
        EntityRendererRegistry.register(ModEntities.PEA, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNOW_PEA, FlyingItemEntityRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(new ConeArmorRenderer(), ModItems.CONE);
    }
}
