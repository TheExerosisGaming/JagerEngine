package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.function.Predicate;

public class HungerDisabledState extends PlayerState {
    private Predicate<FoodLevelChangeEvent> eventPredicate = event -> true;

    public HungerDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public HungerDisabledState(Predicate<Player> playerPredicate, Predicate<FoodLevelChangeEvent> eventPredicate) {
        this(playerPredicate);
        this.eventPredicate = eventPredicate;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(event.getEntity() instanceof Player && getPlayerPredicate().test((Player) event.getEntity()) && eventPredicate.test(event));
    }
}
