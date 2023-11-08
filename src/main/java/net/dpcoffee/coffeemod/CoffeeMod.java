package net.dpcoffee.coffeemod;


import net.dpcoffee.coffeemod.Enchatment.EnchantmentRegistry;
import net.dpcoffee.coffeemod.block.ModBlocks;
import net.dpcoffee.coffeemod.blockentity.ModBlockEntities;
import net.dpcoffee.coffeemod.entity.ModEntities;
import net.dpcoffee.coffeemod.entity.custom.ChestMimicEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeGolemEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeSpiderEntity;
import net.dpcoffee.coffeemod.entity.custom.CoffeeThingEntity;
import net.dpcoffee.coffeemod.entity.projectile.GrenadeEntity;
import net.dpcoffee.coffeemod.gen.ModEntitySpawn;
import net.dpcoffee.coffeemod.item.ModItems;
import net.dpcoffee.coffeemod.networking.ModPackets;
import net.dpcoffee.coffeemod.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;


public class CoffeeMod implements ModInitializer {

	public static final String MOD_ID = "coffeemod";
	public static final Logger LOGGER = LoggerFactory.getLogger("coffeemod");
	public static SoundEvent COFFEE_THING_AMBIENT = SoundEvent.of(new Identifier(MOD_ID, "coffee_thing_ambient"));
	public static SoundEvent COFFEE_THING_HURT = SoundEvent.of(new Identifier(MOD_ID, "coffee_thing_hurt"));
	public static SoundEvent COFFEE_GOLEM_HURT = SoundEvent.of(new Identifier(MOD_ID, "coffee_golem_hurt"));
	public static SoundEvent COFFEE_GOLEM_AMBIENT = SoundEvent.of(new Identifier(MOD_ID, "coffee_golem_ambient"));

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();
		GeckoLib.initialize();
		EnchantmentRegistry.registerEnchantments();

		FabricDefaultAttributeRegistry.register(ModEntities.COFFEE_THING, CoffeeThingEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.COFFEE_GOLEM, CoffeeGolemEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.COFFEE_SPIDER, CoffeeSpiderEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CHEST_MIMIC, ChestMimicEntity.setAttributes());

		portalRegister();
		soundRegister();
		ModPackets.registerS2CPackets();

		ModEntitySpawn.addEntitySpawn();



	}

	private void soundRegister() {
		 Registry.register(Registries.SOUND_EVENT, new Identifier(MOD_ID, "coffee_thing_ambient"),COFFEE_THING_AMBIENT);
		 Registry.register(Registries.SOUND_EVENT, new Identifier(MOD_ID, "coffee_thing_hurt"), COFFEE_THING_HURT);
	}

	private void portalRegister() {
		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.COFFEE_BEAN_BLOCK)
				.lightWithItem(ModItems.NETHERITE_INFUSED_COFFEE_BEANS)
				.destDimID(new Identifier(CoffeeMod.MOD_ID, "coffee"))
				.tintColor(78, 0, 10)
				.registerPortal();

	}
}
