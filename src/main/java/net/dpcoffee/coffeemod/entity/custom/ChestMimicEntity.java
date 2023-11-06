package net.dpcoffee.coffeemod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.Random;

public class ChestMimicEntity extends HostileEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final RawAnimation OPEN = RawAnimation.begin().thenPlay("animation.chest_mimic.open");
    private static final RawAnimation CLOSE = RawAnimation.begin().thenPlay("animation.chest_mimic.close");
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chest_mimic.idle");
    private boolean pounced = false;
    private Random r = new Random();
    private Vec3d old_pos;



    public ChestMimicEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.stepHeight = 3.0f;
        old_pos = this.getPos();
    }


    @Override
    public void mobTick() {
        super.mobTick();

        if(this.onGround && this.getTarget() != null && r.nextInt(10) == 3) {
            //Pounce(10, r.nextFloat(3.0f), 0);
            //Pounce(100, 2f, 0);
            this.getMoveControl().moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 4);
            this.addVelocity(0, r.nextFloat(0.8f), 0);
        }
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 10.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new TargetGoal<PlayerEntity>(this, PlayerEntity.class));
        this.goalSelector.add(3, new AttackGoal(this));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
        if(state.isMoving()) {
            if (state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
                state.getController().forceAnimationReset();
                return state.setAndContinue(OPEN);
            }
            return state.setAndContinue(IDLE);
        }

        return state.setAndContinue(CLOSE);
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    static class TargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {
        public TargetGoal(ChestMimicEntity entity, Class<T> targetEntityClass) {
            super((MobEntity) entity, targetEntityClass, true);
        }

        @Override
        public boolean canStart() {
            this.findClosestTarget();
            return this.targetEntity != null;
        }
    }
}
