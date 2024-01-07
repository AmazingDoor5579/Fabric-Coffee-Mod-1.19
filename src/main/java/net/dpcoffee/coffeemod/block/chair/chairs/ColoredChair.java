package net.dpcoffee.coffeemod.block.chair.chairs;

import net.dpcoffee.coffeemod.block.chair.TwoTallChairBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.util.DyeColor;

public class ColoredChair extends TwoTallChairBlock {

    private DyeColor color;
    public ColoredChair(FabricBlockSettings settings, DyeColor color) {
        super(settings);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
