package de.thedon.oresandtools.entity;

import de.thedon.oresandtools.block.ModBlocks;
import de.thedon.oresandtools.block.ValyrianChestBlock;
import de.thedon.oresandtools.inventory.ValyrianChestMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValyrianChestBlockEntity extends BlockEntity implements MenuProvider, Nameable, LidBlockEntity {
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        protected void onOpen(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
            ValyrianChestBlockEntity.playSound(pLevel, pPos, pState, SoundEvents.CHEST_OPEN);
        }

        protected void onClose(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
            ValyrianChestBlockEntity.playSound(pLevel, pPos, pState, SoundEvents.CHEST_CLOSE);
        }

        protected void openerCountChanged(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, int pEventId, int pEventParam) {
            ValyrianChestBlockEntity.this.signalOpenCount(pLevel, pPos, pState, pEventId, pEventParam);
        }

        protected boolean isOwnContainer(Player pPlayer) {
            if (!(pPlayer.containerMenu instanceof ValyrianChestMenu menu)) {
                return false;
            } else {
                IItemHandler itemHandler = menu.getInventory();
                return itemHandler == ValyrianChestBlockEntity.this.inventory;
            }
        }
    };

    @Nullable
    private Component name;
    private ItemStackHandler inventory = new ItemStackHandler(54) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyInventory = LazyOptional.empty();
    protected final ChestLidController chestLidController = new ChestLidController();

    protected ValyrianChestBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public ValyrianChestBlockEntity(BlockPos pPos, BlockState pState) {
        this(ModBlockEntities.VALYRIAN_CHEST.get(), pPos, pState);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, this.lazyInventory);
    }

    public IItemHandlerModifiable getInventory() {
        return this.inventory;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyInventory = LazyOptional.of(() -> inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyInventory.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", inventory.serializeNBT());
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        inventory.deserializeNBT(nbt.getCompound("inventory"));
    }

    public static void lidAnimateTick(Level pLevel, BlockPos pPos, BlockState pState, ValyrianChestBlockEntity pBlockEntity) {
        pBlockEntity.chestLidController.tickLid();
    }

    static void playSound(Level pLevel, BlockPos pPos, BlockState pState, SoundEvent pSound) {
        ChestType chesttype = pState.getValue(ValyrianChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)pPos.getX() + 0.5D;
            double d1 = (double)pPos.getY() + 0.5D;
            double d2 = (double)pPos.getZ() + 0.5D;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = ValyrianChestBlock.getConnectedDirection(pState);
                d0 += (double)direction.getStepX() * 0.5D;
                d2 += (double)direction.getStepZ() * 0.5D;
            }

            pLevel.playSound((Player)null, d0, d1, d2, pSound, SoundSource.BLOCKS, 0.5F, pLevel.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.chestLidController.shouldBeOpen(pType > 0);
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }

    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator() && this.getLevel() != null) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator() && this.getLevel() != null) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void drops() {
        if (this.level != null) {
            SimpleContainer container = new SimpleContainer(inventory.getSlots());
            for (int i = 0; i < inventory.getSlots(); i++) {
                container.setItem(i, inventory.getStackInSlot(i));
            }

            Containers.dropContents(this.level, this.worldPosition, container);
        }
    }

    @Override
    public boolean hasCustomName() {
        return Nameable.super.hasCustomName();
    }

    public void setCustomName(@NotNull Component pName) {
        this.name = pName;
    }

    @Override
    public @NotNull Component getName() {
        return this.name != null ? this.name : this.getDefaultName();
    }


    @Nullable
    public Component getCustomName() { return this.name; }

    public @NotNull Component getDefaultName() {
        return Component.translatable(ModBlocks.VALYRIAN_CHEST.get().getDescriptionId());
    }

    @Override
    public @NotNull Component getDisplayName() {
        return this.getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return ValyrianChestMenu.menu6x9(pContainerId, pPlayerInventory, this);
    }

    public boolean canOpen(Player pPlayer) {
        return !pPlayer.isSpectator();
    }

    @Override
    public float getOpenNess(float pPartialTicks) {
        return this.chestLidController.getOpenness(pPartialTicks);
    }

    public static int getOpenCount(BlockGetter pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos);
        if (blockstate.hasBlockEntity()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof ValyrianChestBlockEntity valyrianChestBlockEntity) {
                return valyrianChestBlockEntity.openersCounter.getOpenerCount();
            }
        }

        return 0;
    }

    public static void swapContents(ValyrianChestBlockEntity pChest, ValyrianChestBlockEntity pOtherChest) {
        ItemStackHandler inventory1 = (ItemStackHandler) pChest.getInventory();
        ItemStackHandler inventory2 = (ItemStackHandler) pOtherChest.getInventory();

        int slotCount = Math.min(inventory1.getSlots(), inventory2.getSlots());
        for (int i = 0; i < slotCount; i++) {
            ItemStack tempStack = inventory1.getStackInSlot(i);
            inventory1.setStackInSlot(i, inventory2.getStackInSlot(i));
            inventory2.setStackInSlot(i, tempStack);
        }
    }

    public void recheckOpen() {
        if (!this.remove && this.getLevel() != null) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    protected void signalOpenCount(Level pLevel, BlockPos pPos, BlockState pState, int pEventId, int pEventParam) {
        Block block = pState.getBlock();
        pLevel.blockEvent(pPos, block, 1, pEventParam);
    }
}
