package me.exerosis.jager.engine.implementation.components.printer.printers;

import me.exerosis.jager.engine.implementation.components.printer.DestinationPrinter;

/**
 * Created by Exerosis.
 */
public class ConsolePrinter extends DestinationPrinter {

    @Override
    protected void _print(Object message) {
        System.out.println(message);
    }
}
