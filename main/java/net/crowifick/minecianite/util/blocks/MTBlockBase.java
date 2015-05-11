package net.crowifick.minecianite.util.blocks;

import java.util.Random;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.items.MTItem;
import net.crowifick.minecianite.util.Utility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTBlockBase extends Block {

	public MTBlockBase(String name, Material material, float hardness, float resistance) {
		
		super(material);
		setBlockName(name);
		setHardness(hardness);
		setResistance(resistance);	
		setBlockTextureName(Utility.TPATH + name);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	public MTBlockBase(String name, Material material, float hardness, float resistance, String tool, int toolLevel) {
		
		super(material);
		setBlockName(name);
		setHardness(hardness);
		setResistance(resistance);	
		setBlockTextureName(Utility.TPATH + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel(tool, toolLevel);
		
	}
	
	public int quantityDropped(Random random) {
		
		if(this.equals(MTBlock.depletedRemnantOre))
			return 2 + random.nextInt(1);
		
        return 1;

	}
	
	public Item getItemDropped(int i, Random random, int k) {
		
		if(this.equals(MTBlock.depletedRemnantOre))
			return MTItem.depletedRemnant;
		
        return Item.getItemFromBlock(this);
    
	}

}
