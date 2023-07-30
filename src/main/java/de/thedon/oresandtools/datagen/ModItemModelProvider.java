package de.thedon.oresandtools.datagen;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAndToolsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /* NORMAL ITEMS */
        simpleItem(ModItems.HARDENED_DIAMOND);
        simpleItem(ModItems.HEATING_HARDENED_DIAMOND_1);
        simpleItem(ModItems.HEATING_HARDENED_DIAMOND_2);
        simpleItem(ModItems.HEATING_HARDENED_DIAMOND_3);
        simpleItem(ModItems.HOT_HARDENED_DIAMOND);
        simpleItem(ModItems.VALYRIAN_DUST);
        simpleItem(ModItems.VALYRIAN_INGOT);
        simpleItem(ModItems.OBSIDIAN_SHARD);
        simpleItem(ModItems.DRAGONS_APPLE);
        simpleItem(ModItems.STEEL_CHUNK);
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.RAW_URANIUM);
        simpleItem(ModItems.URANIUM_INGOT);
        simpleItem(ModItems.IMPROVISED_REACTOR);
        /* TOOLS */
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_HOE);
        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.STEEL_SHOVEL);
        handheldItem(ModItems.STEEL_PICKAXE);
        handheldItem(ModItems.STEEL_AXE);
        handheldItem(ModItems.STEEL_HOE);
        handheldItem(ModItems.STEEL_SWORD);
        handheldItem(ModItems.VALYRIAN_SHOVEL);
        handheldItem(ModItems.VALYRIAN_PICKAXE);
        handheldItem(ModItems.VALYRIAN_AXE);
        handheldItem(ModItems.VALYRIAN_HOE);
        handheldItem(ModItems.VALYRIAN_SWORD);
        handheldItem(ModItems.HARDENED_DIAMOND_SHOVEL);
        handheldItem(ModItems.HARDENED_DIAMOND_PICKAXE);
        handheldItem(ModItems.HARDENED_DIAMOND_AXE);
        handheldItem(ModItems.HARDENED_DIAMOND_HOE);
        handheldItem(ModItems.HARDENED_DIAMOND_SWORD);
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_SHOVEL);
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_PICKAXE);
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_AXE);
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_HOE);
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_SWORD);
        handheldItem(ModItems.EMERALD_SHOVEL);
        handheldItem(ModItems.EMERALD_PICKAXE);
        handheldItem(ModItems.EMERALD_AXE);
        handheldItem(ModItems.EMERALD_HOE);
        handheldItem(ModItems.EMERALD_SWORD);
        handheldItem(ModItems.OBSIDIAN_SHOVEL);
        handheldItem(ModItems.OBSIDIAN_PICKAXE);
        handheldItem(ModItems.OBSIDIAN_AXE);
        handheldItem(ModItems.OBSIDIAN_HOE);
        handheldItem(ModItems.OBSIDIAN_SWORD);
        /* ARMOR */
        simpleItem(ModItems.COPPER_HELMET);
        simpleItem(ModItems.COPPER_CHESTPLATE);
        simpleItem(ModItems.COPPER_LEGGINGS);
        simpleItem(ModItems.COPPER_BOOTS);
        simpleItem(ModItems.STEEL_HELMET);
        simpleItem(ModItems.STEEL_CHESTPLATE);
        simpleItem(ModItems.STEEL_LEGGINGS);
        simpleItem(ModItems.STEEL_BOOTS);
        simpleItem(ModItems.VALYRIAN_HELMET);
        simpleItem(ModItems.VALYRIAN_CHESTPLATE);
        simpleItem(ModItems.VALYRIAN_LEGGINGS);
        simpleItem(ModItems.VALYRIAN_BOOTS);
        simpleItem(ModItems.HARDENED_DIAMOND_HELMET);
        simpleItem(ModItems.HARDENED_DIAMOND_CHESTPLATE);
        simpleItem(ModItems.HARDENED_DIAMOND_LEGGINGS);
        simpleItem(ModItems.HARDENED_DIAMOND_BOOTS);
        simpleItem(ModItems.HOT_HARDENED_DIAMOND_HELMET);
        simpleItem(ModItems.HOT_HARDENED_DIAMOND_CHESTPLATE);
        simpleItem(ModItems.HOT_HARDENED_DIAMOND_LEGGINGS);
        simpleItem(ModItems.HOT_HARDENED_DIAMOND_BOOTS);
        simpleItem(ModItems.EMERALD_HELMET);
        simpleItem(ModItems.EMERALD_CHESTPLATE);
        simpleItem(ModItems.EMERALD_LEGGINGS);
        simpleItem(ModItems.EMERALD_BOOTS);
        simpleItem(ModItems.OBSIDIAN_HELMET);
        simpleItem(ModItems.OBSIDIAN_CHESTPLATE);
        simpleItem(ModItems.OBSIDIAN_LEGGINGS);
        simpleItem(ModItems.OBSIDIAN_BOOTS);
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(OresAndToolsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(OresAndToolsMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
