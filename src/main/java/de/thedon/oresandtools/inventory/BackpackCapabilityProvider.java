//package de.thedon.oresandtools.inventory;
//
//import de.thedon.oresandtools.item.ModItems;
//import net.minecraft.core.Direction;
//import net.minecraft.core.component.DataComponentMap;
//import net.minecraft.core.component.DataComponents;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.Nameable;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.capabilities.ICapabilityProvider;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//public class BackpackCapabilityProvider implements ICapabilityProvider, MenuProvider, Nameable {
//    private final BackpackItemStackHandler inventory;
//    private final LazyOptional<IItemHandler> lazyInventory;
//
//    @Nullable
//    private Component name;
//
//    @Nullable
//    public static BackpackCapabilityProvider createDefaultProvider(ItemStack stack)
//    {
//        if (stack.getItem() == ModItems.SHULKER_BACKPACK.get()){
//            return new BackpackCapabilityProvider(stack);
//        }
//        return null;
//    }
//
//    @Nullable
//    public static BackpackCapabilityProvider createDefaultProvider(ItemStack stack, @Nullable CompoundTag nbt)
//    {
//        if (stack.getItem() == ModItems.SHULKER_BACKPACK.get()){
//            return new BackpackCapabilityProvider(stack, nbt);
//        }
//        return null;
//    }
//
//    public BackpackCapabilityProvider(ItemStack stack) {
//        this.inventory = new BackpackItemStackHandler(stack);
//        this.lazyInventory = LazyOptional.of(() -> inventory);
//
//        DataComponentMap components = stack.getComponents();
//        if (components.has(DataComponents.CUSTOM_NAME)) {
//            setCustomName(components.get(DataComponents.CUSTOM_NAME));
//        }
//    }
//
//    public BackpackCapabilityProvider(ItemStack stack, @Nullable CompoundTag nbt) {
//        this(stack);
//    }
//
//    @Override
//    @NotNull
//    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, this.lazyInventory);
//    }
//
////    void invalidate() {
////        this.lazyInventory.invalidate();
////    }
//
//    @Override
//    public boolean hasCustomName() {
//        return Nameable.super.hasCustomName();
//    }
//
//    public void setCustomName(Component pName) {
//        this.name = pName;
//    }
//
//    @Override
//    public @NotNull Component getName() {
//        return this.name != null ? this.name : this.getDefaultName();
//    }
//
//
//    @Nullable
//    public Component getCustomName() { return this.name; }
//
//    public @NotNull Component getDefaultName() {
//        return Component.translatable(ModItems.SHULKER_BACKPACK.get().getDescriptionId());
//    }
//
//    @Override
//    public @NotNull Component getDisplayName() {
//        return this.getName();
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int pId, @NotNull Inventory pInventory, @NotNull Player pPlayer) {
//        return new BackpackMenu(pId, pInventory, this);
//    }
//}
