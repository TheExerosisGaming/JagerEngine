package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DropItemDisabledState extends PlayerState {
    private Predicate<ItemStack> itemPredicate = item -> true;

    public DropItemDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DropItemDisabledState(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(event.getItemDrop().getItemStack()));
    }
}