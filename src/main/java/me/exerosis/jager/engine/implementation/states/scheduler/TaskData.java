package me.exerosis.jager.engine.implementation.states.scheduler;

/**
 * Written by Exerosis!
 *
 * @author BlockServer Team
 * @see SchedulerState
 */
public class TaskData {
    protected long lastTickTime;
    private double delay;
    private int repeatTimes;

    public TaskData(double delay, int repeatTimes) {
        this.delay = delay;
        this.repeatTimes = repeatTimes;
    }

    public long getNextTickTime() {
        return lastTickTime + (long) delay;
    }

    public long getLastTickTime() {
        return lastTickTime;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }
}