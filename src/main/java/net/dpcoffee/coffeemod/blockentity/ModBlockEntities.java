package net.dpcoffee.coffeemod.blockentity;
import net.dpcoffee.coffeemod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<BlockEntityQrag> BLOCK_ENTITY_QRAG;
    public static BlockEntityType<BlockEntityStaffHolder> BLOCK_ENTITY_STAFF_HOLDER;
    public static BlockEntityType<BlockEntityJetPackCharger> BLOCK_ENTITY_JET_PACK_CHARGER;
    public static BlockEntityType<BlockEntityMythicAnvil> BLOCK_ENTITY_MYTHIC_ANVIL;

    public static void registerBlockEntities() {
        BLOCK_ENTITY_QRAG = Registry.register(Registries.BLOCK_ENTITY_TYPE, "coffeemod:block_entity_qrag", FabricBlockEntityTypeBuilder.create(BlockEntityQrag::new, ModBlocks.Q_RAG).build());
        BLOCK_ENTITY_STAFF_HOLDER = Registry.register(Registries.BLOCK_ENTITY_TYPE, "coffeemod:block_entity_staff_holder", FabricBlockEntityTypeBuilder.create(BlockEntityStaffHolder::new, ModBlocks.STAFF_HOLDER).build());
        BLOCK_ENTITY_JET_PACK_CHARGER = Registry.register(Registries.BLOCK_ENTITY_TYPE, "coffeemod:block_entity_jet_pack_charger", FabricBlockEntityTypeBuilder.create(BlockEntityJetPackCharger::new, ModBlocks.JET_PACK_CHARGER).build());
        BLOCK_ENTITY_MYTHIC_ANVIL = Registry.register(Registries.BLOCK_ENTITY_TYPE, "coffeemod:block_entity_mythic_anvil", FabricBlockEntityTypeBuilder.create(BlockEntityMythicAnvil::new, ModBlocks.MYTHIC_ANVIL).build());
    }
}

