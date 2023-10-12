package net.dpcoffee.coffeemod.networking;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.networking.packet.ExampleC2sPacket;
import net.dpcoffee.coffeemod.networking.packet.FlyingC2SPacket;
import net.dpcoffee.coffeemod.networking.packet.FlyingSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier FLYING_ID = new Identifier(CoffeeMod.MOD_ID, "flying");
    public static final Identifier FLYING_SYNC_ID = new Identifier(CoffeeMod.MOD_ID, "flying");
    public static final Identifier EXAMPLE = new Identifier(CoffeeMod.MOD_ID, "example");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE, ExampleC2sPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(FLYING_ID, FlyingC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(FLYING_SYNC_ID, FlyingSyncS2CPacket::receive);
    }
}
