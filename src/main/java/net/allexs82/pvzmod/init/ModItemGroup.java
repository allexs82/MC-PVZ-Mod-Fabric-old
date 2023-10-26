package net.allexs82.pvzmod.init;

import net.allexs82.pvzmod.PVZMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(PVZMod.MOD_ID, "items"),
            () -> new ItemStack(ModItems.SUN));

    public static final ItemGroup SEED_PACKETS = FabricItemGroupBuilder.build(new Identifier(PVZMod.MOD_ID, "seed_packets"),
            () -> new ItemStack(ModItems.EMPTY_SEED_PACKET));

    public static final ItemGroup ZOMBIES = FabricItemGroupBuilder.build(new Identifier(PVZMod.MOD_ID, "zombies"),
            () -> new ItemStack(ModItems.BASIC_ZOMBIE_SPAWN_EGG));
}
