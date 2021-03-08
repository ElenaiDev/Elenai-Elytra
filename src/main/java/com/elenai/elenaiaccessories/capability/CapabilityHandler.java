package com.elenai.elenaiaccessories.capability;

import com.elenai.elenaiaccessories.ElenaiAccessories;
import com.elenai.elenaiaccessories.capability.xp.XpProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler {

	public static final ResourceLocation XP_CAP = new ResourceLocation(ElenaiAccessories.MODID, "xp");



	@SubscribeEvent
	public void onEntityConstructing(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {

			event.addCapability(XP_CAP, new XpProvider());



		}
	}
}
