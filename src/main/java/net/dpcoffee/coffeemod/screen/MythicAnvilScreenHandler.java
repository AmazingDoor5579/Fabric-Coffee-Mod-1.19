package net.dpcoffee.coffeemod.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class MythicAnvilScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    //private final BlockEntityMythicAnvil blockEntity;

    public MythicAnvilScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    public MythicAnvilScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.MYTHIC_ANVIL_SCREEN_HANLDER, syncId);
        checkSize(inventory, 3);
        this.inventory = inventory;
        playerInventory.onOpen(playerInventory.player);
        //this.blockEntity = (BlockEntityMythicAnvil) blockEntity;


        this.addSlot(new Slot(inventory, 0, 27, 47));
        this.addSlot(new Slot(inventory, 1, 76, 47));
        this.addSlot(new Slot(inventory, 2, 134, 47) {
            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                super.onTakeItem(player, stack);
                inventory.setStack(0, ItemStack.EMPTY);
                inventory.setStack(1, new ItemStack(inventory.getStack(1).copy().getItem(), inventory.getStack(1).getCount() - 1));
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
