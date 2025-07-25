package net.tetro48.classicaddon.mixin.blocks;

import btw.block.blocks.PlantsBlock;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlantsBlock.class)
public abstract class PlantsBlockMixin extends Block {
	protected PlantsBlockMixin(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {}
}
