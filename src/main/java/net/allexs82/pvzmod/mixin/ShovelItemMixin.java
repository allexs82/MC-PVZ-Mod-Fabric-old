package net.allexs82.pvzmod.mixin;

import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.allexs82.pvzmod.init.ModSounds;
import net.allexs82.pvzmod.item.SeedPacketItem;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShovelItem.class)
public abstract class ShovelItemMixin extends MiningToolItem {

    protected ShovelItemMixin(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        if (entity instanceof PVZPlantEntity && !world.isClient()) {
            world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.SHOVEL, SoundCategory.PLAYERS, 0.5f, 1.0f);
            for (Enchantment enchantment : EnchantmentHelper.get(stack).keySet()) {
                if (EnchantmentHelper.getEnchantmentId(enchantment) == EnchantmentHelper.getEnchantmentId(Enchantments.SILK_TOUCH)) {
                    user.giveItemStack(new ItemStack(SeedPacketItem.forEntity(entity.getType())));
                }
            }
            entity.discard();
            stack.damage(1, user, (p) -> p.sendToolBreakStatus(hand));
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
