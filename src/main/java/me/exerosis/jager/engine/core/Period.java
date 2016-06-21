package me.exerosis.jager.engine.core;

/**
 * Created by Exerosis.
 */
public interface Period extends State {
    int getLength();
    void setLength(int length);
    int getTicksRemaining();
    void setTicksRemaining(int ticksRemaining);
    void tick();
}

//tick
//current tick
//