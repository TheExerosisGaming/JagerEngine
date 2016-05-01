package me.exerosis.jager.gameengine.implementation.components.player.disablers;

import me.exerosis.jager.gameengine.core.utilites.BlockUtilities;
import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class DisableBlockBreak extends PlayerComponent {
    private Predicate<ItemStack> itemPredicate = item -> true;

    public DisableBlockBreak(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisableBlockBreak(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(BlockUtilities.toItemStack(event.getBlock())));
    }
}
