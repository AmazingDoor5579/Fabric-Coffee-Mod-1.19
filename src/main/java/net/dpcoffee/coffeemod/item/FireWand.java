package net.dpcoffee.coffeemod.item;

import net.dpcoffee.coffeemod.entity.ModEntities;
import net.dpcoffee.coffeemod.entity.projectile.FireProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class FireWand extends Item {

    public FireWand(Settings settings) {
        super(settings);

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(entity instanceof PlayerEntity) {
            ItemStack itemStack = stack;
            if (!world.isClient) {
                if (!itemStack.hasNbt() && stack.getItem() instanceof FireWand) {
                    itemStack.getOrCreateNbt().putInt("charge", 100);
                }
            }
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(100);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient) {
            attemptFire(world, user, itemStack);

        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    private void attemptFire(World world, PlayerEntity user, ItemStack stack) {
            if (stack.getNbt().getInt("charge") > 0) {
                ///////////////////////////////////////////////////////////////////////
                FireProjectile fireEntity = new FireProjectile(ModEntities.FIRE_PROJECTILE, world);
                fireEntity.setPos(user.getX(), user.getY() + 1, user.getZ());
                fireEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 3.5f, 1.0f);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 1.0f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                world.spawnEntity(fireEntity);
                ///////////////////////////////////////////////////////////////////////
                FireProjectile fireEntity2 = new FireProjectile(ModEntities.FIRE_PROJECTILE, world);
                fireEntity2.setPos(user.getX(), user.getY() + 1, user.getZ());
                fireEntity2.setVelocity(user, user.getPitch() + (world.getRandom().nextFloat() * 2), user.getYaw()  + (world.getRandom().nextFloat() * 2), 0.0f, 3.5f, 1.0f);
                world.spawnEntity(fireEntity2);
                ///////////////////////////////////////////////////////////////////////
                FireProjectile fireEntity3 = new FireProjectile(ModEntities.FIRE_PROJECTILE, world);
                fireEntity3.setPos(user.getX(), user.getY() + 1, user.getZ());
                fireEntity3.setVelocity(user, user.getPitch() + (world.getRandom().nextFloat() * 2), user.getYaw() + (world.getRandom().nextFloat() * 2), 0.0f, 3.5f, 1.0f);
                world.spawnEntity(fireEntity3);
                ///////////////////////////////////////////////////////////////////////
                stack.getNbt().putInt("charge", stack.getNbt().getInt("charge") - 1);
            }
        }
}
