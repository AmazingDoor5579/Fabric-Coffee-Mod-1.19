package net.dpcoffee.coffeemod.screen;

import net.dpcoffee.coffeemod.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class JetPackSlot extends Slot {
    public JetPackSlot(Inventory inventory, int index, int x, int y) {

        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if(stack.getItem() == ModItems.JET_PACK) {
            return super.canInsert(stack);
        } else {
            return false;
        }
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return true;
    }


}
