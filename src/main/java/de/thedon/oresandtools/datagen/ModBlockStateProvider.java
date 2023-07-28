package de.thedon.oresandtools.datagen;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OresAndToolsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /* NORMAL BLOCKS */
        blockWithItem(ModBlocks.HARDENED_DIAMOND_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);

        /* ORES */
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
