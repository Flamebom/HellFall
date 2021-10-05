package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, HellFall.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
                singleTexture(
                        Registration.KURATSU.get().getRegistryName().getPath(),
                        new ResourceLocation("item/handheld"),
                        "layer0",
                       new ResourceLocation(HellFall.MODID, "item/kuratsu"));
                singleTexture(
                        Registration.GODFALL.get().getRegistryName().getPath(),
                        new ResourceLocation("item/handheld"),
                        "layer0",
                       new ResourceLocation(HellFall.MODID, "item/godfall"));
                singleTexture(
                        Registration.CALAMITY_CORE.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated"),
                        "layer0",
                       new ResourceLocation(HellFall.MODID, "item/calamity_core"));
                singleTexture(
                        Registration.GODSEND_CORE.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated"),
                        "layer0",
                       new ResourceLocation(HellFall.MODID, "item/godsend_core"));
                singleTexture(
                        Registration.EMPTY_CORE.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated"),
                        "layer0",
                       new ResourceLocation(HellFall.MODID, "item/empty_core"));
	}
}