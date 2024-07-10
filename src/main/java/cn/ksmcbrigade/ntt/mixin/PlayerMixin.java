package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = {"getPortalWaitTime","getDimensionChangingDelay"},at = @At("RETURN"),cancellable = true)
    public void getWait(CallbackInfoReturnable<Integer> cir){
        if(NetherTweaker.quickNether.enabled) cir.setReturnValue(1);
    }
}
