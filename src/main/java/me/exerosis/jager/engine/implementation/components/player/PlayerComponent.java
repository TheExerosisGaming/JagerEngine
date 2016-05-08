package me.exerosis.jager.engine.implementation.components.player;

import me.exerosis.jager.engine.implementation.components.EventComponent;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class PlayerComponent extends EventComponent {
    private Predicate<Player> playerPredicate;

    public PlayerComponent(Predicate<Player> playerPredicate) {
        this.playerPredicate = playerPredicate;
    }

    public PlayerComponent() {
        this(player -> true);
    }

    public void setPlayerPredicate(Predicate<Player> predicate) {
        this.playerPredicate = predicate;
    }

    public Predicate<Player> getPlayerPredicate() {
        return playerPredicate;
    }
}