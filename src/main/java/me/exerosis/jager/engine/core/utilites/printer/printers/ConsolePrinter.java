package me.exerosis.jager.engine.core.utilites.printer.printers;

import me.exerosis.jager.engine.core.utilites.printer.DestinationPrinter;

/**
 * Created by Exerosis.
 */
public class ConsolePrinter extends DestinationPrinter {

    @Override
    protected void _print(Object message) {
        System.out.println(message);
    }
}
