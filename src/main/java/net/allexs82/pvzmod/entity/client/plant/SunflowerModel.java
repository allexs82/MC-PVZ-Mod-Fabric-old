package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.SunflowerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SunflowerModel extends AnimatedGeoModel<SunflowerEntity> {
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

    @Override
    @SuppressWarnings({"unchecked"})
    public void setCustomAnimations(SunflowerEntity entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
