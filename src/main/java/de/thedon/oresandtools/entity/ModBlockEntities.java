package de.thedon.oresandtools.entity;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OresAndToolsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ValyrianChestBlockEntity>> VALYRIAN_CHEST
            = BLOCK_ENTITIES.register("valyrian_chest", () -> BlockEntityType.Builder.of(ValyrianChestBlockEntity::new, ModBlocks.VALYRIAN_CHEST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
