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
    public static final ResourceLocation STAFF_HAS_DATA = new ResourceLocation(HellFall.MODID, "staff_on");
	public static void init(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(Registration.KURATSU.get(), new ResourceLocation(HellFall.MODID, "blocking"),
					(stack, level, living, id) -> {

						return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
					});
			ItemProperties.register(Registration.WAS_SPECTRE.get(), STAFF_HAS_DATA,
					(stack, level, living, id) -> {
						if (living != null && living.getUseItem() == stack) {
							if(living.getUseItem().getOrCreateTag().getBoolean("on"))
							return 1.0F;
						}
						return 0.0F;
					});
		});
		MinecraftForge.EVENT_BUS.addListener(KeyInputHandler::onKeyInput);
		KeyBindings.init();
	}
}