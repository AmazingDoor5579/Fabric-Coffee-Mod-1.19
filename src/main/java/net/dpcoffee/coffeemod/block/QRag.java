package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.blockentity.BlockEntityQrag;
import net.dpcoffee.coffeemod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class QRag extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final BooleanProperty COFFEE = BooleanProperty.of("coffee");
    public static final BooleanProperty CUP = BooleanProperty.of("cup");
    public static final BooleanProperty Q_CUP = BooleanProperty.of("q_cup");
    public static final BooleanProperty MAKING = BooleanProperty.of("making");
    private BlockPos block_pos;

    public QRag(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(COFFEE, Boolean.FALSE).with(CUP, Boolean.FALSE).with(Q_CUP, Boolean.FALSE).with(MAKING, Boolean.FALSE));
    }

    //Blockstate settings
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, COFFEE, CUP, Q_CUP, MAKING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.2f, 0.0f, 0.1f, 0.7f, 0.7f, 0.9f);
            case SOUTH:
                return VoxelShapes.cuboid(0.3f, 0.0f, 0.1f, 0.8f, 0.7f, 0.9f);
            case EAST:
                return VoxelShapes.cuboid(0.1f, 0.0f, .2f, 0.9f, 0.7f, 0.7f);
            case WEST:
                return VoxelShapes.cuboid(0.1f, 0.0f, 0.3f, 0.9f, 0.7f, 0.8f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    //Block Entity Settings
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        block_pos = pos;
        return new BlockEntityQrag(pos, state);
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {

        return BlockEntityQrag::tick;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemstack = player.getStackInHand(hand);
            ItemStack q_cup = new ItemStack(ModItems.Q_CUP, 1);
            ItemStack cup = new ItemStack(ModItems.CUP, 1);
            ItemStack coffee = new ItemStack(ModItems.COFFEE, 1);
            Item item = itemstack.getItem();
            BlockEntity tileentity = world.getBlockEntity(pos);
            // determine what is the block
            //
            if (((BlockEntityQrag) tileentity).getCoffee() == true) {
                player.giveItemStack(coffee);
                ((BlockEntityQrag) tileentity).removeCoffee();
                world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else if (((BlockEntityQrag) tileentity).getCoffee() == false && (((BlockEntityQrag) tileentity).getMaking() == false)) {
                if (item != ModItems.CUP && item != ModItems.Q_CUP) {
                    if (((BlockEntityQrag) tileentity).getCup() == true) {
                        player.giveItemStack(cup);
                        ((BlockEntityQrag) tileentity).removeCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                    if (((BlockEntityQrag) tileentity).getQCup() == true) {
                        player.giveItemStack(q_cup);
                        ((BlockEntityQrag) tileentity).removeQCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                    if (((BlockEntityQrag) tileentity).getCoffee() == true) {
                        player.giveItemStack(coffee);
                        ((BlockEntityQrag) tileentity).removeCoffee();
                        world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                } else if (item == ModItems.CUP) {
                    if (((BlockEntityQrag) tileentity).getCup() == false) {
                        ((BlockEntityQrag) tileentity).addCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        if (!player.isCreative()) {
                            itemstack.decrement(1);
                        }
                    } else {
                        player.giveItemStack(cup);
                        ((BlockEntityQrag) tileentity).removeCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_LANTERN_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                } else if (item == ModItems.Q_CUP) {
                    if (((BlockEntityQrag) tileentity).getQCup() == false) {
                        ((BlockEntityQrag) tileentity).addQCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        if (!player.isCreative()) {
                            itemstack.decrement(1);
                        }
                    } else {
                        player.giveItemStack(q_cup);
                        ((BlockEntityQrag) tileentity).removeQCup();
                        world.playSound(null, pos, SoundEvents.BLOCK_ANCIENT_DEBRIS_STEP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                }

                //
                //end if statement
            }
        }
        return ActionResult.CONSUME;
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = 0D;
        double y = 0.4D;
        double z = 0D;
        if(state.get(MAKING)) {
            Direction dir = state.get(FACING);
            switch (dir) {
                case NORTH:
                    z = 0.0D;
                    x = 0.5D;
                    break;
                case SOUTH:
                    z = 0.9D;
                    x = 0.5D;
                    break;
                case EAST:
                    x = 0.9D;
                    z = 0.5D;
                    break;
                case WEST:
                    x = 0.0D;
                    z = 0.5D;
                    break;
                default:
                    x = 0D;
                    y = y;
                    z = 0D;

            }


            double d0 = (double) pos.getX() + x;
            double d1 = (double) pos.getY() + y;
            double d2 = (double) pos.getZ() + z;

            world.addParticle(ParticleTypes.POOF, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            super.randomDisplayTick(state, world, pos, random);
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity be = world.getBlockEntity(pos);
        ItemStack q_cup_stack = new ItemStack(ModItems.Q_CUP, 1);
        ItemStack cup_stack = new ItemStack(ModItems.CUP, 1);
        ItemStack coffee_stack = new ItemStack(ModItems.COFFEE, 1);
        ItemEntity q_cup = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ() , q_cup_stack);
        ItemEntity cup = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ() , cup_stack);
        ItemEntity coffee = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ() , coffee_stack);
        if(((BlockEntityQrag) be).getQCup()) {
            world.spawnEntity(q_cup);
        }
        if(((BlockEntityQrag) be).getCup()) {
            world.spawnEntity(cup);
        }
        if(((BlockEntityQrag) be).getCoffee()) {
            world.spawnEntity(coffee);
        }
        super.onBreak(world, pos, state, player);
    }
}
