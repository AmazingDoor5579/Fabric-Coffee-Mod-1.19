package net.dpcoffee.coffeemod.entity.custom;

import net.dpcoffee.coffeemod.CoffeeMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CoffeeGolemEntity extends HostileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.coffee_golem.idle");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.coffee_golem.walk");
    private static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.coffee_golem.attack");

    public CoffeeGolemEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStepHeight(1.0f);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0f, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
        if(state.isMoving()) {
            return state.setAndContinue(WALK);
        }
        return state.setAndContinue(IDLE);
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
    protected SoundEvent getHurtSound(DamageSource source) {
        return CoffeeMod.COFFEE_GOLEM_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return CoffeeMod.COFFEE_GOLEM_AMBIENT;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "walk_idle", 0, this::predicate),
                        new AnimationController<>(this, "attack", 0, this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
