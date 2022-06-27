package com.flamebom.hellfall.network;

import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketDeflect {

	public PacketDeflect() {
	}

	public PacketDeflect(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context ctx = supplier.get();
		ctx.enqueueWork(() -> {
			ServerPlayer player = ctx.getSender();
		});
		return true;
	}
}
