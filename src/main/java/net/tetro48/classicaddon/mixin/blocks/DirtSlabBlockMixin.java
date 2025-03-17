package net.tetro48.classicaddon.mixin.blocks;

import btw.block.BTWBlocks;
import btw.block.blocks.DirtSlabBlock;
import btw.block.blocks.GrassSlabBlock;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DirtSlabBlock.class)
public class DirtSlabBlockMixin extends Block {

    protected DirtSlabBlockMixin(int iBlockID, Material material) {
        super(iBlockID, material);
    }

    @Inject(method = "idDropped", at = @At("RETURN"), cancellable = true)
    public void changeDirtDrop(int iMetadata, Random random, int iFortuneModifier, CallbackInfoReturnable<Integer> cir) {
        if (cir.getReturnValue() == BTWBlocks.looseDirtSlab.blockID) cir.setReturnValue(BTWBlocks.dirtSlab.blockID);
    }
    @Redirect(method = "dropComponentItemsOnBadBreak", at = @At(value = "INVOKE", target = "Lbtw/block/blocks/DirtSlabBlock;dropItemsIndividually(Lnet/minecraft/src/World;IIIIIIF)V"))
    public void changeDirtDropOnBadBreak(DirtSlabBlock instance, World world, int i, int j, int k, int id, int amount, int iMetadata, float fChanceOfDrop) {
        this.dropBlockAsItem(world, i, j, k, BTWBlocks.dirtSlab.blockID, 1);
    }
}
