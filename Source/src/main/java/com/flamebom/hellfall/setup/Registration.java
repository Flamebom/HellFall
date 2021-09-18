package com.flamebom.hellfall.setup;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import static com.flamebom.hellfall.HellFall.MODID;

import com.flamebom.hellfall.items.Kuratsu;

public class Registration {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
	}
	public static final RegistryObject<Kuratsu> KURATSU = ITEMS.register("KURATSU", Kuratsu::new);
	
}
