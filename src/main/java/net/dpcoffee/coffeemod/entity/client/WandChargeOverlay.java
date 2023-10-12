package net.dpcoffee.coffeemod.entity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketsApi;
import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.item.FireWand;
import net.dpcoffee.coffeemod.item.JetPackItem;
import net.dpcoffee.coffeemod.item.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class WandChargeOverlay implements HudRenderCallback {
    private static final Identifier CHARGE_FULL = new Identifier(CoffeeMod.MOD_ID, "textures/wand/wand_meter_center.png");
    private static final Identifier CHARGE_FULL_LEFT = new Identifier(CoffeeMod.MOD_ID, "textures/wand/wand_meter_left.png");
    private static final Identifier CHARGE_FULL_RIGHT = new Identifier(CoffeeMod.MOD_ID, "textures/wand/wand_meter_right.png");
    private final int offset = 92;
    private int yOffset = 5;


    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width/2;
            y = height;
        }
        //if(((IPlayerEntityMixin)MinecraftClient.getInstance().player).getStack().getItem() instanceof JetPack) {
        if(TrinketsApi.getTrinketComponent(client.player).get().isEquipped(ModItems.JET_PACK)) {
        //if(((ILivingEntityMixin)MinecraftClient.getInstance().player).getStack().getItem() instanceof JetPack) {
            this.yOffset = 10;
        } else {
            this.yOffset = 5;
        }

        ItemStack stack  = MinecraftClient.getInstance().player.getStackInHand(MinecraftClient.getInstance().player.getActiveHand());
        for(int i = 0; i < 10; i++) {
            if(stack.getItem() instanceof FireWand) {
                if(stack.hasNbt()) {
                    if ((Math.ceil(stack.getNbt().getInt("charge")/ 10) >= i) && stack.getNbt().getInt("charge") != 0) {
                        if (i == 9) {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL_RIGHT);
                            DrawableHelper.drawTexture(matrixStack, x + offset + (i * 9), y - yOffset, 0, 0, 12, 4, 12, 4);
                        } else if(i == 0) {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL_LEFT);
                            DrawableHelper.drawTexture(matrixStack, x + offset + (i * 9), y - yOffset, 0, 0, 12, 4, 12, 4);

                        } else {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL);
                            DrawableHelper.drawTexture(matrixStack, x + offset + (i * 9), y - yOffset, 0, 0, 12, 4, 12, 4);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
