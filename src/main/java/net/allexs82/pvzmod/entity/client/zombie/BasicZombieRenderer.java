package net.allexs82.pvzmod.entity.client.zombie;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class BasicZombieRenderer extends GeoEntityRenderer<BasicZombieEntity> {
    public BasicZombieRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new BasicZombieModel());
    }

    @Override
    public Identifier getTextureLocation(BasicZombieEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "textures/entity/basic_zombie/basic_zombie.png");
    }
}
