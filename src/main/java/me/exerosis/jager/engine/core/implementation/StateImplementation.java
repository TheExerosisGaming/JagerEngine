package me.exerosis.jager.engine.core.implementation;

import me.exerosis.jager.engine.core.State;

/**
 * Created by Exerosis.
 */
public class StateImplementation implements State {
    private boolean enabled = false;

    @Override
    public void enable() {
        if (isEnabled())
            return;
        enabled = true;
        onEnable();
    }

    @Override
    public void disable() {
        if (!isEnabled())
            return;
        enabled = false;
        onDisable();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    protected void onEnable() {

    }


    protected void onDisable() {

    }
}
