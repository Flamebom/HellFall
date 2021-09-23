package com.flamebom.hellfall.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.NbtComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Kuratsu extends SwordItem {

	 public Kuratsu() {
	        super(Tiers.NETHERITE, 1, -2.8F, new Item.Properties());
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
		public boolean onDroppedByPlayer(ItemStack item, Player player) {
		CompoundTag tag =item.getOrCreateTag();
	
			return super.onDroppedByPlayer(item, player);
		}
	 @Override
	public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
		// TODO Auto-generated method stub
		return true;
	}
	 
}
