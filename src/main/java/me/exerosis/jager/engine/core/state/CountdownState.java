package me.exerosis.jager.engine.core.state;

import me.exerosis.jager.engine.implementation.components.scheduler.SchedulerComponent;

/**
 * Created by Exerosis.
 */
public class CountdownState extends State implements Runnable {
    private int countdownTime;
    private int timeLeft;
    private SchedulerComponent schedulerComponent;

    public CountdownState(SchedulerComponent schedulerComponent) {
        this.schedulerComponent = schedulerComponent;
    }

    @Override
    public void enable() {
        super.enable();
        timeLeft = countdownTime;
        schedulerComponent.registerTask(this, 1, Integer.MAX_VALUE);
    }

    @Override
    public void disable() {
        super.disable();
        schedulerComponent.cancelTask(this);
    }

    protected void tick(int timeLeft){

    }

    @Override
    public void run() {
        tick(--timeLeft);
        if (timeLeft == 0)
            disable();
    }
}
