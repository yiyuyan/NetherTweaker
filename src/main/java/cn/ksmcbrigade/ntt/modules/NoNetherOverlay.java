package cn.ksmcbrigade.ntt.modules;

import cn.ksmcbrigade.vmr.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class NoNetherOverlay extends Module {
    public NoNetherOverlay() {
        super("hack.name.no_nov");
    }

    @Override
    public void playerTick(Minecraft MC, @Nullable Player player) {
        if(player instanceof LocalPlayer localPlayer){
            localPlayer.spinningEffectIntensity = 0f;
            localPlayer.oSpinningEffectIntensity = 0f;
        }
    }
}
