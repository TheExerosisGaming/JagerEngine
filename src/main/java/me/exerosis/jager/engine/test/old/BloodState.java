package me.exerosis.jager.engine.test.old;

import me.exerosis.jager.engine.implementation.states.player.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.*;
import java.util.function.Predicate;

public class BloodState extends PlayerState {

	private Map<Player, Predicate<Player>> predicates = new HashMap<Player, Predicate<Player>>();
	private List<Player> players = new ArrayList<Player>();
	// We're using LinkedHashMap here because LinkedHashMaps are generally better at the get methods, which is more of what we're doing here.
	private Map<Player, List<Item>> bloodItems = new LinkedHashMap<Player, List<Item>>();
	private Plugin plugin;

	public BloodState(Plugin plugin) {
		this.plugin = plugin;
	}

	public void addPlayer(Player p) {
		players.add(p);
		predicates.put(p, getPlayerPredicate());
	}

	public void setEnabledPlayer(Player p) {
		predicates.put(p, getPlayerPredicate());
		
	}

	public void removePlayer(Player p) {
		players.remove(p);
		predicates.remove(p);
	}

	public void removePlayer(int index) {
		predicates.remove(players.get(index));
		players.remove(index);
	}

	public Map<Player, Predicate<Player>> getPredicates() {
		return predicates;
	}

	public List<Player> getPlayers() {
		return players;
	}

	@SuppressWarnings("deprecation")
	public void onEnable() {
		for (Player player : getPlayers()) {
			List<Item> items = new LinkedList<Item>();
			for (int i = 0; i < 4; i++) {
				Item itemEntity = player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.getMaterial(351)));
				ItemStack item = new ItemStack(Material.getMaterial(351));
				item.setDurability((short) 1);
				itemEntity.setItemStack(item);
				itemEntity.setPickupDelay(1000);
				Vector v = new Vector();
				v.setX(BloodState.nextFloat(0.4f));
				v.setZ(BloodState.nextFloat(0.4f));
				v.setY(BloodState.nextFloat(0.5f));
				itemEntity.setVelocity(v);
				itemEntity.setCustomName("§cBlood");
				itemEntity.setCustomNameVisible(true);
				items.set(i, itemEntity);
			}
			bloodItems.put(player, items);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				for (Player player : getPlayers()) {
					for (int i = 0; i < 4; i++) {
						if (bloodItems.get(player) == null) {
							// error
							Bukkit.getLogger().info("Player is equal to null!");
							break;
						}
						bloodItems.get(player).get(i).remove();
					}
				}
			}
		}, 15l);
	}

	public static float nextFloat(float maxValue) {
		while (true) {
			// creating a new random object each time to create a special seed, to induce more random outcomes.
			float f = new Random().nextFloat();
			if (f > maxValue)
				continue;
			else
				return f;
		}
	}
	
	public void onDisable() {
		for (Player player : getPlayers()) {
			for (int i = 0; i < 4; i++) {
				bloodItems.get(player).get(i).remove();
			}
		}
	}

}
