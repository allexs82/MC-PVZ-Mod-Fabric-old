package net.allexs82.pvzmod.util;

import net.minecraft.entity.player.PlayerEntity;
import org.checkerframework.checker.index.qual.Positive;
import org.jetbrains.annotations.NotNull;

public abstract class Money {

    private static final String NBT_KEY = "money";

    public static void addMoney(@NotNull PlayerEntity player, @Positive int moneyToAdd) {
        IPlayerEntityDataSaver playerEntityDataSaver = (IPlayerEntityDataSaver) player;
        playerEntityDataSaver.PVZModFabric$getPersistenceData().putInt(NBT_KEY, moneyToAdd + getMoney(playerEntityDataSaver));
    }

    public static boolean subMoney(@NotNull PlayerEntity player, @Positive int moneyToSubtract) {
        IPlayerEntityDataSaver playerEntityDataSaver = (IPlayerEntityDataSaver) player;
        if (getMoney(playerEntityDataSaver) - moneyToSubtract >= 0) {
            playerEntityDataSaver.PVZModFabric$getPersistenceData().putInt(NBT_KEY, getMoney(playerEntityDataSaver) - moneyToSubtract);
            return true;
        }
        return false;
    }

    public static int getMoney(@NotNull PlayerEntity player) {
        IPlayerEntityDataSaver playerEntityDataSaver = (IPlayerEntityDataSaver) player;
        return playerEntityDataSaver.PVZModFabric$getPersistenceData().getInt(NBT_KEY);
    }


    private static int getMoney(@NotNull IPlayerEntityDataSaver playerEntityDataSaver) {
        return playerEntityDataSaver.PVZModFabric$getPersistenceData().getInt(NBT_KEY);
    }
}
