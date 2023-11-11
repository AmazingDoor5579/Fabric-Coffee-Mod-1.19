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

public class NecklaceOfRegenerationItem extends TrinketItem {
    public NecklaceOfRegenerationItem(Settings settings) {
        super(settings);
    }

    Random r = new Random();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(entity instanceof PlayerEntity) {
            ItemStack itemstack = stack;
            if(!world.isClient) {
                if(!itemstack.hasNbt() && stack.getItem() instanceof NecklaceOfRegenerationItem) {
                    itemstack.getOrCreateNbt().putInt("modifier", r.nextInt(2));
                    System.out.println(stack.getNbt().getInt("modifier"));
                    if(stack.getNbt().getInt("modifier") == 1) {
                        stack.setCustomName(Text.translatable("Strong " + stack.getName().getString()).formatted(Formatting.RESET));
                    } else {
                        stack.setCustomName(Text.translatable(stack.getName().getString()).formatted(Formatting.RESET));
                    }
                }
            }
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.tick(stack, slot, entity);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, stack.getNbt().getInt("modifier"), false, false));
    }
}
