package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
	public Language(DataGenerator gen) {
		super(gen, HellFall.MODID, "en_us");

	}

	@Override
	protected void addTranslations() {
		add("message.kuratsu.xp","XP:%s/100");
		add("message.kuratsu.level","Level:%s");
		addItem(Registration.KURATSU, "Kuratsu");
		addItem(Registration.GODFALL, "Godfall");
		addItem(Registration.EMPTY_CORE, "Empty Core");
		addItem(Registration.GODSEND_CORE, "Godsend Core");
		addItem(Registration.CALAMITY_CORE, "Calamity Core");
		
	}}
