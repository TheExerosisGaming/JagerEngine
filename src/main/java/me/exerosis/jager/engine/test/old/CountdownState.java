package me.exerosis.jager.engine.test.old;

import me.exerosis.jager.engine.implementation.states.scheduler.SchedulerState;

/**
 * Created by Exerosis.
 */
public class CountdownState extends State implements Runnable {
    private int countdownTime;
    private int timeLeft;
    private SchedulerState schedulerState;

    public CountdownState(SchedulerState schedulerState) {
        this.schedulerState = schedulerState;
    }

    @Override
    public void enable() {
        super.enable();
        timeLeft = countdownTime;
        schedulerState.registerTask(this, 1, Integer.MAX_VALUE);
    }

    @Override
    public void disable() {
        super.disable();
        schedulerState.cancelTask(this);
    }

    protected void tick(int timeLeft){

    }

    @Override
    public void run() {
        tick(--timeLeft);
        if (timeLeft == 0)
            disable();
    }

    public int getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(int countdownTime) {
        this.countdownTime = countdownTime;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
}
