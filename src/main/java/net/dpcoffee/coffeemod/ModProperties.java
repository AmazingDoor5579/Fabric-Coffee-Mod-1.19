package net.dpcoffee.coffeemod;

import net.dpcoffee.coffeemod.block.chair.ChairPart;
import net.minecraft.state.property.EnumProperty;

public class ModProperties {
    public static final EnumProperty<ChairPart> CHAIR_PART = EnumProperty.of("part", ChairPart.class);
}
