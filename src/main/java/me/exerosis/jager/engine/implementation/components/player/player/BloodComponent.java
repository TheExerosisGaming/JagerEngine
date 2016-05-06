package me.exerosis.jager.engine.implementation.components.player.player;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.exerosis.jager.engine.core.component.Component;

public class BloodComponent extends Component {

	private Player player = null;
	private Item[] bloodItems = null;
	private Plugin plugin;
	
	public BloodComponent(Plugin plugin, Player player, boolean enabledByDefault) {
		this.setPlayer(player);
		this.plugin = plugin;
		if (enabledByDefault)
			enable();
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@SuppressWarnings("deprecation")
	public void onEnable() {
		bloodItems = new Item[4];
		for (int i = 0; i < 4; i++) {
			Item itemEntity = player.getWorld().dropItem(player.getLocation(), new ItemStack(Material.getMaterial(351)));
			ItemStack item = new ItemStack(Material.getMaterial(351));
			item.setDurability((short) 1);
			itemEntity.setItemStack(item);
			itemEntity.setPickupDelay(1000);
			Random r = new Random();
			itemEntity.setVelocity(new Vector().setX(r.nextInt(4) - 2).setZ(r.nextInt(4) - 2).setY(0));
			itemEntity.setCustomName("§cBlood");
			itemEntity.setCustomNameVisible(true);
			bloodItems[i] = itemEntity;
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				for (int i = 0; i < 4; i++) {
					bloodItems[i].remove();
				}
			}
		}, 15l);
	}

	public void onDisable() {
		if (bloodItems == null)
			return;
		for (Item i : bloodItems) {
			i.remove();
		}
	}

}
