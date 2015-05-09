package net.crowifick.minecianite.util.items;

import net.crowifick.minecianite.util.Utility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTItemBase extends Item {
	
	public MTItemBase(String name, CreativeTabs tab) {
		
		setUnlocalizedName(name);
		setTextureName(Utility.TPATH + name);
		setCreativeTab(tab);
		
	}
	
	public MTItemBase(String name, CreativeTabs tab, int maxStackSize) {
		
		setUnlocalizedName(name);
		setTextureName(Utility.TPATH + name);
		setCreativeTab(tab);
		setMaxStackSize(maxStackSize);
		
	}

}
