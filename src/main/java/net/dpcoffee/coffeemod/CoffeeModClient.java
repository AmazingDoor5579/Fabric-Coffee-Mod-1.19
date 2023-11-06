package net.dpcoffee.coffeemod;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.dpcoffee.coffeemod.block.ModBlocks;

import net.dpcoffee.coffeemod.entity.ModEntities;
import net.dpcoffee.coffeemod.entity.client.*;
import net.dpcoffee.coffeemod.entity.inventory.JetPackEntityRenderer;
import net.dpcoffee.coffeemod.entity.projectile.GrenadeEntity;
import net.dpcoffee.coffeemod.event.KeyInputHandler;
import net.dpcoffee.coffeemod.item.JetPackItem;
import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.networking.ModPackets;
import net.dpcoffee.coffeemod.screen.JetPackChargerScreen;
import net.dpcoffee.coffeemod.screen.ModScreenHandlers;
import net.dpcoffee.coffeemod.screen.StaffChargerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class CoffeeModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.Q_RAG, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STAFF_HOLDER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COFFEE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STAFF_HOLDER, RenderLayer.getTranslucent());
        TrinketRendererRegistry.registerRenderer(ModItems.JET_PACK, new JetPackEntityRenderer());

        EntityRendererRegistry.register(ModEntities.COFFEE_THING, CoffeeThingRenderer::new);
        EntityRendererRegistry.register(ModEntities.COFFEE_GOLEM, CoffeeGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.COFFEE_SPIDER, CoffeeSpiderRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHEST_MIMIC, ChestMimicRenderer::new);


        EntityRendererRegistry.register(ModEntities.FIRE_PROJECTILE, (context) -> new FlyingItemEntityRenderer<>(context));
        EntityRendererRegistry.register(ModEntities.GRENADE_ENTITY, (context) -> new FlyingItemEntityRenderer<>(context));

        HudRenderCallback.EVENT.register(new WandChargeOverlay());
        HudRenderCallback.EVENT.register(new JetPackChargeOverlay());
        HudRenderCallback.EVENT.register(new GrenadeCookOverlay());

        HandledScreens.register(ModScreenHandlers.STAFF_CHARGER_SCREEN_HANDLER, StaffChargerScreen::new);
        HandledScreens.register(ModScreenHandlers.JET_PACK_CHARGER_SCREEN_HANDLER, JetPackChargerScreen::new);
        KeyInputHandler.registerKeyInputs();
        ModPackets.registerC2SPackets();

    }
}
