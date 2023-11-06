package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.ChestMimicEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class ChestMimicModel extends GeoModel<ChestMimicEntity> {
    @Override
    public Identifier getModelResource(ChestMimicEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "geo/chest_mimic.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChestMimicEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/chest_mimic.png");
    }

    @Override
    public Identifier getAnimationResource(ChestMimicEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "animations/chest_mimic.animation.json");
    }
}
