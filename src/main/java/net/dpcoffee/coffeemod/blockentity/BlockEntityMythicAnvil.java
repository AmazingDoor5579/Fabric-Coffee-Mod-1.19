package net.dpcoffee.coffeemod.blockentity;

import net.dpcoffee.coffeemod.block.ModBlocks;
import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.screen.MythicAnvilScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class BlockEntityMythicAnvil extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;
    public static final int FUEL_SLOT = 2;

    public BlockEntityMythicAnvil(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOCK_ENTITY_MYTHIC_ANVIL, pos, state);

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //@Override
    //public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
    //buf.writeBlockPos(this.pos);
    //}

    @Override
    public Text getDisplayName() {
        return Text.literal("Mythic Anvil");
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        //Inventories.readNbt(nbt, inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        //Inventories.writeNbt(nbt, inventory);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MythicAnvilScreenHandler(syncId, playerInventory, this);
    }

    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState state, BlockEntityMythicAnvil entity) {
        if (world.isClient) {
            return;
        }

        SimpleInventory inv = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inv.setStack(i, entity.getStack(i));
        }
        markDirty(world, pos, state);
        if (entity.getStack(0).hasNbt() && entity.getStack(1).getItem() == ModItems.INFUSED_DIAMOND) {
            if(entity.getStack(0).getNbt().contains("modifier")) {
                ItemStack stack = entity.getStack(0).copy();
                stack.removeSubNbt("modifier");
                if(stack.getName().getString().startsWith("Weak")) {
                    stack.setCustomName(Text.translatable(stack.getName().getString().substring(5)));
                } else if (stack.getName().getString().startsWith("Strong")) {
                    stack.setCustomName(Text.translatable(stack.getName().getString().substring(7)));
                } else {
                    stack.getName().getString();
                }
                entity.setStack(2, stack);
            }
        }
    }


}
