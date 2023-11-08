package net.dpcoffee.coffeemod.entity.inventory;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.dpcoffee.coffeemod.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;

public class HealthRingEntityRightRenderer implements TrinketRenderer {
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack itemStack = new ItemStack(ModItems.HEALTH_BRACELET);

        if(slotReference.inventory().getSlotType().getGroup().equals("hand")) {
            System.out.println("hand");
            TrinketRenderer.translateToLeftArm(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity);
            matrices.multiply(new Quaternionf(new AxisAngle4f(-90f * (3.141592f / 180f), 1f, 0f, 0f)));
            matrices.scale(0.4f, 0.4f, 0.4f);
            matrices.translate(-0.0F, 0.0F, -0.4F);
            itemRenderer.renderItem(entity, itemStack, ModelTransformation.Mode.FIXED, false, matrices, vertexConsumers, entity.world, light, OverlayTexture.DEFAULT_UV, 0);
        } else if(slotReference.inventory().getSlotType().getGroup().equals("offhand")) {
            System.out.println("offhand");
            TrinketRenderer.translateToRightArm(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity);
            matrices.multiply(new Quaternionf(new AxisAngle4f(-90f * (3.141592f / 180f), 1f, 0f, 0f)));
            matrices.scale(0.4f, 0.4f, 0.4f);
            matrices.translate(0.0F, 0.0F, -0.4F);
            itemRenderer.renderItem(entity, itemStack, ModelTransformation.Mode.FIXED, false, matrices, vertexConsumers, entity.world, light, OverlayTexture.DEFAULT_UV, 0);
        }
    }
}

