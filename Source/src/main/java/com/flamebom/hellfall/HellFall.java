package com.flamebom.hellfall;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("hellfall")
public class HellFall {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "hellfall";

	public HellFall() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
	}
}
