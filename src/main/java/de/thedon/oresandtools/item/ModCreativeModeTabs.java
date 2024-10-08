package de.thedon.oresandtools.item;

import de.thedon.oresandtools.OresAndToolsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = OresAndToolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresAndToolsMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("oat_main_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + OresAndToolsMod.MOD_ID + ".oat_main_tab"))
            .icon(() -> new ItemStack(ModItems.HARDENED_DIAMOND.get())).build());
    public static RegistryObject<CreativeModeTab> TOOLS_TAB = CREATIVE_MODE_TABS.register("oat_tools_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + OresAndToolsMod.MOD_ID + ".oat_tools_tab"))
            .withTabsBefore(MAIN_TAB.getId())
            .icon(() -> new ItemStack(ModItems.HARDENED_DIAMOND_AXE.get())).build());
    public static RegistryObject<CreativeModeTab> COMBAT_TAB = CREATIVE_MODE_TABS.register("oat_combat_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + OresAndToolsMod.MOD_ID + ".oat_combat_tab"))
            .withTabsBefore(MAIN_TAB.getId(), TOOLS_TAB.getId())
            .icon(() -> new ItemStack(ModItems.HARDENED_DIAMOND_SWORD.get())).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
