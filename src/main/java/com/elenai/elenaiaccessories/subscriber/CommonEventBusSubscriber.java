package com.elenai.elenaiaccessories.subscriber;

import com.elenai.elenaiaccessories.ElenaiAccessories;
import com.elenai.elenaiaccessories.item.ItemArtfulDodger;
import com.elenai.elenaiaccessories.item.ItemElenaisTear;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElenaiAccessories.MODID, bus = Bus.MOD)
public class CommonEventBusSubscriber {
	
	public static ItemElenaisTear elenaisTear;
	public static ItemArtfulDodger artfulDodger;

	  @SubscribeEvent
	  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		  elenaisTear = new ItemElenaisTear();
		  elenaisTear.setRegistryName("elenais_tear");
		  
		  artfulDodger = new ItemArtfulDodger();
		  artfulDodger.setRegistryName("artful_dodger");
	    
	    itemRegisterEvent.getRegistry().registerAll(elenaisTear, artfulDodger);
	  }
	
	@SubscribeEvent
	public static void onStaticCommonSetup(FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(artfulDodger);
		MinecraftForge.EVENT_BUS.register(elenaisTear);


	}


}
