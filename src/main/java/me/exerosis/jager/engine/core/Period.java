package me.exerosis.jager.engine.core;

/**
 * Created by Exerosis.
 */
public interface Period extends State {
    int getTicksRemaining();
    void tick();
}
