package com.flamebom.hellfall.setup;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.client.KeyBindings;
import com.flamebom.hellfall.client.KeyInputHandler;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HellFall.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	public static void init(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.addListener(KeyInputHandler::onKeyInput);
		   KeyBindings.init();
	}
	
}
