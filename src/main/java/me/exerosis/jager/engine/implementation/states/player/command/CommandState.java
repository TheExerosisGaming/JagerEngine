package me.exerosis.jager.engine.implementation.states.player.command;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by Exerosis.
 */
public class CommandState extends PlayerState {
    private String prefix;

    public CommandState(Predicate<Player> playerPredicate) {
        super(playerPredicate);
    }

    public CommandState(Predicate<Player> playerPredicate, String prefix) {
        this.prefix = prefix;
    }

    public void onCommand(String[] params){

    }

    @EventHandler
    public void onAsyncChatEvent(AsyncPlayerChatEvent event) {
        if (!event.getMessage().startsWith("/"))
            return;
        if (!getPlayerPredicate().test(event.getPlayer()))
            return;

        String[] parts = event.getMessage().replaceFirst("/", "").split(" ");
        if (!parts[0].equalsIgnoreCase(prefix))
            return;

        onCommand(Arrays.copyOfRange(parts, 1, parts.length));
    }
}
