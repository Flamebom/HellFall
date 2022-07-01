package com.flamebom.hellfall.setup;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;



import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.data.SkillsEvents;

@Mod.EventBusSubscriber(modid = HellFall.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
	public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(HellFall.MODID) {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Registration.KURATSU.get());
		}
	};
	public static void init(FMLCommonSetupEvent event) {
		Messages.register();
	}

	public static void  setup() {
		IEventBus bus = MinecraftForge.EVENT_BUS;
		bus.addGenericListener(Entity.class,SkillsEvents::onAttachCapabilitiesPlayer);
		bus.addListener(SkillsEvents::onPlayerCloned);
		bus.addListener(SkillsEvents::onRegisterCapabilities);
	}
}
