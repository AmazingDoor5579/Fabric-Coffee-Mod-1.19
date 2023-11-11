package net.dpcoffee.coffeemod.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class ModEntityDataSaverMixin {

    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract float getMaxHealth();

    @Shadow public abstract float getHealth();

    @Unique
    @Nullable
    private Float set_health = null;

    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustom(NbtCompound nbt, CallbackInfo info) {
        set_health = nbt.getFloat("Health");
    }

    @Inject(method = "getEquipmentChanges", at = @At("RETURN"))
    private void test(CallbackInfoReturnable<@Nullable Map<EquipmentSlot, ItemStack>> cir) {
        if(set_health != null){
            if(getMaxHealth() > 20) {
                setHealth(set_health);
                set_health = null;
            }
        }

    }
}
