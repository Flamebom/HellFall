package com.flamebom.hellfall.datagen;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.client.KeyBindings;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
	public Language(DataGenerator gen, String locale) {
		super(gen, HellFall.MODID, locale);

	}

	@Override
	protected void addTranslations() {
		add("message.kuratsu.xp", "XP:%s/100");
		add("itemGroup.hellfall", "HellFall");
		add("message.kuratsu.level", "Level:%s");
		add("message.wip", "Work in Progress, Not yet implamented");
		addItem(Registration.KURATSU, "Kuratsu");
		addItem(Registration.GODFALL, "Godfall");
		addItem(Registration.WAS_SPECTRE, "Was Spectre");
		addItem(Registration.EMPTY_CORE, "Empty Core");
		addItem(Registration.GODSEND_CORE, "Godsend Core");
		addItem(Registration.CALAMITY_CORE, "Calamity Core");
		add(KeyBindings.KEY_CATEGORIES_HELLFALL, "HellFall");
		add(KeyBindings.KEY_WEAPON_INTERACTION, "Weapon Interaction");

	}
}
