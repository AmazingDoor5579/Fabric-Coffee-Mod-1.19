package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.blockentity.BlockEntityStaffHolder;
import net.dpcoffee.coffeemod.blockentity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockStaffHolder extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty STAFF = BooleanProperty.of("staff");
    public static final BooleanProperty CHARGING = BooleanProperty.of("charging");
    //public static final IntProperty CHARGE = IntProperty.of("holder_charge", 0, 100);

    public BlockStaffHolder(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(STAFF, false).with(CHARGING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAFF, CHARGING);
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        int temp = random.nextBetween(0, 11);
        if (temp <= 1) {
            if (world.getBlockState(pos).get(STAFF)) {
                particleNoStaff(world, pos, random);
            } else {
                particleStaff(world, pos, random);
            }
        }
        if (world.getBlockState(pos).get(CHARGING) && world.getBlockState(pos).get(STAFF)) {
            particleCharging(world, pos, random);
        }
    }

    private void particleStaff(World world, BlockPos pos, Random random) {
        world.addParticle(ParticleTypes.END_ROD, pos.getX() + random.nextBetween(0, 10) / 10.0f, pos.getY() + random.nextBetween(5, 10) / 10.0f, pos.getZ() + random.nextBetween(0, 10) / 10.0f, 0, 0, 0);
    }

    private void particleNoStaff(World world, BlockPos pos, Random random) {
        world.addParticle(ParticleTypes.SMALL_FLAME, pos.getX() + .5f, pos.getY() + .5f, pos.getZ() + .5f, random.nextBetween(-10, 10) / 200.0f, 0.02, random.nextBetween(-10, 10) / 200.0f);
    }

    private void particleCharging(World world, BlockPos pos, Random random) {
        world.addParticle(ParticleTypes.ENCHANTED_HIT, pos.getX() + .5f, pos.getY() + .45f, pos.getZ() + .5f, random.nextBetween(-5, 5) / 200.0f, 0.02, random.nextBetween(5, 5) / 200.0f);
    }

    /*BLOCK ENTITY*/

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

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof BlockEntityStaffHolder) {
                ItemScatterer.spawn(world, pos, (BlockEntityStaffHolder)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityStaffHolder(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.BLOCK_ENTITY_STAFF_HOLDER, BlockEntityStaffHolder::tick);

    }
}

