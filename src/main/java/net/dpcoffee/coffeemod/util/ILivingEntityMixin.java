package net.dpcoffee.coffeemod.util;

import net.minecraft.util.math.BlockPos;

public interface ILivingEntityMixin {
    void sit(BlockPos pos);
    boolean inSittingPose();
    void setSittingPose(boolean pose);
}
