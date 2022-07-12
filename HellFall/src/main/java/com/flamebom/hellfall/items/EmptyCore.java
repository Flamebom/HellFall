package com.flamebom.hellfall.items;

import com.flamebom.hellfall.setup.ModSetup;

import net.minecraft.world.item.Item;

public class EmptyCore extends Item {
	public EmptyCore() {
		super(new Item.Properties().tab(ModSetup.ITEM_GROUP));
	}
}
