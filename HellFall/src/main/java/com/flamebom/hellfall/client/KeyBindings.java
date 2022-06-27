package com.flamebom.hellfall.client;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
	public static final String KEY_CATEGORIES_HELLFALL = "key.categories.hellfall";
	public static final String KEY_DEFLECT = "key.Deflect";
	public static KeyMapping Deflect;

	public static void init() {
		Deflect = new KeyMapping(KEY_DEFLECT, KeyConflictContext.IN_GAME, InputConstants.getKey("key.keyboard.period"),
				KEY_CATEGORIES_HELLFALL);
		ClientRegistry.registerKeyBinding(Deflect);
	}
}
