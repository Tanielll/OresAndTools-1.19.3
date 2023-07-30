package de.thedon.oresandtools;

import com.mojang.logging.LogUtils;
import de.thedon.oresandtools.block.ModBlocks;
import de.thedon.oresandtools.config.ClientConfig;
import de.thedon.oresandtools.config.CommonConfig;
import de.thedon.oresandtools.item.ModCreativeModeTabs;
import de.thedon.oresandtools.item.ModItems;
import de.thedon.oresandtools.util.PropertyRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OresAndToolsMod.MOD_ID)
public class OresAndToolsMod {
    public static final String MOD_ID = "oresandtools";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OresAndToolsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, MOD_ID + "-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, MOD_ID + "-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.MAIN_TAB.get()) {
            event.accept(ModItems.STEEL_CHUNK.get());
            event.accept(ModItems.STEEL_INGOT.get());
            event.accept(ModItems.VALYRIAN_DUST.get());
            event.accept(ModItems.VALYRIAN_INGOT.get());
            event.accept(ModItems.DRAGONS_APPLE.get());
            event.accept(ModItems.RAW_URANIUM.get());
            event.accept(ModItems.URANIUM_INGOT.get());
            event.accept(ModItems.IMPROVISED_REACTOR.get());
            event.accept(ModItems.HARDENED_DIAMOND.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND.get());
            event.accept(ModItems.OBSIDIAN_SHARD.get());

            event.accept(ModBlocks.STEEL_BLOCK.get());
            event.accept(ModBlocks.HARDENED_DIAMOND_BLOCK.get());
            event.accept(ModBlocks.VALYRIAN_ORE.get());
            event.accept(ModBlocks.DEEPSLATE_VALYRIAN_ORE.get());
            event.accept(ModBlocks.OBSIDIAN_ORE.get());
            event.accept(ModBlocks.DEEPSLATE_OBSIDIAN_ORE.get());
            event.accept(ModBlocks.XP_ORE.get());
            event.accept(ModBlocks.DEEPSLATE_XP_ORE.get());
            event.accept(ModBlocks.URANIUM_ORE.get());
            event.accept(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
//            event.accept(ModBlocks.MOLTEN_COPPER_ORE.get());
//            event.accept(ModBlocks.MOLTEN_IRON_ORE.get());
//            event.accept(ModBlocks.MOLTEN_GOLD_ORE.get());
//            event.accept(ModBlocks.MOLTEN_URANIUM_ORE.get());
//            event.accept(ModBlocks.MOLTEN_STONE.get());
//            event.accept(ModBlocks.MOLTEN_SAND.get());
        }
        if (event.getTab() == ModCreativeModeTabs.TOOLS_TAB.get()) {
            event.accept(ModItems.COPPER_SHOVEL.get());
            event.accept(ModItems.COPPER_PICKAXE.get());
            event.accept(ModItems.COPPER_AXE.get());
            event.accept(ModItems.COPPER_HOE.get());
            event.accept(ModItems.STEEL_SHOVEL.get());
            event.accept(ModItems.STEEL_PICKAXE.get());
            event.accept(ModItems.STEEL_AXE.get());
            event.accept(ModItems.STEEL_HOE.get());
            event.accept(ModItems.VALYRIAN_SHOVEL.get());
            event.accept(ModItems.VALYRIAN_PICKAXE.get());
            event.accept(ModItems.VALYRIAN_AXE.get());
            event.accept(ModItems.VALYRIAN_HOE.get());
            event.accept(ModItems.HARDENED_DIAMOND_SHOVEL.get());
            event.accept(ModItems.HARDENED_DIAMOND_PICKAXE.get());
            event.accept(ModItems.HARDENED_DIAMOND_AXE.get());
            event.accept(ModItems.HARDENED_DIAMOND_HOE.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_SHOVEL.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_PICKAXE.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_AXE.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_HOE.get());
            event.accept(ModItems.EMERALD_SHOVEL.get());
            event.accept(ModItems.EMERALD_PICKAXE.get());
            event.accept(ModItems.EMERALD_AXE.get());
            event.accept(ModItems.EMERALD_HOE.get());
            event.accept(ModItems.OBSIDIAN_SHOVEL.get());
            event.accept(ModItems.OBSIDIAN_PICKAXE.get());
            event.accept(ModItems.OBSIDIAN_AXE.get());
            event.accept(ModItems.OBSIDIAN_HOE.get());
        }
        if (event.getTab() == ModCreativeModeTabs.COMBAT_TAB.get()) {
            event.accept(ModItems.COPPER_SWORD.get());
            event.accept(ModItems.STEEL_SWORD.get());
            event.accept(ModItems.HARDENED_DIAMOND_SWORD.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_SWORD.get());
            event.accept(ModItems.VALYRIAN_SWORD.get());
            event.accept(ModItems.EMERALD_SWORD.get());
            event.accept(ModItems.OBSIDIAN_SWORD.get());
            event.accept(ModItems.VALYRIAN_BOW.get());
            event.accept(ModItems.OBSIDIAN_SHIELD.get());
            event.accept(ModItems.COPPER_HELMET.get());
            event.accept(ModItems.COPPER_CHESTPLATE.get());
            event.accept(ModItems.COPPER_LEGGINGS.get());
            event.accept(ModItems.COPPER_BOOTS.get());
            event.accept(ModItems.STEEL_HELMET.get());
            event.accept(ModItems.STEEL_CHESTPLATE.get());
            event.accept(ModItems.STEEL_LEGGINGS.get());
            event.accept(ModItems.STEEL_BOOTS.get());
            event.accept(ModItems.VALYRIAN_HELMET.get());
            event.accept(ModItems.VALYRIAN_CHESTPLATE.get());
            event.accept(ModItems.VALYRIAN_LEGGINGS.get());
            event.accept(ModItems.VALYRIAN_BOOTS.get());
            event.accept(ModItems.HARDENED_DIAMOND_HELMET.get());
            event.accept(ModItems.HARDENED_DIAMOND_CHESTPLATE.get());
            event.accept(ModItems.HARDENED_DIAMOND_LEGGINGS.get());
            event.accept(ModItems.HARDENED_DIAMOND_BOOTS.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_HELMET.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_CHESTPLATE.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_LEGGINGS.get());
            event.accept(ModItems.HOT_HARDENED_DIAMOND_BOOTS.get());
            event.accept(ModItems.EMERALD_HELMET.get());
            event.accept(ModItems.EMERALD_CHESTPLATE.get());
            event.accept(ModItems.EMERALD_LEGGINGS.get());
            event.accept(ModItems.EMERALD_BOOTS.get());
            event.accept(ModItems.OBSIDIAN_HELMET.get());
            event.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
            event.accept(ModItems.OBSIDIAN_LEGGINGS.get());
            event.accept(ModItems.OBSIDIAN_BOOTS.get());
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            PropertyRegistration.registerProperties();
        }
    }
}
