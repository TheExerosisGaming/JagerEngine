package me.exerosis.jager.engine.implementation.states.player.spectate.event;

import org.bukkit.entity.Player;

public class PlayerExitSpectateEvent extends SpectateEvent {
    public PlayerExitSpectateEvent(Player player) {
        super(player);
    }
}
