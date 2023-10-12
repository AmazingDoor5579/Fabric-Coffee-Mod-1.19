package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeSpiderEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CoffeeSpiderModel extends GeoModel<CoffeeSpiderEntity> {

    @Override
    public Identifier getModelResource(CoffeeSpiderEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "geo/coffee_spider.geo.json");
    }

    @Override
    public Identifier getTextureResource(CoffeeSpiderEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_spider.png");
    }


    @Override
    public Identifier getAnimationResource(CoffeeSpiderEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "animations/coffee_spider.animation.json");
    }
}
