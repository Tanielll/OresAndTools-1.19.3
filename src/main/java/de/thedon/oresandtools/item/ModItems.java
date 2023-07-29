package de.thedon.oresandtools.item;

import de.thedon.oresandtools.OresAndToolsMod;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.List;

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

    /* TOOLS */
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ModTiers.COPPER, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModTiers.COPPER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModTiers.COPPER, 6f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ModTiers.COPPER, -3, -1f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ModTiers.COPPER, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(ModTiers.STEEL, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(ModTiers.STEEL, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(ModTiers.STEEL, 6f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(ModTiers.STEEL, -3, -1f, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(ModTiers.STEEL, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_SHOVEL = ITEMS.register("valyrian_shovel", () -> new ShovelItem(ModTiers.VALYRIAN, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_PICKAXE = ITEMS.register("valyrian_pickaxe", () -> new PickaxeItem(ModTiers.VALYRIAN, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_AXE = ITEMS.register("valyrian_axe", () -> new AxeItem(ModTiers.VALYRIAN, 4f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_HOE = ITEMS.register("valyrian_hoe", () -> new HoeItem(ModTiers.VALYRIAN, -3, 1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VALYRIAN_SWORD = ITEMS.register("valyrian_sword", () -> new SwordItem(ModTiers.VALYRIAN, 3, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_SHOVEL = ITEMS.register("hardened_diamond_shovel", () -> new ShovelItem(ModTiers.H_DIAMOND, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_PICKAXE = ITEMS.register("hardened_diamond_pickaxe", () -> new PickaxeItem(ModTiers.H_DIAMOND, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_AXE = ITEMS.register("hardened_diamond_axe", () -> new AxeItem(ModTiers.H_DIAMOND, 6f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_HOE = ITEMS.register("hardened_diamond_hoe", () -> new HoeItem(ModTiers.H_DIAMOND, -3, 1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_SWORD = ITEMS.register("hardened_diamond_sword", () -> new SwordItem(ModTiers.H_DIAMOND, 3, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_SHOVEL = ITEMS.register("hot_hardened_diamond_shovel", () -> new ModShovelItem(ModTiers.HOT_H_DIAMOND, 1.5f, -3f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_PICKAXE = ITEMS.register("hot_hardened_diamond_pickaxe", () -> new ModPickaxeItem(ModTiers.HOT_H_DIAMOND, 1, -2.8f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_AXE = ITEMS.register("hot_hardened_diamond_axe", () -> new ModAxeItem(ModTiers.HOT_H_DIAMOND, 6f, -3.1f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_HOE = ITEMS.register("hot_hardened_diamond_hoe", () -> new ModHoeItem(ModTiers.HOT_H_DIAMOND, -3, 1f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_SWORD = ITEMS.register("hot_hardened_diamond_sword", () -> new ModSwordItem(ModTiers.HOT_H_DIAMOND, 3, -2.4f, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(ModTiers.EMERALD, 1.5f, -3f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(ModTiers.EMERALD, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(ModTiers.EMERALD, 5.5f, -3.1f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ModTiers.EMERALD, -3, 0f, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(ModTiers.EMERALD, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () -> new ShovelItem(ModTiers.OBSIDIAN, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () -> new PickaxeItem(ModTiers.OBSIDIAN, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () -> new AxeItem(ModTiers.OBSIDIAN, 5f, -3.1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () -> new HoeItem(ModTiers.OBSIDIAN, -3, -1f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new SwordItem(ModTiers.OBSIDIAN, 3, -2.4f, new Item.Properties().fireResistant()));

    /* ARMOR */
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> VALYRIAN_HELMET = ITEMS.register("valyrian_helmet", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.HELMET, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_CHESTPLATE = ITEMS.register("valyrian_chestplate", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_LEGGINGS = ITEMS.register("valyrian_leggings", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> VALYRIAN_BOOTS = ITEMS.register("valyrian_boots", () -> new ModArmorItem(ModArmorMaterials.VALYRIAN, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HARDENED_DIAMOND_HELMET = ITEMS.register("hardened_diamond_helmet", () -> new ArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_CHESTPLATE = ITEMS.register("hardened_diamond_chestplate", () -> new ArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_LEGGINGS = ITEMS.register("hardened_diamond_leggings", () -> new ArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HARDENED_DIAMOND_BOOTS = ITEMS.register("hardened_diamond_boots", () -> new ArmorItem(ModArmorMaterials.H_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_HELMET = ITEMS.register("hot_hardened_diamond_helmet", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_CHESTPLATE = ITEMS.register("hot_hardened_diamond_chestplate", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_LEGGINGS = ITEMS.register("hot_hardened_diamond_leggings", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> HOT_HARDENED_DIAMOND_BOOTS = ITEMS.register("hot_hardened_diamond_boots", () -> new ModArmorItem(ModArmorMaterials.HOT_H_DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant(), true));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    /* BOWS */
    public static final RegistryObject<Item> VALYRIAN_BOW = ITEMS.register("valyrian_bow", () -> new ModBowItem(VALYRIAN_INGOT.get(), 1.1f, 60000, 20, new Item.Properties().durability(3225)));

    /* SHIELDS */
    public static final RegistryObject<Item> OBSIDIAN_SHIELD = ITEMS.register("obsidian_shield", () -> new ModShieldItem(Items.OBSIDIAN, new Item.Properties().durability(2500)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public enum ModTiers implements Tier {
        COPPER("copper", 1, 180, 9.0f, 1.0f, 17, Ingredient.of(Items.COPPER_INGOT), List.of(Tiers.STONE), List.of(Tiers.IRON)),
        STEEL("steel", 2, 500, 6.5f, 2.5f, 12, Ingredient.of(ModItems.STEEL_INGOT.get()), List.of(Tiers.IRON), List.of(Tiers.DIAMOND)),
        VALYRIAN("valyrian", 4, 4000, 10f, 6f, 25, Ingredient.of(ModItems.VALYRIAN_INGOT.get()), List.of(Tiers.NETHERITE), List.of()),
        H_DIAMOND("hardened_diamond", 4, 7000, 8f, 3f, 10, Ingredient.of(ModItems.HARDENED_DIAMOND.get()), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE)),
        HOT_H_DIAMOND("hot_hardened_diamond", 4, 5500, 8f, 3f, 11, Ingredient.of(ModItems.HOT_HARDENED_DIAMOND.get()), List.of(H_DIAMOND), List.of(Tiers.NETHERITE)),
        EMERALD("emerald", 3, 1561, 12f, 3f, 14, Ingredient.of(Items.EMERALD), List.of(Tiers.DIAMOND), List.of(H_DIAMOND)),
        OBSIDIAN("obsidian", 2, 6500, 6f, 3f, 8, Ingredient.of(Items.OBSIDIAN), List.of(STEEL), List.of(Tiers.DIAMOND));

        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final Ingredient repairIngredient;

        ModTiers(String pName, int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Ingredient pRepairIngredient, List<Object> pAfter, List<Object> pBefore) {
            this.level = pLevel;
            this.uses = pUses;
            this.speed = pSpeed;
            this.damage = pDamage;
            this.enchantmentValue = pEnchantmentValue;
            this.repairIngredient = pRepairIngredient;
            TierSortingRegistry.registerTier(this, new ResourceLocation(OresAndToolsMod.MOD_ID, pName), pAfter, pBefore);
        }

        @Override
        public int getUses() { return uses; }

        @Override
        public float getSpeed() { return speed; }

        @Override
        public float getAttackDamageBonus() { return damage; }

        @Override
        public int getLevel() { return level; }

        @Override
        public int getEnchantmentValue() { return enchantmentValue; }

        @Override
        public @NotNull Ingredient getRepairIngredient() { return repairIngredient; }
    }

    public enum ModArmorMaterials implements ArmorMaterial {
        COPPER("copper", 10, getProtectionFunctionForType(1, 3, 4, 2), 17, SoundEvents.ARMOR_EQUIP_GOLD, 0.0f, 0.0f, Ingredient.of(Items.COPPER_INGOT)),
        STEEL("steel", 20, getProtectionFunctionForType(2, 5, 7, 3), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, Ingredient.of(ModItems.STEEL_INGOT.get())),
        VALYRIAN("valyrian", 50, getProtectionFunctionForType(4, 7, 10, 4), 25, SoundEvents.ARMOR_EQUIP_GOLD, 3.0f, 0.0f, Ingredient.of(ModItems.VALYRIAN_INGOT.get())),
        H_DIAMOND("hardened_diamond", 65, getProtectionFunctionForType(3, 6, 8, 3), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, Ingredient.of(ModItems.HARDENED_DIAMOND.get())),
        HOT_H_DIAMOND("hot_hardened_diamond", 59, getProtectionFunctionForType(3, 6, 8, 3), 11, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, Ingredient.of(ModItems.HOT_HARDENED_DIAMOND.get())),
        EMERALD("emerald", 33, getProtectionFunctionForType(3, 6, 8, 3), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5f, 0.0f, Ingredient.of(Items.EMERALD)),
        OBSIDIAN("obsidian", 62, getProtectionFunctionForType(3, 7, 9, 4), 9, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.5f, 0.5f, Ingredient.of(Items.OBSIDIAN));

        private final String name;
        private final int durabilityMultiplier;
        private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
        private final int enchantmentValue;
        private final SoundEvent sound;
        private final float toughness;
        private final float knockbackResistance;
        private final Ingredient repairIngredient;

        private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (type) -> {
            type.put(ArmorItem.Type.BOOTS, 13);
            type.put(ArmorItem.Type.LEGGINGS, 15);
            type.put(ArmorItem.Type.CHESTPLATE, 16);
            type.put(ArmorItem.Type.HELMET, 11);
        });

        private static EnumMap<ArmorItem.Type, Integer> getProtectionFunctionForType(int boots, int leggings, int chestplate, int helmet) {
            return Util.make(new EnumMap<>(ArmorItem.Type.class), (type) -> {
                type.put(ArmorItem.Type.BOOTS, boots);
                type.put(ArmorItem.Type.LEGGINGS, leggings);
                type.put(ArmorItem.Type.CHESTPLATE, chestplate);
                type.put(ArmorItem.Type.HELMET, helmet);
            });
        }

        ModArmorMaterials(String pName, int pDurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Ingredient pRepairIngredient) {
            this.name = OresAndToolsMod.MOD_ID + ":" + pName;
            this.durabilityMultiplier = pDurabilityMultiplier;
            this.protectionFunctionForType = pProtectionFunctionForType;
            this.enchantmentValue = pEnchantmentValue;
            this.sound = pSound;
            this.toughness = pToughness;
            this.knockbackResistance = pKnockbackResistance;
            this.repairIngredient = pRepairIngredient;
        }

        @Override
        public int getDurabilityForType(ArmorItem.@NotNull Type pType) {
            return durabilityMultiplier * HEALTH_FUNCTION_FOR_TYPE.get(pType);
        }

        @Override
        public int getDefenseForType(ArmorItem.@NotNull Type pType) {
            return protectionFunctionForType.get(pType);
        }

        @Override
        public int getEnchantmentValue() { return enchantmentValue; }

        @Override
        public @NotNull SoundEvent getEquipSound() { return sound; }

        @Override
        public @NotNull Ingredient getRepairIngredient() { return repairIngredient; }

        @Override
        public @NotNull String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }
}
