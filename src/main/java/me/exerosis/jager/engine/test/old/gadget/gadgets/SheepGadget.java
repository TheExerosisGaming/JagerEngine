package me.exerosis.jager.engine.test.old.gadget;

import java.util.function.Predicate;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.exerosis.jager.engine.Main;

public class SheepGadget extends Gadget {

	private Main plugin;
	
	public SheepGadget(Predicate<Player> playerPredicate, Main pl) {
		super(playerPredicate);
		plugin = pl;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (!getPlayerPredicate().test(e.getPlayer()))
			return;
		Player p = e.getPlayer();
		ItemStack item = new ItemStack(Material.getMaterial(383));
		item.setDurability((short) 91);
		// This is done because apprently comparing ItemStacks doesn't work.
		if (p.getItemInHand().getType() != item.getType() && p.getItemInHand().getDurability() != item.getDurability())
			return;
		Sheep sheep = (Sheep) p.getWorld().spawnEntity(p.getLocation(), EntityType.SHEEP);
		Location l = p.getLocation();
		sheep.teleport(l);
		sheep.setVelocity(p.getLocation().getDirection());
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
			public void run() {
				sheep.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1, true));
				sheep.setHealth(0);
			}
		}, 20l);
	}

}
