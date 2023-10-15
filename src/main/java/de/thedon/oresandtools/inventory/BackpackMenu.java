package de.thedon.oresandtools.inventory;

import de.thedon.oresandtools.item.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class BackpackMenu extends AbstractContainerMenu {
    private static final int ROWS = 6;
    private final BackpackCapabilityProvider capabilityProvider;

    public BackpackMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
        this(pContainerId, pPlayerInventory, new BackpackCapabilityProvider(new ItemStack(ModItems.SHULKER_BACKPACK.get())));
    }

    public BackpackMenu(int pContainerId, Inventory pPlayerInventory, BackpackCapabilityProvider pCapabilityProvider) {
        super(ModMenuTypes.BACKPACK_MENU.get(), pContainerId);
        this.capabilityProvider = pCapabilityProvider;
        int i = (ROWS - 4) * 18;

        this.capabilityProvider.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
            checkContainerSize(itemHandler, ROWS * 9);
            for(int j = 0; j < ROWS; ++j) {
                for(int k = 0; k < 9; ++k) {
                    this.addSlot(new SlotItemHandler(itemHandler, k + j * 9, 8 + k * 18, 18 + j * 18));
                }
            }
        });

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(pPlayerInventory, i1, 8 + i1 * 18, 161 + i));
        }
    }

    protected static void checkContainerSize(IItemHandler pItemHandler, int pMinSize) {
        int i = pItemHandler.getSlots();
        if (i < pMinSize) {
            throw new IllegalArgumentException("Container size " + i + " is smaller than expected " + pMinSize);
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < ROWS * 9) {
                if (!this.moveItemStackTo(itemstack1, ROWS * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, ROWS * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return true;
    }

    public int getRowCount() {
        return ROWS;
    }

}
