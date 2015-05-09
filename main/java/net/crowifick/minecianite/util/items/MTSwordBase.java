package net.crowifick.minecianite.util.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.minecianite.util.Utility;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class MTSwordBase extends ItemSword {

	private String item_Description;
	
	public MTSwordBase(String name, ToolMaterial toolMaterial, String description) {
		
		super(toolMaterial);
		setUnlocalizedName(name);
		setTextureName(Utility.MODID + name);
		setCreativeTab(CreativeTabs.tabCombat);
		
	}

	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par3) {
		  
		 list.add(item_Description);
		
	 }
	
}
