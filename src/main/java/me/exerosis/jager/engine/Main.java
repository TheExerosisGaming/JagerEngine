package me.exerosis.jager.engine;

import me.exerosis.jager.engine.implementation.arenas.temp.ExampleArena;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Created by Exerosis.
 */
public class Main extends JavaPlugin {
    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        ExampleArena arena;
        try {
            arena = new ExampleArena();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You messed something up that's for sure! Let's not start this server hah!");
            return;
        }
        arena.enable();
    }

    public static Main getPlugin() {
        return plugin;
    }

    public static void registerEvents(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, getPlugin());
    }

    public static void unregisterEvents(Listener listener) {
        HandlerList.unregisterAll(listener);
    }
}
