package me.exerosis.jager.engine.core.implementation;

import me.exerosis.jager.engine.core.Period;

import java.util.Queue;

/**
 * Created by Exerosis.
 */
public class Game extends PeriodImplementation {
    private Queue<Period> periods;
    private Period currentPeriod;

    public Game(Period... periods) {

    }

    @Override
    protected void onEnable() {
        currentPeriod.enable();
    }

    @Override
    protected void onDisable() {
        currentPeriod.disable();
    }

    @Override
    protected void onTick() {
        if (currentPeriod.getTicksRemaining() == 1) {
            currentPeriod.tick();
            currentPeriod = periods.poll();
            currentPeriod.enable();
        }
        currentPeriod.tick();
    }
}