package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.utilites.configuration.Configuration;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.states.player.disablers.MovementDisabledState;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;

/**
 * Created by Exerosis.
 */
public class SpleefPreGamePeriod extends SpleefGamePeriod {
    private final MovementDisabledState movementDisabledState;

    public SpleefPreGamePeriod(ConsolePrinter console, Configuration config, SpectateState spectateState) {
        super(console, config, spectateState);
        movementDisabledState = new MovementDisabledState(spectateState);
    }

    @Override
    protected void onEnable() {
        movementDisabledState.enable();
    }

    @Override
    protected void onDisable() {
        movementDisabledState.disable();
    }

    public MovementDisabledState getMovementDisabledState() {
        return movementDisabledState;
    }
}
