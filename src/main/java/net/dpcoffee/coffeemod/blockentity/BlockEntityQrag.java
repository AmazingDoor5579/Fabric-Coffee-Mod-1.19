package net.dpcoffee.coffeemod.blockentity;

import net.dpcoffee.coffeemod.block.QRag;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEntityQrag extends BlockEntity {
    public BlockEntityQrag(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOCK_ENTITY_QRAG, pos, state);
    }
    private Boolean cup = false;
    private Boolean q_cup = false;
    private Boolean coffee = false;
    private Boolean making = false;
    private int make_time_left = 0;
    private int make_time = 100;
    private World world = this.getWorld();

    public void addCup() {

        cup = true;
    }

    public void removeCup() {
        cup = false;
    }

    public boolean getCup() {
        return cup;
    }
    public void addQCup() {

        q_cup = true;
    }

    public void removeQCup() {

        q_cup = false;
    }

    public Boolean getQCup() {
        return q_cup;
    }

    public void addCoffee() {

        coffee = true;
    }

    public void removeCoffee() {

        coffee = false;
    }

    public Boolean getCoffee() {
        return coffee;
    }

    public void Make() {
        if(making == false) {
            make_time_left = make_time;
            making = true;
        }
    }

    public boolean getMaking() {
        return making;
    }

    private void MakingInfo(World world, BlockPos pos) {
        if(make_time_left > 1) {
            make_time_left--;
        } else if(make_time_left == 1) {
            addCoffee();
            removeQCup();
            removeCup();
            make_time_left--;
            making = false;
        }
        if(make_time_left % 20 == 0 && make_time_left != 0) {
            world.playSound(null, pos, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }


    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState blockState, T t) {
        if(world.isClient()) {
            return;
        }
        BlockEntity be = world.getBlockEntity(pos);
        world.setBlockState(pos, blockState.with(QRag.CUP, ((BlockEntityQrag) be).cup).with(QRag.Q_CUP, ((BlockEntityQrag) be).q_cup).with(QRag.COFFEE, ((BlockEntityQrag) be).coffee).with(QRag.MAKING, ((BlockEntityQrag) be).making));

        if(((BlockEntityQrag) be).getCup() && ((BlockEntityQrag) be).getQCup()) {
            ((BlockEntityQrag) be).Make();
        }
        ((BlockEntityQrag) be).MakingInfo(world, pos);



    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        making = nbt.getBoolean("making");
        cup = nbt.getBoolean("cup");
        q_cup = nbt.getBoolean("q_cup");
        coffee = nbt.getBoolean("coffee");
        make_time_left = nbt.getInt("make_time_left");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean("making", making);
        nbt.putBoolean("cup", cup);
        nbt.putBoolean("q_cup", q_cup);
        nbt.putBoolean("coffee", coffee);
        nbt.putInt("make_time_left", make_time_left);
    }
}

