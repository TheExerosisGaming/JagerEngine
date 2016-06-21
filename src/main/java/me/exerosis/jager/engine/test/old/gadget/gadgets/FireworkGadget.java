package me.exerosis.jager.engine.test.old.gadget;

import java.util.Random;
import java.util.function.Predicate;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkGadget extends Gadget {
	public FireworkGadget(Predicate<Player> playerPredicate) {
		super(playerPredicate);
	}
	
	@EventHandler
	public void onInteractEvent(PlayerInteractEvent event) {
		if (!getPlayerPredicate().test(event.getPlayer()))
			return;
		if (!event.getPlayer().getItemInHand().equals(new ItemStack(Material.FIREWORK, 1)))
			return;
		Random random = new Random();
		Firework firework = (Firework) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.FIREWORK);
		FireworkMeta meta = firework.getFireworkMeta();
		Builder fireworkBuilder = FireworkEffect.builder();
		fireworkBuilder.flicker(random.nextBoolean());
		fireworkBuilder.withColor(Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)), Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		fireworkBuilder.withFade(Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		Type[] allTypes = { Type.BALL, Type.BALL_LARGE, Type.BURST, Type.CREEPER, Type.STAR };
		fireworkBuilder.with(allTypes[random.nextInt(allTypes.length)]);
		if (random.nextBoolean())
			fireworkBuilder.withFlicker();

		meta.addEffect(fireworkBuilder.build());
		firework.setFireworkMeta(meta);
	}
}
