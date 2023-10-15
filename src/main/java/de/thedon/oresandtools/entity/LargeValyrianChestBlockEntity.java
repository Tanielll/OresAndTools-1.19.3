package de.thedon.oresandtools.entity;

import de.thedon.oresandtools.inventory.ValyrianChestMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LargeValyrianChestBlockEntity extends ValyrianChestBlockEntity {
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        protected void onOpen(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
            ValyrianChestBlockEntity.playSound(pLevel, pPos, pState, SoundEvents.CHEST_OPEN);
        }

        protected void onClose(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
            ValyrianChestBlockEntity.playSound(pLevel, pPos, pState, SoundEvents.CHEST_CLOSE);
        }

        protected void openerCountChanged(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, int pEventId, int pEventParam) {
            LargeValyrianChestBlockEntity.this.signalOpenCount(pLevel, pPos, pState, pEventId, pEventParam);
        }

        protected boolean isOwnContainer(Player pPlayer) {
            if (!(pPlayer.containerMenu instanceof ValyrianChestMenu menu)) {
                return false;
            } else {
                IItemHandler itemHandler = menu.getInventory();
                return itemHandler == LargeValyrianChestBlockEntity.this.getInventory();
            }
        }
    };

    ValyrianChestBlockEntity first;
    ValyrianChestBlockEntity second;

    private LazyOptional<IItemHandler> combinedLazyInventory = LazyOptional.empty();

    protected LargeValyrianChestBlockEntity(BlockPos pPos, BlockState pState) {
        super(pPos, pState);
    }

    public LargeValyrianChestBlockEntity(ValyrianChestBlockEntity pFirst, ValyrianChestBlockEntity pSecond) {
        this(pFirst.getBlockPos(), pFirst.getBlockState());
        this.first = pFirst;
        this.second = pSecond;
        this.combinedLazyInventory = LazyOptional.of(this::getInventory);
        this.level = pFirst.getLevel();
    }

    @Override
    public IItemHandlerModifiable getInventory() {
        return new CombinedInvWrapper(first.getInventory(), second.getInventory());
    }

    @Override
    public void onLoad() {
        super.onLoad();
        combinedLazyInventory = LazyOptional.of(this::getInventory);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, this.combinedLazyInventory);
    }

    @Override
    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator() && this.getLevel() != null) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
            first.startOpen(pPlayer);
            second.startOpen(pPlayer);
        }
    }

    @Override
    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator() && this.getLevel() != null) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
            first.stopOpen(pPlayer);
            second.stopOpen(pPlayer);
        }
    }

    @Override
    public void recheckOpen() {
        if (!this.remove && this.getLevel() != null) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
            first.recheckOpen();
            second.recheckOpen();
        }
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        if (pId == 1) {
            this.chestLidController.shouldBeOpen(pType > 0);
            first.chestLidController.shouldBeOpen(pType > 0);
            second.chestLidController.shouldBeOpen(pType > 0);
            return true;
        } else {
            return super.triggerEvent(pId, pType);
        }
    }
}
