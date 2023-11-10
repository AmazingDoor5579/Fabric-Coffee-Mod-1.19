package net.dpcoffee.coffeemod.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class ModEntityDataSaverMixin {

    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract float getMaxHealth();

    @Shadow public abstract float getHealth();

    @Unique
    @Nullable
    private Float set_health = null;


    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    public void writeCustom(NbtCompound nbt, CallbackInfo info) {


    }

    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    public void readCustom(NbtCompound nbt, CallbackInfo info) {
        set_health = nbt.getFloat("Health");
    }

    @Inject(method = "getEquipmentChanges", at = @At("RETURN"))
    private void test(CallbackInfoReturnable<@Nullable Map<EquipmentSlot, ItemStack>> cir) {
        if(set_health != null){
            if(getMaxHealth() > 20) {
                setHealth(set_health);
                System.out.println(set_health);
                set_health = null;
            }
        }

    }
}
