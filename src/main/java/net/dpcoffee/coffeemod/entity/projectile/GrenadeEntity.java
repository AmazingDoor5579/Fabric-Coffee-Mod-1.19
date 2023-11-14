package net.dpcoffee.coffeemod.entity.projectile;

import net.dpcoffee.coffeemod.entity.ModEntities;
import net.dpcoffee.coffeemod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class GrenadeEntity extends ThrownItemEntity {

    private int max_cook_time = 100;
    public static final TrackedData<Integer> CURRENT_COOK = DataTracker.registerData(GrenadeEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public GrenadeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {

        super(entityType, world);

    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(CURRENT_COOK, 0);
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        if(blockHitResult.getSide() == Direction.UP && (Math.abs(this.getVelocity().x) > .001 || Math.abs(this.getVelocity().y) > .001 || Math.abs(this.getVelocity().z) > .001)) {
            this.setVelocity(this.getVelocity().x / 3, -this.getVelocity().y / 4, this.getVelocity().z / 3);
        } else {
            this.setVelocity(0,0,0);
        }

    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GRENADE_ITEM;
    }

    @Override
    public void tick() {
        int i = this.getCookTime() + 1;
        this.setCookTime(i);
        if(i >= this.max_cook_time) {
            this.discard();
           if(!this.getWorld().isClient) {
                this.Explode();
            }
        }
        super.tick();
    }

    public void setCookTime(int cook) {this.dataTracker.set(CURRENT_COOK, cook);}



    private void Explode() {
        this.getWorld().createExplosion(this, this.getX(),this.getY(),this.getZ(), 4.0f, false, World.ExplosionSourceType.NONE);
    }
    public int getCookTime() {return this.dataTracker.get(CURRENT_COOK);}

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("cook", this.getCookTime());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setCookTime(nbt.getInt("cook"));
    }
}
