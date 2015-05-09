package net.crowifick.minecianite.util.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MTShardBase extends MTItemBase {

	private String item_Description;
	
	public MTShardBase(String name, CreativeTabs tab, String description) {
		
		super(name, tab);
		
		item_Description = description;
		
	}
	
	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par3) {
		  
		 list.add(item_Description);
		
	 }

}
