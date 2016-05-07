package me.exerosis.jager.engine.implementation.components.player.death.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FakeDeathEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    
    public FakeDeathEvent(Player player) {
    	this.player = player;
    }
    
    public Player getPlayer() {
    	return player;
    }

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
