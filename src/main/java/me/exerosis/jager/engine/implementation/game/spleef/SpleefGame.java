package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.Period;
import me.exerosis.jager.engine.core.implementation.GameImplementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends GameImplementation {
    private final SpleefPreGamePeriod preGamePeriod;
    private final SpleefInGamePeriod inGamePeriod;
    private final SpleefPostGamePeriod postGamePeriod;

    public SpleefGame(SpleefPreGamePeriod preGamePeriod, SpleefInGamePeriod inGamePeriod, SpleefPostGamePeriod postGamePeriod) {
        this.preGamePeriod = preGamePeriod;
        this.inGamePeriod = inGamePeriod;
        this.postGamePeriod = postGamePeriod;
    }

    @Override
    public Queue<Period> getPeriods() {
        LinkedList<Period> periods = new LinkedList<>();
        periods.addFirst(preGamePeriod);
        periods.addFirst(inGamePeriod);
        periods.addFirst(postGamePeriod);
        return periods;
    }
}
