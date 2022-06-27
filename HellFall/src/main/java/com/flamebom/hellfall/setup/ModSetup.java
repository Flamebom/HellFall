package com.flamebom.hellfall.setup;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import com.flamebom.hellfall.HellFall;

@Mod.EventBusSubscriber(modid = HellFall.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
	public static void init(FMLCommonSetupEvent event) {
		Messages.register();
	}
}
