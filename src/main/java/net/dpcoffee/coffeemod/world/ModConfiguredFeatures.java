package net.dpcoffee.coffeemod.world;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_KEY = registerKey("blue_mushroom");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest mushroomPlaceable = new TagMatchRuleTest(BlockTags.MUSHROOM_GROW_BLOCK);


        register(context, BLUE_MUSHROOM_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM)));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CoffeeMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register (Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
