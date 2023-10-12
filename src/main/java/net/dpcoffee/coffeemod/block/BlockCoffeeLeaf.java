package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlockCoffeeLeaf extends LeavesBlock {

    public static final BooleanProperty GROWN = BooleanProperty.of("grown");
    public BlockCoffeeLeaf(Settings settings) {

        super(settings);
        this.setDefaultState(this.getDefaultState().with(GROWN, false).with(DISTANCE, 6).with(PERSISTENT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(GROWN);

        //setDefaultState(this.getStateManager().getDefaultState().with(GROWN, Boolean.FALSE).with(DISTANCE, Integer.valueOf(6)).with(PERSISTENT, Boolean.valueOf(false)));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(state.get(DISTANCE) < 7 && !state.get(PERSISTENT)) {
            if(world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
                if (!world.isChunkLoaded(pos))
                    return;
                world.setBlockState(pos, state.with(GROWN, Boolean.TRUE));
            }
        }

        if((Integer)state.get(DISTANCE) == 7 && !(Boolean)state.get(PERSISTENT)) {
            if(!state.get(GROWN)) {
                if (!(Boolean) state.get(PERSISTENT) && (Integer) state.get(DISTANCE) == 7) {
                    dropStacks(state, world, pos);
                    world.removeBlock(pos, false);
                }
            } else {
                ItemStack coffee = new ItemStack(ModItems.COFFEE_BEANS, 1);
                ItemEntity coffee_entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), coffee);
                world.spawnEntity(coffee_entity);
                world.removeBlock(pos, false);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack coffee = new ItemStack(ModItems.COFFEE_BEANS, 1);
        ItemEntity coffee_item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), coffee);
        if(state.get(GROWN) == true) {
            world.spawnEntity(coffee_item);
            world.setBlockState(pos, state.with(GROWN, Boolean.valueOf(false)));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
