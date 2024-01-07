package net.dpcoffee.coffeemod.block.chair;

import net.dpcoffee.coffeemod.ModProperties;
import net.dpcoffee.coffeemod.blockentity.BlockEntityQrag;
import net.dpcoffee.coffeemod.blockentity.BlockEntityTwoTallChair;
import net.dpcoffee.coffeemod.mixin.PlayerEntityMixin;
import net.dpcoffee.coffeemod.util.ILivingEntityMixin;
import net.dpcoffee.coffeemod.util.IPlayerEntityMixin;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

public class TwoTallChairBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public static final EnumProperty<ChairPart> PART = ModProperties.CHAIR_PART;
    public static final BooleanProperty OCCUPIED = Properties.OCCUPIED;
    protected static final VoxelShape PLATFORM = Block.createCuboidShape(1.0, 10.0, 1.0, 15.0, 12.0, 15.0);
    protected static final VoxelShape LEG1 = Block.createCuboidShape(1.25, 0.0, 13.25, 2.75, 10.0, 14.75);
    protected static final VoxelShape LEG2 = Block.createCuboidShape(13.25, 0.0, 1.25, 14.75, 10.0, 2.75);
    protected static final VoxelShape LEG3 = Block.createCuboidShape(13.25, 0.0, 13.25, 14.75, 10.0, 14.75);
    protected static final VoxelShape LEG4 = Block.createCuboidShape(1.25, 0.0, 1.25, 2.75, 10.0, 2.75);

    protected static  final VoxelShape BOTTOM_SHAPE = VoxelShapes.union(PLATFORM, LEG1, LEG2, LEG3, LEG4);


    public TwoTallChairBlock(FabricBlockSettings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(PART, ChairPart.BOTTOM).with(OCCUPIED, false));
    }

    public static Direction getDirection(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.getBlock() instanceof TwoTallChairBlock ? blockState.get(FACING) : null;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        ChairPart part = state.get(PART);
        switch (part) {
            case TOP: {
                Direction direction = state.get(FACING);
                switch (direction) {
                    case NORTH : {
                         VoxelShape BAR1 = Block.createCuboidShape(1, -4, 1.25, 2, 10, 2.25);
                         VoxelShape BAR2 = Block.createCuboidShape(4.25, -4, 1.25, 5.25, 10, 2.25);
                         VoxelShape BAR3 = Block.createCuboidShape(7.5, -4, 1.25, 8.5, 10, 2.25);
                         VoxelShape BAR4 = Block.createCuboidShape(10.75, -4, 1.25, 11.75, 10, 2.25);
                         VoxelShape BAR5 = Block.createCuboidShape(14, -4, 1.25, 15, 10, 2.25);
                         VoxelShape CROSSBAR = Block.createCuboidShape(0.75, 9.5, 1, 15.25, 11, 2.5);
                        return  VoxelShapes.union(BAR1, BAR2, BAR3, BAR4, BAR5, CROSSBAR);
                    }
                    case SOUTH: {
                         VoxelShape BAR1 = Block.createCuboidShape(14, -4, 13.75, 15, 10, 14.75);
                         VoxelShape BAR2 = Block.createCuboidShape(10.75, -4, 13.75, 11.75, 10, 14.75);
                         VoxelShape BAR3 = Block.createCuboidShape(7.5, -4, 13.75, 8.5, 10, 14.75);
                         VoxelShape BAR4 = Block.createCuboidShape(4.25, -4, 13.75, 5.25, 10, 14.75);
                         VoxelShape BAR5 = Block.createCuboidShape(1, -4, 13.75, 2, 10, 14.75);
                         VoxelShape CROSSBAR = Block.createCuboidShape(0.75, 9.5, 13.5, 15.25, 11, 15);
                         return  VoxelShapes.union(BAR1, BAR2, BAR3, BAR4, BAR5, CROSSBAR);
                    }
                    case EAST: {
                        VoxelShape BAR1 = Block.createCuboidShape(13.75, -4, 14, 14.75, 10, 15);
                        VoxelShape BAR2 = Block.createCuboidShape(13.75, -4, 10.75, 14.75, 10, 11.75);
                        VoxelShape BAR3 = Block.createCuboidShape(13.75, -4, 7.5, 14.75, 10, 8.5);
                        VoxelShape BAR4 = Block.createCuboidShape(13.75, -4, 4.25, 14.75, 10, 5.25);
                        VoxelShape BAR5 = Block.createCuboidShape(13.75, -4, 1, 14.75, 10, 2);
                        VoxelShape CROSSBAR = Block.createCuboidShape(13.5, 9.5, 0.75, 15, 11, 15.25);
                        return  VoxelShapes.union(BAR1, BAR2, BAR3, BAR4, BAR5, CROSSBAR);
                    }
                    case WEST: {
                        VoxelShape BAR1 = Block.createCuboidShape(1.25, -4, 1, 2.25, 10, 2);
                        VoxelShape BAR2 = Block.createCuboidShape(1.25, -4, 4.25, 2.25, 10, 5.25);
                        VoxelShape BAR3 = Block.createCuboidShape(1.25, -4, 7.5, 2.25, 10, 8.5);
                        VoxelShape BAR4 = Block.createCuboidShape(1.25, -4, 10.75, 2.25, 10, 11.75);
                        VoxelShape BAR5 = Block.createCuboidShape(1.25, -4, 14, 2.25, 10, 15);
                        VoxelShape CROSSBAR = Block.createCuboidShape(1, 9.5, 0.75, 2.5, 11, 15.25);
                        return  VoxelShapes.union(BAR1, BAR2, BAR3, BAR4, BAR5, CROSSBAR);
                    }
                }
            }
        }
        return BOTTOM_SHAPE;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockPos blockPos;
        ChairPart chairPart = state.get(PART);
        BlockEntityTwoTallChair blockEntity = (BlockEntityTwoTallChair) world.getBlockEntity(pos);
        if(blockEntity.getPlayer() != null) {
            ((ILivingEntityMixin)blockEntity.getPlayer()).setSittingPose(false);
            blockEntity.setPlayer(null);
        }
        if(!world.isClient) {
            if(chairPart == ChairPart.BOTTOM) {
                blockPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            } else {
                blockPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            }
                if(world.getBlockState(blockPos).getBlock() instanceof TwoTallChairBlock) {
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.SKIP_DROPS);
                    world.syncWorldEvent(player, WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(state));
                }

        }
        super.onBreak(world, pos, state, player);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getHorizontalPlayerFacing();
        BlockPos blockPos = ctx.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(Direction.UP, 1);
        World world = ctx.getWorld();
        if(world.getBlockState(blockPos2).canReplace(ctx) && world.getWorldBorder().contains(blockPos2)) {
            return this.getDefaultState().with(FACING, direction);
        }
        return null;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if(!world.isClient) {
            BlockPos blockPos = pos.offset(Direction.UP, 1);
            world.setBlockState(blockPos, state.with(PART, ChairPart.TOP), Block.NOTIFY_ALL);
            world.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(world, pos, Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OCCUPIED, PART);
        super.appendProperties(builder);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient()) {
            if (((BlockEntityTwoTallChair)world.getBlockEntity(pos)).getPlayer() == null && !((ILivingEntityMixin)player).inSittingPose()) {
                ((BlockEntityTwoTallChair) world.getBlockEntity(pos)).setPlayer(player);
            }
        }

        if (((BlockEntityTwoTallChair)world.getBlockEntity(pos)).getPlayer() == null && !((ILivingEntityMixin)player).inSittingPose()) {
            ((BlockEntityTwoTallChair) world.getBlockEntity(pos)).setPlayer(player);
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return BlockEntityTwoTallChair::tick;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityTwoTallChair(pos, state);
    }
}
