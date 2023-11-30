package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.blockentity.BlockEntityMythicAnvil;
import net.dpcoffee.coffeemod.blockentity.BlockEntityStaffHolder;
import net.dpcoffee.coffeemod.blockentity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class BlockMythicAnvil extends BlockWithEntity implements BlockEntityProvider {

    protected BlockMythicAnvil(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        switch(dir) {
            case NORTH:
            case SOUTH:
                return Block.createCuboidShape(1.5, 0, 3.5, 14.5, 15, 12.5);
            case EAST:
            case WEST:
                return Block.createCuboidShape(3.5, 0, 1.5, 12.5, 15, 14.5);
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }


    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        BlockEntity entity = world.getBlockEntity(pos);
        if(entity instanceof BlockEntityMythicAnvil) {
            DefaultedList<ItemStack> inv = ((BlockEntityMythicAnvil) entity).getItems();
            for (int i = 0; i < inv.size() - 1; i++) {
                    ItemEntity stack = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), inv.get(i));
                    world.spawnEntity(stack);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if(screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {

        return new BlockEntityMythicAnvil(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.BLOCK_ENTITY_MYTHIC_ANVIL, BlockEntityMythicAnvil::tick);
    }
}
