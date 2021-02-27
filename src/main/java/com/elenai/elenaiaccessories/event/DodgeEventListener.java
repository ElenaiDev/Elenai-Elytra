package com.elenai.elenaiaccessories.event;

import com.elenai.elenaiaccessories.subscriber.CommonEventBusSubscriber;
import com.elenai.elenaidodge2.api.DodgeEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class DodgeEventListener {

	@SubscribeEvent
	public void onDodge(DodgeEvent.ServerDodgeEvent event) {
		
		if(CuriosApi.getCuriosHelper().findEquippedCurio(CommonEventBusSubscriber.itemSimple, event.getPlayer())
		.isPresent()) {
			event.setForce(event.getForce() + 10);
		}
		
	}
	
}
