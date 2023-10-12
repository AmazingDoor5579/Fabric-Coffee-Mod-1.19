package net.dpcoffee.coffeemod.entity.client.option;

import net.dpcoffee.coffeemod.item.GrenadeItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.TranslatableOption;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

@Environment(value= EnvType.CLIENT)
public enum GrenadeIndicator implements TranslatableOption
{
    OFF(0, "options.off"),
    CROSSHAIR(1, "options.attack.crosshair");

    private static final IntFunction<GrenadeIndicator> BY_ID;
    private final int id;
    private final String translationKey;

    private GrenadeIndicator(int id, String translationKey) {
        this.id = id;
        this.translationKey = translationKey;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTranslationKey() {
        return this.translationKey;
    }

    public static GrenadeIndicator byId(int id) {return BY_ID.apply(id);}

    static {
        BY_ID = ValueLists.createIdToValueFunction(GrenadeIndicator::getId, GrenadeIndicator.values(), ValueLists.OutOfBoundsHandling.WRAP);
    }
}
