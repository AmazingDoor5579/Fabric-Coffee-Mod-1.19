package net.dpcoffee.coffeemod.item;

import net.dpcoffee.coffeemod.entity.ModEntities;
import net.dpcoffee.coffeemod.entity.projectile.GrenadeEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class GrenadeItem extends Item {

    private final int max_cook_time = 100;

    public GrenadeItem(Settings settings) {
        super(settings);
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        return max_cook_time;
    }




    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
        if(!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity) user;
        ItemStack itemStack = stack;
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if(!world.isClient) {
            GrenadeEntity grenadeEntity = new GrenadeEntity(ModEntities.GRENADE_ENTITY, world);
            grenadeEntity.setItem(itemStack);
            grenadeEntity.setPos(playerEntity.getX(), playerEntity.getY() + 1.8, playerEntity.getZ());
            grenadeEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, 1.5f, 1.0f);
            grenadeEntity.setCookTime(this.getMaxUseTime(stack) - remainingUseTicks);
            world.spawnEntity(grenadeEntity);
            if(!playerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }


    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
        if(!(user instanceof PlayerEntity)) {
            return;
        }
        if(!(stack.isOf(ModItems.GRENADE_ITEM))) {
            return;
        }
        PlayerEntity entity = (PlayerEntity) user;
        //entity.sendMessage(Text.literal(String.valueOf(this.getMaxUseTime(stack) - remainingUseTicks)));
        if(remainingUseTicks <=1) {
            if(world.isClient) {
                return;
            }
            GrenadeEntity g = new GrenadeEntity(ModEntities.GRENADE_ENTITY, world);
            g.setVelocity(0,0,0);
            g.setPos(entity.getX(), entity.getY()+1.8, entity.getZ());
            g.setCookTime(max_cook_time - 1);
            world.spawnEntity(g);
            if(!entity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.success(itemStack, false);
    }


}
