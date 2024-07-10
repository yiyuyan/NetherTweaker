package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "renderConfusionOverlay",at = @At("HEAD"),cancellable = true)
    public void anti(GuiGraphics p_282460_, float p_282656_, CallbackInfo ci){
        if(NetherTweaker.antiNausea.enabled) ci.cancel();
    }
}
