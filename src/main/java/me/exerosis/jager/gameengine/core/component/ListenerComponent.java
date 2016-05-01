package me.exerosis.jager.gameengine.core.component;

import me.exerosis.jager.gameengine.Main;
import org.bukkit.event.Listener;

/**
 * Created by Exerosis.
 */
public class ListenerComponent extends Component implements Listener {
    @Override
    public void onEnable() {
        Main.registerEvents(this);
    }

    @Override
    public void onDisable() {
        Main.unregisterEvents(this);
    }
}