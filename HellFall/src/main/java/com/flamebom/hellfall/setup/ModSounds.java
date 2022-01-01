package com.flamebom.hellfall.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.flamebom.hellfall.helpers.ResourceLocationHelper.prefix;

public class ModSounds {
	public static final SoundEvent bowshot = makeSoundEvent("bow_shot");

	private static SoundEvent makeSoundEvent(String name) {
		ResourceLocation loc = prefix(name);
		return new SoundEvent(loc).setRegistryName(loc);
	}

	public static void registerSounds(RegistryEvent.Register<SoundEvent> evt) {
		IForgeRegistry<SoundEvent> r = evt.getRegistry();
		r.register(bowshot);
	}
}
