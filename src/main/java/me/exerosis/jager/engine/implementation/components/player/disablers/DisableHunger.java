package me.exerosis.jager.gameengine.implementation.components.player.disablers;

import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.function.Predicate;

public class DisableHunger extends PlayerComponent {
    private Predicate<FoodLevelChangeEvent> eventPredicate = event -> true;

    public DisableHunger(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisableHunger(Predicate<Player> playerPredicate, Predicate<FoodLevelChangeEvent> eventPredicate) {
        this(playerPredicate);
        this.eventPredicate = eventPredicate;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && getPlayerPredicate().test((Player) event.getEntity()) && eventPredicate.test(event));
    }
}
