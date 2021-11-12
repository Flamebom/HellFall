package com.flamebom.hellfall.entity;

import com.flamebom.hellfall.items.EntitySword;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
	public static final EntityType<EntitySword> LIGHT_SWORD = EntityType.Builder.<EntitySword>of(EntitySword::new, MobCategory.MISC)
			.sized(5F, 0.1F)
			.clientTrackingRange(8)
			.setUpdateInterval(40)
			.setShouldReceiveVelocityUpdates(false)
			.build("");
}
