package com.flamebom.hellfall.helpers;

import com.flamebom.hellfall.HellFall;

import net.minecraft.resources.ResourceLocation;

public class ResourceLocationHelper {
	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(HellFall.MODID, path);
	}
}