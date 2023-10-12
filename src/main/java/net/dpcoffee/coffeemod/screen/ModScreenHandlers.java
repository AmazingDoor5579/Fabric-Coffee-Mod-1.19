package net.dpcoffee.coffeemod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<StaffChargerScreenHandler> STAFF_CHARGER_SCREEN_HANDLER;
    public static ScreenHandlerType<ModJetSlotHandler> MOD_JET_SLOT_HANDLER;
    public static ScreenHandlerType<JetPackChargerScreenHandler> JET_PACK_CHARGER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        STAFF_CHARGER_SCREEN_HANDLER = new ScreenHandlerType<>(StaffChargerScreenHandler::new);
        MOD_JET_SLOT_HANDLER = new ScreenHandlerType<>(ModJetSlotHandler::new);
        JET_PACK_CHARGER_SCREEN_HANDLER = new ScreenHandlerType<>(JetPackChargerScreenHandler::new);
    }
}
