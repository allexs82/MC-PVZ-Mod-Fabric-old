package net.allexs82.pvzmod;

import net.allexs82.pvzmod.init.*;
import net.allexs82.pvzmod.world.gen.ModEntitySpawn;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;


public class PVZMod implements ModInitializer {
    public static final String MOD_ID = "allexs82s_pvz";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final String NBT_MODIFIER = MOD_ID + "_data";

    @Override
    public void onInitialize() {
        ModSounds.registerModSounds();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEventsRegister.registerEvents();

        ModRegistries.registerModStuffs();

        ModEntitySpawn.addEntitySpawn();

        GeckoLib.initialize();
    }
}
