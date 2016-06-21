package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

public class MovementDisabledState extends PlayerState {
    private Predicate<Location> locationPredicate = location -> true;

    public MovementDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public MovementDisabledState(Predicate<Player> playerPredicate, Predicate<Location> locationPredicate) {
        this(playerPredicate);
        this.locationPredicate = locationPredicate;
    }
}