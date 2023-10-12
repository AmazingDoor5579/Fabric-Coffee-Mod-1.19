package net.dpcoffee.coffeemod.entity.layers;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.CoffeeSpiderEntity;
import net.dpcoffee.coffeemod.item.Coffee;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CoffeeSpiderEyeLayer extends GeoRenderLayer<CoffeeSpiderEntity> {

    private static final Identifier TEXTURE = new Identifier(GeckoLib.MOD_ID, "textures/entity/cool_kid_glasses.png");

    public CoffeeSpiderEyeLayer(GeoRenderer<CoffeeSpiderEntity> entityRendererIn) {super(entityRendererIn);}

    @Override
    public void render(MatrixStack poseStack, CoffeeSpiderEntity animatable, BakedGeoModel bakedModel, RenderLayer renderType, VertexConsumerProvider bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderLayer armorRenderType = RenderLayer.getArmorCutoutNoCull(TEXTURE);

        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.DEFAULT_UV,
                1, 1, 1, 1);
    }
}
