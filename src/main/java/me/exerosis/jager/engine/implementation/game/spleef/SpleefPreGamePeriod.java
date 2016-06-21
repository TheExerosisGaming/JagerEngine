package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.implementation.PeriodImplementation;

/**
 * Created by Exerosis.
 */
public class SpleefPreGamePeriod extends PeriodImplementation {
    public SpleefPreGamePeriod() {

    }

    @Override
    protected void onEnable() {
        //Pull countdown time from config.
        setTicksRemaining(20*30);
    }
}
