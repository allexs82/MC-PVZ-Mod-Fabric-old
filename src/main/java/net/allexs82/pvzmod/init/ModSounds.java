package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent ENTITY_ZOMBIE_AMBIENT = registerSoundEvents("entity.zombie.ambient");

    private static SoundEvent registerSoundEvents(String name) {
        Identifier id = new Identifier(PVZMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
