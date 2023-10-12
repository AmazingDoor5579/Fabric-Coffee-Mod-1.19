package net.dpcoffee.coffeemod.util;

import net.dpcoffee.coffeemod.entity.client.option.GrenadeIndicator;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Shadow;

public interface IGameOptionsMixin {

    SimpleOption<GrenadeIndicator> getGrenadeIndicator();
}
