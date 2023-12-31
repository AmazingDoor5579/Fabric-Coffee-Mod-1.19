package net.dpcoffee.coffeemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dpcoffee.coffeemod.CoffeeMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class StaffChargerScreen extends HandledScreen<StaffChargerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(CoffeeMod.MOD_ID, "textures/gui/staff_charger_gui.png");

    public StaffChargerScreen(StaffChargerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
        titleY = titleY - 3;
    }

    @Override
    protected void drawBackground(DrawContext drawContext, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = ((width / 2) - (backgroundWidth / 2));
        int y = (height - backgroundHeight) / 2;
        drawContext.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        //drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderBlockCharge(drawContext, x, y);
        renderCurrentCharge(drawContext, x, y);
    }

    private void renderBlockCharge(DrawContext drawContext, int x, int y) {
        drawContext.drawTexture(TEXTURE, x + 68, y + 77, 184, 64, -8, -handler.getScaledProgressBlockCharge());
    }

    private void renderCurrentCharge(DrawContext drawContext, int x, int y) {
        drawContext.drawTexture(TEXTURE, x + 116, y + 77, 192, 64, -8, -handler.getScaledProgressStaffCharge());
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        renderBackground(drawContext);
        super.render(drawContext, mouseX, mouseY, delta);
        drawMouseoverTooltip(drawContext, mouseX, mouseY);
    }
}
