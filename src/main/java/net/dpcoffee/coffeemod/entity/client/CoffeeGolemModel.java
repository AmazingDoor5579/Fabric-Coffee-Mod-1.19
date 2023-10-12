package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeGolemEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CoffeeGolemModel extends GeoModel<CoffeeGolemEntity> {
    @Override
    public Identifier getModelResource(CoffeeGolemEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "geo/coffee_golem.geo.json");
    }

    @Override
    public Identifier getTextureResource(CoffeeGolemEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_golem.png");

    }

    @Override
    public Identifier getAnimationResource(CoffeeGolemEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "animations/coffee_golem.animation.json");

    }
}
