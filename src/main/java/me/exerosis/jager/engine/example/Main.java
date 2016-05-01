package me.exerosis.jager.gameengine.implementation.components.player.gadget.example;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.exerosis.jager.gameengine.implementation.components.player.gadget.FireworkGadget;

public class Main extends JavaPlugin {
	public void onEnable() {
		// Just an example, doesn't have to be a permission, could just be
		// playerList.contains or something.
		FireworkGadget fireworkGadget = new FireworkGadget(player -> player.hasPermission("gadget.fireworks"));
		Bukkit.getPluginManager().registerEvents(fireworkGadget, this);
		
		new HubState(fireworkGadget).enable();
	}
}