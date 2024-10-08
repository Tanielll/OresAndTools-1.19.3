package de.thedon.oresandtools.item;

import de.thedon.oresandtools.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier COPPER = new ForgeTier(180, 9f, 1f, 17,
            ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL);

    public static final Tier STEEL = new ForgeTier(500, 6.5f, 2.5f, 12,
            ModTags.Blocks.NEEDS_STEEL_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL);

    public static final Tier VALYRIAN = new ForgeTier(4000, 10f, 6f, 25,
            ModTags.Blocks.NEEDS_VALYRIAN_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_VALYRIAN_TOOL);

    public static final Tier HARDENED_DIAMOND = new ForgeTier(7000, 8f, 3f, 10,
            ModTags.Blocks.NEEDS_HARDENED_DIAMOND_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_HARDENED_DIAMOND_TOOL);

    public static final Tier HOT_HARDENED_DIAMOND = new ForgeTier(5500, 8f, 3f, 11,
            ModTags.Blocks.NEEDS_HOT_HARDENED_DIAMOND_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_HOT_HARDENED_DIAMOND_TOOL);

    public static final Tier EMERALD = new ForgeTier(1561, 12f, 3f, 14,
            ModTags.Blocks.NEEDS_EMERALD_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL);

    public static final Tier OBSIDIAN = new ForgeTier(6500, 6f, 3f, 8,
            ModTags.Blocks.NEEDS_OBSIDIAN_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL);
}
