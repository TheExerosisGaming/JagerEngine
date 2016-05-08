package me.exerosis.jager.engine.implementation.components.player.spectate;

import org.bukkit.entity.Player;

public class PlayerExitSpectateEvent extends SpectateEvent {
    public PlayerExitSpectateEvent(Player player) {
        super(player);
    }
}
