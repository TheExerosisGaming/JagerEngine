package me.exerosis.jager.gameengine.example;

/**
 * Created by Exerosis.
 */
public class HubState extends State {
    private final Gadget[] gadgets = new Gadgets[]{};

    public HubState (Gadget... gadgets) {
        this.gadgets = gadgets;
    }

    @Override
    public void onEnable(){
        for(Gadget gadget: gadgets){
            gadget.enable();
        }
    }

    @Override
    public void onDisable(){
        for(Gadget gadget: gadgets){
            gadget.disable();
        }
    }

}
