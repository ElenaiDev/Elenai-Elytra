package com.elenai.elenaielytra.event;

import com.elenai.elenaidodge2.api.DodgeEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerTickEvent {

	@SubscribeEvent
	public void onPlayerDodge(DodgeEvent.ServerDodgeEvent event) {

		if (event.getPlayer().isElytraFlying()) {
			
			// Move the player here and send animations
			
			PlayerEntity playerentity = event.getPlayer();

                playerentity.startSpinAttack(20);

			event.setCanceled(true);
		}
	}
	
}
