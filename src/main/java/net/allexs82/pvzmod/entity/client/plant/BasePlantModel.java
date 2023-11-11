package net.allexs82.pvzmod.entity.client.plant;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

@Environment(EnvType.CLIENT)
@SuppressWarnings("DuplicatedCode")
public abstract class BasePlantModel<E extends IAnimatable> extends AnimatedGeoModel<E> {

    private final boolean rotateHead;

    protected BasePlantModel(){
        rotateHead = true;
    }

    protected BasePlantModel(boolean rotateHead){
        this.rotateHead = rotateHead;
    }
    @Override
    @SuppressWarnings({"unchecked"})
    public void setCustomAnimations(E entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null && rotateHead) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
