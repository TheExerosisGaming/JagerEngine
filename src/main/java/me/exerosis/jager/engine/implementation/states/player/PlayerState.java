package me.exerosis.jager.engine.implementation.states.player;

import me.exerosis.jager.engine.implementation.states.EventState;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class PlayerState extends EventState {
    private Predicate<Player> playerPredicate;

    public PlayerState(Predicate<Player> playerPredicate) {
        this.playerPredicate = playerPredicate;
    }

    public PlayerState() {
        this(player -> true);
    }

    public void setPlayerPredicate(Predicate<Player> predicate) {
        this.playerPredicate = predicate;
    }

    public Predicate<Player> getPlayerPredicate() {
        return playerPredicate;
    }
}