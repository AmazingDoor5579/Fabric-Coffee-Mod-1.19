package net.dpcoffee.coffeemod.blockentity;

import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.screen.JetPackChargerScreenHandler;
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

import static net.dpcoffee.coffeemod.block.JetPackCharger.CHARGING;
import static net.dpcoffee.coffeemod.block.JetPackCharger.JET_PACK;

public class BlockEntityJetPackCharger extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private static int charge_time;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 75;
    //1 = charging
    private int charging = 0;
    private int blockCharge = 0;

    public BlockEntityJetPackCharger(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOCK_ENTITY_JET_PACK_CHARGER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return BlockEntityJetPackCharger.this.progress;
                    case 1: return BlockEntityJetPackCharger.this.maxProgress;
                    case 2: return BlockEntityJetPackCharger.this.charging;
                    case 3: return BlockEntityJetPackCharger.this.blockCharge;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        BlockEntityJetPackCharger.this.progress = value;
                        break;
                    case 1:
                        BlockEntityJetPackCharger.this.maxProgress = value;
                        break;
                    case 2:
                        BlockEntityJetPackCharger.this.charging = value;
                        break;
                    case 3:
                        BlockEntityJetPackCharger.this.blockCharge = value;
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
        return Text.literal("Jetpack Charger");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new JetPackChargerScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("jet_pack_charger.progress", progress);
        nbt.putInt("jet_pack_charger.blockCharge", blockCharge);
        nbt.putInt("jet_pack_charger.charging", charging);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("jet_pack_charger.progress");
        blockCharge = nbt.getInt("jet_pack_charger.blockCharge");
        charging = nbt.getInt("jet_pack_charger.charging");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void resetCharge() {
        this.blockCharge = 100;
    }

    private void chargeJetPack() {
        this.blockCharge--;
        if(blockCharge % 10.0f == 0.0f) {
            this.getStack(0).getNbt().putInt("fuel", this.getStack(0).getNbt().getInt("fuel") + 20);
        }
    }


    public static void tick(World world, BlockPos pos, BlockState blockState, BlockEntityJetPackCharger entity) {
        if(world.isClient) {
            return;
        }

        if(hasRecipe(entity, world, blockState, pos)) {
            entity.chargeJetPack();
            markDirty(world, pos, blockState);
            world.setBlockState(pos, blockState.with(CHARGING, true).with(JET_PACK, world.getBlockState(pos).get(JET_PACK)));
        } else {
            world.setBlockState(pos, blockState.with(CHARGING, false).with(JET_PACK, world.getBlockState(pos).get(JET_PACK)));
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

    private static void decrementInput(BlockEntityJetPackCharger entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        entity.removeStack(1, 1);
    }

    private static void craftItem(BlockEntityJetPackCharger entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

            entity.removeStack(0, 1);

            entity.setStack(1, new ItemStack(Items.ACACIA_LOG,
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
    }

    private static boolean hasRecipe(BlockEntityJetPackCharger entity, World world, BlockState state, BlockPos pos) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasFirstSlot = entity.getStack(0).getItem() == ModItems.JET_PACK;
        boolean hasSecondSlot = entity.getStack(1).getItem() == ModItems.FIRE_STONE;
        boolean jetPackNotCharged;
        if(hasFirstSlot) {
            world.setBlockState(pos, state.with(JET_PACK, true));//.with(CHARGE, world.getBlockState(pos).get(CHARGE)));
            jetPackNotCharged = entity.getStack(0).getNbt().getInt("fuel") < 5000;
        } else {
            world.setBlockState(pos, state.with(JET_PACK, false));//.with(CHARGE, world.getBlockState(pos).get(CHARGE)));
            jetPackNotCharged = false;
        }

        if(hasSecondSlot && entity.blockCharge <= 0) {
            entity.resetCharge();
            decrementInput(entity);
            markDirty(world, pos, state);

        }
        boolean hasEnergy = entity.blockCharge > 0;

        return hasFirstSlot && hasEnergy && jetPackNotCharged;
    }


    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(1).getItem() == output || inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }
}
