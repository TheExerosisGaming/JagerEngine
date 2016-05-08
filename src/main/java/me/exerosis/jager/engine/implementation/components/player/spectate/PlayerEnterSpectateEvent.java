package me.exerosis.jager.engine.implementation.components.player.spectate;

import org.bukkit.entity.Player;

public class PlayerEnterSpectateEvent extends SpectateEvent {
    public PlayerEnterSpectateEvent(Player player) {
        super(player);
    }
}
