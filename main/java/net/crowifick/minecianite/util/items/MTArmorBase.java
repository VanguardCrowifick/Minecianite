package net.crowifick.minecianite.util.items;

import net.crowifick.minecianite.util.Utility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MTArmorBase extends ItemArmor {

	private String textureName;
	
	public MTArmorBase(ArmorMaterial material, String name, int renderIndex, int armorType) {
		
		super(material, renderIndex, armorType);
		setUnlocalizedName(name);
		setTextureName(name);
		setCreativeTab(CreativeTabs.tabCombat);
		textureName = name;
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		 
		 return Utility.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png"; 
		 
	}

}
