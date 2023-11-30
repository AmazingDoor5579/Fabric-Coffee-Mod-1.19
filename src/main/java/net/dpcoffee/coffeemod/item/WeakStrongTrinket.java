package net.dpcoffee.coffeemod.item;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.Random;

public class WeakStrongTrinket extends TrinketItem {
    Random r = new Random();
    int weak;
    int strong;

    int min;
    int max;

    WeakStrongModifiers modifier = WeakStrongModifiers.NONE;

    public WeakStrongTrinket(Settings settings, int weak, int strong, int minimum_strength, int maximum_strength) {
        super(settings);
        this.weak = weak;
        this.strong = strong;
        this.min = minimum_strength;
        this.max = maximum_strength + 1;

    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(entity instanceof PlayerEntity) {
            ItemStack itemStack = stack;
            String name;
            if(!world.isClient()) {
                if(stack.getName().getString().startsWith("Weak")) {
                    name = stack.getName().getString().substring(5);
                } else if (stack.getName().getString().startsWith("Strong")) {
                    name = stack.getName().getString().substring(7);
                } else {
                    name = stack.getName().getString();
                }

                if((!itemStack.hasNbt() || !itemStack.getNbt().contains("modifier"))) {
                    itemStack.getOrCreateNbt().putInt("modifier", r.nextInt(max - min) + min);
                    if(stack.getNbt().getInt("modifier") <= weak) {
                        modifier = WeakStrongModifiers.WEAK;
                        //stack.setCustomName(Text.translatable("Weak " + name).formatted(Formatting.RESET));
                    } else if(stack.getNbt().getInt("modifier") >= strong) {
                        modifier = WeakStrongModifiers.STRONG;
                        //stack.setCustomName(Text.translatable("Strong " + name).formatted(Formatting.RESET));
                    } else {
                        modifier = WeakStrongModifiers.NONE;
                        //stack.setCustomName(Text.translatable(name).formatted(Formatting.RESET));
                    }
                    stack.setCustomName(Text.translatable(modifier.mod_name + name).formatted(Formatting.RESET));

                }

            }
        }

    }

    public void setWeak(int i) {
        weak = i;
    }

    public int getWeak() {
        return weak;
    }

    public void setStrong(int i) {
        strong = i;
    }

    public int getStrong() {
        return strong;
    }

    public void setMinimumStrength(int i) {
        min = i;
    }

    public int getMinimumStrength() {
        return min;
    }

    public void setMaxStrength(int i) {
        max = i;
    }

    public int getMaximumStrength() {
        return max;
    }
}
