package com.flamebom.hellfall.items;

import java.util.List;

import com.flamebom.hellfall.HellFall;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Kuratsu extends SwordItem {

	public Kuratsu() {
		super(Tiers.NETHERITE, 1, -2.8F, new Item.Properties().tab(HellFall.ITEM_GROUP));
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
		if (slot == EquipmentSlot.MAINHAND) {
			System.out.println(tag.getInt("currentdamage"));
			multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier",
					tag.getInt("currentdamage"), AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (attacker instanceof Player) {
			damageupdater(stack,target,attacker);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	public void damageupdater(ItemStack sword, LivingEntity killedEntity, LivingEntity player) {
		CompoundTag tag = sword.getOrCreateTag();
		if (killedEntity.getType() == EntityType.SKELETON && killedEntity.isDeadOrDying()) {
			if (tag.contains("currentdamage")) {
				tag.putInt("currentdamage", 10 + tag.getInt("currentdamage"));
			} else {
				tag.putInt("currentdamage", 1);
			}
		}
	}

	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
		return true;
	}

	@Override
	public boolean canBeDepleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MutableComponent getName(ItemStack stack) {
		return new TranslatableComponent(this.getDescriptionId(stack)).withStyle(ChatFormatting.DARK_RED);
	}

	@Override
	public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {

		tooltip.add(new TranslatableComponent("message.kuratsu",
				Integer.toString(stack.getOrCreateTag().getInt("currentdamage"))).withStyle(ChatFormatting.DARK_RED));
	}

}
