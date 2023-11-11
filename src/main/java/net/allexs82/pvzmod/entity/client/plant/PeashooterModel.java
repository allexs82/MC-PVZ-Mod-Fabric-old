package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.PeashooterEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PeashooterModel extends BasePlantModel<PeashooterEntity> {
    @Override
    public Identifier getModelLocation(PeashooterEntity object) {
        return new Identifier(PVZMod.MOD_ID, "geo/peashooter.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PeashooterEntity object) {
        return new Identifier(PVZMod.MOD_ID, "textures/entity/peashooter/peashooter.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PeashooterEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "animations/peashooter.animation.json");
    }
}
