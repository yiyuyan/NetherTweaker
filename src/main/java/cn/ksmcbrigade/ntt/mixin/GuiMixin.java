package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {
    @Inject(method = "renderPortalOverlay",at = @At("HEAD"),cancellable = true)
    public void render(CallbackInfo ci){
        if(NetherTweaker.noNetherOverlay.enabled) ci.cancel();
    }
}