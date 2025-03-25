package net.tetro48.classicaddon.mixin;

import net.minecraft.src.Gui;
import net.minecraft.src.GuiIngame;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public abstract class GuiIngameMixin extends Gui {
    @Unique public boolean hasFullSaturationShank = false;
    @ModifyArg(method = "drawFoodOverlay", index = 2, at = @At(ordinal = 0, value = "INVOKE", target = "Lnet/minecraft/src/GuiIngame;drawTexturedModalRect(IIIIII)V"))
    public int getVariableThing(int par1) {
        hasFullSaturationShank = par1 == 25;
        return par1;
    }
    @Inject(method = "drawFoodOverlay", at = @At(ordinal = 0, value = "INVOKE", target = "Lnet/minecraft/src/GuiIngame;drawTexturedModalRect(IIIIII)V"))
    public void changeSaturationPipColor(int iScreenX, int iScreenY, CallbackInfo ci) {
        if (hasFullSaturationShank) GL11.glColor3d(0.75d, 0.75d, 0d);
    }
    @Inject(method = "drawFoodOverlay", at = @At(ordinal = 0, value = "INVOKE", target = "Lnet/minecraft/src/GuiIngame;drawTexturedModalRect(IIIIII)V", shift = At.Shift.AFTER))
    public void postChangeSaturationPipColor(int iScreenX, int iScreenY, CallbackInfo ci) {
        GL11.glColor3d(1d, 1d, 1d);
    }
    @Inject(method = "drawFoodOverlay", at = @At(ordinal = 1, value = "INVOKE", target = "Lnet/minecraft/src/GuiIngame;drawTexturedModalRect(IIIIII)V"))
    public void changePartialSaturationPipColor(int iScreenX, int iScreenY, CallbackInfo ci) {
        GL11.glColor3d(0.75d, 0.75d, 0d);
    }
    @Inject(method = "drawFoodOverlay", at = @At(ordinal = 1, value = "INVOKE", target = "Lnet/minecraft/src/GuiIngame;drawTexturedModalRect(IIIIII)V", shift = At.Shift.AFTER))
    public void postChangePartialSaturationPipColor(int iScreenX, int iScreenY, CallbackInfo ci) {
        GL11.glColor3d(1d, 1d, 1d);
    }
}
