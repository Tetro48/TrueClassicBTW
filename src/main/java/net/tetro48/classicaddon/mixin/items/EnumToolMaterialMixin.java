package net.tetro48.classicaddon.mixin.items;

import net.minecraft.src.EnumToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EnumToolMaterial.class)
public class EnumToolMaterialMixin {
    @ModifyArg(method = "<clinit>", index = 3, at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/src/EnumToolMaterial;<init>(Ljava/lang/String;IIIFFIII)V"))
    private static int changeWoodDurability(int original) {
        return 59;
    }
    @ModifyArg(method = "<clinit>", index = 3, at = @At(value = "INVOKE", ordinal = 1, target = "Lnet/minecraft/src/EnumToolMaterial;<init>(Ljava/lang/String;IIIFFIII)V"))
    private static int changeStoneDurability(int original) {
        return 131;
    }
}
