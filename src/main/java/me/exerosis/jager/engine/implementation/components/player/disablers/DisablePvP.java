package me.exerosis.jager.engine.implementation.components.player.disablers;

import me.exerosis.jager.engine.implementation.components.player.PlayerComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.function.Predicate;

public class DisablePvP extends PlayerComponent {
    private Predicate<Player> attackerPredicate = player -> true;

    public DisablePvP(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public DisablePvP(Predicate<Player> playerPredicate, Predicate<Player> attackerPredicate) {
        this(playerPredicate);
        this.attackerPredicate = attackerPredicate;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player))
            return;
        Player player = (Player) event.getEntity();
        Player attacker = (Player) event.getDamager();

        event.setCancelled(getPlayerPredicate().test(player) && attackerPredicate.test(attacker));
    }
}