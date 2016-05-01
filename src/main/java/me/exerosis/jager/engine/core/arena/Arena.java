package me.exerosis.jager.gameengine.core.arena;

import me.exerosis.jager.gameengine.core.state.StateProvider;

/**
 * Created by Exerosis.
 */
public class Arena {
    private StateProvider stateProvider;

    public Arena(StateProvider stateProvider) {
        this.stateProvider = stateProvider;
    }
}