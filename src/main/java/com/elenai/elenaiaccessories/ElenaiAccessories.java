package com.elenai.elenaiaccessories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(ElenaiAccessories.MODID)
public class ElenaiAccessories {
	
	public static final String MODID = "elenaiaccessories";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String NAME = "Elenai Accessories";
    public static final String VERSION = "1.0";


    public ElenaiAccessories() {
    	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::enqueueIMC);
    }
    
    private void enqueueIMC(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.RING.getMessageBuilder().build());
	}


}
