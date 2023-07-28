package de.thedon.oresandtools.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import de.thedon.oresandtools.OresAndToolsMod;
import de.thedon.oresandtools.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ModBEWLRenderer extends BlockEntityWithoutLevelRenderer {
//    public static final ResourceLocation OBSIDIAN_SHIELD_SHEET = new ResourceLocation(OresAndToolsMod.MOD_ID,"textures/atlas/obsidian_shield_patterns.png");
    public static final Material OBSIDIAN_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(OresAndToolsMod.MOD_ID, "textures/entity/obsidian_shield_base.png"));
//    public static final Material OBSIDIAN_SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(OresAndToolsMod.MOD_ID, "entity/obsidian_shield_base"));
    public static final Material NO_PATTERN_OBSIDIAN_SHIELD = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(OresAndToolsMod.MOD_ID, "textures/entity/obsidian_shield_base_nopattern.png"));
//    public static final Material NO_PATTERN_OBSIDIAN_SHIELD = new Material(Sheets.SHIELD_SHEET, new ResourceLocation(OresAndToolsMod.MOD_ID, "entity/obsidian_shield_base_nopattern"));
    public static final Material SHIELD_BASE = new Material(Sheets.SHIELD_SHEET, new ResourceLocation("minecraft", "entity/shield_base"));
    public static final Material NO_PATTERN_SHIELD = new Material(Sheets.SHIELD_SHEET, new ResourceLocation("minecraft", "entity/shield_base_nopattern"));
    private ShieldModel shieldModel;
    private final EntityModelSet entityModelSet;

    public ModBEWLRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.entityModelSet = Minecraft.getInstance().getEntityModels();
        this.shieldModel = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    public void onResourceManagerReload(@NotNull ResourceManager pResourceManager) {
        this.shieldModel = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void renderByItem(ItemStack pStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
//        OresAndToolsMod.LOGGER.debug(NO_PATTERN_OBSIDIAN_SHIELD.toString());
//        OresAndToolsMod.LOGGER.debug(NO_PATTERN_SHIELD.toString());
//        OresAndToolsMod.LOGGER.debug(OBSIDIAN_SHIELD_BASE.toString());
//        OresAndToolsMod.LOGGER.debug(SHIELD_BASE.toString());
        if (pStack.is(ModItems.OBSIDIAN_SHIELD.get())) {
            boolean flag = BlockItem.getBlockEntityData(pStack) != null;
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
//            Material material = flag ? OBSIDIAN_SHIELD_BASE : NO_PATTERN_OBSIDIAN_SHIELD;
            Material material = flag ? SHIELD_BASE : NO_PATTERN_SHIELD;
//            Material material = NO_PATTERN_OBSIDIAN_SHIELD;
//            Material material = NO_PATTERN_SHIELD;
            VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(pBuffer, this.shieldModel.renderType(material.atlasLocation()), true, pStack.hasFoil()));
            this.shieldModel.handle().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            this.shieldModel.plate().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            if (flag) {
                List<Pair<Holder<BannerPattern>, DyeColor>> list = BannerBlockEntity.createPatterns(ShieldItem.getColor(pStack), BannerBlockEntity.getItemPatterns(pStack));
                BannerRenderer.renderPatterns(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, this.shieldModel.plate(), material, false, list, pStack.hasFoil());
            } else {
                this.shieldModel.plate().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            }
            pPoseStack.popPose();
        }
    }
}
