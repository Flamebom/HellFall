package com.flamebom.hellfall.setup;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;



import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.data.SkillsEvents;

@Mod.EventBusSubscriber(modid = HellFall.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
	public static void init(FMLCommonSetupEvent event) {
		Messages.register();
	}

	public void setup() {
		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.addGenericListener(Entity.class,SkillsEvents::onAttachCapabilitiesPlayer);
		bus.addListener(SkillsEvents::onPlayerCloned);
		bus.addListener(SkillsEvents::onRegisterCapabilities);
	}
}
