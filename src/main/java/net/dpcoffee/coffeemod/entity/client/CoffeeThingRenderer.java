package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeThingEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CoffeeThingRenderer extends GeoEntityRenderer<CoffeeThingEntity> {
    public CoffeeThingRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CoffeeThingModel());
        this.shadowRadius = 0.4f;
    }


    public Identifier getTexture(CoffeeThingEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_thing.png");
    }

    @Override
    public RenderLayer getRenderType(CoffeeThingEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
