package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeGolemEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CoffeeGolemRenderer extends GeoEntityRenderer<CoffeeGolemEntity> {
    public CoffeeGolemRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CoffeeGolemModel());
        this.shadowRadius = 2.0f;
    }

    public Identifier getTexture(CoffeeGolemEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/coffee_golem.png");
    }

    @Override
    public RenderLayer getRenderType(CoffeeGolemEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
