package net.allexs82.pvzmod.item;

import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.util.Money;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.checkerframework.checker.index.qual.Positive;

public class MoneyItem extends Item {

    private final int moneyValue;

    public MoneyItem(Settings settings, @Positive int moneyValue) {
        super(settings);
        this.moneyValue = moneyValue;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!user.getAbilities().creativeMode) itemStack.decrement(1);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!world.isClient()) {
            Money.addMoney(user, this.moneyValue);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MONEY_FALLS, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
        return TypedActionResult.success(itemStack);
    }
}
