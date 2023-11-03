package net.allexs82.pvzmod.entity.client.armor;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.item.ConeArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ConeArmorModel extends AnimatedGeoModel<ConeArmorItem> {
    @Override
    public Identifier getModelLocation(ConeArmorItem object) {
        return new Identifier(PVZMod.MOD_ID, "geo/cone_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ConeArmorItem object) {
        return new Identifier(PVZMod.MOD_ID, "textures/models/armor/cone_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ConeArmorItem animatable) {
        return new Identifier(PVZMod.MOD_ID, "animations/dummy.animation.json");
    }
}
