package net.allexs82.pvzmod.entity.client.plant;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.plant.PeashooterEntity;
import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PeashooterModel extends AnimatedGeoModel<PeashooterEntity> {
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
    @Override
    @SuppressWarnings({"unchecked"})
    public void setCustomAnimations(PeashooterEntity entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
