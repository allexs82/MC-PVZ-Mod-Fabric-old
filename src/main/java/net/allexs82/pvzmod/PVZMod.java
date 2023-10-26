package net.allexs82.pvzmod;

import net.allexs82.pvzmod.init.ModBlocks;
import net.allexs82.pvzmod.init.ModEventsRegister;
import net.allexs82.pvzmod.init.ModItems;
import net.allexs82.pvzmod.init.ModRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;


public class PVZMod implements ModInitializer {
    public static final String MOD_ID = "allexs82s_pvz";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final String NBT_MODIFIER = MOD_ID + "_Data";

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEventsRegister.registerEvents();

        ModRegistries.registerModStuffs();

        GeckoLib.initialize();
    }
}
