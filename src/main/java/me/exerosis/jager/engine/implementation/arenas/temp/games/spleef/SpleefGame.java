package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.Period;
import me.exerosis.jager.engine.core.implementation.GameImplementation;
import me.exerosis.jager.engine.implementation.states.player.death.DeathState;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;
import me.exerosis.jager.engine.implementation.states.worlds.WorldLoadedState;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends GameImplementation {
    private final SpleefPreGamePeriod preGamePeriod;
    private final SpleefInGamePeriod inGamePeriod;
    private final SpleefPostGamePeriod postGamePeriod;

    private final DeathState deathState;
    private final WorldLoadedState worldLoadedState;
    private final SpectateState spectateState;

    public SpleefGame(DeathState deathState, WorldLoadedState worldLoadedState, SpectateState spectateState) {
        this.deathState = deathState;
        this.worldLoadedState = worldLoadedState;
        this.spectateState = spectateState;

        this.preGamePeriod = new SpleefPreGamePeriod();
        this.inGamePeriod = new SpleefInGamePeriod();
        this.postGamePeriod = new SpleefPostGamePeriod();
    }

    @Override
    public Queue<Period> getPeriods() {
        LinkedList<Period> periods = new LinkedList<>();
        periods.addFirst(preGamePeriod);
        periods.addFirst(inGamePeriod);
        periods.addFirst(postGamePeriod);
        return periods;
    }

    @Override
    protected void onEnable() {
        deathState.enable();
        worldLoadedState.enable();
        spectateState.enable();
    }

    @Override
    protected void onDisable() {
        deathState.disable();
        worldLoadedState.disable();
        spectateState.disable();
    }


    public SpleefPreGamePeriod getPreGamePeriod() {
        return preGamePeriod;
    }

    public SpleefInGamePeriod getInGamePeriod() {
        return inGamePeriod;
    }

    public SpleefPostGamePeriod getPostGamePeriod() {
        return postGamePeriod;
    }


    public DeathState getDeathState() {
        return deathState;
    }

    public WorldLoadedState getWorldLoadedState() {
        return worldLoadedState;
    }

    public SpectateState getSpectateState() {
        return spectateState;
    }
}