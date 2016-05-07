package me.exerosis.jager.engine.implementation.components.player.death;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import me.exerosis.jager.engine.implementation.components.ListenerComponent;
import me.exerosis.jager.engine.implementation.components.player.death.event.FakeDeathEvent;

public class FakeDeath extends ListenerComponent {

    public FakeDeath() {
    }

    @EventHandler
    public void fakeDeath(EntityDamageEvent event) {
    	if(!(event.getEntity() instanceof Player)) {
    		return;
    	}
    	Player player = (Player) event.getEntity();
    	if(event.getDamage() >= player.getHealth()) { //Check if the damage is greater or even to the players health
    		//FAKEDEATH
    		player.damage(0); //Create a fake hit effect
    		event.setCancelled(true); //Otherwise the player would die xD
    		Bukkit.getPluginManager().callEvent(new FakeDeathEvent(player)); //Calling the fakedeath event
    	}
    }
}
