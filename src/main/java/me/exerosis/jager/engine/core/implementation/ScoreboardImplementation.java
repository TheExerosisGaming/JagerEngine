package me.exerosis.jager.engine.core.implementation;

import me.exerosis.jager.engine.core.ScorePanel;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

/**
 * Created by addison118 on 6/20/16.
 */
public class ScoreboardImplementation implements ScorePanel {

    private String name = "";
    private Scoreboard scoreboard;
    private Objective mainObjective;

    public ScoreboardImplementation(String name, Objective mainObjective) {
        this.name = name;
        this.mainObjective = mainObjective;
    }

    @Override
    public void createScoreboard(String name) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        mainObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.setName(this.name);
    }

    @Override
    public void setName(String name) {
        mainObjective.setDisplayName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Objective getMainObjective() {
        return this.mainObjective;
    }

    @Override
    public void configure(Team team) {
        String teamName = team.getName();
        Scoreboard tscore = team.getScoreboard();
        tscore.registerNewTeam(teamName);
    }

    @Override
    public void setObjective(String name, String criteria) {
        scoreboard.registerNewObjective(name, criteria);
    }
}
