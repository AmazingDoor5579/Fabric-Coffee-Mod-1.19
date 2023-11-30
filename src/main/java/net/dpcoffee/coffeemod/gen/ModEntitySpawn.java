package net.dpcoffee.coffeemod.gen;

import net.dpcoffee.coffeemod.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSource;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES, BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER, ModEntities.CHEST_MIMIC, 10, 1, 1);

        SpawnRestriction.register(ModEntities.CHEST_MIMIC, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);


    }
}
