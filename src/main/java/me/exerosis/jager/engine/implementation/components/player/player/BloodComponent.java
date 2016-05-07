package me.exerosis.jager.engine.implementation.components.player.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.exerosis.jager.engine.implementation.components.player.PlayerComponent;

public class BloodComponent extends PlayerComponent {

	private Map<Player, Predicate<Player>> predicates = new HashMap<Player, Predicate<Player>>();
	private List<Player> players = new ArrayList<Player>();
	private Map<Player, Item[]> bloodItems = new LinkedHashMap<Player, Item[]>();
	private Plugin plugin;
	private boolean enabledByDefault;

	public BloodComponent(Plugin plugin, boolean enabledByDefault) {
		this.plugin = plugin;
		if (enabledByDefault)
			enable();
		this.enabledByDefault = enabledByDefault;
	}

	public void addPlayer(Player p) {
		players.add(p);
		predicates.put(p, player -> enabledByDefault);
	}

	public void addPlayer(Player p, boolean enabled) {
		players.add(p);
		predicates.put(p, player -> enabled);
	}

	public void setEnabledPlayer(Player p, boolean enabled) {
		predicates.put(p, player -> enabled);
		
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
			Item[] items = new Item[4];
			for (int i = 0; i < 4; i++) {
				Item itemEntity = player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.getMaterial(351)));
				ItemStack item = new ItemStack(Material.getMaterial(351));
				item.setDurability((short) 1);
				itemEntity.setItemStack(item);
				itemEntity.setPickupDelay(1000);
				Vector v = new Vector();
				v.setX(nextFloat(new Random(), 0.4f));
				v.setZ(nextFloat(new Random(), 0.4f));
				v.setY(nextFloat(new Random(), 0.5f));
				itemEntity.setVelocity(v);
				itemEntity.setCustomName("§cBlood");
				itemEntity.setCustomNameVisible(true);
				items[i] = itemEntity;
			}
			bloodItems.put(player, items);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				for (Player player : getPlayers()) {
					for (int i = 0; i < 4; i++) {
						if (bloodItems.get(player) == null) {
							Bukkit.getLogger().info("Player is equal to null!");
							break;
						}
						bloodItems.get(player)[i].remove();
					}
				}
			}
		}, 15l);
	}

	public float nextFloat(Random r, float maxValue) {
		while (true) {
			float f = r.nextFloat();
			if (f > maxValue)
				continue;
			else
				return f;
		}
	}
	
	public void onDisable() {
		for (Player player : getPlayers()) {
			for (int i = 0; i < 4; i++) {
				bloodItems.get(player)[i].remove();
			}
		}
	}

}
