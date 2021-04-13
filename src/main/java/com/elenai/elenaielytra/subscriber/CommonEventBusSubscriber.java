package com.elenai.elenaielytra.subscriber;

import com.elenai.elenaielytra.ElenaiElytra;
import com.elenai.elenaielytra.event.PlayerTickEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElenaiElytra.MODID, bus = Bus.MOD)
public class CommonEventBusSubscriber {
	
	@SubscribeEvent
	public static void onStaticCommonSetup(FMLCommonSetupEvent event) {
		event.setPhase(EventPriority.HIGHEST);
		MinecraftForge.EVENT_BUS.register(new PlayerTickEvent());

	}


}
