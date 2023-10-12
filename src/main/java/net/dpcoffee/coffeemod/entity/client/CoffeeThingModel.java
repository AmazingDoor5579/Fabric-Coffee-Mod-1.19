package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeThingEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CoffeeThingModel extends GeoModel<CoffeeThingEntity> {
    @Override
    public Identifier getModelResource(CoffeeThingEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "geo/coffee_thing.geo.json");
    }

    @Override
    public Identifier getTextureResource(CoffeeThingEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_thing.png");
    }

    @Override
    public Identifier getAnimationResource(CoffeeThingEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "animations/coffee_thing.animation.json");
    }
}
