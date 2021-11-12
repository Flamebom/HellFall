package com.flamebom.hellfall.items;

import java.util.List;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.network.PacketHandler;
import com.flamebom.hellfall.network.PacketLeftClick;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.realmsclient.dto.RealmsServer.WorldType;

import net.minecraft.ChatFormatting;
import net.minecraft.client.player.LocalPlayer;
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
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Kuratsu extends SwordItem {

	public Kuratsu() {
		super(Tiers.NETHERITE, 1, -2.8F, new Item.Properties().tab(HellFall.ITEM_GROUP));
		MinecraftForge.EVENT_BUS.addListener(this::leftClick);
		MinecraftForge.EVENT_BUS.addListener(this::attackEntity);
	}

	/*
	 * Projectile based off Terrablade code
	 */
	private void leftClick(PlayerInteractEvent.LeftClickEmpty evt) {
		if (!evt.getItemStack().isEmpty()
				&& evt.getItemStack().getItem() == this) {
			PacketHandler.sendToServer(new PacketLeftClick());
		}
	}

	private void attackEntity(AttackEntityEvent evt) {
		if (!evt.getPlayer().level.isClientSide) {
			trySpawnSword(evt.getPlayer());
		}
	}

	public void trySpawnSword(Player player) {
		if (!player.getMainHandItem().isEmpty()
				&& player.getMainHandItem().getItem() == this
				&& player.getAttackStrengthScale(0) == 1) {
			EntitySword sword = new EntitySword(player, player.level);
			player.level.addFreshEntity(sword);
		
			//player.level.playSound(null, player.getX(), player.getY(), player.getZ(),  null, null, 0.4F, 1.4F);
		}
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
			damageupdater(stack, target, attacker);
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
		return false;
	}

	@Override
	public MutableComponent getName(ItemStack stack) {
		return new TranslatableComponent(this.getDescriptionId(stack)).withStyle(ChatFormatting.DARK_RED);
	}

	@Override
	public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flagIn) {

		tooltip.add(new TranslatableComponent("message.kuratsu",
				Integer.toString(stack.getOrCreateTag().getInt("currentdamage"))).withStyle(ChatFormatting.DARK_RED));
	}

}
