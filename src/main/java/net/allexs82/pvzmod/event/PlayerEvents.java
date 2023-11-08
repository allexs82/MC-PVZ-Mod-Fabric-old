package net.allexs82.pvzmod.event;

import net.allexs82.pvzmod.util.IPlayerEntityDataSaver;
import net.allexs82.pvzmod.util.Money;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerEvents implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        IPlayerEntityDataSaver original = (IPlayerEntityDataSaver) oldPlayer;
        IPlayerEntityDataSaver player = (IPlayerEntityDataSaver) newPlayer;

        player.PVZModFabric$getPersistenceData().putInt(Money.NBT_KEY, original.PVZModFabric$getPersistenceData().getInt(Money.NBT_KEY));
    }
}
