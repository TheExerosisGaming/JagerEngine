package me.exerosis.jager.gameengine.implementation.components.player.gadget.example;

import me.exerosis.jager.gameengine.core.state.State;
import me.exerosis.jager.gameengine.implementation.components.player.gadget.Gadget;

public class HubState extends State {
	private Gadget[] gadgets = new Gadget[] {};

	public HubState(Gadget... gadgets) {
		this.gadgets = gadgets;
	}

	@Override
	public void onEnable() {
		for (Gadget gadget : gadgets) {
			gadget.enable();
		}
	}

	@Override
	public void onDisable() {
		for (Gadget gadget : gadgets) {
			gadget.disable();
		}
	}

}
