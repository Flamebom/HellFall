package com.flamebom.hellfall;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flamebom.hellfall.setup.Registration;

@Mod("hellfall")
public class HellFall {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "hellfall";

	public HellFall() {
	  //  ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

       Registration.init();


        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
     //   modbus.addListener(ModSetup::init);
     //   modbus.addListener(ModSetup::onAttributeCreate);
    //  modbus.addListener(ClientSetup::init);
	}
}
