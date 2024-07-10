package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Redirect(method = "handleNetherPortalClient",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;closeContainer()V"))
    public void close(LocalPlayer instance){
        if(!NetherTweaker.netherInv.enabled) instance.closeContainer();
    }

    @Redirect(method = "handleNetherPortalClient",at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V"))
    public void set(Minecraft instance, Screen old){
        if(!NetherTweaker.netherInv.enabled) instance.setScreen(old);
    }
}
