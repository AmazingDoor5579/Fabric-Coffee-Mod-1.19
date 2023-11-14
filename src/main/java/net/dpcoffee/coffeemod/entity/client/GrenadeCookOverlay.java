package net.dpcoffee.coffeemod.entity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.client.option.GrenadeIndicator;
import net.dpcoffee.coffeemod.item.GrenadeItem;
import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.util.IGameOptionsMixin;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
//import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import software.bernie.shadowed.eliotlash.mclib.math.functions.limit.Min;

public class GrenadeCookOverlay implements HudRenderCallback {
    private final int offset = 7;
    private int yOffset = 5;
    private static final Identifier COOK = new Identifier(CoffeeMod.MOD_ID, "textures/grenade/grenade_indicator.png");


    private static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height =  client.getWindow().getScaledHeight();

            x = width/2;
            y = height / 2;
        }
        ItemStack stack = client.player.getInventory().getMainHandStack();
        if(!stack.isOf(ModItems.GRENADE_ITEM)){return;}
        if(client.player.getItemUseTime() > 0) {
            if(((IGameOptionsMixin)MinecraftClient.getInstance().options).getGrenadeIndicator().getValue() == GrenadeIndicator.CROSSHAIR) {
                RenderSystem.setShaderTexture(0, COOK);
                if(100 - client.player.getItemUseTime() < 40) {
                    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, clamp((float) Math.sin((client.player.getItemUseTime()) / 1f) + 0.75f, 0.5f, 1f));
                }
                drawContext.drawTexture(COOK, x + offset, y + yOffset, 0, 10, -2, (-(stack.getMaxUseTime() - client.player.getItemUseTime()) / 10) - 1, 2, 10);

                //DrawableHelper.drawTexture(matrixStack, x + offset + (i * 9), y - yOffset, 192, 64, -8, -100, 12, 4);
            }
        }
    }
}
