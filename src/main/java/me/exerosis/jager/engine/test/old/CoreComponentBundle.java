package me.exerosis.jager.engine.test.old;

import me.exerosis.jager.engine.implementation.states.player.command.CommandState;
import me.exerosis.jager.engine.implementation.states.player.death.DeathState;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;
import me.exerosis.jager.engine.core.utilites.printer.printers.ChatPrinter;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.states.scheduler.SchedulerState;
import me.exerosis.jager.engine.implementation.states.worlds.WorldLoadedState;

import java.io.File;

/**
 * Created by Exerosis.
 */
public class CoreComponentBundle {
    private final SpectateState spectateState;
    private final SchedulerState schedulerState;
    private final ConsolePrinter consolePrinter;
    private final ChatPrinter chatPrinter;
    private final DeathState deathComponent;
    private final CommandState commandComponent;
    private final WorldLoadedState worldLoadedState;

    public CoreComponentBundle(File worldFile, String worldKickMessage) {
        spectateState = new SpectateState();
        schedulerState = new SchedulerState();
        consolePrinter = new ConsolePrinter();
        chatPrinter = new ChatPrinter();
        deathComponent = new DeathState();


        commandComponent = new CommandState(player -> true);
        worldLoadedState = new WorldLoadedState(consolePrinter, schedulerState, worldFile, worldKickMessage);
    }

    public SpectateState getSpectateState() {
        return spectateState;
    }

    public SchedulerState getSchedulerState() {
        return schedulerState;
    }

    public ConsolePrinter getConsolePrinter() {
        return consolePrinter;
    }

    public ChatPrinter getChatPrinter() {
        return chatPrinter;
    }

    public DeathState getDeathComponent() {
        return deathComponent;
    }

    public CommandState getCommandComponent() {
        return commandComponent;
    }

    public WorldLoadedState getWorldLoadedState() {
        return worldLoadedState;
    }
}
