package net.dpcoffee.coffeemod;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModTreeConfiguredFeatures extends net.minecraft.world.gen.feature.TreeConfiguredFeatures {
    //public static final RegistryKey<ConfiguredFeature<?, ?>> COFFEE_TREE = ConfiguredFeatures.of("trees_coffee");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COFFEE_TREE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoffeeMod.MOD_ID,"trees_coffee"));
}
