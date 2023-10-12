package net.dpcoffee.coffeemod.util;

import net.minecraft.item.ItemUsageContext;

public interface IPlayerEntityMixin {
    void setAttackCoolDown(int i);
    int getAttackCoolDown();
    void hammerAttack(ItemUsageContext context);
}
