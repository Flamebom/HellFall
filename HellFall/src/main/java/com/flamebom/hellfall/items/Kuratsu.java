package com.flamebom.hellfall.items;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.helpers.EnchantmentCreator;
import com.flamebom.hellfall.setup.ModSounds;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Kuratsu extends SwordItem {

	public Kuratsu() {
		super(Tiers.NETHERITE, 6, -2.8F, new Item.Properties().tab(HellFall.ITEM_GROUP));

		MinecraftForge.EVENT_BUS.addListener(this::leftClick);
		// MinecraftForge.EVENT_BUS.addListener(this::attackEntity);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		return super.onLeftClickEntity(stack, player, entity);
	}

	private void leftClick(PlayerInteractEvent.LeftClickEmpty evt) {

		if (!evt.getItemStack().isEmpty() && evt.getItemStack().getItem() == this) {
			// trySpawnSword(evt.getPlayer());
		}
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
			tag.putInt("sharpness", 10);
			tag.putInt("level", 1);
			tag.putBoolean("init", true);
		}

	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		if (attacker instanceof Player) {
			damageupdater(stack, target, attacker);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

	public void damageupdater(ItemStack sword, LivingEntity killedEntity, LivingEntity player) {
		if (killedEntity.getType() == EntityType.SKELETON && killedEntity.isDeadOrDying()) {
			player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.bowshot,
					SoundSource.PLAYERS, 20F, 1F);
			setXPOfSword(sword, 20);
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

	public void setEnchantment(ItemStack stack) {
		EnchantmentInstance enchant = EnchantmentCreator.addEnchant(getLevel(stack));
		Map<Enchantment, Integer> Enchantments = EnchantmentHelper.getEnchantments(stack);
		if (Enchantments.containsKey(enchant.enchantment)) {
			Enchantments.put(enchant.enchantment, enchant.level + Enchantments.get(enchant.enchantment));
			EnchantmentHelper.setEnchantments(Enchantments, stack);
		} else {
			stack.enchant(enchant.enchantment, enchant.level);
		}
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
		if (xp >= 100) {
			xp = xp % 100;
			setLevel(stack, 1);
			Random random = new Random();
			int level = getLevel(stack);
			int cycles = 0;
			if (level <= 10) {
				cycles = random.nextInt(0, 3);
			} else {
				cycles = random.nextInt(0, level / 5 + 1);
			}
			for (int i = 0; i < cycles; i++) {
				boolean enchant = random.nextBoolean();
				if (enchant) {
					setEnchantment(stack);
				} else {
					setDamageOfSword(stack, 1 * tag.getInt("sharpness"));
				}
			}

		}
		tag.putInt("experience", xp);

	}

}
