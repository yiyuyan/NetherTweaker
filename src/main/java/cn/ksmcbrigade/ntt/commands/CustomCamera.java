package cn.ksmcbrigade.ntt.commands;

import cn.ksmcbrigade.vmr.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.concurrent.atomic.AtomicReference;

public class CustomCamera extends Command {

    public CustomCamera() {
        super("camera",1);
    }

    @Override
    public void onCommand(Minecraft MC, Player player, String[] args) {
        if (MC.level != null) {
            AtomicReference<Entity> entity = new AtomicReference<>();
            MC.level.getEntitiesOfClass(LivingEntity.class,new AABB(player.getOnPos()).inflate(1000)).forEach(e -> {
                if(e.getName().getString().equalsIgnoreCase(args[0])){
                    entity.set(e);
                }
            });
            if(entity.get()!=null){
                MC.cameraEntity = entity.get();
            }
        }
    }
}
