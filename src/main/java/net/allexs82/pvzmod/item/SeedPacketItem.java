package net.allexs82.pvzmod.item;

import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.util.EPlantType;
import net.allexs82.pvzmod.util.PVZModArrays;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SeedPacketItem extends SpawnEggItem {

    private static final int WHITE = 0xFFFFFF;

    private final EPlantType PlantType;

    public SeedPacketItem(EntityType<? extends PVZPlantEntity> type, Settings settings) {
        super(type, WHITE, WHITE, settings);
        this.PlantType = EPlantType.DEFAULT;
    }

    public SeedPacketItem(EntityType<? extends PVZPlantEntity> type, Settings settings, EPlantType EPlantType) {
        super(type, WHITE, WHITE, settings);
        this.PlantType = EPlantType;
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (!PVZModArrays.canPlantPlant(blockState.getBlock())) return ActionResult.PASS;

        PlayerEntity player = context.getPlayer();
        if (!world.isClient() && player != null) {
            context.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PLANT,
                    SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (PlantType != EPlantType.AQUATIC) return TypedActionResult.pass(user.getStackInHand(hand));
        if (!world.isClient()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.PLANT_WATER,
                    SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        return super.use(world, user, hand);
    }
}
