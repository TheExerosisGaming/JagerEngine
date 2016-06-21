package me.exerosis.jager.engine.core;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

/**
 * Created by addison118 on 6/20/16.
 */

public interface ScorePanel {

    void createScoreboard(String name);
    String getName();
    void setName(String name);
    void configure(Team team);
    Objective getMainObjective();
    void setObjective(String name, String criteria);

}
