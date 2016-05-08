package me.exerosis.jager.engine.implementation.components.player.spectate;

import me.exerosis.jager.engine.implementation.components.EventComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class SpectateComponent extends EventComponent implements Predicate<Player> {
    private final Set<Player> players = new HashSet<>();

    public SpectateComponent() {
    }

    public void enterSpectating(Player player) {
        if (!isEnabled() || !test(player))
            return;

        callEvent(new PlayerEnterSpectateEvent(player), event -> {
            if (event.isCancelled())
                return;
            if (!players.add(player))
                return;
            player.setGameMode(GameMode.ADVENTURE);
            player.setVelocity(new Vector());
            player.setFlying(true);
            player.teleport(player.getWorld().getSpawnLocation());
        });
    }

    public void exitSpectating(Player player) {
        players.remove(player);
    }

    public void removeAll() {
        players.clear();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        exitSpectating(event.getPlayer());
    }

    @EventHandler
    public void onDoubleJump(PlayerToggleFlightEvent event) {
        if (test(event.getPlayer()))
            event.getPlayer().setFlying(true);
    }

    @EventHandler
    public void onScroll(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (!test(player) || !player.isSprinting())
            return;
        event.setCancelled(true);

        player.setFlySpeed(event.getNewSlot() * 0.1F);
//        player.setFlySpeed(NumberUtilities.bound(player.getFlySpeed() + (event.getNewSlot() > event.getPreviousSlot() ? 0.05F : -0.05F)));
    }

    @Override
    public boolean test(Player player) {
        return players.contains(player);
    }

    @Override
    public void onDisable() {
        removeAll();
    }

    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public int getNumberOfSpectators() {
        return players.size();
    }

    public int getNumberOfGamePlayers() {
        return Bukkit.getOnlinePlayers().size() - players.size();
    }
}