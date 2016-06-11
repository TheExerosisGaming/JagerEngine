package me.exerosis.jager.engine.implementation.states;

import me.exerosis.jager.engine.Main;
import me.exerosis.jager.engine.core.implementation.StateImplementation;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import java.util.function.Consumer;

/**
 * Created by Exerosis.
 */
public class EventState extends StateImplementation implements Listener {

    @Override
    protected void onEnable() {
        Main.registerEvents(this);
    }

    @Override
    protected void onDisable() {
        Main.unregisterEvents(this);
    }

    public <T extends Event> void callEvent(T event) {
        callEvent(event, null);
    }

    public <T extends Event> void callEvent(T event, Consumer<T> consumer) {
        Bukkit.getPluginManager().callEvent(event);
        if (consumer != null)
            consumer.accept(event);
    }
}