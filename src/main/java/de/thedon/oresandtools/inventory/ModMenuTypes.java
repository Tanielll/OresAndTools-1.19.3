package de.thedon.oresandtools.inventory;

import de.thedon.oresandtools.OresAndToolsMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, OresAndToolsMod.MOD_ID);

    public static final RegistryObject<MenuType<BackpackMenu>> BACKPACK_MENU = registerMenuType("backpack_menu", BackpackMenu::new);
    public static final RegistryObject<MenuType<ValyrianChestMenu>> VALYRIAN_CHEST_MENU_6x9 = registerMenuType("valyrian_chest_menu_6x9", ValyrianChestMenu::menu6x9);
    public static final RegistryObject<MenuType<ValyrianChestMenu>> VALYRIAN_CHEST_MENU_9x12 = registerMenuType("valyrian_chest_menu_9x12", ValyrianChestMenu::menu9x12);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
