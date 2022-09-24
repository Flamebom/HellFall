package com.flamebom.hellfall.client;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {
	public static final String KEY_CATEGORIES_HELLFALL = "key.categories.hellfall";
	public static final String KEY_WEAPON_INTERACTION = "key.Deflect";
	public static KeyMapping WeaponInteraction;

	public static void init() {
		WeaponInteraction = new KeyMapping(KEY_WEAPON_INTERACTION, KeyConflictContext.IN_GAME, InputConstants.getKey(InputConstants.MOUSE_BUTTON_MIDDLE, InputConstants.MOUSE_BUTTON_MIDDLE),
				KEY_CATEGORIES_HELLFALL);
		ClientRegistry.registerKeyBinding(WeaponInteraction);
	}
}
