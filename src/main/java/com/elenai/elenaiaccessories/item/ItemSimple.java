package com.elenai.elenaiaccessories.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemSimple extends Item {

	public ItemSimple() {
		super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));
	}
}