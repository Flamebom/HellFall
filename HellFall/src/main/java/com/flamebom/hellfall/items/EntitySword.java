package com.flamebom.hellfall.items;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.flamebom.hellfall.entity.ModEntities;
import com.flamebom.hellfall.helpers.MathHelper;
import com.flamebom.hellfall.helpers.Vector3;

import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

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
