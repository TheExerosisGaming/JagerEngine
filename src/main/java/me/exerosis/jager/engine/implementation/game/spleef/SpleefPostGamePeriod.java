package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.implementation.PeriodImplementation;

/**
 * Created by Exerosis.
 */
public class SpleefPostGamePeriod extends PeriodImplementation {
    public SpleefPostGamePeriod() {

    }

    @Override
    protected void onEnable() {
        //Pull countdown time from config.
        setTicksRemaining(20*30);
    }
}
