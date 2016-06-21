package me.exerosis.jager.engine.implementation.states.player.disablers;

import me.exerosis.jager.engine.core.utilites.BlockUtilities;
import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class BlockBreakDisabledState extends PlayerState {
    private Predicate<ItemStack> itemPredicate = item -> true;

    public BlockBreakDisabledState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public BlockBreakDisabledState(Predicate<Player> playerPredicate, Predicate<ItemStack> itemPredicate) {
        this(playerPredicate);
        this.itemPredicate = itemPredicate;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(getPlayerPredicate().test(event.getPlayer()) && itemPredicate.test(BlockUtilities.toItemStack(event.getBlock())));
    }
}
