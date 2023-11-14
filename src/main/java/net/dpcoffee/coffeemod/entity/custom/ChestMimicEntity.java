package net.dpcoffee.coffeemod.entity.custom;

import com.ibm.icu.impl.LocaleDisplayNamesImpl;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
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

import javax.xml.crypto.Data;
import java.util.Random;

public class ChestMimicEntity extends HostileEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    private static final RawAnimation OPEN = RawAnimation.begin().thenPlay("animation.chest_mimic.open");
    private static final RawAnimation CLOSE = RawAnimation.begin().thenPlay("animation.chest_mimic.close");
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chest_mimic.idle");

    private static final TrackedData<Boolean> ACTIVE = DataTracker.registerData(ChestMimicEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> ACTIVE_TIME = DataTracker.registerData(ChestMimicEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> POS_SET = DataTracker.registerData(ChestMimicEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private Random r = new Random();


    public ChestMimicEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setStepHeight(3.0f);
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ACTIVE, false);
        this.dataTracker.startTracking(POS_SET, false);
        this.dataTracker.startTracking(ACTIVE_TIME, 0);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.dataTracker.get(ACTIVE)) {
            this.setAiDisabled(false);
            this.dataTracker.set(POS_SET, false);
        }else {
            float dir = (this.getYaw() % 360 + 360) % 360;
            if (dir > 135 || dir < -135) {
                this.setBodyYaw(Direction.NORTH.asRotation());
            } else if (dir < -45) {
                this.setBodyYaw(Direction.EAST.asRotation());
            } else if (dir > 45) {
                this.setBodyYaw(Direction.WEST.asRotation());
            } else {
                this.setBodyYaw(Direction.SOUTH.asRotation());
            }

            this.setAiDisabled(true);
            if(!this.dataTracker.get(POS_SET)) {
                setBlockPosition();
            }
        }
    }

    @Override
    public void mobTick() {
        super.mobTick();

        if(this.dataTracker.get(ACTIVE) && this.getTarget() != null) {
            this.dataTracker.set(ACTIVE_TIME, 100);
        } else {
            this.dataTracker.set(ACTIVE_TIME, this.dataTracker.get(ACTIVE_TIME) - 1);
        }

        if(this.dataTracker.get(ACTIVE_TIME) <= 0) {
            this.dataTracker.set(ACTIVE, false);
        }

        if(this.dataTracker.get(ACTIVE)) {
            if (this.isOnGround() && this.getTarget() != null && r.nextInt(60) == 3) {
                this.getMoveControl().moveTo(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ(), 4);
                this.addVelocity(0, r.nextFloat(0.8f), 0);
            }
        } else {
            Vec3d rot = this.getRotationVector();
            this.setVelocity(Vec3d.ZERO);

        }
    }

    void setBlockPosition() {
        this.setPos(Math.ceil(this.getPos().x) - 0.5,(int)this.getPos().y,Math.ceil(this.getPos().z) - 0.5);
        this.serverYaw = 1;
        this.dataTracker.set(POS_SET, true);
    }


    @Override
    public boolean handleAttack(Entity attacker) {
        if(attacker.getClass() == ServerPlayerEntity.class) {
            if(!this.getWorld().isClient) {
                this.dataTracker.set(ACTIVE, true);
                this.dataTracker.set(ACTIVE_TIME, 100);
            }
        }
        return super.handleAttack(attacker);
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if(!this.getWorld().isClient) {
            this.dataTracker.set(ACTIVE, true);
            this.dataTracker.set(ACTIVE_TIME, 100);
        }
        return ActionResult.success(this.getWorld().isClient);

    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 10.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        //this.goalSelector.add(1, new TargetGoal<PlayerEntity>(this, PlayerEntity.class));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1, false));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
        if(this.dataTracker.get(ACTIVE)) {
            if (state.isCurrentAnimation(CLOSE) || (state.isCurrentAnimation(OPEN) && state.getController().getAnimationState().equals(AnimationController.State.RUNNING))) {
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

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("active", this.dataTracker.get(ACTIVE));
        nbt.putInt("active_time", this.dataTracker.get(ACTIVE_TIME));
        nbt.putBoolean("pos_set", this.dataTracker.get(POS_SET));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(ACTIVE, nbt.getBoolean("active"));
        this.dataTracker.set(ACTIVE_TIME, nbt.getInt("active_time"));
        this.dataTracker.set(POS_SET, nbt.getBoolean("pos_set"));
    }
}
