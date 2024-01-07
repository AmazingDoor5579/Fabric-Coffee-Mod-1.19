package net.dpcoffee.coffeemod.mixin;

import jdk.jfr.BooleanFlag;
import net.dpcoffee.coffeemod.util.ILivingEntityMixin;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead {

    @Shadow @Final public ModelPart leftLeg;

    @Shadow @Final public ModelPart rightLeg;

    @Shadow @Final public ModelPart head;

    @Shadow @Final public ModelPart body;

    @Shadow @Final public ModelPart rightArm;

    @Shadow @Final public ModelPart leftArm;

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
    public void setCustomAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
        if(((ILivingEntityMixin)livingEntity).inSittingPose()) {
            float legPitch = -1.5f;
            float offset = 10.0f;
            this.leftLeg.pitch = legPitch;
            this.rightLeg.pitch = legPitch;
            this.head.pivotY = offset;
            this.body.pivotY = offset;
            this.rightArm.pivotY = offset + 2;
            this.leftArm.pivotY = offset + 2;
            this.leftLeg.pivotY = 23.0f;
            this.rightLeg.pivotY = 23.0f;

        }
    }

}
