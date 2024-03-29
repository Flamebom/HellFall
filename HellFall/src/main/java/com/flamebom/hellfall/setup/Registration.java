package com.flamebom.hellfall.setup;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import static com.flamebom.hellfall.HellFall.MODID;

import com.flamebom.hellfall.items.CalamityCore;
import com.flamebom.hellfall.items.EmptyCore;
import com.flamebom.hellfall.items.GodFall;
import com.flamebom.hellfall.items.GodsendCore;
import com.flamebom.hellfall.items.Kuratsu;
import com.flamebom.hellfall.items.Was_Spectre;

public class Registration {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
	}
	public static final RegistryObject<Kuratsu> KURATSU = ITEMS.register("kuratsu", Kuratsu::new);
	public static final RegistryObject<Was_Spectre> WAS_SPECTRE = ITEMS.register("was_spectre", Was_Spectre::new);
	public static final RegistryObject<GodFall> GODFALL = ITEMS.register("godfall", GodFall::new);
	public static final RegistryObject<EmptyCore> EMPTY_CORE = ITEMS.register("empty_core", EmptyCore::new);
	public static final RegistryObject<CalamityCore> CALAMITY_CORE = ITEMS.register("calamity_core", CalamityCore::new);
	public static final RegistryObject<GodsendCore> GODSEND_CORE = ITEMS.register("godsend_core", GodsendCore::new);
	
}
