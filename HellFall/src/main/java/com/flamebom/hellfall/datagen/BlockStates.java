package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

	public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, HellFall.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

	}
}