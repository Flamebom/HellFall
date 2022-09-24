package com.flamebom.hellfall.client;

import com.flamebom.hellfall.network.PacketInteraction;
import com.flamebom.hellfall.setup.Messages;

import net.minecraft.world.InteractionHand;
import net.minecraftforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;
public class KeyInputHandler {
	  public static void onKeyInput(InputEvent.MouseInputEvent event) {
	       if(KeyBindings.WeaponInteraction.consumeClick()) {
	            Messages.sendToServer(new PacketInteraction());
	        }
	    }
}
