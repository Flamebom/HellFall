package com.flamebom.hellfall.client;

import com.flamebom.hellfall.setup.Messages;

import net.minecraftforge.client.event.InputEvent;

public class KeyInputHandler {
	  public static void onKeyInput(InputEvent.KeyInputEvent event) {
	        if (KeyBindings.Deflect.consumeClick()) {
	            Messages.sendToServer(new PacketDeflect());
	        }
	    }
}
