package me.exerosis.jager.engine.implementation.components.player.disablers;

import me.exerosis.jager.engine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DisableDropItem extends PlayerComponent {
    private Predicate<ItemStack> itemPredicate = item -> true;

    public DisableDropItem(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisableDropItem(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(event.getItemDrop().getItemStack()));
    }
}