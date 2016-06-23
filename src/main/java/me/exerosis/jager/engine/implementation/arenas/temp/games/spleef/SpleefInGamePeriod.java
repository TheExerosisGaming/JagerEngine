package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.utilites.configuration.Configuration;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;

/**
 * Created by Exerosis.
 */
public class SpleefInGamePeriod extends SpleefGamePeriod {

    public SpleefInGamePeriod(ConsolePrinter console, Configuration config, SpectateState spectateState) {
        super(console, config, spectateState);
    }
}
