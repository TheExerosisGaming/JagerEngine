package me.exerosis.jager.engine.implementation.components.player.disablers;

import me.exerosis.jager.engine.core.utilites.BlockUtilities;
import me.exerosis.jager.engine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DisableBlockPlace extends PlayerComponent {
    private Predicate<ItemStack> itemPredicate = item -> true;

    public DisableBlockPlace(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisableBlockPlace(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(BlockUtilities.toItemStack(event.getBlock())));
    }
}