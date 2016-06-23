package me.exerosis.jager.engine.implementation.arenas.temp;

import me.exerosis.jager.engine.core.Game;
import me.exerosis.jager.engine.core.implementation.StateImplementation;
import me.exerosis.jager.engine.core.utilites.ListUtilities;
import me.exerosis.jager.engine.core.utilites.printer.printers.ConsolePrinter;
import me.exerosis.jager.engine.implementation.arenas.temp.games.spleef.SpleefGame;
import me.exerosis.jager.engine.implementation.states.player.death.DeathState;
import me.exerosis.jager.engine.implementation.states.player.spectate.SpectateState;
import me.exerosis.jager.engine.implementation.states.scheduler.SchedulerState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Exerosis.
 */
public class ExampleArena extends StateImplementation {
    //Misc.
    private final ConsolePrinter console;

    //States
    private final DeathState deathState;
    private final SpectateState spectateState;
    private final SchedulerState schedulerState;

    //Games
    private final List<Game> games = new ArrayList<>();
    private Game currentGame;


    public ExampleArena() throws IOException {
        //No params.
        deathState = new DeathState();
        spectateState = new SpectateState();
        console = new ConsolePrinter();
        schedulerState = new SchedulerState();

        //Multiple Params.


        //Games.
        games.add(new SpleefGame(spectateState, console, schedulerState, "IDK what the URL is yet!"));
    }


    @Override
    protected void onEnable() {
        spectateState.enable();
        deathState.enable();
        schedulerState.enable();

        currentGame = games.get(0);

        schedulerState.registerTask(() -> {
            if (currentGame.getTicksRemaining() == 1) {
                currentGame.tick();

                Game newGame = currentGame;
                while (currentGame == newGame) {
                    newGame = ListUtilities.getRandom(games);
                }
                currentGame = newGame;
                currentGame.enable();
            }
            currentGame.tick();
        }, 1D);
    }

    @Override
    protected void onDisable() {
        spectateState.disable();
        deathState.disable();
        schedulerState.disable();
    }


    public ConsolePrinter getConsole() {
        return console;
    }

    public SpectateState getSpectateState() {
        return spectateState;
    }

    public DeathState getDeathState() {
        return deathState;
    }

    public SchedulerState getSchedulerState() {
        return schedulerState;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public List<Game> getGames() {
        return games;
    }
}