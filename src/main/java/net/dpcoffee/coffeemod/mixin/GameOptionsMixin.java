package net.dpcoffee.coffeemod.mixin;

import com.mojang.serialization.Codec;
import net.dpcoffee.coffeemod.entity.client.option.GrenadeIndicator;
import net.dpcoffee.coffeemod.util.IGameOptionsMixin;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.StringVisitable;
import net.minecraft.util.math.Spline;
import net.minecraft.world.GameRules;
import org.lwjgl.system.CallbackI;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.function.Function;

@Mixin(GameOptions.class)
public class GameOptionsMixin implements IGameOptionsMixin {
    private final SimpleOption<GrenadeIndicator> grenadeIndicator = new SimpleOption<>("options.grenadeIndicator", SimpleOption.emptyTooltip(), SimpleOption.enumValueText(), new SimpleOption.PotentialValuesBasedCallbacks<GrenadeIndicator>(Arrays.asList(GrenadeIndicator.values()), Codec.INT.xmap(GrenadeIndicator::byId, GrenadeIndicator::getId)), GrenadeIndicator.CROSSHAIR, value-> {});

    @Override
    public SimpleOption<GrenadeIndicator> getGrenadeIndicator() {
        return this.grenadeIndicator;
    }

}
