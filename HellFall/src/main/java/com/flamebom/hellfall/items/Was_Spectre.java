package com.flamebom.hellfall.items;

import java.util.List;
import com.flamebom.hellfall.setup.ModSetup;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Was_Spectre extends AxeItem {
	public Was_Spectre() {
		super(Tiers.NETHERITE, 6, -2.8F, new Item.Properties().tab(ModSetup.ITEM_GROUP));
	}
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		intialize(stack);
		Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();

		if (slot == EquipmentSlot.MAINHAND) {
			multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
					getDamageOfSword(stack), AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
	public void intialize(ItemStack stack) {

		CompoundTag tag = stack.getOrCreateTag();
		if (!tag.contains("init")) {
			tag.putInt("experience", 0);
			tag.putInt("currentdamage", 5);
			tag.putInt("level", 1);
			tag.putBoolean("init", true);
			tag.putBoolean("on", false);
		}

	}
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (attacker instanceof Player && stack.getOrCreateTag().getBoolean("on") ) {
			damageupdater(stack, target, attacker);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	public void damageupdater(ItemStack sword, LivingEntity killedEntity, LivingEntity player) {
		if (killedEntity.getType() == EntityType.WITHER || killedEntity.getType() == EntityType.ENDER_DRAGON && killedEntity.isDeadOrDying()) {
			setXPOfSword(sword, 25);
		}
		else if (killedEntity.getType() == EntityType.RAVAGER || killedEntity.getType() == EntityType.ELDER_GUARDIAN && killedEntity.isDeadOrDying()) {
			setXPOfSword(sword, 10);
		}
		else if (killedEntity.getMobType() == MobType.UNDEAD ||killedEntity.getMobType() == MobType.UNDEFINED || killedEntity.getMobType() == MobType.ARTHROPOD || killedEntity.getMobType() == MobType.WATER || killedEntity.getMobType() == MobType.ILLAGER  && killedEntity.isDeadOrDying()) {
			//player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.bowshot,	SoundSource.PLAYERS, 20F, 1F);
			setXPOfSword(sword, 1);
		}
		
	}

	@Override
	public boolean canBeDepleted() {
		return false;
	}

	@Override
	public MutableComponent getName(ItemStack stack) {
		if (getLevel(stack) <= 10)
			return new TranslatableComponent(this.getDescriptionId(stack)).withStyle(ChatFormatting.RED);
		else {
			return new TranslatableComponent(this.getDescriptionId(stack)).withStyle(ChatFormatting.DARK_RED);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {

		tooltip.add(new TranslatableComponent("message.kuratsu.xp",
				Integer.toString(stack.getOrCreateTag().getInt("experience"))).withStyle(ChatFormatting.DARK_RED));
		tooltip.add(new TranslatableComponent("message.kuratsu.level",
				Integer.toString(stack.getOrCreateTag().getInt("level"))).withStyle(ChatFormatting.RED));
	}

	public int getDamageOfSword(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		return tag.getInt("currentdamage");
	}

	public void setDamageOfSword(ItemStack stack, int increase) {
		CompoundTag tag = stack.getOrCreateTag();
		tag.putInt("currentdamage", increase + tag.getInt("currentdamage"));
	}

	public int getLevel(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		return tag.getInt("level");
	}

	public void setLevel(ItemStack stack, int increase) {
		CompoundTag tag = stack.getOrCreateTag();
		tag.putInt("level", increase + tag.getInt("level"));
	}

	public int getXPOfSword(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		return tag.getInt("experience");
	}

	public void setXPOfSword(ItemStack stack, int increase) {
		CompoundTag tag = stack.getOrCreateTag();

		int xp = tag.getInt("experience") + increase;
		if (xp >= 50) {
			xp = xp % 50;
			setLevel(stack, 1);
			setDamageOfSword(stack, 1);
		}
		tag.putInt("experience", xp);

	}

}
