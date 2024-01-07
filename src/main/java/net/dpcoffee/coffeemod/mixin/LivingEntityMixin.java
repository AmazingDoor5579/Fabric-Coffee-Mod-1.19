package net.dpcoffee.coffeemod.mixin;

import net.dpcoffee.coffeemod.block.chair.TwoTallChairBlock;
import net.dpcoffee.coffeemod.util.ILivingEntityMixin;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ILivingEntityMixin {

    private static final TrackedData<Boolean> SITTING = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Shadow public abstract void stopRiding();

    @Shadow public abstract EntityDimensions getDimensions(EntityPose pose);

    protected LivingEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    public void trackCustomData(CallbackInfo ci) {
        this.dataTracker.startTracking(SITTING, false);
    }

    @Override
    public void sit(BlockPos pos) {
        BlockState blockState;
        if(this.hasVehicle()) {
            this.stopRiding();
        }
        if ((blockState = this.getWorld().getBlockState(pos)).getBlock() instanceof TwoTallChairBlock) {
            this.setPose(EntityPose.SITTING);
            this.setPos(pos.getX(), pos.getY(), pos.getZ());

            this.setBoundingBox(this.calculateBoundingBox());
            this.setVelocity(Vec3d.ZERO);
            this.velocityDirty = true;
        }
    }


    @Override
    public boolean inSittingPose() {
        return this.getDataTracker().get(SITTING);
    }

    @Override
    public void setSittingPose(boolean sitting) {
        this.getDataTracker().set(SITTING, sitting);
    }




}
