package net.dpcoffee.coffeemod.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModPlantPlacement {

    public static List<PlacementModifier> modifiers(int count) {
        return List.of(CountPlacementModifier.of(count), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> mushroomModifiers(int chance, @Nullable PlacementModifier modifier) {
        ImmutableList.Builder<PlacementModifier> builder = ImmutableList.builder();
        if (modifier != null) {
            builder.add(modifier);
        }

        if (chance != 0) {
            builder.add(RarityFilterPlacementModifier.of(chance));
        }

        builder.add(SquarePlacementModifier.of());
        builder.add(PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);
        builder.add(BiomePlacementModifier.of());
        return builder.build();
    }
}
