package net.crowifick.minecianite.util.blocks;

import net.crowifick.minecianite.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MTBlockBase extends Block {

	public MTBlockBase(String name, Material material, float hardness, float resistance) {
		
		super(material);
		setBlockName(name);
		setHardness(hardness);
		setResistance(resistance);	
		setBlockTextureName(Utility.TPATH + name);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}

}
