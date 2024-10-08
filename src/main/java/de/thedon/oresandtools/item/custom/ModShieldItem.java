package de.thedon.oresandtools.item.custom;

import de.thedon.oresandtools.render.ModBEWLRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class ModShieldItem extends ShieldItem {
    Item repairItem;

    public ModShieldItem(Item repairItem, Properties builder) {
        super(builder);
        this.repairItem = repairItem;

    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate) {
        return (repairItem == pRepairCandidate.getItem()) || super.isValidRepairItem(pStack, pRepairCandidate);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new ModBEWLRenderer();
            }
        });
    }
}
