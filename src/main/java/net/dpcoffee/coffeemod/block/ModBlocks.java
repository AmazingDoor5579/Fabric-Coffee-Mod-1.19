package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COFFEE_BEAN_BLOCK = registerBlock("coffee_bean_block", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.WART_BLOCK).strength(0.2f)), ItemGroups.BUILDING_BLOCKS);
    public static final Block FIRE_STONE_ORE = registerBlock("fire_stone_ore", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1.0f).luminance(4)), ItemGroups.NATURAL);
    public static final Block STAFF_HOLDER = registerBlock("staff_holder", new BlockStaffHolder(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).nonOpaque().strength(0.3f).ticksRandomly()), ItemGroups.COMBAT);
    public static final Block JET_PACK_CHARGER = registerBlock("jet_pack_charger", new JetPackCharger(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).nonOpaque().strength(0.3f).ticksRandomly()), ItemGroups.COMBAT);
    public static  final Block Q_RAG = registerBlock("q_rag", new QRag(FabricBlockSettings.of(Material.STONE).nonOpaque()), ItemGroups.FUNCTIONAL);
    public static final Block COFFEE_LEAF = registerBlock("coffee_leaf_block", new BlockCoffeeLeaf(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque().strength(0.2f)), ItemGroups.BUILDING_BLOCKS);
    //public static final Block OAK_SAPLING = Blocks.register("oak_sapling", new SaplingBlock(new OakSaplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block COFFEE_SAPLING = registerBlock("coffee_sapling", new SaplingBlock(new CoffeeSaplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), ItemGroups.NATURAL);
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CoffeeMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(CoffeeMod.MOD_ID, name), block);
    }
    public static void registerModBlocks() {

    }
}
