package net.crowifick.minecianite.items;

import net.crowifick.minecianite.util.Utility;
import net.crowifick.minecianite.util.items.MTItemBase;
import net.minecraft.creativetab.CreativeTabs;

public class MTItem {
	
	public static MTItemBase fireShard = new MTItemBase("fireShard", CreativeTabs.tabMaterials);
	
	public static void init() {
		
		Utility.registerItems(fireShard);
		
	}

}
