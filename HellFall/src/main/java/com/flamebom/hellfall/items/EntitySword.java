package com.flamebom.hellfall.items;

import com.flamebom.hellfall.entity.ModEntities;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntitySword extends ThrowableProjectile {
	private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Entity.class, EntityDataSerializers.FLOAT);

	public EntitySword(EntityType<EntitySword> type, Level level) {
		super(type, level);
	}

	public EntitySword(Player player, int currentdamage) {
		super(ModEntities.ENTITY_SWORD, player, player.level);
		float currentdamagef = currentdamage;
		entityData.set(DAMAGE, currentdamagef);
	}
	@Override
	protected void defineSynchedData() {
		entityData.define(DAMAGE, 1F);
		
	}
	
@Override
protected void onHitEntity(EntityHitResult pResult) {
    super.onHitEntity(pResult);
    pResult.getEntity().hurt(DamageSource.OUT_OF_WORLD,entityData.get(DAMAGE));
}

}
