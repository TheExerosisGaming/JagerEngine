package me.exerosis.jager.gameengine.implementation.components.player.disablers;

import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DisablePickUpItem extends PlayerComponent {
    private Predicate<ItemStack> itemPredicate;

    public DisablePickUpItem(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisablePickUpItem(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(event.getItem().getItemStack()));
    }
}