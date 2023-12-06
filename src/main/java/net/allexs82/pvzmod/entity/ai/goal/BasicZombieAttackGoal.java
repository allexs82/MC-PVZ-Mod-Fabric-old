package net.allexs82.pvzmod.entity.ai.goal;

import net.allexs82.pvzmod.entity.zombie.BasicZombieEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class BasicZombieAttackGoal extends MeleeAttackGoal {

    private final BasicZombieEntity zombie;
    private int ticks;

    public BasicZombieAttackGoal(BasicZombieEntity zombie, double speed, boolean pauseWhenMobIdle) {
        super(zombie, speed, pauseWhenMobIdle);
        this.zombie = zombie;
    }

    @Override
    public void start() {
        super.start();
        this.ticks = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.zombie.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        ++this.ticks;
        this.zombie.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);
    }
}
