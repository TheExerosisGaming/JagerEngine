package me.exerosis.jager.engine.core;

/**
 * Created by Exerosis.
 */
public interface State {
    void enable();

    void disable();

    boolean isEnabled();
}