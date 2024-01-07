package net.dpcoffee.coffeemod.block;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.dpcoffee.coffeemod.block.chair.chairs.ColoredChair;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COFFEE_BEAN_BLOCK = registerBlock("coffee_bean_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).sounds(BlockSoundGroup.WART_BLOCK).strength(0.2f)), ItemGroups.BUILDING_BLOCKS);
    /////////////////////////////////////////////////////////////CHAIRS///////////////////////////////////////////////////////////////////////////////////////////////
    public static final Block OAK_WHITE_CHAIR = registerBlock("white_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block OAK_ORANGE_CHAIR = registerBlock("orange_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block OAK_MAGENTA_CHAIR = registerBlock("magenta_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block OAK_LIGHT_BLUE_CHAIR = registerBlock("light_blue_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block OAK_YELLOW_CHAIR = registerBlock("yellow_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block OAK_LIME_CHAIR = registerBlock("lime_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block OAK_PINK_CHAIR = registerBlock("pink_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block OAK_GRAY_CHAIR = registerBlock("gray_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block OAK_LIGHT_GRAY_CHAIR = registerBlock("light_gray_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block OAK_CYAN_CHAIR = registerBlock("cyan_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block OAK_PURPLE_CHAIR = registerBlock("purple_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block OAK_BLUE_CHAIR = registerBlock("blue_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block OAK_BROWN_CHAIR = registerBlock("brown_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block OAK_GREEN_CHAIR = registerBlock("green_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block OAK_RED_CHAIR = registerBlock("red_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block OAK_BLACK_CHAIR = registerBlock("black_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_WHITE_CHAIR = registerBlock("white_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_ORANGE_CHAIR = registerBlock("orange_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_MAGENTA_CHAIR = registerBlock("magenta_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_LIGHT_BLUE_CHAIR = registerBlock("light_blue_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_YELLOW_CHAIR = registerBlock("yellow_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_LIME_CHAIR = registerBlock("lime_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_PINK_CHAIR = registerBlock("pink_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_GRAY_CHAIR = registerBlock("gray_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_LIGHT_GRAY_CHAIR = registerBlock("light_gray_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_CYAN_CHAIR = registerBlock("cyan_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_PURPLE_CHAIR = registerBlock("purple_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_BLUE_CHAIR = registerBlock("blue_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_BROWN_CHAIR = registerBlock("brown_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_GREEN_CHAIR = registerBlock("green_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_RED_CHAIR = registerBlock("red_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block SPRUCE_BLACK_CHAIR = registerBlock("black_spruce_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_WHITE_CHAIR = registerBlock("white_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_ORANGE_CHAIR = registerBlock("orange_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_MAGENTA_CHAIR = registerBlock("magenta_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_LIGHT_BLUE_CHAIR = registerBlock("light_blue_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_YELLOW_CHAIR = registerBlock("yellow_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_LIME_CHAIR = registerBlock("lime_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_PINK_CHAIR = registerBlock("pink_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_GRAY_CHAIR = registerBlock("gray_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_LIGHT_GRAY_CHAIR = registerBlock("light_gray_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_CYAN_CHAIR = registerBlock("cyan_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_PURPLE_CHAIR = registerBlock("purple_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_BLUE_CHAIR = registerBlock("blue_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_BROWN_CHAIR = registerBlock("brown_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_GREEN_CHAIR = registerBlock("green_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_RED_CHAIR = registerBlock("red_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block BIRCH_BLACK_CHAIR = registerBlock("black_birch_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_WHITE_CHAIR = registerBlock("white_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_ORANGE_CHAIR = registerBlock("orange_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_MAGENTA_CHAIR = registerBlock("magenta_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_LIGHT_BLUE_CHAIR = registerBlock("light_blue_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_YELLOW_CHAIR = registerBlock("yellow_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_LIME_CHAIR = registerBlock("lime_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_PINK_CHAIR = registerBlock("pink_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_GRAY_CHAIR = registerBlock("gray_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_LIGHT_GRAY_CHAIR = registerBlock("light_gray_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_CYAN_CHAIR = registerBlock("cyan_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_PURPLE_CHAIR = registerBlock("purple_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_BLUE_CHAIR = registerBlock("blue_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_BROWN_CHAIR = registerBlock("brown_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_GREEN_CHAIR = registerBlock("green_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_RED_CHAIR = registerBlock("red_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block JUNGLE_BLACK_CHAIR = registerBlock("black_jungle_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_WHITE_CHAIR = registerBlock("white_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_ORANGE_CHAIR = registerBlock("orange_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_MAGENTA_CHAIR = registerBlock("magenta_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_LIGHT_BLUE_CHAIR = registerBlock("light_blue_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_YELLOW_CHAIR = registerBlock("yellow_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_LIME_CHAIR = registerBlock("lime_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_PINK_CHAIR = registerBlock("pink_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_GRAY_CHAIR = registerBlock("gray_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_LIGHT_GRAY_CHAIR = registerBlock("light_gray_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_CYAN_CHAIR = registerBlock("cyan_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_PURPLE_CHAIR = registerBlock("purple_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_BLUE_CHAIR = registerBlock("blue_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_BROWN_CHAIR = registerBlock("brown_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_GREEN_CHAIR = registerBlock("green_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_RED_CHAIR = registerBlock("red_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block ACACIA_BLACK_CHAIR = registerBlock("black_acacia_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_WHITE_CHAIR = registerBlock("white_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_ORANGE_CHAIR = registerBlock("orange_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_MAGENTA_CHAIR = registerBlock("magenta_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_LIGHT_BLUE_CHAIR = registerBlock("light_blue_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_YELLOW_CHAIR = registerBlock("yellow_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_LIME_CHAIR = registerBlock("lime_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_PINK_CHAIR = registerBlock("pink_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_GRAY_CHAIR = registerBlock("gray_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_LIGHT_GRAY_CHAIR = registerBlock("light_gray_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_CYAN_CHAIR = registerBlock("cyan_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_PURPLE_CHAIR = registerBlock("purple_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_BLUE_CHAIR = registerBlock("blue_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_BROWN_CHAIR = registerBlock("brown_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_GREEN_CHAIR = registerBlock("green_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_RED_CHAIR = registerBlock("red_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block DARK_OAK_BLACK_CHAIR = registerBlock("black_dark_oak_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_WHITE_CHAIR = registerBlock("white_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_ORANGE_CHAIR = registerBlock("orange_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_MAGENTA_CHAIR = registerBlock("magenta_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_LIGHT_BLUE_CHAIR = registerBlock("light_blue_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_YELLOW_CHAIR = registerBlock("yellow_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_LIME_CHAIR = registerBlock("lime_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_PINK_CHAIR = registerBlock("pink_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_GRAY_CHAIR = registerBlock("gray_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_LIGHT_GRAY_CHAIR = registerBlock("light_gray_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_CYAN_CHAIR = registerBlock("cyan_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_PURPLE_CHAIR = registerBlock("purple_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_BLUE_CHAIR = registerBlock("blue_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_BROWN_CHAIR = registerBlock("brown_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_GREEN_CHAIR = registerBlock("green_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_RED_CHAIR = registerBlock("red_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block MANGROVE_BLACK_CHAIR = registerBlock("black_mangrove_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_WHITE_CHAIR = registerBlock("white_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_ORANGE_CHAIR = registerBlock("orange_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_MAGENTA_CHAIR = registerBlock("magenta_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_LIGHT_BLUE_CHAIR = registerBlock("light_blue_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_YELLOW_CHAIR = registerBlock("yellow_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_LIME_CHAIR = registerBlock("lime_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_PINK_CHAIR = registerBlock("pink_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_GRAY_CHAIR = registerBlock("gray_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_LIGHT_GRAY_CHAIR = registerBlock("light_gray_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_CYAN_CHAIR = registerBlock("cyan_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_PURPLE_CHAIR = registerBlock("purple_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_BLUE_CHAIR = registerBlock("blue_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_BROWN_CHAIR = registerBlock("brown_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_GREEN_CHAIR = registerBlock("green_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_RED_CHAIR = registerBlock("red_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block CHERRY_BLACK_CHAIR = registerBlock("black_cherry_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_WHITE_CHAIR = registerBlock("white_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_ORANGE_CHAIR = registerBlock("orange_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_MAGENTA_CHAIR = registerBlock("magenta_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_LIGHT_BLUE_CHAIR = registerBlock("light_blue_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_YELLOW_CHAIR = registerBlock("yellow_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_LIME_CHAIR = registerBlock("lime_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_PINK_CHAIR = registerBlock("pink_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_GRAY_CHAIR = registerBlock("gray_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_LIGHT_GRAY_CHAIR = registerBlock("light_gray_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_CYAN_CHAIR = registerBlock("cyan_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_PURPLE_CHAIR = registerBlock("purple_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_BLUE_CHAIR = registerBlock("blue_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_BROWN_CHAIR = registerBlock("brown_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_GREEN_CHAIR = registerBlock("green_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_RED_CHAIR = registerBlock("red_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block BAMBOO_BLACK_CHAIR = registerBlock("black_bamboo_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_WHITE_CHAIR = registerBlock("white_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_ORANGE_CHAIR = registerBlock("orange_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_MAGENTA_CHAIR = registerBlock("magenta_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_LIGHT_BLUE_CHAIR = registerBlock("light_blue_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_YELLOW_CHAIR = registerBlock("yellow_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_LIME_CHAIR = registerBlock("lime_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_PINK_CHAIR = registerBlock("pink_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_GRAY_CHAIR = registerBlock("gray_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_LIGHT_GRAY_CHAIR = registerBlock("light_gray_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_CYAN_CHAIR = registerBlock("cyan_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_PURPLE_CHAIR = registerBlock("purple_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_BLUE_CHAIR = registerBlock("blue_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_BROWN_CHAIR = registerBlock("brown_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_GREEN_CHAIR = registerBlock("green_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_RED_CHAIR = registerBlock("red_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block CRIMSON_BLACK_CHAIR = registerBlock("black_crimson_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_WHITE_CHAIR = registerBlock("white_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_ORANGE_CHAIR = registerBlock("orange_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_MAGENTA_CHAIR = registerBlock("magenta_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_LIGHT_BLUE_CHAIR = registerBlock("light_blue_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_YELLOW_CHAIR = registerBlock("yellow_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_LIME_CHAIR = registerBlock("lime_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_PINK_CHAIR = registerBlock("pink_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_GRAY_CHAIR = registerBlock("gray_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_LIGHT_GRAY_CHAIR = registerBlock("light_gray_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_CYAN_CHAIR = registerBlock("cyan_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_PURPLE_CHAIR = registerBlock("purple_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_BLUE_CHAIR = registerBlock("blue_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_BROWN_CHAIR = registerBlock("brown_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_GREEN_CHAIR = registerBlock("green_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_RED_CHAIR = registerBlock("red_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block WARPED_BLACK_CHAIR = registerBlock("black_warped_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_WHITE_CHAIR = registerBlock("white_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.WHITE),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_ORANGE_CHAIR = registerBlock("orange_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.ORANGE),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_MAGENTA_CHAIR = registerBlock("magenta_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.MAGENTA),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_LIGHT_BLUE_CHAIR = registerBlock("light_blue_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_BLUE),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_YELLOW_CHAIR = registerBlock("yellow_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.YELLOW),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_LIME_CHAIR = registerBlock("lime_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIME),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_PINK_CHAIR = registerBlock("pink_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PINK),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_GRAY_CHAIR = registerBlock("gray_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GRAY),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_LIGHT_GRAY_CHAIR = registerBlock("light_gray_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.LIGHT_GRAY),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_CYAN_CHAIR = registerBlock("cyan_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.CYAN),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_PURPLE_CHAIR = registerBlock("purple_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.PURPLE),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_BLUE_CHAIR = registerBlock("blue_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLUE),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_BROWN_CHAIR = registerBlock("brown_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BROWN),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_GREEN_CHAIR = registerBlock("green_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.GREEN),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_RED_CHAIR = registerBlock("red_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.RED),ItemGroups.FUNCTIONAL);
    public static final Block NETHER_BRICK_BLACK_CHAIR = registerBlock("black_nether_brick_chair", new ColoredChair(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.WOOD).strength(0.2f).nonOpaque(), DyeColor.BLACK),ItemGroups.FUNCTIONAL);


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final Block FIRE_STONE_ORE = registerBlock("fire_stone_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.STONE).strength(1.0f).luminance(4)), ItemGroups.NATURAL);
    public static final Block STAFF_HOLDER = registerBlock("staff_holder", new BlockStaffHolder(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.STONE).nonOpaque().strength(0.3f).ticksRandomly()),ItemGroups.COMBAT);
    public static final Block JET_PACK_CHARGER = registerBlock("jet_pack_charger", new JetPackCharger(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.STONE).nonOpaque().strength(0.3f).ticksRandomly()), ItemGroups.BUILDING_BLOCKS);
    public static  final Block Q_RAG = registerBlock("q_rag", new QRag(FabricBlockSettings.copyOf(Blocks.DIRT).nonOpaque().luminance(8)), ItemGroups.FOOD_AND_DRINK);
    public static final Block MYTHIC_ANVIL = registerBlock("mythic_anvil", new BlockMythicAnvil(FabricBlockSettings.copyOf(Blocks.ANVIL).nonOpaque()), ItemGroups.FUNCTIONAL);
    public static final Block COFFEE_LEAF = registerBlock("coffee_leaf_block", new BlockCoffeeLeaf(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.GRASS).nonOpaque().strength(0.2f)), ItemGroups.NATURAL);
    public static final Block BLUE_MUSHROOM = registerBlock("blue_mushroom", new BlockBlueMushroom(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM).sounds(BlockSoundGroup.WART_BLOCK).nonOpaque().strength(0.0f).luminance(4)), ItemGroups.NATURAL);
    //public static final Block OAK_SAPLING = Blocks.register("oak_sapling", new SaplingBlock(new OakSaplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)));
    public static final Block COFFEE_SAPLING = registerBlock("coffee_sapling", new SaplingBlock(new CoffeeSaplingGenerator(), AbstractBlock.Settings.copy(Blocks.KELP_PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque()), ItemGroups.NATURAL);
    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CoffeeMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {entries.add(block);});
        return item;
    }

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(CoffeeMod.MOD_ID, name), block);
    }
    public static void registerModBlocks() {

    }


    /////////////////////////////////////////CHAIR LIST///////////////////////////////////////////////////////////
    public static Block[] CHAIRS = {ModBlocks.OAK_WHITE_CHAIR, ModBlocks.OAK_ORANGE_CHAIR, ModBlocks.OAK_MAGENTA_CHAIR,
            ModBlocks.OAK_LIGHT_BLUE_CHAIR, ModBlocks.OAK_YELLOW_CHAIR, ModBlocks.OAK_LIME_CHAIR,
            ModBlocks.OAK_PINK_CHAIR, ModBlocks.OAK_GRAY_CHAIR, ModBlocks.OAK_LIGHT_GRAY_CHAIR,
            ModBlocks.OAK_CYAN_CHAIR, ModBlocks.OAK_PURPLE_CHAIR, ModBlocks.OAK_BLUE_CHAIR, ModBlocks.OAK_BROWN_CHAIR,
            ModBlocks.OAK_GREEN_CHAIR, ModBlocks.OAK_RED_CHAIR, ModBlocks.OAK_BLACK_CHAIR, ModBlocks.SPRUCE_WHITE_CHAIR,
            ModBlocks.SPRUCE_ORANGE_CHAIR, ModBlocks.SPRUCE_MAGENTA_CHAIR, ModBlocks.SPRUCE_LIGHT_BLUE_CHAIR,
            ModBlocks.SPRUCE_YELLOW_CHAIR, ModBlocks.SPRUCE_LIME_CHAIR, ModBlocks.SPRUCE_PINK_CHAIR,
            ModBlocks.SPRUCE_GRAY_CHAIR, ModBlocks.SPRUCE_LIGHT_GRAY_CHAIR, ModBlocks.SPRUCE_CYAN_CHAIR,
            ModBlocks.SPRUCE_PURPLE_CHAIR, ModBlocks.SPRUCE_BLUE_CHAIR, ModBlocks.SPRUCE_BROWN_CHAIR,
            ModBlocks.SPRUCE_GREEN_CHAIR, ModBlocks.SPRUCE_RED_CHAIR, ModBlocks.SPRUCE_BLACK_CHAIR,
            ModBlocks.BIRCH_WHITE_CHAIR, ModBlocks.BIRCH_ORANGE_CHAIR, ModBlocks.BIRCH_MAGENTA_CHAIR,
            ModBlocks.BIRCH_LIGHT_BLUE_CHAIR, ModBlocks.BIRCH_YELLOW_CHAIR, ModBlocks.BIRCH_LIME_CHAIR,
            ModBlocks.BIRCH_PINK_CHAIR, ModBlocks.BIRCH_GRAY_CHAIR, ModBlocks.BIRCH_LIGHT_GRAY_CHAIR,
            ModBlocks.BIRCH_CYAN_CHAIR, ModBlocks.BIRCH_PURPLE_CHAIR, ModBlocks.BIRCH_BLUE_CHAIR,
            ModBlocks.BIRCH_BROWN_CHAIR, ModBlocks.BIRCH_GREEN_CHAIR, ModBlocks.BIRCH_RED_CHAIR,
            ModBlocks.BIRCH_BLACK_CHAIR, ModBlocks.JUNGLE_WHITE_CHAIR, ModBlocks.JUNGLE_ORANGE_CHAIR,
            ModBlocks.JUNGLE_MAGENTA_CHAIR, ModBlocks.JUNGLE_LIGHT_BLUE_CHAIR, ModBlocks.JUNGLE_YELLOW_CHAIR,
            ModBlocks.JUNGLE_LIME_CHAIR, ModBlocks.JUNGLE_PINK_CHAIR, ModBlocks.JUNGLE_GRAY_CHAIR,
            ModBlocks.JUNGLE_LIGHT_GRAY_CHAIR, ModBlocks.JUNGLE_CYAN_CHAIR, ModBlocks.JUNGLE_PURPLE_CHAIR,
            ModBlocks.JUNGLE_BLUE_CHAIR, ModBlocks.JUNGLE_BROWN_CHAIR, ModBlocks.JUNGLE_GREEN_CHAIR,
            ModBlocks.JUNGLE_RED_CHAIR, ModBlocks.JUNGLE_BLACK_CHAIR, ModBlocks.ACACIA_WHITE_CHAIR,
            ModBlocks.ACACIA_ORANGE_CHAIR, ModBlocks.ACACIA_MAGENTA_CHAIR, ModBlocks.ACACIA_LIGHT_BLUE_CHAIR,
            ModBlocks.ACACIA_YELLOW_CHAIR, ModBlocks.ACACIA_LIME_CHAIR, ModBlocks.ACACIA_PINK_CHAIR,
            ModBlocks.ACACIA_GRAY_CHAIR, ModBlocks.ACACIA_LIGHT_GRAY_CHAIR, ModBlocks.ACACIA_CYAN_CHAIR,
            ModBlocks.ACACIA_PURPLE_CHAIR, ModBlocks.ACACIA_BLUE_CHAIR, ModBlocks.ACACIA_BROWN_CHAIR,
            ModBlocks.ACACIA_GREEN_CHAIR, ModBlocks.ACACIA_RED_CHAIR, ModBlocks.ACACIA_BLACK_CHAIR,
            ModBlocks.DARK_OAK_WHITE_CHAIR, ModBlocks.DARK_OAK_ORANGE_CHAIR, ModBlocks.DARK_OAK_MAGENTA_CHAIR,
            ModBlocks.DARK_OAK_LIGHT_BLUE_CHAIR, ModBlocks.DARK_OAK_YELLOW_CHAIR, ModBlocks.DARK_OAK_LIME_CHAIR,
            ModBlocks.DARK_OAK_PINK_CHAIR, ModBlocks.DARK_OAK_GRAY_CHAIR, ModBlocks.DARK_OAK_LIGHT_GRAY_CHAIR,
            ModBlocks.DARK_OAK_CYAN_CHAIR, ModBlocks.DARK_OAK_PURPLE_CHAIR, ModBlocks.DARK_OAK_BLUE_CHAIR,
            ModBlocks.DARK_OAK_BROWN_CHAIR, ModBlocks.DARK_OAK_GREEN_CHAIR, ModBlocks.DARK_OAK_RED_CHAIR,
            ModBlocks.DARK_OAK_BLACK_CHAIR, ModBlocks.MANGROVE_WHITE_CHAIR, ModBlocks.MANGROVE_ORANGE_CHAIR,
            ModBlocks.MANGROVE_MAGENTA_CHAIR, ModBlocks.MANGROVE_LIGHT_BLUE_CHAIR, ModBlocks.MANGROVE_YELLOW_CHAIR,
            ModBlocks.MANGROVE_LIME_CHAIR, ModBlocks.MANGROVE_PINK_CHAIR, ModBlocks.MANGROVE_GRAY_CHAIR,
            ModBlocks.MANGROVE_LIGHT_GRAY_CHAIR, ModBlocks.MANGROVE_CYAN_CHAIR, ModBlocks.MANGROVE_PURPLE_CHAIR,
            ModBlocks.MANGROVE_BLUE_CHAIR, ModBlocks.MANGROVE_BROWN_CHAIR, ModBlocks.MANGROVE_GREEN_CHAIR,
            ModBlocks.MANGROVE_RED_CHAIR, ModBlocks.MANGROVE_BLACK_CHAIR, ModBlocks.CHERRY_WHITE_CHAIR,
            ModBlocks.CHERRY_ORANGE_CHAIR, ModBlocks.CHERRY_MAGENTA_CHAIR, ModBlocks.CHERRY_LIGHT_BLUE_CHAIR,
            ModBlocks.CHERRY_YELLOW_CHAIR, ModBlocks.CHERRY_LIME_CHAIR, ModBlocks.CHERRY_PINK_CHAIR,
            ModBlocks.CHERRY_GRAY_CHAIR, ModBlocks.CHERRY_LIGHT_GRAY_CHAIR, ModBlocks.CHERRY_CYAN_CHAIR,
            ModBlocks.CHERRY_PURPLE_CHAIR, ModBlocks.CHERRY_BLUE_CHAIR, ModBlocks.CHERRY_BROWN_CHAIR,
            ModBlocks.CHERRY_GREEN_CHAIR, ModBlocks.CHERRY_RED_CHAIR, ModBlocks.CHERRY_BLACK_CHAIR,
            ModBlocks.BAMBOO_WHITE_CHAIR, ModBlocks.BAMBOO_ORANGE_CHAIR, ModBlocks.BAMBOO_MAGENTA_CHAIR,
            ModBlocks.BAMBOO_LIGHT_BLUE_CHAIR, ModBlocks.BAMBOO_YELLOW_CHAIR, ModBlocks.BAMBOO_LIME_CHAIR,
            ModBlocks.BAMBOO_PINK_CHAIR, ModBlocks.BAMBOO_GRAY_CHAIR, ModBlocks.BAMBOO_LIGHT_GRAY_CHAIR,
            ModBlocks.BAMBOO_CYAN_CHAIR, ModBlocks.BAMBOO_PURPLE_CHAIR, ModBlocks.BAMBOO_BLUE_CHAIR,
            ModBlocks.BAMBOO_BROWN_CHAIR, ModBlocks.BAMBOO_GREEN_CHAIR, ModBlocks.BAMBOO_RED_CHAIR,
            ModBlocks.BAMBOO_BLACK_CHAIR, ModBlocks.CRIMSON_WHITE_CHAIR, ModBlocks.CRIMSON_ORANGE_CHAIR,
            ModBlocks.CRIMSON_MAGENTA_CHAIR, ModBlocks.CRIMSON_LIGHT_BLUE_CHAIR, ModBlocks.CRIMSON_YELLOW_CHAIR,
            ModBlocks.CRIMSON_LIME_CHAIR, ModBlocks.CRIMSON_PINK_CHAIR, ModBlocks.CRIMSON_GRAY_CHAIR,
            ModBlocks.CRIMSON_LIGHT_GRAY_CHAIR, ModBlocks.CRIMSON_CYAN_CHAIR, ModBlocks.CRIMSON_PURPLE_CHAIR,
            ModBlocks.CRIMSON_BLUE_CHAIR, ModBlocks.CRIMSON_BROWN_CHAIR, ModBlocks.CRIMSON_GREEN_CHAIR,
            ModBlocks.CRIMSON_RED_CHAIR, ModBlocks.CRIMSON_BLACK_CHAIR, ModBlocks.WARPED_WHITE_CHAIR,
            ModBlocks.WARPED_ORANGE_CHAIR, ModBlocks.WARPED_MAGENTA_CHAIR, ModBlocks.WARPED_LIGHT_BLUE_CHAIR,
            ModBlocks.WARPED_YELLOW_CHAIR, ModBlocks.WARPED_LIME_CHAIR, ModBlocks.WARPED_PINK_CHAIR,
            ModBlocks.WARPED_GRAY_CHAIR, ModBlocks.WARPED_LIGHT_GRAY_CHAIR, ModBlocks.WARPED_CYAN_CHAIR,
            ModBlocks.WARPED_PURPLE_CHAIR, ModBlocks.WARPED_BLUE_CHAIR, ModBlocks.WARPED_BROWN_CHAIR,
            ModBlocks.WARPED_GREEN_CHAIR, ModBlocks.WARPED_RED_CHAIR, ModBlocks.WARPED_BLACK_CHAIR,
            ModBlocks.NETHER_BRICK_WHITE_CHAIR, ModBlocks.NETHER_BRICK_ORANGE_CHAIR,
            ModBlocks.NETHER_BRICK_MAGENTA_CHAIR, ModBlocks.NETHER_BRICK_LIGHT_BLUE_CHAIR,
            ModBlocks.NETHER_BRICK_YELLOW_CHAIR, ModBlocks.NETHER_BRICK_LIME_CHAIR,
            ModBlocks.NETHER_BRICK_PINK_CHAIR, ModBlocks.NETHER_BRICK_GRAY_CHAIR,
            ModBlocks.NETHER_BRICK_LIGHT_GRAY_CHAIR, ModBlocks.NETHER_BRICK_CYAN_CHAIR,
            ModBlocks.NETHER_BRICK_PURPLE_CHAIR, ModBlocks.NETHER_BRICK_BLUE_CHAIR,
            ModBlocks.NETHER_BRICK_BROWN_CHAIR, ModBlocks.NETHER_BRICK_GREEN_CHAIR,
            ModBlocks.NETHER_BRICK_RED_CHAIR, ModBlocks.NETHER_BRICK_BLACK_CHAIR};
}
