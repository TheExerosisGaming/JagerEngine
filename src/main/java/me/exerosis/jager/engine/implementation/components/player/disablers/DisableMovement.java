package me.exerosis.jager.engine.implementation.components.player.disablers;

import me.exerosis.jager.engine.implementation.components.player.PlayerComponent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

public class DisableMovement extends PlayerComponent {
    private Predicate<Location> locationPredicate = location -> true;

    public DisableMovement(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisableMovement(Predicate<Player> playerPredicate, Predicate<Location> locationPredicate) {
        this(playerPredicate);
        this.locationPredicate = locationPredicate;
    }
}