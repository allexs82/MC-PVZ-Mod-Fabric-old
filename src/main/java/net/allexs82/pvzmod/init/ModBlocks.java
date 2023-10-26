package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings({"SameParameterValue", "UnusedReturnValue"})
public class ModBlocks {

    private static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registry.BLOCK, new Identifier(PVZMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup itemGroup) {
        return Registry.register(Registry.ITEM, new Identifier(PVZMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(itemGroup)));
    }
    public static void registerModBlocks() {
        PVZMod.LOGGER.info("Registering blocks for " + PVZMod.MOD_ID);
    }
}
