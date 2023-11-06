package net.dpcoffee.coffeemod.entity;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.custom.ChestMimicEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeGolemEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeSpiderEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeThingEntity;
import net.dpcoffee.coffeemod.entity.projectile.FireProjectile;
import net.dpcoffee.coffeemod.entity.projectile.GrenadeEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities implements ModInitializer {

    public static final EntityType<ChestMimicEntity> CHEST_MIMIC = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "chest_mimic"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ChestMimicEntity::new).dimensions(EntityDimensions.fixed(0.9f,0.8f)).build());
    public static final EntityType<CoffeeThingEntity> COFFEE_THING = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "coffee_thing"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CoffeeThingEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.85f)).build());
    public static final EntityType<CoffeeGolemEntity> COFFEE_GOLEM = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "coffee_golem"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CoffeeGolemEntity::new).dimensions(EntityDimensions.fixed(1.8f, 3.0f)).build());
    public static final EntityType<CoffeeSpiderEntity> COFFEE_SPIDER = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "coffee_spider"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CoffeeSpiderEntity::new).dimensions(EntityDimensions.fixed(1.5f, 0.8f)).build());
    //public static final EntityType<SmallFireballEntity> SMALL_FIREBALL = EntityType.register("small_fireball", EntityType.Builder.create(SmallFireballEntity::new, SpawnGroup.MISC).setDimensions(0.3125f, 0.3125f).maxTrackingRange(4).trackingTickInterval(10));
    public static final EntityType<FireProjectile> FIRE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "fire_entity"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireProjectile::new).dimensions(EntityDimensions.fixed(0.3125f, 0.3125f)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    public static final EntityType<GrenadeEntity> GRENADE_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(CoffeeMod.MOD_ID, "grenade_entity"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, GrenadeEntity::new).dimensions(EntityDimensions.fixed(0.3125f, 0.3125f)).trackRangeBlocks(4).trackedUpdateRate(10).build());
    @Override
    public void onInitialize() {

    }
}
