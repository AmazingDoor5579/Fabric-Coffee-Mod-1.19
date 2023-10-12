package net.dpcoffee.coffeemod.Enchatment;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantmentRegistry {

    public static Enchantment TUNNELER = new TunnelerEnchantment();

    public static void registerEnchantments() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(CoffeeMod.MOD_ID, "tunneler"), TUNNELER);
    }
}
