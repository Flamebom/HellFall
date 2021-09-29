package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, HellFall.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
	}
}