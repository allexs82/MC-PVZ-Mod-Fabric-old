package net.allexs82.pvzmod.entity.client.zombie;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@Environment(EnvType.CLIENT)
public class BasicZombieModel extends BaseZombieModel<BasicZombieEntity> {
    @Override
    public Identifier getModelLocation(BasicZombieEntity object) {
        return new Identifier(PVZMod.MOD_ID, "geo/basic_zombie.geo.json");
    }

    @Override
    public Identifier getTextureLocation(BasicZombieEntity object) {
        return new Identifier(PVZMod.MOD_ID, "textures/entity/basic_zombie/basic_zombie.png");
    }

    @Override
    public Identifier getAnimationFileLocation(BasicZombieEntity animatable) {
        return new Identifier(PVZMod.MOD_ID, "animations/basic_zombie.animation.json");
    }
}
