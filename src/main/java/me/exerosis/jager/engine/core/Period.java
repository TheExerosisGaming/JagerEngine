package me.exerosis.jager.engine.core;

/**
 * Created by Exerosis.
 */
public interface Period extends State {
    int getLength();
    int getTicksRemaining();
    void setTicksRemaining(int ticksRemaining);
    void tick();
}