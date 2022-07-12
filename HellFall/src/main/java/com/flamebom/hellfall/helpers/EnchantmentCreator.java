package com.flamebom.hellfall.helpers;

import java.util.Random;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;

public class EnchantmentCreator {
static public EnchantmentInstance addEnchant(int itemlevel) {
		Random random = new Random();
		int randomEnchant = random.nextInt(1, 21);
		
		int level = 0;
		if (itemlevel <= 10) {
			level = random.nextInt(1, 3);
		} else {
			level = itemlevel / random.nextInt(5, itemlevel + 1);
		}
		EnchantmentInstance enchant = new EnchantmentInstance(getEnchant(randomEnchant), level);
		return enchant;

	}

	static private Enchantment getEnchant(int randomEnchant) {
//enchant pool
		switch (randomEnchant) {
		case 1:
			return Enchantments.BANE_OF_ARTHROPODS;
		case 2:
			return Enchantments.BANE_OF_ARTHROPODS;
		case 3:
			return Enchantments.BANE_OF_ARTHROPODS;
		case 4:
			return Enchantments.SMITE;
		case 5:
			return Enchantments.SMITE;
		case 6:
			return Enchantments.SMITE;
		case 7:
			return Enchantments.SHARPNESS;
		case 8:
			return Enchantments.SHARPNESS;
		case 9:
			return Enchantments.SHARPNESS;
		case 10:
			return Enchantments.SHARPNESS;
		case 11:
			return Enchantments.UNBREAKING;
		case 12:
			return Enchantments.UNBREAKING;
		case 13:
			return Enchantments.UNBREAKING;
		case 14:
			return Enchantments.SWEEPING_EDGE;
		case 15:
			return Enchantments.SWEEPING_EDGE;
		case 16:
			return Enchantments.SWEEPING_EDGE;
		case 17:
			return Enchantments.FIRE_ASPECT;
		case 18:
			return Enchantments.FIRE_ASPECT;
		case 19:
			return Enchantments.MOB_LOOTING;
		case 20:	
			return Enchantments.MOB_LOOTING;
		}
		return null;
	}

}
