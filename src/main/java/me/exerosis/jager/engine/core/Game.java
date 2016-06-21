package me.exerosis.jager.engine.core;

import java.util.Queue;

/**
 * Created by Exerosis.
 */
public interface Game extends Period {
    Queue<Period> getPeriods();
}
