package net.dpcoffee.coffeemod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.dpcoffee.coffeemod.util.IPlayerEntityMixin;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;

public class HammerItem extends ToolItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public HammerItem(Settings settings, float attackSpeed, ToolMaterial material) {
        super(material, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", getAttackDamage(material), EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();

    }

    private float getAttackDamage(ToolMaterial m) {
        if(m == ToolMaterials.WOOD) {
            return 9;
        }
        if(m == ToolMaterials.STONE) {
            return 10;
        }
        if(m == ToolMaterials.IRON) {
            return 11;
        }
        if(m == ToolMaterials.GOLD) {
            return 9;
        }
        if(m == ToolMaterials.DIAMOND) {
            return 11;
        }
        if(m == ToolMaterials.NETHERITE) {
            return 15;
        }
        return 0;
    }



    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        target.setOnFireFor(6);
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(user.getAttackCooldownProgress(0.0f) < 1.0f) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        if(!world.isClient) {


            /**BlockPos pos = user.getBlockPos();
            CowEntity cow = new CowEntity(EntityType.COW, world);
            cow.setPos(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(cow);
             **/
        }


        BlockPos pos = user.getBlockPos();
        int reachMultiplier = 4;
        int lookX = user.getHorizontalFacing().getVector().getX();
        int lookZ = user.getHorizontalFacing().getVector().getZ();
        int dirX = lookX * reachMultiplier;
        int dirZ = lookZ * reachMultiplier;
        List<Entity> list = user.getWorld().getOtherEntities(user, new Box(pos.getX() - dirZ, pos.getY(), pos.getZ() + dirX, pos.getX() + dirX + dirZ, pos.getY() + 2, pos.getZ() - dirX + dirZ));

        for(int i = 0; i < list.size(); ++i) {
            Entity e = list.get(i);
            Vec3d dir = user.getRotationVec(0);
            Vec3d knockBack = new Vec3d(dir.x * 2, 0.2, dir.z * 2);
            //e.damage(new DamageSource((RegistryEntry<DamageType>) DamageTypes.GENERIC), getAttackDamage(this.getMaterial()) * .7f);
            e.damage(e.getDamageSources().generic(), getAttackDamage(this.getMaterial()) * .7f);
            if(this.getMaterial() == ToolMaterials.NETHERITE) {
                if(!e.isFireImmune()) {
                    e.setOnFireFor(4);
                }
            }
            e.addVelocity(knockBack);
        }

        for(int p = 0; p < 6; p++) {
            Random r = new Random();
            int low = -3;
            int high = 3;
            int rx = r.nextInt(high - low) + low;
            int rz = r.nextInt(high - low) + low;
            world.addParticle(ParticleTypes.POOF, pos.getX() + rx + lookX + .5, pos.getY(), pos.getZ() + rz + lookZ + .5, 0.0D, 0.0D, 0.0D);
        }
        user.getStackInHand(hand).damage(4, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        world.playSound(user, pos, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.AMBIENT);
        user.resetLastAttackedTicks();
        user.swingHand(hand, true);


        return super.use(world, user, hand);
    }
}
