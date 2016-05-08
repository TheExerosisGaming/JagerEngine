package me.exerosis.jager.engine.implementation.game.spleef;

import me.exerosis.jager.engine.core.Game;
import me.exerosis.jager.engine.implementation.game.CoreComponentBundle;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends Game {
    private final SpleefDisabledState disabledState;
    private final SpleefPreGameState preGameState;
    private final SpleefInGameState inGameState;
    private final SpleefPostGameState postGameState;

    public SpleefGame(CoreComponentBundle coreComponentBundle) {
        disabledState = null;
        preGameState = null;
        inGameState = null;
        postGameState = null;
    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }
}
