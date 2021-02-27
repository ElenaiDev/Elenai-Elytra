package com.elenai.elenaiaccessories.subscriber;

import com.elenai.elenaiaccessories.ElenaiAccessories;
import com.elenai.elenaiaccessories.event.DodgeEventListener;
import com.elenai.elenaiaccessories.item.ItemRing;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElenaiAccessories.MODID, bus = Bus.MOD)
public class CommonEventBusSubscriber {
	
	public static ItemRing itemRingForceful;

	  @SubscribeEvent
	  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		  itemRingForceful = new ItemRing(25);
		  itemRingForceful.setRegistryName("forceful_ring");
	    
	    itemRegisterEvent.getRegistry().registerAll(itemRingForceful);
	  }
	
	@SubscribeEvent
	public static void onStaticCommonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new DodgeEventListener());
	}


}
