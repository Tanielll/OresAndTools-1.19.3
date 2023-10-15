package de.thedon.oresandtools.inventory;

import de.thedon.oresandtools.block.ValyrianChestBlock;
import de.thedon.oresandtools.entity.LargeValyrianChestBlockEntity;
import de.thedon.oresandtools.entity.ValyrianChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ValyrianChestMenu extends AbstractContainerMenu {
    private static final DoubleBlockCombiner.Combiner<ValyrianChestBlockEntity, Optional<ValyrianChestBlockEntity>> CHEST_ENTITY_COMBINER = new DoubleBlockCombiner.Combiner<>() {
        public @NotNull Optional<ValyrianChestBlockEntity> acceptDouble(@NotNull ValyrianChestBlockEntity pFirst, @NotNull ValyrianChestBlockEntity pSecond) {
//            final IItemHandler inventory = new CombinedInvWrapper(pFirst.getInventory(), pSecond.getInventory());
            return Optional.of(new LargeValyrianChestBlockEntity(pFirst, pSecond));
        }

        public @NotNull Optional<ValyrianChestBlockEntity> acceptSingle(@NotNull ValyrianChestBlockEntity pEntity) {
            return Optional.of(pEntity);
        }

        public @NotNull Optional<ValyrianChestBlockEntity> acceptNone() {
            return Optional.empty();
        }
    };
    private final ValyrianChestBlockEntity entity;
    private final IItemHandler inventory;
    private final int rows;
    private final int columns;

    private static ValyrianChestBlockEntity getEntity(Inventory pInventory, FriendlyByteBuf pExtraData) {
        Level level = pInventory.player.level();
        BlockPos pos = pExtraData.readBlockPos();
        BlockState state = level.getBlockState(pos);
        ValyrianChestBlock chest = (ValyrianChestBlock) state.getBlock();
        return chest.combine(state, level, pos, true).apply(CHEST_ENTITY_COMBINER).orElse(null);
    }

    public static ValyrianChestMenu menu6x9(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf pExtraData) {
        return new ValyrianChestMenu(ModMenuTypes.VALYRIAN_CHEST_MENU_6x9.get(), pContainerId, pPlayerInventory, pExtraData, 6, 9);
    }

    public static ValyrianChestMenu menu6x9(int pContainerId, Inventory pPlayerInventory, ValyrianChestBlockEntity pEntity) {
        return new ValyrianChestMenu(ModMenuTypes.VALYRIAN_CHEST_MENU_6x9.get(), pContainerId, pPlayerInventory, pEntity, 6, 9);
    }

    public static ValyrianChestMenu menu9x12(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf pExtraData) {
        return new ValyrianChestMenu(ModMenuTypes.VALYRIAN_CHEST_MENU_9x12.get(), pContainerId, pPlayerInventory, pExtraData, 9, 12);
    }

    public static ValyrianChestMenu menu9x12(int pContainerId, Inventory pPlayerInventory, ValyrianChestBlockEntity pEntity) {
        return new ValyrianChestMenu(ModMenuTypes.VALYRIAN_CHEST_MENU_9x12.get(), pContainerId, pPlayerInventory, pEntity, 9, 12);
    }

    public ValyrianChestMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf pExtraData, int pRows, int pColumns) {
        this(pType, pContainerId, pPlayerInventory, getEntity(pPlayerInventory, pExtraData), pRows, pColumns);
    }

    public ValyrianChestMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, ValyrianChestBlockEntity pEntity, int pRows, int pColumns) {
        super(pType, pContainerId);
        checkContainerSize(pEntity.getInventory(), pRows * pColumns);
        this.entity = pEntity;
        this.inventory = pEntity.getInventory();
        this.rows = pRows;
        this.columns = pColumns;
        pEntity.startOpen(pPlayerInventory.player);

        int i = (this.rows - 4) * 18;
        int chestSlotsYOffset = is6x9() ? 18 : 8;
        int invSlotsXOffset = is6x9() ? 8 : 35;
        int invSlotsYOffset = is6x9() ? 103 : 83;
        int barSlotsYOffset = is6x9() ? 161 : 141;

        this.entity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(itemHandler -> {
            checkContainerSize(itemHandler, this.rows * this.columns);
            for(int j = 0; j < this.rows; ++j) {
                for(int k = 0; k < this.columns; ++k) {
                    this.addSlot(new SlotItemHandler(itemHandler, k + j * this.columns, 8 + k * 18, chestSlotsYOffset + j * 18));
                }
            }
        });

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 9 + 9, invSlotsXOffset + j1 * 18, invSlotsYOffset + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(pPlayerInventory, i1, invSlotsXOffset + i1 * 18, barSlotsYOffset + i));
        }
    }

    private boolean is6x9() {
        return this.rows * this.columns == 54;
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
            if (pIndex < this.rows * this.columns) {
                if (!this.moveItemStackTo(itemstack1, this.rows * this.columns, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.rows * this.columns, false)) {
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

    @Override
    public void removed(@NotNull Player pPlayer) {
        super.removed(pPlayer);
        this.entity.stopOpen(pPlayer);
    }

    public int getRowCount() {
        return this.rows;
    }

    public IItemHandler getInventory() {
        return this.inventory;
    }
}
