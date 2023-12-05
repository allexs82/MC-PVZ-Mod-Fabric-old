package net.allexs82.pvzmod.entity.zombie;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.entity.ai.goal.BasicZombieAttackGoal;
import net.allexs82.pvzmod.entity.plant.PVZPlantEntity;
import net.allexs82.pvzmod.util.EAnimType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

@SuppressWarnings({"SameReturnValue"})
public class BasicZombieEntity extends PVZZombieEntity<BasicZombieEntity> implements IAnimatable, Monster {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public BasicZombieEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f);
    }

    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new BasicZombieAttackGoal(this, 1.0, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1));

        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PVZPlantEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
    }
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected String getAnimName(EAnimType AnimType) {
        switch (AnimType){
            case idle -> {
                return "animation.basic_zombie.idle";
            }
            case walk -> {
                return "animation.basic_zombie.walk";
            }
            case attack -> {
                return "animation.basic_zombie.attack";
            }
            default -> {
                PVZMod.LOGGER.error("[BasicZombieEntity] [getAnimName]: can't find anim of type: " + AnimType.name());
                return null;
            }
        }
    }
}
