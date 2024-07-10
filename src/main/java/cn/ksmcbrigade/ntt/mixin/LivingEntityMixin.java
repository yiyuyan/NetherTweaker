package cn.ksmcbrigade.ntt.mixin;

import cn.ksmcbrigade.ntt.NetherTweaker;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hasEffect",at = @At("HEAD"),cancellable = true)
    public void effect(MobEffect p_21024_, CallbackInfoReturnable<Boolean> cir){
        if(p_21024_.equals(MobEffects.CONFUSION) && NetherTweaker.antiNausea.enabled) cir.setReturnValue(false);
    }
}
