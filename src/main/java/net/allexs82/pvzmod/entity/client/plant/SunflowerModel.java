package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.SunflowerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@Environment(EnvType.CLIENT)
public class SunflowerModel extends BasePlantModel<SunflowerEntity> {
    @Override
    public Identifier getModelLocation(SunflowerEntity object) {
        return new Identifier(PVZMod.MOD_ID, "geo/sunflower.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SunflowerEntity object) {
        return new Identifier(PVZMod.MOD_ID, "texture/entity/sunflower/sunflower.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SunflowerEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "animations/sunflower.animation.json");
    }
    protected SunflowerModel(){
        super(false);
    }
}
