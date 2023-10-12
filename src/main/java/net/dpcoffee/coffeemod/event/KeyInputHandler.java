package net.dpcoffee.coffeemod.event;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.networking.ModPackets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Optional;

public class KeyInputHandler {

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(client.options.jumpKey.isPressed()) {
                //if((((IPlayerEntityMixin)client.player).getStack() != ItemStack.EMPTY)) {
                Optional<TrinketComponent> t = TrinketsApi.getTrinketComponent(client.player);
                if(t.get().isEquipped(ModItems.JET_PACK)) {
                //if((((ILivingEntityMixin)client.player).getStack() != ItemStack.EMPTY)) {
                    ItemStack stack = t.get().getEquipped(ModItems.JET_PACK).get(0).getRight();
                    if(t.get().getEquipped(ModItems.JET_PACK).get(0).getRight().getNbt().getInt("fuel") > 0) {
                    //if(((IPlayerEntityMixin)client.player).getStack().getNbt().getInt("fuel") > 0) {
                    //if(((ILivingEntityMixin)client.player).getStack().getNbt().getInt("fuel") > 0) {
                        if (client.player.getVelocity().y < 0) {
                            client.player.addVelocity(0, 0.3, 0);
                            makeJetPretty(client);
                        } else {
                            client.player.addVelocity(0, 0.13, 0);
                            makeJetPretty(client);

                            if (client.player.getVelocity().y > 1.5) {
                                client.player.setVelocity(client.player.getVelocity().x, 1.5f, client.player.getVelocity().z);
                            }
                        }
                    }
                }
                //ClientPlayNetworking.send(ModPackets.FLYING_ID, PacketByteBufs.create());
                //ClientPlayNetworking.send(ModPackets.FLYING_SYNC_ID, PacketByteBufs.create());
            }
        });
    }
    private static void makeJetPretty(MinecraftClient client) {
        client.player.getWorld().playSound(null, client.player.getBlockPos(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.4f, 1.0f);
        client.player.playSound(SoundEvents.BLOCK_LAVA_EXTINGUISH, 0.4f, 1);
        client.player.getWorld().addParticle(ParticleTypes.POOF, client.player.getX(), client.player.getY(), client.player.getZ(), 0.0D, 0.2D, 0.0D);
        client.player.airStrafingSpeed = 0.1f;
        ClientPlayNetworking.send(ModPackets.FLYING_ID, PacketByteBufs.create());

    }
}
