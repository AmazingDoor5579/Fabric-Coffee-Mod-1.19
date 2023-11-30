package net.dpcoffee.coffeemod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<StaffChargerScreenHandler> STAFF_CHARGER_SCREEN_HANDLER;
    public static ScreenHandlerType<ModJetSlotHandler> MOD_JET_SLOT_HANDLER;
    public static ScreenHandlerType<JetPackChargerScreenHandler> JET_PACK_CHARGER_SCREEN_HANDLER;
    public static ScreenHandlerType<MythicAnvilScreenHandler> MYTHIC_ANVIL_SCREEN_HANLDER;

    public static void registerAllScreenHandlers() {
        STAFF_CHARGER_SCREEN_HANDLER = new ScreenHandlerType<>(StaffChargerScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        MOD_JET_SLOT_HANDLER = new ScreenHandlerType<>(ModJetSlotHandler::new, FeatureFlags.VANILLA_FEATURES);
        JET_PACK_CHARGER_SCREEN_HANDLER = new ScreenHandlerType<>(JetPackChargerScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        MYTHIC_ANVIL_SCREEN_HANLDER = new ScreenHandlerType<>(MythicAnvilScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
    }
}
