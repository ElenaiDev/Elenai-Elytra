package com.elenai.elenaiaccessories.capability.xp;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class XpProvider implements ICapabilitySerializable<INBT> {

	@CapabilityInject(IXp.class)
	public static final Capability<IXp> XP_CAP = null;
	
	private LazyOptional<IXp> instance = LazyOptional.of(XP_CAP::getDefaultInstance);

	    @Nonnull
	    @Override
	    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
	        return cap == XP_CAP ? instance.cast() : LazyOptional.empty();
	    }

	    @Override
	    public INBT serializeNBT() {
	        return XP_CAP.getStorage().writeNBT(XP_CAP, instance.orElseThrow( () -> new NullPointerException("Lazy Optional was empty")), null);
	    }

	    @Override
	    public void deserializeNBT(INBT nbt) {
	    	XP_CAP.getStorage().readNBT(XP_CAP, instance.orElseThrow( () -> new NullPointerException("Lazy Optional was empty")), null, nbt);
	    }

}
