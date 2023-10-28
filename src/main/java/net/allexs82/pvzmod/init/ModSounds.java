package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent ZOMBIE_GROAN = registerSoundEvents("zombie_groan");

    public static SoundEvent ZOMBIE_SPLAT = registerSoundEvents("zombie_splat");

    public static SoundEvent ZOMBIE_CHOMP = registerSoundEvents("zombie_chomp");

    public static SoundEvent GULP = registerSoundEvents("pvz_gulp");

    public static SoundEvent PROJECTILE_THROW = registerSoundEvents("projectile_throw");

    public static SoundEvent SHOVEL = registerSoundEvents("shovel");

    public static SoundEvent MONEY_FALLS = registerSoundEvents("money_falls");

    private static SoundEvent registerSoundEvents(String name) {
        Identifier id = new Identifier(PVZMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerModSounds() {
        PVZMod.LOGGER.info("Registering sounds for " + PVZMod.MOD_ID);
    }
}
