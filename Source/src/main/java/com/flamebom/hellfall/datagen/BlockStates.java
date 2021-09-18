package com.flamebom.hellfall.datagen;

import java.util.Random;

import com.flamebom.hellfall.HellFall;

import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

	 public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
		// super(gen, HellFall.MODID, exFileHelper);
	    }

		@Override
		protected BlockStateProviderType<?> type() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public BlockState getState(Random p_68750_, BlockPos p_68751_) {
			// TODO Auto-generated method stub
			return null;
		}

}
