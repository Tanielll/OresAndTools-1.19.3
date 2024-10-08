package de.thedon.oresandtools.event;

import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.block.ModBlocks;
import de.thedon.oresandtools.config.CommonConfig;
import de.thedon.oresandtools.item.ModArmorMaterials;
import de.thedon.oresandtools.item.ModItems;
import de.thedon.oresandtools.item.ModToolTiers;
import de.thedon.oresandtools.item.custom.ModArmorItem;
import de.thedon.oresandtools.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = OresAndToolsMod.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onShieldBlocked(LivingAttackEvent event){
            if (event.getEntity() instanceof Player player) {
                ItemStack useItem = player.getUseItem();
                if (player.isBlocking() && (useItem.getItem() == ModItems.OBSIDIAN_SHIELD.get())) {
                    DamageSource source = event.getSource();
                    if (source.is(DamageTypes.ARROW) || source.is(DamageTypes.EXPLOSION) || source.is(DamageTypes.MAGIC)) {
                        useItem.setDamageValue((int)event.getAmount());
                    }
                }
            }
        }
    
//        private static int ticksBeforeNextDamageByUran = CommonConfig.URANIUM_DAMAGE_TICKRATE.get();
        private static int ticksBeforeNextDamageByUran = 100;
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            Player player = event.player;
            if (!player.isCreative() && !player.isSpectator()) {
                if (ticksBeforeNextDamageByUran == 0) {
                    if (player.getMainHandItem().getItem() == ModItems.URANIUM_INGOT.get()) {
                        player.setHealth(player.getHealth() - CommonConfig.URANIUM_DAMAGE_AMOUNT.get());
                        player.animateHurt(1.0F);
                    }
                    ticksBeforeNextDamageByUran = CommonConfig.URANIUM_DAMAGE_TICKRATE.get();
                } else {
                    ticksBeforeNextDamageByUran--;
                }
            }
        }
    
        @SubscribeEvent
        public static void onPlayerAttacked(LivingAttackEvent event) {
            if (event.getEntity() instanceof Player player) {
                if (player.getArmorSlots() instanceof List<ItemStack> armorItems) {
                    if (armorItems.size() == 4 && !CommonConfig.DISABLE_SET_BONUSES.get()) {
                        boolean allValyrian = true;
                        boolean allHotDiamond = true;
                        for (ItemStack itemStack : armorItems) {
                            if (itemStack.getItem() instanceof ModArmorItem armorItem) {
                                if (armorItem.getMaterial() != ModArmorMaterials.VALYRIAN) {
                                    allValyrian = false;
                                }
                                if (armorItem.getMaterial() != ModArmorMaterials.HOT_H_DIAMOND) {
                                    allHotDiamond = false;
                                }
                            } else {
                                allValyrian = false;
                                allHotDiamond = false;
                            }
                        }
                        if (allValyrian) {
                            event.setCanceled(event.getSource().is(DamageTypes.ON_FIRE) || event.getSource().is(DamageTypes.IN_FIRE));
                            player.extinguishFire();
                        }
                        if (allHotDiamond) {
                            Entity source = event.getSource().getEntity();
                            if (source instanceof LivingEntity living) {
                                living.setRemainingFireTicks(CommonConfig.HOT_DIA_FIRE_REFLECT_DURATION.get());
                                living.hurt(event.getSource(), event.getAmount());
                            }
                        }
                    }
                }
            }
        }
    
        @SubscribeEvent
        public static void onUndeadAttackedByHotDiaTool(AttackEntityEvent event) {
            if (event.getEntity().getMainHandItem().getItem() instanceof TieredItem tieredItem) {
                if (tieredItem.getTier() == ModToolTiers.HOT_HARDENED_DIAMOND && !CommonConfig.DISABLE_HOT_DIA_FIRE_ASPECT.get()) {
                    if (event.getTarget().isAlive()) {
                        if (event.getTarget() instanceof LivingEntity target) {
                            if (target instanceof Zombie || target instanceof AbstractSkeleton) {
                                target.setRemainingFireTicks(CommonConfig.HOT_DIA_FIRE_ASPECT_DURATION.get());
                            }
                        }
                    }
                }
            }
        }
    
        @SubscribeEvent
        public static void onBlockBreakByHotDiaTool(BlockEvent.BreakEvent event) {
            RegistryAccess registryAccess = event.getLevel().registryAccess();
            Player player = event.getPlayer();
            if (!player.isCreative() && !player.isSpectator()) {
                if (player.getMainHandItem().getItem() instanceof TieredItem tieredItem) {
                    if (tieredItem.getTier() == ModToolTiers.HOT_HARDENED_DIAMOND) {
                        ItemEnchantments enchantments = player.getMainHandItem().getEnchantments();
                        Holder<Enchantment> silkTouch = Enchantments.SILK_TOUCH.getOrThrow(registryAccess);
                        Holder<Enchantment> fortune = Enchantments.FORTUNE.getOrThrow(registryAccess);
                        int fortuneLevel = 0;
                        boolean hasSilkTouch = enchantments.keySet().contains(silkTouch);
                        if (enchantments.keySet().contains(fortune)) {
                            fortuneLevel = enchantments.getLevel(fortune);
                        }
                        if (!hasSilkTouch) {
                            if (event.getLevel() instanceof Level level) {
                                BlockState blockState = event.getState();
                                Block block = event.getState().getBlock();
                                int xpAmount = block.getExpDrop(event.getState(), level, level.getRandom(), event.getPos(), fortuneLevel, 0);
                                if (xpAmount == 0) {
                                    xpAmount = UniformInt.of(2,6).sample(level.getRandom());
                                }
                                BlockPos pos = event.getPos();
                                level.addFreshEntity(new ExperienceOrb(level, pos.getX(), pos.getY(), pos.getZ(), xpAmount));
                                if (blockState.is(BlockTags.COPPER_ORES)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_COPPER_ORE.get(), pos, Items.COPPER_INGOT, fortuneLevel);
                                } else if (blockState.is(BlockTags.IRON_ORES)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_IRON_ORE.get(), pos, Items.IRON_INGOT, fortuneLevel);
                                } else if (blockState.is(BlockTags.GOLD_ORES)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_GOLD_ORE.get(), pos, Items.GOLD_INGOT, fortuneLevel);
                                } else if (blockState.is(ModTags.Blocks.URANIUM_ORES)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_URANIUM_ORE.get(), pos, ModItems.URANIUM_INGOT.get(), fortuneLevel);
                                } else if (blockState.is(ModTags.Blocks.MELTABLE_TO_STONE)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_STONE.get(), pos, null, fortuneLevel);
                                } else if (blockState.is(BlockTags.SAND)) {
                                    doBlockDrops(level, ModBlocks.MOLTEN_SAND.get(), pos, null, fortuneLevel);
                                }
                            }
                        }
                    }
                }
            }
        }
    
        private static void doBlockDrops(Level level, Block replacement, BlockPos pos, Item drop, int fortuneLevel) {
            BlockState state = replacement.defaultBlockState();
            level.setBlock(pos, state, 4);
            level.destroyBlock(pos, true);
            if (drop != null) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                if (Math.random() * (fortuneLevel + 1) > 1.5) {
                    if (Math.random() * (fortuneLevel + 1) > 2.5) {
                        level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(drop, 2)));
                    } else {
                        level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(drop)));
                    }
                }
            }
        }
    
        @SubscribeEvent
        public static void onVillagerKilledByEmeraldSword(LivingDropsEvent event) {
            if (Math.random() < CommonConfig.VILLAGER_EMERALD_DROP_CHANCE.get()) {
                if (event.getSource().getEntity() instanceof Player player) {
                    if (player.getMainHandItem().getItem() == ModItems.EMERALD_SWORD.get()) {
                        LivingEntity entity = event.getEntity();
                        if (entity instanceof Villager) {
                            Level level = entity.getCommandSenderWorld();
                            event.getDrops().add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(),
                                new ItemStack(Items.EMERALD)));
                        }
                    }
                }
            }
        }
    
    
        private static final ArrayList<ItemEntity> droppedDiamonds = new ArrayList<>();
    
        @SubscribeEvent
        public static void onHardenedDiamondDropped(ItemTossEvent event) {
            ItemEntity itemEntity = event.getEntity();
            if (itemEntity.getItem().getItem() == ModItems.HARDENED_DIAMOND.get()) {
                droppedDiamonds.add(itemEntity);
            }
        }

        @SubscribeEvent
        public static void onHardenedDiamondDespawn(ItemExpireEvent event) {
            ItemEntity itemEntity = event.getEntity();
            if (itemEntity.isInLava()) {
                Item item = itemEntity.getItem().getItem();
                if (item == ModItems.HARDENED_DIAMOND.get() ||
                    item == ModItems.HOT_HARDENED_DIAMOND.get() ||
                    item == ModItems.HEATING_HARDENED_DIAMOND_1.get() ||
                    item == ModItems.HEATING_HARDENED_DIAMOND_2.get() ||
                    item == ModItems.HEATING_HARDENED_DIAMOND_3.get()) {
                    event.setCanceled(true);
                }
            }
        }
    
        @SubscribeEvent
        public static void onLevelTick(TickEvent.LevelTickEvent event) {
            for (ItemEntity diamond : droppedDiamonds) {
                int count = diamond.getItem().getCount();
                if (diamond.isInLava()) {
//                    diamond.setExtendedLifetime();
                    if (diamond.getAge() >= 300) {
                        diamond.setItem(new ItemStack(ModItems.HOT_HARDENED_DIAMOND.get(), count));
                    }
                    else if (diamond.getAge() >= 225) {
                        diamond.setItem(new ItemStack(ModItems.HEATING_HARDENED_DIAMOND_3.get(), count));
                    }
                    else if (diamond.getAge() >= 150) {
                        diamond.setItem(new ItemStack(ModItems.HEATING_HARDENED_DIAMOND_2.get(), count));
                    }
                    else if (diamond.getAge() >= 75) {
                        diamond.setItem(new ItemStack(ModItems.HEATING_HARDENED_DIAMOND_1.get(), count));
                    }
                } else {
                    if (diamond.getAge() >= 6000) {
                        diamond.remove(Entity.RemovalReason.DISCARDED);
                    }
                    else if (!diamond.isInLava() && diamond.getItem().getItem() != ModItems.HOT_HARDENED_DIAMOND.get()) {
                        diamond.setItem(new ItemStack(ModItems.HARDENED_DIAMOND.get(), count));
                    }
                }
            }
        }
    
        @SubscribeEvent
        public static void onHardenedDiamondPickup(EntityItemPickupEvent event) {
            Item item = event.getItem().getItem().getItem();
            if (item == ModItems.HEATING_HARDENED_DIAMOND_1.get() ||
                item == ModItems.HEATING_HARDENED_DIAMOND_2.get() ||
                item == ModItems.HEATING_HARDENED_DIAMOND_3.get()) {
                event.setCanceled(true);
            }
            if (item == ModItems.HOT_HARDENED_DIAMOND.get() || item == ModItems.HARDENED_DIAMOND.get()) {
                droppedDiamonds.remove(event.getItem());
            }
        }        
    }

//    @Mod.EventBusSubscriber(modid = OresAndToolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class ModEventBusEvents {
//
//    }
}
