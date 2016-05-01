package me.exerosis.jager.gameengine.implementation.components.player.disablers;

import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Predicate;

public class DisablePvE extends PlayerComponent {
    private Predicate<EntityDamageEvent> eventPredicate = event -> true;

    public DisablePvE(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisablePvE(Predicate<Player> playerPredicate, Predicate<EntityDamageEvent> eventPredicate) {
        this(playerPredicate);
        this.eventPredicate = eventPredicate;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && getPlayerPredicate().test((Player) event.getEntity()) && eventPredicate.test(event));
    }
}
