package me.exerosis.jager.engine.implementation.components;

import me.exerosis.jager.engine.Main;
import me.exerosis.jager.engine.core.component.Component;
import org.bukkit.event.Listener;

/**
 * Created by Exerosis.
 */
public class ListenerComponent extends Component implements Listener {
    @Override
    protected void onEnable() {
        Main.registerEvents(this);
    }

    @Override
    protected void onDisable() {
        Main.unregisterEvents(this);
    }
}