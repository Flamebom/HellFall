package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = HellFall.MODID  ,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
		      generator.addProvider(new Recipes(generator));
		}
		if (event.includeClient()) {
          generator.addProvider(new BlockStates(generator, event.getExistingFileHelper()));
	       generator.addProvider(new Items(generator, event.getExistingFileHelper()));
	   	generator.addProvider(new Language(generator, "en_us"));
		}	
	}
}
