package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.SunflowerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class SunflowerRenderer extends GeoEntityRenderer<SunflowerEntity> {
    public SunflowerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SunflowerModel());
    }

    @Override
    public Identifier getTextureLocation(SunflowerEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "textures/entity/sunflower/sunflower.png");
    }
}
