package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

public class PvEDisabledState extends PlayerState {
    private Predicate<EntityDamageEvent> eventPredicate = event -> true;

    public PvEDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public PvEDisabledState(Predicate<Player> playerPredicate, Predicate<EntityDamageEvent> eventPredicate) {
        this(playerPredicate);
        this.eventPredicate = eventPredicate;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && getPlayerPredicate().test((Player) event.getEntity()) && eventPredicate.test(event));
    }
}
