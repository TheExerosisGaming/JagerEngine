package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.implementation.PeriodImplementation;

/**
 * Created by Exerosis.
 */
public class SpleefInGamePeriod extends PeriodImplementation {
    public SpleefInGamePeriod() {

    }

    @Override
    protected void onEnable() {
        //Pull countdown time from config.
        setTicksRemaining(20*30);
    }
}
