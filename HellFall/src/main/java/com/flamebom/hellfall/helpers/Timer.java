package com.flamebom.hellfall.helpers;

import com.flamebom.hellfall.HellFall;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HellFall.MODID)
public class Timer {
	static private float seconds;
static private ItemStack stack;
	public Timer(float seconds,ItemStack stack) {
		this.seconds = seconds;
		this.stack = stack;
	}

	public float getTime() {
		return seconds;
	}

	@SubscribeEvent
	public static void tickEvent(ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			return;
		}
		seconds = seconds - 0.05F;
		if (seconds<0 ){
			stack.getOrCreateTag().putBoolean("on", false);
			return;
		}
	}
}
