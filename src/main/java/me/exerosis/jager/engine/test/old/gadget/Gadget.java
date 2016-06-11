package me.exerosis.jager.engine.test.old.gadget;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

public class Gadget extends PlayerState {

  public Gadget(Predicate<Player> playerPredicate) {
      super(playerPredicate);
  }
}
