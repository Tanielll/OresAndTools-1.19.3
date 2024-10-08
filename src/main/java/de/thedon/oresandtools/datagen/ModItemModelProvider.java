package de.thedon.oresandtools.datagen;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAndToolsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /* NORMAL ITEMS */
        basicItem(ModItems.HARDENED_DIAMOND.get());
        basicItem(ModItems.HEATING_HARDENED_DIAMOND_1.get());
        basicItem(ModItems.HEATING_HARDENED_DIAMOND_2.get());
        basicItem(ModItems.HEATING_HARDENED_DIAMOND_3.get());
        basicItem(ModItems.HOT_HARDENED_DIAMOND.get());
        basicItem(ModItems.VALYRIAN_DUST.get());
        basicItem(ModItems.VALYRIAN_INGOT.get());
        basicItem(ModItems.OBSIDIAN_SHARD.get());
        basicItem(ModItems.DRAGONS_APPLE.get());
        basicItem(ModItems.STEEL_CHUNK.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.RAW_URANIUM.get());
        basicItem(ModItems.URANIUM_INGOT.get());
        basicItem(ModItems.IMPROVISED_REACTOR.get());
        basicItem(ModItems.VALYRIAN_LEATHER.get());
        basicItem(ModItems.SHULKER_BACKPACK.get());
        /* TOOLS */
        handheldItem(ModItems.COPPER_SHOVEL.get());
        handheldItem(ModItems.COPPER_PICKAXE.get());
        handheldItem(ModItems.COPPER_AXE.get());
        handheldItem(ModItems.COPPER_HOE.get());
        handheldItem(ModItems.COPPER_SWORD.get());
        handheldItem(ModItems.STEEL_SHOVEL.get());
        handheldItem(ModItems.STEEL_PICKAXE.get());
        handheldItem(ModItems.STEEL_AXE.get());
        handheldItem(ModItems.STEEL_HOE.get());
        handheldItem(ModItems.STEEL_SWORD.get());
        handheldItem(ModItems.VALYRIAN_SHOVEL.get());
        handheldItem(ModItems.VALYRIAN_PICKAXE.get());
        handheldItem(ModItems.VALYRIAN_AXE.get());
        handheldItem(ModItems.VALYRIAN_HOE.get());
        handheldItem(ModItems.VALYRIAN_SWORD.get());
        handheldItem(ModItems.HARDENED_DIAMOND_SHOVEL.get());
        handheldItem(ModItems.HARDENED_DIAMOND_PICKAXE.get());
        handheldItem(ModItems.HARDENED_DIAMOND_AXE.get());
        handheldItem(ModItems.HARDENED_DIAMOND_HOE.get());
        handheldItem(ModItems.HARDENED_DIAMOND_SWORD.get());
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_SHOVEL.get());
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_PICKAXE.get());
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_AXE.get());
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_HOE.get());
        handheldItem(ModItems.HOT_HARDENED_DIAMOND_SWORD.get());
        handheldItem(ModItems.EMERALD_SHOVEL.get());
        handheldItem(ModItems.EMERALD_PICKAXE.get());
        handheldItem(ModItems.EMERALD_AXE.get());
        handheldItem(ModItems.EMERALD_HOE.get());
        handheldItem(ModItems.EMERALD_SWORD.get());
        handheldItem(ModItems.OBSIDIAN_SHOVEL.get());
        handheldItem(ModItems.OBSIDIAN_PICKAXE.get());
        handheldItem(ModItems.OBSIDIAN_AXE.get());
        handheldItem(ModItems.OBSIDIAN_HOE.get());
        handheldItem(ModItems.OBSIDIAN_SWORD.get());
        /* ARMOR */
        trimmedArmorItem(ModItems.COPPER_HELMET);
        trimmedArmorItem(ModItems.COPPER_CHESTPLATE);
        trimmedArmorItem(ModItems.COPPER_LEGGINGS);
        trimmedArmorItem(ModItems.COPPER_BOOTS);
        trimmedArmorItem(ModItems.STEEL_HELMET);
        trimmedArmorItem(ModItems.STEEL_CHESTPLATE);
        trimmedArmorItem(ModItems.STEEL_LEGGINGS);
        trimmedArmorItem(ModItems.STEEL_BOOTS);
        trimmedArmorItem(ModItems.VALYRIAN_HELMET);
        trimmedArmorItem(ModItems.VALYRIAN_CHESTPLATE);
        trimmedArmorItem(ModItems.VALYRIAN_LEGGINGS);
        trimmedArmorItem(ModItems.VALYRIAN_BOOTS);
        trimmedArmorItem(ModItems.HARDENED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.HARDENED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.HARDENED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.HARDENED_DIAMOND_BOOTS);
        trimmedArmorItem(ModItems.HOT_HARDENED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.HOT_HARDENED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.HOT_HARDENED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.HOT_HARDENED_DIAMOND_BOOTS);
        trimmedArmorItem(ModItems.EMERALD_HELMET);
        trimmedArmorItem(ModItems.EMERALD_CHESTPLATE);
        trimmedArmorItem(ModItems.EMERALD_LEGGINGS);
        trimmedArmorItem(ModItems.EMERALD_BOOTS);
        trimmedArmorItem(ModItems.OBSIDIAN_HELMET);
        trimmedArmorItem(ModItems.OBSIDIAN_CHESTPLATE);
        trimmedArmorItem(ModItems.OBSIDIAN_LEGGINGS);
        trimmedArmorItem(ModItems.OBSIDIAN_BOOTS);
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder handheldItem(Item item) {
        ResourceLocation itemLocation = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        return getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/handheld"))
                                          .texture("layer0", itemLocation.withPrefix("item/"));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(OresAndToolsMod.MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
