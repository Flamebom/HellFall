 package com.flamebom.hellfall.network;

import java.util.function.Supplier;

import com.flamebom.hellfall.items.Kuratsu;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

/*
 From botania github code 
 */

public class PacketLeftClick {
	public static void encode(PacketLeftClick msg, FriendlyByteBuf buf) {}

	public static PacketLeftClick decode(FriendlyByteBuf buf) {
		return new PacketLeftClick();
	}

	public static void handle(PacketLeftClick msg, Supplier<NetworkEvent.Context> ctx) {
	/*
		if (ctx.get().getDirection().getReceptionSide().isServer()) {
			ctx.get().enqueueWork(() -> ((Kuratsu) Registration.KURATSU.get()).trySpawnSword(ctx.get().getSender()));
		}
		ctx.get().setPacketHandled(true);*/
	}
}