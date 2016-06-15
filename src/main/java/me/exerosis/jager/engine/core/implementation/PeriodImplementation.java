package me.exerosis.jager.engine.core.implementation;

import me.exerosis.jager.engine.core.Period;

/**
 * Created by Exerosis.
 */
public class PeriodImplementation extends StateImplementation implements Period {
    private int ticksRemaining = 0;
    private int length = 0;

    public PeriodImplementation() {

    }

    @Override
    public void tick() {
        if (!isEnabled())
            return;

        if (ticksRemaining-- <= 0)
            disable();
        else
            onTick();
    }

    @Override
    public void disable() {
        if (isEnabled())
            ticksRemaining = 0;
        super.disable();
    }

    @Override
    public void enable() {
        if(!isEnabled())
            ticksRemaining = length;
        super.enable();
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getTicksRemaining() {
        return ticksRemaining;
    }

    @Override
    public void setTicksRemaining(int ticksRemaining) {
        this.ticksRemaining = ticksRemaining;
    }

    protected void onTick() {

    }
}
