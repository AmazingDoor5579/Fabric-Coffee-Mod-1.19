package net.dpcoffee.coffeemod.item;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CUP = registerItem("cup", new Item(new FabricItemSettings()), ItemGroups.FOOD_AND_DRINK);
    public static final Item FIRE_STONE = registerItem("fire_stone", new Item(new FabricItemSettings().maxCount(64)), ItemGroups.INGREDIENTS);
    public static final Item FIRE_STAFF = registerItem("fire_wand", new FireWand(new FabricItemSettings().maxCount(1)), ItemGroups.COMBAT);
    public static final Item COFFEE = registerItem("coffee", new Coffee(new FabricItemSettings().maxCount(1)), ItemGroups.FOOD_AND_DRINK);
    public static final Item Q_CUP = registerItem("q_cup", new Item(new FabricItemSettings()), ItemGroups.FOOD_AND_DRINK);
    public static final Item COFFEE_BEANS = registerItem("coffee_beans", new Item(new FabricItemSettings()), ItemGroups.FOOD_AND_DRINK);
    public static final Item JET_PACK = registerItem("jet_pack", new JetPackItem(new FabricItemSettings().maxCount(1)), ItemGroups.FUNCTIONAL);
    public static final Item NETHERITE_INFUSED_COFFEE_BEANS = registerItem("netherite_infused_coffee_beans", new Item(new FabricItemSettings()), ItemGroups.FOOD_AND_DRINK);
    public static final Item GRENADE_ITEM = registerItem("grenade", new GrenadeItem(new FabricItemSettings()), ItemGroups.COMBAT);
    public static final Item HEALTH_BRACELET = registerItem("health_bracelet", new HealthBraceletItem(new FabricItemSettings().maxCount(1)), ItemGroups.COMBAT);
    public static final Item NECKLACE_OF_REGENERATION = registerItem("necklace_of_regeneration", new NecklaceOfRegenerationItem(new FabricItemSettings().maxCount(1)), ItemGroups.COMBAT);

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(300), -3.3f, ToolMaterials.WOOD), ItemGroups.COMBAT);
    public static final Item STONE_HAMMER = registerItem("stone_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(550), -3.3f, ToolMaterials.STONE), ItemGroups.COMBAT);
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(800), -3.3f, ToolMaterials.IRON), ItemGroups.COMBAT);
    public static final Item GOLD_HAMMER = registerItem("gold_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(300), -3.3f, ToolMaterials.GOLD), ItemGroups.COMBAT);
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(1200), -3.3f, ToolMaterials.DIAMOND), ItemGroups.COMBAT);
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer", new HammerItem(new FabricItemSettings().maxCount(1).maxDamage(1600), -3.3f, ToolMaterials.NETHERITE), ItemGroups.COMBAT);


    public static final Item COFFEE_THING_SPAWN_EGG = registerItem("coffee_thing_spawn_egg", new SpawnEggItem(ModEntities.COFFEE_THING, 6633744, 16711680, new FabricItemSettings()), ItemGroups.SPAWN_EGGS);
    public static final Item COFFEE_GOLEM_SPAWN_EGG = registerItem("coffee_golem_spawn_egg", new SpawnEggItem(ModEntities.COFFEE_GOLEM, 6633744, 16711680, new FabricItemSettings()), ItemGroups.SPAWN_EGGS);
    public static final Item COFFEE_SPIDER_SPAWN_EGG = registerItem("coffee_spider_spawn_egg", new SpawnEggItem(ModEntities.COFFEE_SPIDER, 6633744, 16711680, new FabricItemSettings()), ItemGroups.SPAWN_EGGS);
    public static final Item CHEST_MIMIC_SPAWN_EGG = registerItem("chest_mimic_spawn_egg", new SpawnEggItem(ModEntities.CHEST_MIMIC, 11372032, 4470016, new FabricItemSettings()), ItemGroups.SPAWN_EGGS);

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CoffeeMod.MOD_ID, name), item);
    }
    private static Item registerItem(String name, Item item, RegistryKey<ItemGroup> group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(item));
        return Registry.register(Registries.ITEM, new Identifier(CoffeeMod.MOD_ID, name), item);
    }



    public static void registerModItems() {

    }
}
