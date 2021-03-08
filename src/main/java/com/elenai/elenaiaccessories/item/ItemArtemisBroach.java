package com.elenai.elenaiaccessories.item;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.elenai.elenaiaccessories.capability.xp.XpProvider;
import com.elenai.elenaiaccessories.subscriber.CommonEventBusSubscriber;
import com.elenai.elenaidodge2.api.FeathersHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class ItemArtemisBroach extends Item {

	public ItemArtemisBroach() {
		super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));
	}

	@Override
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new StringTextComponent(""));
		list.add(new StringTextComponent(TextFormatting.GRAY + "When on Body:"));
		list.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "Experience Orbs regenerate Feathers"));
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
				return !CuriosApi.getCuriosHelper()
						.findEquippedCurio(CommonEventBusSubscriber.artemisBroach, entityLivingBase).isPresent();
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

	@SubscribeEvent
	public void onExpPickup(PlayerXpEvent.XpChange event) {

		FeathersHelper helper = new FeathersHelper();
		if (CuriosApi.getCuriosHelper().findEquippedCurio(CommonEventBusSubscriber.artemisBroach, event.getPlayer())
				.isPresent() && helper.getFeatherLevel((ServerPlayerEntity) event.getPlayer()) < 20) {
			event.getPlayer().getCapability(XpProvider.XP_CAP).ifPresent(x -> {
				x.increase(1);
				event.setCanceled(true);
			});
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !event.player.world.isRemote) {
			event.player.getCapability(XpProvider.XP_CAP).ifPresent(x -> {
				if (x.getXp() > 2) {
					x.set(0);
					FeathersHelper helper = new FeathersHelper();
					helper.increaseFeathers((ServerPlayerEntity) event.player, 1);

				}
			});
		}
	}

}