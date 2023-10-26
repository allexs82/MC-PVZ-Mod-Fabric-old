package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.event.PlayerEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ModEventsRegister {
    public static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new PlayerEvents());
    }
}
