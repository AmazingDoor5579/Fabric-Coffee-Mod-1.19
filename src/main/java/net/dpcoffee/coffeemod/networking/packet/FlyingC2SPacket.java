package net.dpcoffee.coffeemod.networking.packet;

import dev.emi.trinkets.api.TrinketsApi;
import net.dpcoffee.coffeemod.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class FlyingC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ItemStack stack = TrinketsApi.getTrinketComponent(player).get().getEquipped(ModItems.JET_PACK).get(0).getRight();
        //ItemStack stack = ((ILivingEntityMixin)player).getStack();

        if((stack != ItemStack.EMPTY) && (player.getVelocity().y < 1.5)) {
            stack.getNbt().putInt("fuel", stack.getNbt().getInt("fuel") - 1);
        }
    }
}
