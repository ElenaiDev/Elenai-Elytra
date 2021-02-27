package com.elenai.elenaiaccessories.item;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.elenai.elenaiaccessories.subscriber.CommonEventBusSubscriber;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class ItemSimple extends Item {

	public ItemSimple() {
		super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));
	}
	
	@Override
	public ICapabilityProvider initCapabilities(final ItemStack stack, CompoundNBT unused) {
		ICurio curio = new ICurio() {
			@Override
			public boolean canRightClickEquip() {
				return true;
			}

			@Override
			public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
				return !CuriosApi.getCuriosHelper().findEquippedCurio(CommonEventBusSubscriber.itemSimple, entityLivingBase)
						.isPresent();
			}
		};

		return new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
	}

	public static boolean isRingInCuriosSlot(ItemStack ring, LivingEntity player) {
		return CuriosApi.getCuriosHelper().findEquippedCurio(ring.getItem(), player).isPresent();
	}
}