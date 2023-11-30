package net.dpcoffee.coffeemod.gen;

import net.dpcoffee.coffeemod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModPlantGeneration {
    public static void generatePlants() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_MUSHROOM_PLACED_KEY);
    }
}
