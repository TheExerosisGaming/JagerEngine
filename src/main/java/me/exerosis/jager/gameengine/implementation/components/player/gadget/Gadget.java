package me.exerosis.jager.gameengine.implementation.components.player.gadget;

import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class Gadget extends PlayerComponent {

    public Gadget(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }
}
