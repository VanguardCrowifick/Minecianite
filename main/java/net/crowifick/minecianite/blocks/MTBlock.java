package net.crowifick.minecianite.blocks;

import net.crowifick.minecianite.util.Utility;
import net.crowifick.minecianite.util.blocks.MTBlockBase;
import net.minecraft.block.material.Material;

public class MTBlock {
	
	public static MTBlockBase fireShardOre = new MTBlockBase("fireShardOre", Material.rock, 1.8f, 2.4f, "pickaxe", 2);
	
	public static void init() {
		
		Utility.registerBlocks(fireShardOre);
		
	}

}
