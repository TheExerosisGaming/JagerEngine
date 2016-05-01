package me.exerosis.jager.gameengine.implementation.components.player.gadget;

import java.util.function.Predicate;

import org.bukkit.entity.Player;

import me.exerosis.jager.gameengine.implementation.components.player.PlayerComponent;

public class Gadget extends PlayerComponent {

  public Gadget(Predicate<Player> playerPredicate) {
      super(playerPredicate);
  }
}
