package com.elenai.elenaiaccessories.subscriber;

import com.elenai.elenaiaccessories.ElenaiAccessories;
import com.elenai.elenaiaccessories.capability.xp.IXp;
import com.elenai.elenaiaccessories.capability.xp.Xp;
import com.elenai.elenaiaccessories.capability.xp.XpStorage;
import com.elenai.elenaiaccessories.item.ItemArtemisBroach;
import com.elenai.elenaiaccessories.item.ItemArtfulDodger;
import com.elenai.elenaiaccessories.item.ItemElenaisTear;
import com.elenai.elenaiaccessories.capability.CapabilityHandler;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ElenaiAccessories.MODID, bus = Bus.MOD)
public class CommonEventBusSubscriber {
	
	public static ItemElenaisTear elenaisTear;
	public static ItemArtfulDodger artfulDodger;
	public static ItemArtemisBroach artemisBroach;

	  @SubscribeEvent
	  public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		  elenaisTear = new ItemElenaisTear();
		  elenaisTear.setRegistryName("elenais_tear");
		  
		  artfulDodger = new ItemArtfulDodger();
		  artfulDodger.setRegistryName("artful_dodger");
		  
		  artemisBroach = new ItemArtemisBroach();
		  artemisBroach.setRegistryName("artemis_broach");
	    
	    itemRegisterEvent.getRegistry().registerAll(elenaisTear, artfulDodger, artemisBroach);
	  }
	
	@SubscribeEvent
	public static void onStaticCommonSetup(FMLCommonSetupEvent event) {
		
		CapabilityManager.INSTANCE.register(IXp.class, new XpStorage(), Xp::new);
		
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());

		MinecraftForge.EVENT_BUS.register(artfulDodger);
		MinecraftForge.EVENT_BUS.register(elenaisTear);
		MinecraftForge.EVENT_BUS.register(artemisBroach);


	}


}
