package net.dpcoffee.coffeemod.entity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketsApi;
import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.item.JetPackItem;
import net.dpcoffee.coffeemod.item.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JetPackChargeOverlay implements HudRenderCallback {
    private static final Identifier CHARGE_FULL = new Identifier(CoffeeMod.MOD_ID, "textures/jetpack/jetpack_meter_center.png");
    private static final Identifier CHARGE_FULL_LEFT = new Identifier(CoffeeMod.MOD_ID, "textures/jetpack/jetpack_meter_left.png");
    private static final Identifier CHARGE_FULL_RIGHT = new Identifier(CoffeeMod.MOD_ID, "textures/jetpack/jetpack_meter_right.png");
    private final int offset = 92;
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width/2;
            y = height;
        }

        //ItemStack stack  = ((IPlayerEntityMixin)MinecraftClient.getInstance().player).getStack();
        ItemStack stack = ItemStack.EMPTY;
        if(TrinketsApi.getTrinketComponent(client.player).get().isEquipped(ModItems.JET_PACK)) {
            stack = TrinketsApi.getTrinketComponent(client.player).get().getEquipped(ModItems.JET_PACK).get(0).getRight();
        }
        for(int i = 0; i < 10; i++) {
            if(stack.getItem() instanceof JetPackItem) {
                if(stack.hasNbt()) {

                    if ((Math.ceil(stack.getNbt().getInt("fuel")/ 500) >= i) && stack.getNbt().getInt("fuel") != 0) {
                        if (i == 9) {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL_RIGHT);
                            drawContext.drawTexture(CHARGE_FULL_RIGHT, x + offset + (i * 9), y - 5, 0, 0, 12, 4, 12, 4);
                        } else if(i == 0) {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL_LEFT);
                            drawContext.drawTexture(CHARGE_FULL_LEFT, x + offset + (i * 9), y - 5, 0, 0, 12, 4, 12, 4);

                        } else {
                            RenderSystem.setShaderTexture(0, CHARGE_FULL);
                            drawContext.drawTexture(CHARGE_FULL, x + offset + (i * 9), y - 5, 0, 0, 12, 4, 12, 4);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
