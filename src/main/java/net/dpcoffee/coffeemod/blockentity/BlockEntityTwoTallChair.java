package net.dpcoffee.coffeemod.blockentity;

import net.dpcoffee.coffeemod.block.chair.ChairPart;
import net.dpcoffee.coffeemod.mixin.LivingEntityMixin;
import net.dpcoffee.coffeemod.util.ILivingEntityMixin;
import net.dpcoffee.coffeemod.util.IPlayerEntityMixin;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityList;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import static net.dpcoffee.coffeemod.block.chair.TwoTallChairBlock.PART;

public class BlockEntityTwoTallChair extends BlockEntity {
    PlayerEntity player;
    public BlockEntityTwoTallChair(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOCK_ENTITY_TWO_TALL_CHAIR, pos, state);
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;

    }


    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState blockState, T t) {
        if(((BlockEntityTwoTallChair) world.getBlockEntity(pos)).getPlayer() != null) {
            float offset;
            if (world.getBlockState(pos).get(PART) == ChairPart.BOTTOM) {
                offset = 0.8f;
            } else {
                offset = -0.2f;
            }
            PlayerEntity playerEntity = ((BlockEntityTwoTallChair) world.getBlockEntity(pos)).getPlayer();
            //((IPlayerEntityMixin)playerEntity).trySit(pos);
            playerEntity.setPosition(pos.getX() + 0.5f, pos.getY() + offset, pos.getZ() + 0.5f);
            ((ILivingEntityMixin)playerEntity).setSittingPose(true);
            playerEntity.setSprinting(false);
            playerEntity.calculateDimensions();
            playerEntity.getDimensions(EntityPose.STANDING);
            playerEntity.stopRiding();

            //playerEntity.refreshPositionAfterTeleport(pos.getX(), pos.getY(), pos.getZ());
            if(playerEntity.isSneaking()) {
                ((ILivingEntityMixin)playerEntity).setSittingPose(false);
                ((BlockEntityTwoTallChair) world.getBlockEntity(pos)).setPlayer(null);
            }
        }
    }
}
