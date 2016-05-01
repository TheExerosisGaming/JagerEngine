package me.exerosis.jager.gameengine.example;

/**
 * Created by Exerosis.
 */
public class Main {
    public static main(String[] args){
        //Just an example, doesn't have to be a permission, could just be playerList.contains or something.
        FireworkGadget fireworkGadget = new FireWorkGadget(player -> player.hasPermission("gadget.fireworks"));

        new HubState(fireworkGadget).enable();
    }
}
