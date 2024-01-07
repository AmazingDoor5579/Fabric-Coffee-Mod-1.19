package net.dpcoffee.coffeemod.mixin;

import net.dpcoffee.coffeemod.util.ILivingEntityMixin;
import net.dpcoffee.coffeemod.util.IPlayerEntityMixin;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements IPlayerEntityMixin {

    //private static final TrackedData<Boolean> IS_SITTING = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Shadow public abstract EntityDimensions getDimensions(EntityPose pose);

    @Shadow public ScreenHandler currentScreenHandler;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void trySit(BlockPos pos) {
        ((ILivingEntityMixin)this).sit(pos);
    }

    //@Override
    //public boolean inSittingPos() {
        //return this.getDataTracker().get(IS_SITTING);
    //}

    //@Override
    //public void setSitting(boolean sitting) {
        //this.getDataTracker().set(IS_SITTING, sitting);
    //}

    //@Inject(method = "initDataTracker", at = @At("TAIL"))
    //public void trackCustomData(CallbackInfo ci) {
        //this.dataTracker.startTracking(IS_SITTING, false);
    //}

    @Inject(method = "getDimensions", at = @At("RETURN"), cancellable = true)
    public void custom(EntityPose pose, CallbackInfoReturnable<EntityDimensions> cir) {
        if(((ILivingEntityMixin)this).inSittingPose()) {

            cir.setReturnValue(new EntityDimensions(0.6f, 1.2f, false));
        }
    }

    @Inject(method = "getActiveEyeHeight", at = @At("RETURN"), cancellable = true)
    public void customEyeHeight(EntityPose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
        if(((ILivingEntityMixin)this).inSittingPose()) {

            cir.setReturnValue(1.0f);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void customCalculateDimensions(CallbackInfo ci) {
        if(getDimensions(EntityPose.STANDING).height != getBoundingBox().maxX) {
            this.calculateDimensions();
        }
    }

}
