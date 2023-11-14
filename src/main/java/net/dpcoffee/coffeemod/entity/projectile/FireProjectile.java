package net.dpcoffee.coffeemod.entity.projectile;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class FireProjectile extends SmallFireballEntity {

    private int life = 20;
    public FireProjectile(EntityType<? extends SmallFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

    }

    @Override
    public void tick() {
        super.tick();
        getWorld().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, getX(), getY(), getZ(), 0.0D, 0.0D, 0.0D);
        if(this.life > 0) {
            this.life--;
        } else {
            if(!this.getWorld().isClient){
                this.kill();
            }
        }
    }
}
