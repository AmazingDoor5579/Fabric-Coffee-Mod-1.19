package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeGolemEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeSpiderEntity;
import net.dpcoffee.coffeemod.entity.layers.CoffeeSpiderEyeLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.EndermanEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import software.bernie.example.client.renderer.entity.layer.CoolKidGlassesLayer;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CoffeeSpiderRenderer extends GeoEntityRenderer<CoffeeSpiderEntity> {

    public CoffeeSpiderRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CoffeeSpiderModel());

        this.shadowRadius = 1.3f;

        //addRenderLayer(new CoffeeSpiderEyeLayer(this));
    }

    public Identifier getTexture(CoffeeSpiderEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_spider.png");
    }


    @Override
    public RenderLayer getRenderType(CoffeeSpiderEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
