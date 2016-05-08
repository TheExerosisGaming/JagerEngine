package me.exerosis.jager.engine.implementation.game;

import me.exerosis.jager.engine.implementation.components.player.command.CommandComponent;
import me.exerosis.jager.engine.implementation.components.player.death.DeathComponent;
import me.exerosis.jager.engine.implementation.components.player.spectate.SpectateComponent;
import me.exerosis.jager.engine.implementation.components.printer.printers.ChatPrinter;
import me.exerosis.jager.engine.implementation.components.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.components.scheduler.SchedulerComponent;
import me.exerosis.jager.engine.implementation.components.worlds.WorldComponent;

import java.io.File;

/**
 * Created by Exerosis.
 */
public class CoreComponentBundle {
    private final SpectateComponent spectateComponent;
    private final SchedulerComponent schedulerComponent;
    private final ConsolePrinter consolePrinter;
    private final ChatPrinter chatPrinter;
    private final DeathComponent deathComponent;
    private final CommandComponent commandComponent;
    private final WorldComponent worldComponent;

    public CoreComponentBundle(File worldFile, String worldKickMessage) {
        spectateComponent = new SpectateComponent();
        schedulerComponent = new SchedulerComponent();
        consolePrinter = new ConsolePrinter();
        chatPrinter = new ChatPrinter();
        deathComponent = new DeathComponent();


        commandComponent = new CommandComponent(player -> true);
        worldComponent = new WorldComponent(consolePrinter, schedulerComponent, worldFile, worldKickMessage);
    }

    public SpectateComponent getSpectateComponent() {
        return spectateComponent;
    }

    public SchedulerComponent getSchedulerComponent() {
        return schedulerComponent;
    }

    public ConsolePrinter getConsolePrinter() {
        return consolePrinter;
    }

    public ChatPrinter getChatPrinter() {
        return chatPrinter;
    }

    public DeathComponent getDeathComponent() {
        return deathComponent;
    }

    public CommandComponent getCommandComponent() {
        return commandComponent;
    }

    public WorldComponent getWorldComponent() {
        return worldComponent;
    }
}
