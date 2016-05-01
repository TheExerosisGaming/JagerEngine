package me.exerosis.jager.gameengine.implementation.components.player.gadget.gadgets;

/**
 * Created by Exerosis.
 */
public class FireworksGadget {
    public FireworksGadget (Predicate<Player> playerPredicate){
        super(playerPredicate);
    }

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event){
        if(!getPlayerPredicate().test(event.getPlayer())
        return;
        if(!event.getPlayer().getItemInHand().equals(new ItemStack(Material.FIREWORKS, 1))
        return;
        Random random = new Random();
        Firework firework = (Firework) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();
        Builder fireworkBuilder = FireworkEffect.builder();
        fireworkBuilder.flicker(random.nextBoolean());
        fireworkBuilder.withColor(Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)), Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        fireworkBuilder.withFade(Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        Type[] allTypes = {Type.BALL, Type.BALL_LARGE, Type.BURST, Type.CREEPER, Type.STAR};
        fireworkBuilder.with(allTypes[random.nextInt(allTypes.length)]);
        if (random.nextBoolean())
            fireworkBuilder.withFlicker();

        meta.addEffect(fireworkBuilder.build());
        firework.setFireworkMeta(meta);
    }
}
