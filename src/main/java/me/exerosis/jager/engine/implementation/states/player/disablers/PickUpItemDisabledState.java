package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class PickUpItemDisabledState extends PlayerState {
    private Predicate<ItemStack> itemPredicate;

    public PickUpItemDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public PickUpItemDisabledState(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(event.getItem().getItemStack()));
    }
}