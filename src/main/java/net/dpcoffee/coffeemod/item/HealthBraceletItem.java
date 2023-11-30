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

public class HealthBraceletItem extends WeakStrongTrinket {
    Random r = new Random();

    public HealthBraceletItem(Settings settings, int weak, int strong, int minimum_strength, int maximum_strength) {
        super(settings, weak, strong, minimum_strength, maximum_strength);
    }


    @Override
    public void setWeak(int i) {
        super.setWeak(3);
    }

    @Override
    public void setStrong(int i) {
        super.setStrong(7);
    }

    @Override
    public void setMaxStrength(int i) {
        super.setMaxStrength(10);
    }

    @Override
    public void setMinimumStrength(int i) {
        super.setMinimumStrength(2);
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
