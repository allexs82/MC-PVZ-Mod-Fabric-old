package net.allexs82.pvzmod.entity.client.armor;

import net.allexs82.pvzmod.item.ConeArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ConeArmorRenderer extends GeoArmorRenderer<ConeArmorItem> {
    public ConeArmorRenderer() {
        super(new ConeArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
