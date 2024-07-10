package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(method = "canChangeDimensions",at = @At("RETURN"),cancellable = true)
    public void change(CallbackInfoReturnable<Boolean> cir){
        if(NetherTweaker.noNetherRules.enabled) cir.setReturnValue(true);
    }
}
