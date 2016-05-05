package me.exerosis.jager.engine.test.spleef;

import me.exerosis.jager.engine.core.Game;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends Game {
    private SpleefDisabledState disabledState;

    public SpleefGame(SpleefDisabledState disabledState) {
        this.disabledState = disabledState;
    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }
}
