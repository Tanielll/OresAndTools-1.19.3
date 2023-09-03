package de.thedon.oresandtools.datagen;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.block.ModBlocks;
import de.thedon.oresandtools.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        /* NORMAL ITEMS */
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.DRAGONS_APPLE.get())
                .define('V', ModItems.VALYRIAN_DUST.get())
                .define('O', ModItems.OBSIDIAN_SHARD.get())
                .define('A', Items.APPLE)
                .pattern("VOV")
                .pattern("OAO")
                .pattern("VOV")
                .unlockedBy("has_dragon_apple_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VALYRIAN_DUST.get(), ModItems.OBSIDIAN_SHARD.get(), Items.APPLE).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HARDENED_DIAMOND.get())
                .define('O', Blocks.OBSIDIAN)
                .define('D', Items.DIAMOND)
                .pattern("ODO")
                .pattern("DOD")
                .pattern("ODO")
                .unlockedBy("has_hardened_dia_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.OBSIDIAN, Items.DIAMOND).build()))
                .save(pWriter, new ResourceLocation(OresAndToolsMod.MOD_ID,
                        getItemName(ModItems.HARDENED_DIAMOND.get()) + "_shaped"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IMPROVISED_REACTOR.get())
                .define('C', Ingredient.of(Items.COAL))
                .define('U', ModItems.URANIUM_INGOT.get())
                .define('B', Items.WATER_BUCKET)
                .pattern("C")
                .pattern("U")
                .pattern("B")
                .unlockedBy("has_impro_reactor_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.COAL, ModItems.URANIUM_INGOT.get(), Items.WATER_BUCKET).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SHIELD.get())
                .define('O', Blocks.OBSIDIAN)
                .define('D', Items.DIAMOND)
                .pattern("ODO")
                .pattern("OOO")
                .pattern(" O ")
                .unlockedBy("has_obsidian_shield_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.OBSIDIAN, Items.DIAMOND).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_CHUNK.get())
                .define('C', Ingredient.of(Items.COAL))
                .define('I', Items.RAW_IRON)
                .pattern("CI")
                .pattern("IC")
                .unlockedBy("has_steel_chunk_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.COAL, Items.RAW_IRON).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STEEL_CHUNK.get())
                .define('C', Ingredient.of(Items.COAL))
                .define('I', Items.IRON_NUGGET)
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .unlockedBy("has_steel_chunk_ingredients_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.COAL, Items.IRON_NUGGET).build()))
                .save(pWriter, "steel_chunk_2");
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VALYRIAN_BOW.get())
                .define('V', ModItems.VALYRIAN_INGOT.get())
                .define('S', Items.STRING)
                .pattern(" VS")
                .pattern("V S")
                .pattern(" VS")
                .unlockedBy("has_valyrian_dust", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VALYRIAN_DUST.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VALYRIAN_INGOT.get())
                .define('V', ModItems.VALYRIAN_DUST.get())
                .define('S', ModItems.STEEL_INGOT.get())
                .pattern("VVV")
                .pattern("VSV")
                .pattern("VVV")
                .unlockedBy("has_valyrian_ingot_ingredients", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VALYRIAN_DUST.get(), ModItems.STEEL_INGOT.get()).build()))
                .save(pWriter);

        /* NINE BLOCK STORAGE */
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.HARDENED_DIAMOND.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.HARDENED_DIAMOND_BLOCK.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.STEEL_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD.get(),
                RecipeCategory.BUILDING_BLOCKS, Blocks.OBSIDIAN);

        /* SMELTING & BLASTING */
        oreSmelting(pWriter, List.of(ModBlocks.OBSIDIAN_ORE.get()), RecipeCategory.BUILDING_BLOCKS,
                Blocks.OBSIDIAN, 5.0F, 500, "obsidian");
        oreBlasting(pWriter, List.of(ModBlocks.OBSIDIAN_ORE.get()), RecipeCategory.BUILDING_BLOCKS,
                Blocks.OBSIDIAN, 3.0F, 300, "obsidian");
        oreBlasting(pWriter, List.of(ModItems.STEEL_CHUNK.get()), RecipeCategory.BUILDING_BLOCKS,
                ModItems.STEEL_INGOT.get(), 1.5F, 150, "steel_ingot");
        oreSmelting(pWriter, List.of(ModItems.RAW_URANIUM.get(), ModBlocks.URANIUM_ORE.get(), ModBlocks.DEEPSLATE_URANIUM_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_INGOT.get(), 1.0F, 200, "uranium_ingot");
        oreBlasting(pWriter, List.of(ModItems.RAW_URANIUM.get(), ModBlocks.URANIUM_ORE.get(), ModBlocks.DEEPSLATE_URANIUM_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_INGOT.get(), 0.75F, 100, "uranium_ingot");
        oreSmelting(pWriter, List.of(ModBlocks.VALYRIAN_ORE.get(), ModBlocks.DEEPSLATE_VALYRIAN_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, ModItems.VALYRIAN_DUST.get(), 3.0F, 180, "valyrian_dust");
        oreBlasting(pWriter, List.of(ModBlocks.VALYRIAN_ORE.get(), ModBlocks.DEEPSLATE_VALYRIAN_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, ModItems.VALYRIAN_DUST.get(), 2.0F, 90, "valyrian_dust");
        oreSmelting(pWriter, List.of(ModBlocks.XP_ORE.get(), ModBlocks.DEEPSLATE_XP_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, 10.0F, 200, "xp");
        oreBlasting(pWriter, List.of(ModBlocks.XP_ORE.get(), ModBlocks.DEEPSLATE_XP_ORE.get()),
                RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, 5.0F, 200, "xp");

        /* TOOLS */
        toolSetRecipes(pWriter, Items.COPPER_INGOT,
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_HOE.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_SWORD.get());
        toolSetRecipes(pWriter, Items.EMERALD,
                ModItems.EMERALD_AXE.get(),
                ModItems.EMERALD_HOE.get(),
                ModItems.EMERALD_PICKAXE.get(),
                ModItems.EMERALD_SHOVEL.get(),
                ModItems.EMERALD_SWORD.get());
        toolSetRecipes(pWriter, ModItems.HARDENED_DIAMOND.get(),
                ModItems.HARDENED_DIAMOND_AXE.get(),
                ModItems.HARDENED_DIAMOND_HOE.get(),
                ModItems.HARDENED_DIAMOND_PICKAXE.get(),
                ModItems.HARDENED_DIAMOND_SHOVEL.get(),
                ModItems.HARDENED_DIAMOND_SWORD.get());
        toolSetRecipes(pWriter, ModItems.HOT_HARDENED_DIAMOND.get(),
                ModItems.HOT_HARDENED_DIAMOND_AXE.get(),
                ModItems.HOT_HARDENED_DIAMOND_HOE.get(),
                ModItems.HOT_HARDENED_DIAMOND_PICKAXE.get(),
                ModItems.HOT_HARDENED_DIAMOND_SHOVEL.get(),
                ModItems.HOT_HARDENED_DIAMOND_SWORD.get());
        toolSetRecipes(pWriter, Blocks.OBSIDIAN.asItem(),
                ModItems.OBSIDIAN_AXE.get(),
                ModItems.OBSIDIAN_HOE.get(),
                ModItems.OBSIDIAN_PICKAXE.get(),
                ModItems.OBSIDIAN_SHOVEL.get(),
                ModItems.OBSIDIAN_SWORD.get());
        toolSetRecipes(pWriter, ModItems.STEEL_INGOT.get(),
                ModItems.STEEL_AXE.get(),
                ModItems.STEEL_HOE.get(),
                ModItems.STEEL_PICKAXE.get(),
                ModItems.STEEL_SHOVEL.get(),
                ModItems.STEEL_SWORD.get());
        toolSetRecipes(pWriter, ModItems.VALYRIAN_INGOT.get(),
                ModItems.VALYRIAN_AXE.get(),
                ModItems.VALYRIAN_HOE.get(),
                ModItems.VALYRIAN_PICKAXE.get(),
                ModItems.VALYRIAN_SHOVEL.get(),
                ModItems.VALYRIAN_SWORD.get());

        /* ARMOR */
        armorSetRecipes(pWriter, Items.COPPER_INGOT,
                ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COPPER_BOOTS.get());
        armorSetRecipes(pWriter, Items.EMERALD,
                ModItems.EMERALD_HELMET.get(),
                ModItems.EMERALD_CHESTPLATE.get(),
                ModItems.EMERALD_LEGGINGS.get(),
                ModItems.EMERALD_BOOTS.get());
        armorSetRecipes(pWriter, ModItems.HARDENED_DIAMOND.get(),
                ModItems.HARDENED_DIAMOND_HELMET.get(),
                ModItems.HARDENED_DIAMOND_CHESTPLATE.get(),
                ModItems.HARDENED_DIAMOND_LEGGINGS.get(),
                ModItems.HARDENED_DIAMOND_BOOTS.get());
        armorSetRecipes(pWriter, ModItems.HOT_HARDENED_DIAMOND.get(),
                ModItems.HOT_HARDENED_DIAMOND_HELMET.get(),
                ModItems.HOT_HARDENED_DIAMOND_CHESTPLATE.get(),
                ModItems.HOT_HARDENED_DIAMOND_LEGGINGS.get(),
                ModItems.HOT_HARDENED_DIAMOND_BOOTS.get());
        armorSetRecipes(pWriter, Items.OBSIDIAN,
                ModItems.OBSIDIAN_HELMET.get(),
                ModItems.OBSIDIAN_CHESTPLATE.get(),
                ModItems.OBSIDIAN_LEGGINGS.get(),
                ModItems.OBSIDIAN_BOOTS.get());
        armorSetRecipes(pWriter, ModItems.STEEL_INGOT.get(),
                ModItems.STEEL_HELMET.get(),
                ModItems.STEEL_CHESTPLATE.get(),
                ModItems.STEEL_LEGGINGS.get(),
                ModItems.STEEL_BOOTS.get());
        armorSetRecipes(pWriter, ModItems.VALYRIAN_INGOT.get(),
                ModItems.VALYRIAN_HELMET.get(),
                ModItems.VALYRIAN_CHESTPLATE.get(),
                ModItems.VALYRIAN_LEGGINGS.get(),
                ModItems.VALYRIAN_BOOTS.get());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pConsumer, pUnpackedCategory, pUnpacked, pPackedCategory,
                pPacked, getSimpleRecipeName(pPacked), (String)null, getSimpleRecipeName(pUnpacked), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName, @Nullable String pPackedGroup, String pUnpackedName, @Nullable String pUnpackedGroup) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked)
                .group(pUnpackedGroup)
                .unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pConsumer, new ResourceLocation(OresAndToolsMod.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked)
                .define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pPackedGroup)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pConsumer, new ResourceLocation(OresAndToolsMod.MOD_ID, pPackedName));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                    Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pConsumer, new ResourceLocation(
                            OresAndToolsMod.MOD_ID,
                            getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike)));
        }
    }

    protected static void toolSetRecipes(Consumer<FinishedRecipe> pConsumer, Item pMaterial,
                                         ItemLike pAxe, ItemLike pHoe, ItemLike pPickaxe, ItemLike pShovel, ItemLike pSword) {
        axeBuilder(pAxe, pMaterial).save(pConsumer);
        hoeBuilder(pHoe, pMaterial).save(pConsumer);
        pickaxeBuilder(pPickaxe, pMaterial).save(pConsumer);
        shovelBuilder(pShovel, pMaterial).save(pConsumer);
        swordBuilder(pSword, pMaterial).save(pConsumer);
    }

    protected static void armorSetRecipes(Consumer<FinishedRecipe> pConsumer, Item pMaterial,
                                         ItemLike pHelmet, ItemLike pChestplate, ItemLike pLeggings, ItemLike pBoots) {
        helmetBuilder(pHelmet, pMaterial).save(pConsumer);
        chestplateBuilder(pChestplate, pMaterial).save(pConsumer);
        leggingsBuilder(pLeggings, pMaterial).save(pConsumer);
        bootsBuilder(pBoots, pMaterial).save(pConsumer);
    }

    protected static RecipeBuilder axeBuilder(ItemLike pAxe, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pAxe)
                .define('#', pMaterial)
                .define('S', Items.STICK)
                .pattern("##")
                .pattern("#S")
                .pattern(" S")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder hoeBuilder(ItemLike pHoe, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHoe)
                .define('#', pMaterial)
                .define('S', Items.STICK)
                .pattern("##")
                .pattern(" S")
                .pattern(" S")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder pickaxeBuilder(ItemLike pPickaxe, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPickaxe)
                .define('#', pMaterial)
                .define('S', Items.STICK)
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder shovelBuilder(ItemLike pShovel, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pShovel)
                .define('#', pMaterial)
                .define('S', Items.STICK)
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder swordBuilder(ItemLike pSword, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pSword)
                .define('#', pMaterial)
                .define('S', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder helmetBuilder(ItemLike pHelmet, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pHelmet)
                .define('#', pMaterial)
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder chestplateBuilder(ItemLike pChestplate, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pChestplate)
                .define('#', pMaterial)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder leggingsBuilder(ItemLike pLeggings, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pLeggings)
                .define('#', pMaterial)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }

    protected static RecipeBuilder bootsBuilder(ItemLike pBoots, Item pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pBoots)
                .define('#', pMaterial)
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_" + getItemName(pMaterial),
                        inventoryTrigger(ItemPredicate.Builder.item().of(pMaterial).build()));
    }
}
