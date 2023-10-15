package de.thedon.oresandtools.item;

import de.thedon.oresandtools.inventory.BackpackCapabilityProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BackpackItem extends ModItem {
    public BackpackItem(Properties pProperties, boolean withToolTip) {
        super(pProperties, withToolTip);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return BackpackCapabilityProvider.createDefaultProvider(stack, nbt);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()) {
            Item item = itemstack.getItem();
            if (item instanceof BackpackItem) {
                NetworkHooks.openScreen((ServerPlayer) pPlayer, BackpackCapabilityProvider.createDefaultProvider(itemstack));
                return InteractionResultHolder.pass(itemstack);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }
}
