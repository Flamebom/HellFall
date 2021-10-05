package com.flamebom.hellfall.items;

import com.flamebom.hellfall.HellFall;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GodsendCore extends Item {
	public GodsendCore() {
		super(new Item.Properties().tab(HellFall.ITEM_GROUP));
	}
	@Override
	public MutableComponent getName(ItemStack stack) {
		return new TranslatableComponent(this.getDescriptionId(stack)).withStyle(ChatFormatting.YELLOW);
	}
}
