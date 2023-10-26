package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.item.PeaItem;
import net.allexs82.pvzmod.item.SilverCoinItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@SuppressWarnings("unused")
public class ModItems {

    public static final Item SUN = registerItem("sun",
            new Item(new FabricItemSettings().group(ModItemGroup.ITEMS).fireproof()));

    public static final Item EMPTY_SEED_PACKET = registerItem("empty_seed_packet",
            new Item(new FabricItemSettings().group(ModItemGroup.SEED_PACKETS).recipeRemainder(Items.PAPER)));

    public static final Item SILVER_COIN = registerItem("silver_coin",
            new SilverCoinItem(new FabricItemSettings().group(ModItemGroup.ITEMS)));

    public static final Item BASIC_ZOMBIE_SPAWN_EGG = registerItem("basic_zombie_spawn_egg",
            new SpawnEggItem(ModEntities.BASIC_ZOMBIE, 1, 1,
                    new FabricItemSettings().group(ModItemGroup.ZOMBIES)));

    public static final Item PEA_ITEM = registerItem("pea_item",
            new PeaItem(new FabricItemSettings().group(ModItemGroup.ITEMS)));

    public static final Item PEASHOOTER_SEED_PACKET = registerItem("peashooter_seed_packet",
            new SpawnEggItem(ModEntities.PEASHOOTER, 0, 0, new FabricItemSettings().group(ModItemGroup.SEED_PACKETS)));


    //-----------------------------------------------------------------//

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PVZMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PVZMod.LOGGER.info("Registering items for " + PVZMod.MOD_ID);
    }
}