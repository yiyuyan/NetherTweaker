package cn.ksmcbrigade.ntt;

import cn.ksmcbrigade.ntt.commands.CustomCamera;
import cn.ksmcbrigade.ntt.modules.*;

import cn.ksmcbrigade.vmr.uitls.CommandUtils;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(NetherTweaker.MODID)
public class NetherTweaker {

    public static final String MODID = "ntt";

    public static AntiNausea antiNausea = new AntiNausea();

    public static NoNetherOverlay noNetherOverlay = new NoNetherOverlay();
    public static NoNetherRules noNetherRules = new NoNetherRules();
    public static QuickNether quickNether = new QuickNether();
    public static NetherInv netherInv = new NetherInv();

    public NetherTweaker() {
        MinecraftForge.EVENT_BUS.register(this);

        ModuleUtils.add(antiNausea);

        ModuleUtils.add(noNetherOverlay);
        ModuleUtils.add(noNetherRules);
        ModuleUtils.add(quickNether);
        ModuleUtils.add(netherInv);

        CommandUtils.add(new CustomCamera());
    }
}
