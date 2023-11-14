package net.dpcoffee.coffeemod.entity.custom;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class CoffeeThingEntity extends HostileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.coffee_thing.idle");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.coffee_thing.walk");
    private static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.coffee_thing.attack");


    public static boolean shot;

    public CoffeeThingEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.00f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 3.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ShootFireballGoal(this));
        this.goalSelector.add(2, new GoToWalkTargetGoal(this, 1.0f));
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
        if(state.isMoving()) {
            return state.setAndContinue(WALK);
        }
        return state.setAndContinue(IDLE);
    }

    private<E extends GeoAnimatable> PlayState firePredicate(AnimationState<E> state) {
        if(this.shot && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.setAndContinue(ATTACK);
            this.shot = false;
        }
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> state) {
        if(this.handSwinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.setAndContinue(ATTACK);
            this.handSwinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "walk_idle", 0, this::predicate),
                        new AnimationController<>(this, "attack", 0, this::attackPredicate),
                        new AnimationController<>(this, "fire", 0, this::firePredicate));

    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return CoffeeMod.COFFEE_THING_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return CoffeeMod.COFFEE_THING_AMBIENT;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public boolean getShot() {
        return this.shot;
    }

    public void setShot(boolean b) {
        this.shot = b;
    }

    /////////////////////////////////////////////////////////


    static class ShootFireballGoal extends Goal {

        private final CoffeeThingEntity coffee_thing;
        private int cool_down;
        private int targetNotVisibleTicks;


        public ShootFireballGoal(CoffeeThingEntity entity) {
            this.coffee_thing = entity;
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = this.coffee_thing.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.coffee_thing.canTarget(livingEntity);
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            --this.cool_down;
            LivingEntity livingEntity = this.coffee_thing.getTarget();
            if (livingEntity == null) {
                return;
            }boolean bl = this.coffee_thing.getVisibilityCache().canSee(livingEntity);
            this.targetNotVisibleTicks = bl ? 0 : ++this.targetNotVisibleTicks;
            double d = this.coffee_thing.squaredDistanceTo(livingEntity);
            if (d < 8.0) {
                if (!bl) {
                    return;
                }
                if (this.cool_down <= 0) {
                    this.cool_down = 20;
                    this.coffee_thing.tryAttack(livingEntity);
                    this.coffee_thing.swingHand(this.coffee_thing.getActiveHand());
                }
                this.coffee_thing.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0);
            } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                double e = livingEntity.getX() - this.coffee_thing.getX();
                double f = livingEntity.getBodyY(0.5) - this.coffee_thing.getBodyY(0.5);
                double g = livingEntity.getZ() - this.coffee_thing.getZ();
                if (this.cool_down <= 0) {
                    double h = Math.sqrt(Math.sqrt(d)) * 0.5;
                    SmallFireballEntity smallFireballEntity = new SmallFireballEntity(this.coffee_thing.getWorld(), this.coffee_thing, this.coffee_thing.getRandom().nextTriangular(e, 2.297 * h), f, this.coffee_thing.getRandom().nextTriangular(g, 2.297 * h));
                    smallFireballEntity.setPosition(smallFireballEntity.getX(), this.coffee_thing.getBodyY(0.5), smallFireballEntity.getZ());
                    this.coffee_thing.getWorld().spawnEntity(smallFireballEntity);
                    this.cool_down = 100;
                    this.coffee_thing.setShot(true);
                }
                this.coffee_thing.getLookControl().lookAt(livingEntity, 10.0f, 10.0f);
            } else if (this.targetNotVisibleTicks < 5) {
                this.coffee_thing.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0);
            }

            super.tick();
        }
        private double getFollowRange() {
            return this.coffee_thing.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        }



    }
}
