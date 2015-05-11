package net.crowifick.minecianite.items;

import net.crowifick.minecianite.util.Utility;
import net.crowifick.minecianite.util.items.MTItemBase;
import net.minecraft.creativetab.CreativeTabs;

public class MTItem {
	
	public static MTItemBase depletedRemnant = new MTItemBase("depletedRemnant", CreativeTabs.tabMaterials);
	public static MTItemBase heliusIngot = new MTItemBase("heliusIngot", CreativeTabs.tabMaterials);
	public static MTItemBase heliusCapsule = new MTItemBase("heliusCapsule", CreativeTabs.tabMaterials);
	public static MTItemBase heliusDepletedRemnantCapsule = new MTItemBase("heliusDepletedRemnantCapsule", CreativeTabs.tabMaterials);
	
	public static void init() {
		
		Utility.registerItems(depletedRemnant);
		Utility.registerItems(heliusIngot);
		Utility.registerItems(heliusCapsule);
		Utility.registerItems(heliusDepletedRemnantCapsule);
		
	}

}
