package de.thedon.oresandtools.item.custom;

import de.thedon.oresandtools.config.CommonConfig;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class ImprovisedReactorItem extends Item {
    public ImprovisedReactorItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return CommonConfig.IMPRO_REACTOR_BURN_TIME.get();
    }
}
