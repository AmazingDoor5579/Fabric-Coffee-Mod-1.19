package net.dpcoffee.coffeemod.mixin;

import net.dpcoffee.coffeemod.util.IGameOptionsMixin;
import net.dpcoffee.coffeemod.util.IVideoOptionsScreenMixin;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VideoOptionsScreen.class)
public class VideoOptionsScreenMixin extends GameOptionsScreen implements IVideoOptionsScreenMixin {
    public VideoOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
        super(parent, gameOptions, title);
    }

    @Override
    public SimpleOption<?>[] getCustomOptions(GameOptions gameOptions) {
        return new SimpleOption[]{((IGameOptionsMixin)this.gameOptions).getGrenadeIndicator()};
    }
    //@Shadow
    //private ButtonListWidget list;

    @Inject(method="init", at = @At("TAIL"))
    private void setCustomOptions(CallbackInfo c) {
        //this.list.addAll(((IVideoOptionsScreenMixin)this).getCustomOptions(this.gameOptions));
    }

}
