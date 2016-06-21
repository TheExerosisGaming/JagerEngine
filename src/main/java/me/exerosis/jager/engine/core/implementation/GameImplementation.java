package me.exerosis.jager.engine.core.implementation;

import me.exerosis.jager.engine.core.Game;
import me.exerosis.jager.engine.core.Period;

/**
 * Created by Exerosis.
 */

public abstract class GameImplementation extends PeriodImplementation implements Game {
    private Period currentPeriod;

    public GameImplementation() {

    }

    @Override
    public int getLength() {
        int length = 0;
        for (Period period : getPeriods())
            length += period.getLength();
        return length;
    }

    @Override
    public void enable() {
        if(!isEnabled())
            currentPeriod.enable();
        super.enable();
    }


    @Override
    public void disable() {
        if(isEnabled())
            currentPeriod.disable();
        super.disable();
    }

    @Override
    protected void onTick() {
        if (currentPeriod.getTicksRemaining() == 1) {
            currentPeriod.tick();
            currentPeriod = getPeriods().poll();
            currentPeriod.enable();
        }
        currentPeriod.tick();
    }
}