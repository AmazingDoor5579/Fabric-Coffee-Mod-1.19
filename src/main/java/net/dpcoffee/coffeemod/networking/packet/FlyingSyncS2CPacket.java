package net.dpcoffee.coffeemod.networking.packet;

import dev.emi.trinkets.api.TrinketsApi;
import net.dpcoffee.coffeemod.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;

public class FlyingSyncS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        //if((((IPlayerEntityMixin)client.player).getStack() != ItemStack.EMPTY) && (client.player.getVelocity().y < 1.5)) {
        if(TrinketsApi.getTrinketComponent(client.player).get().getEquipped(ModItems.JET_PACK).get(0).getRight() != ItemStack.EMPTY && client.player.getVelocity().y < 1.5) {
            client.player.addVelocity(0, 1, 0);
        }
    }
}
