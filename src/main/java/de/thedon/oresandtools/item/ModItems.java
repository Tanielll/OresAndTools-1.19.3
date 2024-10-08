package de.thedon.oresandtools.item;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.item.custom.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OresAndToolsMod.MOD_ID);

    public static final RegistryObject<Item> HARDENED_DIAMOND = ITEMS.register("hardened_diamond", () -> new ModItem(new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HEATING_HARDENED_DIAMOND_1 = ITEMS.register("heating_hardened_diamond_1", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HEATING_HARDENED_DIAMOND_2 = ITEMS.register("heating_hardened_diamond_2", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HEATING_HARDENED_DIAMOND_3 = ITEMS.register("heating_hardened_diamond_3", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND = ITEMS.register("hot_hardened_diamond", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_DUST = ITEMS.register("valyrian_dust", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRAGONS_APPLE = ITEMS.register("dragons_apple", () -> new ModItem(new Item.Properties().food(ModFoods.DRAGONS_APPLE), true));
    public static final RegistryObject<Item> STEEL_CHUNK = ITEMS.register("steel_chunk", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_INGOT = ITEMS.register("valyrian_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uranium", () -> new ModItem(new Item.Properties(), true));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new ModItem(new Item.Properties(), true));
    public static final RegistryObject<Item> IMPROVISED_REACTOR = ITEMS.register("improvised_reactor", () -> new ImprovisedReactorItem(new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_LEATHER = ITEMS.register("valyrian_leather", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_BACKPACK = ITEMS.register("shulker_backpack", () -> new BackpackItem(new Item.Properties(), false));

    /* TOOLS */
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ModShovelItem(ModToolTiers.COPPER, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new ModPickaxeItem(ModToolTiers.COPPER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new ModAxeItem(ModToolTiers.COPPER, 6f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new ModHoeItem(ModToolTiers.COPPER, -3, -1f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new ModSwordItem(ModToolTiers.COPPER, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ModShovelItem(ModToolTiers.STEEL, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new ModPickaxeItem(ModToolTiers.STEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new ModAxeItem(ModToolTiers.STEEL, 6f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () -> new ModHoeItem(ModToolTiers.STEEL, -3, -1f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new ModSwordItem(ModToolTiers.STEEL, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_SHOVEL = ITEMS.register("valyrian_shovel", () -> new ModShovelItem(ModToolTiers.VALYRIAN, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_PICKAXE = ITEMS.register("valyrian_pickaxe", () -> new ModPickaxeItem(ModToolTiers.VALYRIAN, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_AXE = ITEMS.register("valyrian_axe", () -> new ModAxeItem(ModToolTiers.VALYRIAN, 4f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_HOE = ITEMS.register("valyrian_hoe", () -> new ModHoeItem(ModToolTiers.VALYRIAN, -3, 1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_SWORD = ITEMS.register("valyrian_sword", () -> new ModSwordItem(ModToolTiers.VALYRIAN, 3, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_SHOVEL = ITEMS.register("hardened_diamond_shovel", () -> new ModShovelItem(ModToolTiers.HARDENED_DIAMOND, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_PICKAXE = ITEMS.register("hardened_diamond_pickaxe", () -> new ModPickaxeItem(ModToolTiers.HARDENED_DIAMOND, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_AXE = ITEMS.register("hardened_diamond_axe", () -> new ModAxeItem(ModToolTiers.HARDENED_DIAMOND, 6f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_HOE = ITEMS.register("hardened_diamond_hoe", () -> new ModHoeItem(ModToolTiers.HARDENED_DIAMOND, -3, 1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_SWORD = ITEMS.register("hardened_diamond_sword", () -> new ModSwordItem(ModToolTiers.HARDENED_DIAMOND, 3, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_SHOVEL = ITEMS.register("hot_hardened_diamond_shovel", () -> new ModShovelItem(ModToolTiers.HOT_HARDENED_DIAMOND, 1.5f, -3f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_PICKAXE = ITEMS.register("hot_hardened_diamond_pickaxe", () -> new ModPickaxeItem(ModToolTiers.HOT_HARDENED_DIAMOND, 1, -2.8f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_AXE = ITEMS.register("hot_hardened_diamond_axe", () -> new ModAxeItem(ModToolTiers.HOT_HARDENED_DIAMOND, 6f, -3.1f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_HOE = ITEMS.register("hot_hardened_diamond_hoe", () -> new ModHoeItem(ModToolTiers.HOT_HARDENED_DIAMOND, -3, 1f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_SWORD = ITEMS.register("hot_hardened_diamond_sword", () -> new ModSwordItem(ModToolTiers.HOT_HARDENED_DIAMOND, 3, -2.4f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ModShovelItem(ModToolTiers.EMERALD, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new ModPickaxeItem(ModToolTiers.EMERALD, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new ModAxeItem(ModToolTiers.EMERALD, 5.5f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new ModHoeItem(ModToolTiers.EMERALD, -3, 0f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new ModSwordItem(ModToolTiers.EMERALD, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ModShovelItem(ModToolTiers.OBSIDIAN, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new ModPickaxeItem(ModToolTiers.OBSIDIAN, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new ModAxeItem(ModToolTiers.OBSIDIAN, 5f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new ModHoeItem(ModToolTiers.OBSIDIAN, -3, -1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new ModSwordItem(ModToolTiers.OBSIDIAN, 3, -2.4f, new Item.Properties().fireResistant()));

    /* ARMOR */
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_HELMET = ITEMS.register("valyrian_helmet", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.HELMET, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_CHESTPLATE = ITEMS.register("valyrian_chestplate", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_LEGGINGS = ITEMS.register("valyrian_leggings", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_BOOTS = ITEMS.register("valyrian_boots", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HARDENED_DIAMOND_HELMET = ITEMS.register("hardened_diamond_helmet", () -> new ModArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_CHESTPLATE = ITEMS.register("hardened_diamond_chestplate", () -> new ModArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_LEGGINGS = ITEMS.register("hardened_diamond_leggings", () -> new ModArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_BOOTS = ITEMS.register("hardened_diamond_boots", () -> new ModArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_HELMET = ITEMS.register("hot_hardened_diamond_helmet", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_CHESTPLATE = ITEMS.register("hot_hardened_diamond_chestplate", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_LEGGINGS = ITEMS.register("hot_hardened_diamond_leggings", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_BOOTS = ITEMS.register("hot_hardened_diamond_boots", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    /* BOWS */
    public static final RegistryObject<Item> VALYRIAN_BOW = ITEMS.register("valyrian_bow", () -> new ModBowItem(VALYRIAN_INGOT.get(), 1.1f, 60000, 20, new Item.Properties().durability(3225)));

    /* SHIELDS */
    public static final RegistryObject<Item> OBSIDIAN_SHIELD = ITEMS.register("obsidian_shield", () -> new ModShieldItem(Items.OBSIDIAN, new Item.Properties().durability(2500)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
