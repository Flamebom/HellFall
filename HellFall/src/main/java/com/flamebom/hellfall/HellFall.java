package com.flamebom.hellfall;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flamebom.hellfall.setup.ClientSetup;
import com.flamebom.hellfall.setup.Config;
import com.flamebom.hellfall.setup.ModSetup;
import com.flamebom.hellfall.setup.Registration;

@Mod("hellfall")
public class HellFall {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "hellfall";

	public HellFall() {
		ModSetup.setup();
        Registration.init();
        Config.register();     
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ()-> modbus.addListener(ClientSetup::init));
	}
}
