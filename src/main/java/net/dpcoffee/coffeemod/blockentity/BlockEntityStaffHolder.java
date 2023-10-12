package net.dpcoffee.coffeemod.blockentity;

import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.screen.StaffChargerScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.dpcoffee.coffeemod.block.BlockStaffHolder.CHARGING;
import static net.dpcoffee.coffeemod.block.BlockStaffHolder.STAFF;

public class BlockEntityStaffHolder extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private static int charge_time;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 75;
    //1 = charging
    private int charging = 0;
    private int blockCharge = 0;

    public BlockEntityStaffHolder(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOCK_ENTITY_STAFF_HOLDER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return BlockEntityStaffHolder.this.progress;
                    case 1: return BlockEntityStaffHolder.this.maxProgress;
                    case 2: return BlockEntityStaffHolder.this.charging;
                    case 3: return BlockEntityStaffHolder.this.blockCharge;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        BlockEntityStaffHolder.this.progress = value;
                        break;
                    case 1:
                        BlockEntityStaffHolder.this.maxProgress = value;
                        break;
                    case 2:
                        BlockEntityStaffHolder.this.charging = value;
                        break;
                    case 3:
                        BlockEntityStaffHolder.this.blockCharge = value;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Staff Charger");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new StaffChargerScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("staff_charger.progress", progress);
        nbt.putInt("staff_charger.blockCharge", blockCharge);
        nbt.putInt("staff_charger.charging", charging);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("staff_charger.progress");
        blockCharge = nbt.getInt("staff_charger.blockCharge");
        charging = nbt.getInt("staff_charger.charging");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void resetCharge() {
        this.blockCharge = 100;
    }

    private void chargeStaff() {
        this.blockCharge--;
        if(blockCharge % 10.0f == 0.0f) {
            this.getStack(0).getNbt().putInt("charge", this.getStack(0).getNbt().getInt("charge") + 1);
        }
    }


    public static void tick(World world, BlockPos pos, BlockState blockState, BlockEntityStaffHolder entity) {
        if(world.isClient) {
            return;
        }

        if(hasRecipe(entity, world, blockState, pos)) {
            entity.chargeStaff();
            markDirty(world, pos, blockState);
            world.setBlockState(pos, blockState.with(CHARGING, true).with(STAFF, world.getBlockState(pos).get(STAFF)));
        } else {
            world.setBlockState(pos, blockState.with(CHARGING, false).with(STAFF, world.getBlockState(pos).get(STAFF)));
        }



        /*if(hasRecipe(entity)) {
            entity.progress++;
            markDirty(world, pos, blockState);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, pos, blockState);
        }*/
    }

    private static void decrementInput(BlockEntityStaffHolder entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        entity.removeStack(1, 1);
    }

    private static void craftItem(BlockEntityStaffHolder entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

            entity.removeStack(0, 1);

            entity.setStack(1, new ItemStack(Items.ACACIA_LOG,
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
    }

    private static boolean hasRecipe(BlockEntityStaffHolder entity, World world, BlockState state, BlockPos pos) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasFirstSlot = entity.getStack(0).getItem() == ModItems.FIRE_STAFF;
        boolean hasSecondSlot = entity.getStack(1).getItem() == ModItems.FIRE_STONE;
        boolean staffNotCharged;
        if(hasFirstSlot) {
            world.setBlockState(pos, state.with(STAFF, true));//.with(CHARGE, world.getBlockState(pos).get(CHARGE)));
            staffNotCharged = entity.getStack(0).getNbt().getInt("charge") < 100;
        } else {
            world.setBlockState(pos, state.with(STAFF, false));//.with(CHARGE, world.getBlockState(pos).get(CHARGE)));
            staffNotCharged = false;
        }

        if(hasSecondSlot && entity.blockCharge <= 0) {
            entity.resetCharge();
            decrementInput(entity);
            markDirty(world, pos, state);

        }
        boolean hasEnergy = entity.blockCharge > 0;

        return hasFirstSlot && hasEnergy && staffNotCharged;
    }

    /*private static boolean hasRecipe(BlockEntityStaffHolder entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasRawGemInFirstSlot = entity.getStack(0).getItem() == ModItems.FIRE_STONE;

        return hasRawGemInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, Items.ACACIA_LOG);
    }*/

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }
}
