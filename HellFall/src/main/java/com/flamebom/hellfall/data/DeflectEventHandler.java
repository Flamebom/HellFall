package com.flamebom.hellfall.data;

import com.flamebom.hellfall.HellFall;
import com.flamebom.hellfall.items.Kuratsu;
import com.flamebom.hellfall.setup.ModSounds;
import com.flamebom.hellfall.setup.Registration;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HellFall.MODID)
public class DeflectEventHandler {
	

	@SubscribeEvent
	public static void PlayerDeflect(LivingHurtEvent event) {
		DamageSource s = event.getSource();
		Entity e = event.getEntity();
		if (e instanceof Player && s instanceof EntityDamageSource) {
			Player player = (Player) e;
			ItemStack stack = player.getMainHandItem();
			if (!stack.isEmpty() && stack.getItem() instanceof Kuratsu) {
				if (player.getMainHandItem().getTag().getBoolean("canDeflect")) {
					float damage = event.getAmount();
					damage = damage * 0;
					event.setAmount(damage);
					if (!player.level.isClientSide) {
						player.level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.bowshot,
								SoundSource.PLAYERS, 20F, 1F);

					}
				}
			}
		}
		return;
	}



}
