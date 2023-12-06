package net.allexs82.pvzmod.util;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.List;

public abstract class PVZModArrays {

    private static final List<Block> PLANTABLE_BLOCKS;

    public static boolean canPlantPlant(Block block) {
        return PLANTABLE_BLOCKS.contains(block);
    }

    static {
        PLANTABLE_BLOCKS = Lists.newArrayList(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.LILY_PAD, Blocks.MYCELIUM, Blocks.ROOTED_DIRT);
    }
}
