package net.dpcoffee.coffeemod.block.chair;

import net.minecraft.util.StringIdentifiable;

public enum ChairPart implements StringIdentifiable
{
    TOP("top"),
    BOTTOM("bottom");
    private final String name;
    private ChairPart(String name) {this.name = name;}
    public String toString() {return this.name;}

    @Override
    public String asString() {
        return this.name;
    }
}
