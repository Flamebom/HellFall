package com.flamebom.hellfall.entity;

import com.flamebom.hellfall.items.EntitySword;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
	public static final EntityType<EntitySword> ENTITY_SWORD = EntityType.Builder.<EntitySword>of(
			EntitySword::new, MobCategory.MISC)
			.sized(0, 0)
			.setUpdateInterval(10)
			.clientTrackingRange(6)
			.setShouldReceiveVelocityUpdates(true)
			.build("");
}
