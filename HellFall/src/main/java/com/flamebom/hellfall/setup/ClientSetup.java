package com.flamebom.hellfall.setup;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.client.KeyBindings;
import com.flamebom.hellfall.client.KeyInputHandler;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HellFall.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	public static void init(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.addListener(KeyInputHandler::onKeyInput);
		KeyBindings.init();
		event.enqueueWork(() -> {
			ItemProperties.register(Registration.KURATSU.get(), new ResourceLocation(HellFall.MODID, "blocking"),
					(stack, level, living, id) -> {
						float foo = living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F
								: 0.0F;
				
							System.out.println(foo);

						return foo;
					});
		});
	}

}
