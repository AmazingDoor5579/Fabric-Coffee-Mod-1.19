package net.dpcoffee.coffeemod.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.Random;
import java.util.UUID;

public class HealthBraceletItem extends TrinketItem {
    Random r = new Random();

    public HealthBraceletItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(entity instanceof PlayerEntity) {
            ItemStack itemstack = stack;
            if(!world.isClient) {
                if(!itemstack.hasNbt() && stack.getItem() instanceof HealthBraceletItem) {
                    itemstack.getOrCreateNbt().putInt("modifier", r.nextInt(10 - 2) + 2);
                    if(stack.getNbt().getInt("modifier") < 4) {
                        stack.setCustomName(Text.translatable("Weak " + stack.getName().getString()).formatted(Formatting.RESET));
                    } else if(stack.getNbt().getInt("modifier") > 7) {
                        stack.setCustomName(Text.translatable("Strong " + stack.getName().getString().formatted(Formatting.RESET)));
                    } else {
                        stack.setCustomName(Text.translatable(stack.getName().getString()).formatted(Formatting.RESET));
                    }
                }
            }
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        if(stack.hasNbt()) {
            modifiers.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "generic.max_health", stack.getNbt().getInt("modifier"), EntityAttributeModifier.Operation.ADDITION));

        }
        //SlotAttributes.addSlotModifier(modifiers, "hand/glove", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
        return modifiers;
    }
}
