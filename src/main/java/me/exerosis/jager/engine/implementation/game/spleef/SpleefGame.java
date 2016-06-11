package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.implementation.Game;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends Game {
    private final SpleefPreGamePeriod preGamePeriod;
    private final SpleefInGamePeriod inGamePeriod;
    private final SpleefPostGamePeriod postGamePeriod;

    public SpleefGame(SpleefPreGamePeriod preGamePeriod, SpleefInGamePeriod inGamePeriod, SpleefPostGamePeriod postGamePeriod) {
        super(periods);
        this.preGamePeriod = preGamePeriod;
        this.inGamePeriod = inGamePeriod;
        this.postGamePeriod = postGamePeriod;
    }
}
