package com.flamebom.hellfall.network;

import java.util.function.Supplier;

import com.flamebom.hellfall.helpers.Timer;
import com.flamebom.hellfall.items.Kuratsu;
import com.flamebom.hellfall.items.Was_Spectre;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

public class PacketInteraction {

	public PacketInteraction() {
	}

	public PacketInteraction(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {
	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context ctx = supplier.get();
		ctx.enqueueWork(() -> {
			ServerPlayer player = ctx.getSender();
			ItemStack stack = player.getMainHandItem();

			if (stack.getItem() instanceof Was_Spectre) {
				stack.getOrCreateTag().putBoolean("on", true);
	Timer tenseconds = new Timer(10,stack);
			}
		});
		return true;
	}
}
