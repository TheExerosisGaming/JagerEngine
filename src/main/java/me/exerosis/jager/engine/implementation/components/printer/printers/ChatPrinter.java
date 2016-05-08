package me.exerosis.jager.engine.implementation.components.printer.printers;

import me.exerosis.jager.engine.implementation.components.printer.DestinationPrinter;
import org.bukkit.Bukkit;

/**
 * Created by Exerosis.
 */
public class ChatPrinter extends DestinationPrinter {

    @Override
    protected void _print(Object message) {
        Bukkit.broadcastMessage(message.toString());
    }
}
