package me.exerosis.jager.engine.implementation.arenas.temp.games.spleef;

import me.exerosis.jager.engine.core.implementation.PeriodImplementation;
import me.exerosis.jager.engine.implementation.states.player.disablers.MovementDisabledState;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;

/**
 * Created by Exerosis.
 */
public class SpleefPreGamePeriod extends PeriodImplementation {
    private final MovementDisabledState movementDisabledState;

    public SpleefPreGamePeriod(SpectateState spectateState) {
        movementDisabledState = new MovementDisabledState(spectateState);
    }

    @Override
    protected void onTick() {

    }

    @Override
    protected void onEnable() {
        movementDisabledState.enable();
    }

    @Override
    protected void onDisable() {
        movementDisabledState.disable();
    }

    @Override
    public int getLength() {
        return 600;
    }

    public MovementDisabledState getMovementDisabledState() {
        return movementDisabledState;
    }
}
