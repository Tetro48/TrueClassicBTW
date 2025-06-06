package net.tetro48.classicaddon.mixin.blocks;

import btw.block.blocks.BrickBlock;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrickBlock.class)
public abstract class BrickBlockMixin extends Block {
	protected BrickBlockMixin(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public void onBlockDestroyedWithImproperTool(World world, EntityPlayer player, int i, int j, int k, int iMetadata) {}
	@Inject(method = "idDropped", at = @At("RETURN"), cancellable = true)
	public void changeDropType(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(Block.brick.blockID);
	}
}
