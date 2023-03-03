package de.thedon.oresandtools.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties DRAGONS_APPLE = (new FoodProperties.Builder())
            .nutrition(5)
            .saturationMod(2.5F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 1), 1.0F)
            .build();
}
