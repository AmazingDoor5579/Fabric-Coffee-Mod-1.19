package net.dpcoffee.coffeemod.entity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class ModInventoryScreen extends InventoryScreen {
    public ModInventoryScreen(PlayerEntity player) {
        super(player);
    }


    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {

    }
}
