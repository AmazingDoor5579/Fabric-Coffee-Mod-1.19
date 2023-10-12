package net.dpcoffee.coffeemod.mixin;

import net.dpcoffee.coffeemod.Enchatment.EnchantmentRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method="onBreak(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;)V", at = @At("HEAD"))
    private void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo info) {
        if(world.isClient) {
           return;
        }
        Block[] shovel = {Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL, Blocks.SAND,
                Blocks.RED_SAND, Blocks.SOUL_SAND, Blocks.SOUL_SOIL};

        Block[] pick = {Blocks.STONE, Blocks.DEEPSLATE, Blocks.DIORITE, Blocks.GRANITE, Blocks.ANDESITE,
                Blocks.SANDSTONE, Blocks.TUFF, Blocks.NETHERRACK, Blocks.BLACKSTONE, Blocks.RED_SANDSTONE,
                Blocks.BASALT, Blocks.TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
                Blocks.YELLOW_TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA,
                Blocks.BROWN_TERRACOTTA};

        Item[] shovels = {Items.NETHERITE_SHOVEL, Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL,
                Items.IRON_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL};

        Item[] picks = {Items.NETHERITE_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLDEN_PICKAXE,
                Items.IRON_PICKAXE, Items.STONE_PICKAXE, Items.WOODEN_PICKAXE};

        ItemStack stack = player.getStackInHand(player.getActiveHand());
        Item item = stack.getItem();

        if (EnchantmentHelper.getLevel(EnchantmentRegistry.TUNNELER, stack) == 2) {
            int facingX = player.getHorizontalFacing().getVector().getX();
            int facingZ = player.getHorizontalFacing().getVector().getZ();
            BlockPos[] breaks = {
                    new BlockPos(pos.getX() + facingZ , pos.getY(), pos.getZ() + facingX),
                    new BlockPos(pos.getX() - facingZ , pos.getY(), pos.getZ() - facingX),
                    new BlockPos(pos.getX() , pos.getY() - 1, pos.getZ()),
                    new BlockPos(pos.getX() + facingZ , pos.getY() - 1, pos.getZ() + facingX),
                    new BlockPos(pos.getX() - facingZ , pos.getY() - 1, pos.getZ() - facingX)
            };
            for (BlockPos newPos: breaks) {
                BlockState blockState = world.getBlockState(newPos);
                if(Arrays.asList(shovels).contains(item)){
                    if (Arrays.asList(shovel).contains(blockState.getBlock())) {
                        boolean creative = player.isCreative();
                        if (!creative) {
                            stack.damage(1, world.random, (ServerPlayerEntity) player);
                        }
                        world.breakBlock(newPos, !creative, player);
                    }
                } else if(Arrays.asList(picks).contains(item)) {
                    if (Arrays.asList(pick).contains(blockState.getBlock())) {
                        boolean creative = player.isCreative();
                        if (!creative) {
                            stack.damage(1, world.random, (ServerPlayerEntity) player);
                        }
                        world.breakBlock(newPos, !creative, player);
                    }
                }
            }
        } else if (EnchantmentHelper.getLevel(EnchantmentRegistry.TUNNELER, stack) == 1) {
            BlockPos newPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            BlockState blockState = world.getBlockState(newPos);
            if(Arrays.asList(shovels).contains(item)){
                if (Arrays.asList(shovel).contains(blockState.getBlock())) {
                    boolean creative = player.isCreative();
                    if (!creative) {
                        stack.damage(1, world.random, (ServerPlayerEntity) player);
                    }
                    world.breakBlock(newPos, !creative, player);
                }
            } else if(Arrays.asList(picks).contains(item)) {
                if (Arrays.asList(pick).contains(blockState.getBlock())) {
                    boolean creative = player.isCreative();
                    if (!creative) {
                        stack.damage(1, world.random, (ServerPlayerEntity) player);
                    }
                    world.breakBlock(newPos, !creative, player);
                }
            }
        }
    }
}
