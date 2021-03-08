package com.elenai.elenaiaccessories.capability.xp;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class XpStorage implements IStorage<IXp> {

	@Override
	public INBT writeNBT(Capability<IXp> capability, IXp instance, Direction side) {
		return IntNBT.valueOf(instance.getXp());
	}

	@Override
	public void readNBT(Capability<IXp> capability, IXp instance, Direction side, INBT nbt) {
		instance.set(((IntNBT) nbt).getInt());
	}

}
