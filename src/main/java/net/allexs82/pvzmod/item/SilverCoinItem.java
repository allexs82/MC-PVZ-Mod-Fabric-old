package net.allexs82.pvzmod.item;

import net.allexs82.pvzmod.util.Money;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SilverCoinItem extends Item {
    public SilverCoinItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        if (player == null) return ActionResult.FAIL;
        if (!world.isClient()) {
            player.getInventory().getMainHandStack().decrement(1);
            Money.addMoney(player, 5);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!user.getAbilities().creativeMode) itemStack.decrement(1);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!world.isClient()) {
            Money.addMoney(user, 5);
        }
        return TypedActionResult.success(itemStack);
    }
}
