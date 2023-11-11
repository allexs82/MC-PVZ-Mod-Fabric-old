package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.client.zombie.BasicZombieModel;
import net.allexs82.pvzmod.entity.plant.PeashooterEntity;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@Environment(EnvType.CLIENT)
public class PeashooterRenderer extends GeoEntityRenderer<PeashooterEntity> {
    public PeashooterRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PeashooterModel());
    }

    @Override
    public Identifier getTextureLocation(PeashooterEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "textures/entity/peashooter/peashooter.png");
    }
}
