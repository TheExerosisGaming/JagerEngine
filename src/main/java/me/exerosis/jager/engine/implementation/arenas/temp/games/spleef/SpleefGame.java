package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.Period;
import me.exerosis.jager.engine.core.implementation.GameImplementation;
import me.exerosis.jager.engine.core.utilites.configuration.Configuration;
import me.exerosis.jager.engine.core.utilites.configuration.OnlineConfiguration;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;
import me.exerosis.jager.engine.implementation.states.scheduler.SchedulerState;
import me.exerosis.jager.engine.implementation.states.worlds.WorldLoadedState;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Exerosis.
 */
public class SpleefGame extends GameImplementation {
    private final SpleefPreGamePeriod preGamePeriod;
    private final SpleefInGamePeriod inGamePeriod;
    private final SpleefPostGamePeriod postGamePeriod;

    private final WorldLoadedState worldLoadedState;
    private final Configuration config;

    public SpleefGame(
            SpectateState spectateState,
            ConsolePrinter console,
            SchedulerState schedulerState,
            String configURL
            ) throws IOException {

        config = new OnlineConfiguration(configURL);

        this.worldLoadedState = new WorldLoadedState(console, config.getSection("world"), schedulerState);

        this.preGamePeriod = new SpleefPreGamePeriod(console, config.getSection("periods.preGame"), spectateState);
        this.inGamePeriod = new SpleefInGamePeriod(console, config.getSection("periods.inGame"), spectateState);
        this.postGamePeriod = new SpleefPostGamePeriod(console, config.getSection("periods.postGame"), spectateState);
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
        worldLoadedState.enable();
    }

    @Override
    protected void onDisable() {
        worldLoadedState.disable();
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

    public Configuration getConfig() {
        return config;
    }

    public WorldLoadedState getWorldLoadedState() {
        return worldLoadedState;
    }
}