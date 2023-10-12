package net.dpcoffee.coffeemod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class ModJetInvintory extends SimpleInventory {
    public final int size;
    public ModJetInvintory(int size) {
        this.size = size;
    }
    //public final DefaultedList<ItemStack> jetSlot = DefaultedList.ofSize(1, ItemStack.EMPTY);
}
