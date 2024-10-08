package de.thedon.oresandtools.block;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.entity.ModBlockEntities;
import de.thedon.oresandtools.item.ModItems;
import de.thedon.oresandtools.render.ModBEWLRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OresAndToolsMod.MOD_ID);

    /* NORMAL BLOCKS */
    public static final RegistryObject<Block> HARDENED_DIAMOND_BLOCK = registerBlock("hardened_diamond_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(25f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(8f, 10f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> VALYRIAN_CHEST = registerBlock("valyrian_chest", () -> new ValyrianChestBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST).strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL), ModBlockEntities.VALYRIAN_CHEST::get), true);

    /* ORES */
    public static final RegistryObject<Block> VALYRIAN_ORE = registerBlock("valyrian_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_VALYRIAN_ORE = registerBlock("deepslate_valyrian_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(VALYRIAN_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ENDSTONE_VALYRIAN_ORE = registerBlock("endstone_valyrian_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(VALYRIAN_ORE.get()).mapColor(MapColor.SAND).strength(3.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> OBSIDIAN_ORE = registerBlock("obsidian_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(5f, 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_OBSIDIAN_ORE = registerBlock("deepslate_obsidian_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> XP_ORE = registerBlock("xp_ore", () -> new XpOreBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().lightLevel(getLightValueLit(8)).sound(SoundType.STONE), UniformInt.of(12, 20)));
    public static final RegistryObject<Block> DEEPSLATE_XP_ORE = registerBlock("deepslate_xp_ore", () -> new XpOreBlock(BlockBehaviour.Properties.ofFullCopy(XP_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops().lightLevel(getLightValueLit(8)).sound(SoundType.DEEPSLATE), UniformInt.of(12, 20)));
    public static final RegistryObject<Block> URANIUM_ORE = registerBlock("uranium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(URANIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(4.5f, 3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    /* MOLTEN BLOCKS */
    public static final RegistryObject<Block> MOLTEN_COPPER_ORE = registerBlock("molten_copper_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().noTerrainParticles()));
    public static final RegistryObject<Block> MOLTEN_IRON_ORE = registerBlock("molten_iron_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().noTerrainParticles()));
    public static final RegistryObject<Block> MOLTEN_GOLD_ORE = registerBlock("molten_gold_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().noTerrainParticles()));
    public static final RegistryObject<Block> MOLTEN_URANIUM_ORE = registerBlock("molten_uranium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f, 3f).requiresCorrectToolForDrops().noTerrainParticles()));
    public static final RegistryObject<Block> MOLTEN_STONE = registerBlock("molten_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(1.5f, 6f).requiresCorrectToolForDrops().noTerrainParticles()));
    public static final RegistryObject<Block> MOLTEN_SAND = registerBlock("molten_sand", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).strength(0.5f, 0.5f).noTerrainParticles()));


    @SuppressWarnings("SameParameterValue")
    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, false);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean withCustomRenderer) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (withCustomRenderer) {
            registerBlockItemWithRenderer(name, toReturn);
        } else {
            registerBlockItem(name, toReturn);
        }
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> void registerBlockItemWithRenderer(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
                consumer.accept(new IClientItemExtensions() {
                    @Override
                    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                        return new ModBEWLRenderer();
                    }
                });
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
