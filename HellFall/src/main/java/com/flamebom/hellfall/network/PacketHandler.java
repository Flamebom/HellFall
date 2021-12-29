package com.flamebom.hellfall.network;

import com.flamebom.hellfall.HellFall;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

/*
Code from Botania
 */
public final class PacketHandler {
	private static final String PROTOCOL = "10";

	public static final SimpleChannel HANDLER = NetworkRegistry.newSimpleChannel(
			prefix("channel"),
			() -> PROTOCOL,
			PROTOCOL::equals,
			PROTOCOL::equals
	);

	public static void init() {
		int id = 0;
		HANDLER.registerMessage(id++, PacketLeftClick.class, PacketLeftClick::encode, PacketLeftClick::decode, PacketLeftClick::handle);

	}



	public static void sendToServer(Object msg) {
		HANDLER.sendToServer(msg);
	}
	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(HellFall.MODID, path);
	}
	private PacketHandler() {}

}