package net.dpcoffee.coffeemod.util;

import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;

public interface IVideoOptionsScreenMixin {
    SimpleOption<?>[] getCustomOptions(GameOptions gameOptions);
}
