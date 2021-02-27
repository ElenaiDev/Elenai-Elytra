package com.elenai.elenaiaccessories.subscriber;

import com.elenai.elenaiaccessories.ElenaiAccessories;
import com.elenai.elenaiaccessories.item.ItemSimple;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElenaiAccessories.MODID, bus = Bus.MOD)
public class CommonEventBusSubscriber {
	
	public static ItemSimple itemSimple;

	  @SubscribeEvent
	  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
	    itemSimple = new ItemSimple();
	    itemSimple.setRegistryName("forceful_ring");
	    
	    itemRegisterEvent.getRegistry().registerAll(itemSimple);
	  }
	
	@SubscribeEvent
	public static void onStaticCommonSetup(FMLCommonSetupEvent event) {
	}


}
