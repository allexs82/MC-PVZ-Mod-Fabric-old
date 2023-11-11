package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@SuppressWarnings("unused")
public class ModItems {

    public static final Item SUN = registerItem("sun",
            new Item(new FabricItemSettings().group(ModItemGroups.ITEMS).fireproof()));

    public static final Item EMPTY_SEED_PACKET = registerItem("empty_seed_packet",
            new Item(new FabricItemSettings().group(ModItemGroups.SEED_PACKETS)));

    public static final Item SILVER_COIN = registerItem("silver_coin",
            new MoneyItem(new FabricItemSettings().group(ModItemGroups.ITEMS), 5));

    public static final Item GOLDEN_COIN = registerItem("golden_coin", new MoneyItem(
            new FabricItemSettings().group(ModItemGroups.ITEMS), 50));

    public static final Item BASIC_ZOMBIE_SPAWN_EGG = registerItem("basic_zombie_spawn_egg",
            new SpawnEggItem(ModEntities.BASIC_ZOMBIE, 0x310C0C, 0x0B5394,
                    new FabricItemSettings().group(ModItemGroups.ZOMBIES)));

    public static final Item PEA_ITEM = registerItem("pea_item",
            new PeaItem(new FabricItemSettings().group(ModItemGroups.ITEMS)));

    public static final Item SNOW_PEA_ITEM = registerItem("snow_pea_item", new SnowPeaItem(
            new FabricItemSettings().group(ModItemGroups.ITEMS)));

    public static final Item PEASHOOTER_SEED_PACKET = registerItem("peashooter_seed_packet",
            new SeedPacketItem(ModEntities.PEASHOOTER, new FabricItemSettings().group(ModItemGroups.SEED_PACKETS)));

    public static final Item SUNFLOWER_SEED_PACKET = registerItem("sunflower_seed_packet",
            new SeedPacketItem(ModEntities.SUNFLOWER, new FabricItemSettings().group(ModItemGroups.SEED_PACKETS)));
    public static final Item CONE = registerItem("cone",
            new ConeArmorItem(ModArmorMaterials.CONE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.ITEMS)));


    //-----------------------------------------------------------------//

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PVZMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PVZMod.LOGGER.info("Registering items for " + PVZMod.MOD_ID);
    }
}
