package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.implementation.PeriodImplementation;
import me.exerosis.jager.engine.core.utilites.configuration.Configuration;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;

/**
 * Created by Exerosis.
 */
public class SpleefGamePeriod extends PeriodImplementation {
    private final ConsolePrinter console;
    private final Configuration config;
    private final SpectateState spectateState;

    public SpleefGamePeriod(ConsolePrinter console, Configuration config, SpectateState spectateState) {
        this.console = console;
        this.config = config;
        this.spectateState = spectateState;
    }

    public Configuration getConfig() {
        return config;
    }

    public ConsolePrinter getConsole() {
        return console;
    }

    public SpectateState getSpectateState() {
        return spectateState;
    }

    @Override
    public int getLength() {
        return config.getInt("ticks");
    }
}
