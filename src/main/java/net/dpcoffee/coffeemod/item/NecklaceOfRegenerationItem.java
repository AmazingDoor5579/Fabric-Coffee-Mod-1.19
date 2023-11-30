package net.dpcoffee.coffeemod.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class NecklaceOfRegenerationItem extends WeakStrongTrinket {

    public NecklaceOfRegenerationItem(Settings settings, int weak, int strong, int minimum_strength, int maximum_strength) {
        super(settings, weak, strong, minimum_strength, maximum_strength);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, stack.getNbt().getInt("modifier"), false, false));
    }
}
