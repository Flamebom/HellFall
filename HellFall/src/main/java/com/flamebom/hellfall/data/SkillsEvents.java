package com.flamebom.hellfall.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.data.PlayerSkillsProvider;

public class SkillsEvents {
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			if (!event.getObject().getCapability(PlayerSkillsProvider.PLAYER_SKILLS).isPresent()) {
				event.addCapability(new ResourceLocation(HellFall.MODID, "playerskills"), new PlayerSkillsProvider());
			}
		}
	}

	public static void onPlayerCloned(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			// We need to copyFrom the capabilities
			event.getOriginal().getCapability(PlayerSkillsProvider.PLAYER_SKILLS).ifPresent(oldStore -> {
				event.getPlayer().getCapability(PlayerSkillsProvider.PLAYER_SKILLS).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
		}
	}

	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		event.register(PlayerSkills.class);
	}


}
