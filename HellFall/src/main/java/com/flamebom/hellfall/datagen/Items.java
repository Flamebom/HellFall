package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.setup.ClientSetup;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, HellFall.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		singleTexture(Registration.KURATSU.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(HellFall.MODID, "item/kuratsu"));

	      ItemModelBuilder modelNormal = singleTexture("was_spectre", mcLoc("item/handheld"), "layer0", modLoc("item/was_spectre"));
	      ModelFile modelCharged = singleTexture("was_spectre_on", mcLoc("item/handheld"), "layer0", modLoc("item/was_spectre_on"));
	      modelNormal.override()
          .predicate(ClientSetup.STAFF_HAS_DATA, 0)
          .model(modelNormal)
          .end()
      .override()
          .predicate(ClientSetup.STAFF_HAS_DATA, 1)
          .model(modelCharged)
          .end();
		singleTexture(Registration.GODFALL.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(HellFall.MODID, "item/godfall"));
		singleTexture(Registration.CALAMITY_CORE.get().getRegistryName().getPath(),
				new ResourceLocation("item/generated"), "layer0",
				new ResourceLocation(HellFall.MODID, "item/calamity_core"));
		singleTexture(Registration.GODSEND_CORE.get().getRegistryName().getPath(),
				new ResourceLocation("item/generated"), "layer0",
				new ResourceLocation(HellFall.MODID, "item/godsend_core"));
		singleTexture(Registration.EMPTY_CORE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"),
				"layer0", new ResourceLocation(HellFall.MODID, "item/empty_core"));
	}
}