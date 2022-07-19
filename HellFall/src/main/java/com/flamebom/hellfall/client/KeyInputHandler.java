package com.flamebom.hellfall.client;

import com.flamebom.hellfall.network.PacketDeflect;
import com.flamebom.hellfall.setup.Messages;

import net.minecraft.world.InteractionHand;
import net.minecraftforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;
public class KeyInputHandler {
	  public static void onKeyInput(InputEvent.MouseInputEvent event) {
	       if(event.getButton() == GLFW.GLFW_MOUSE_BUTTON_RIGHT && event.getAction() ==GLFW.GLFW_PRESS) {
	            Messages.sendToServer(new PacketDeflect());
	        }
	    }
}
