package net.dpcoffee.coffeemod.entity.client;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.ChestMimicEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChestMimicRenderer extends GeoEntityRenderer<ChestMimicEntity> {
    public ChestMimicRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new ChestMimicModel());
    }

    @Override
    public Identifier getTextureLocation(ChestMimicEntity animatable) {
        return new Identifier(CoffeeMod.MOD_ID, "textures/entity/chest_mimic.png");
    }

    @Override
    public RenderLayer getRenderType(ChestMimicEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
