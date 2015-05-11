package net.crowifick.minecianite.blocks;

import net.crowifick.minecianite.blocks.tileentitys.TileEntityMWB;
import net.crowifick.minecianite.util.Utility;
import net.crowifick.minecianite.util.blocks.MTBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class MTBlock {
	
	public static MTBlockBase depletedRemnantOre = new MTBlockBase("depletedRemnantOre", Material.rock, 4.4f, 5.4f, "pickaxe", 2);
	public static MTBlockBase heliusOre = new MTBlockBase("heliusOre", Material.rock, 5.4f, 6.4f, "pickaxe", 3);
	
	public static Block miraculousWorkBench = new BlockMiraculousWorkBench("miraculousWorkBench", Material.rock, 4.4f, 5.4f);
	
	public static void init() {
		
		Utility.registerBlocks(depletedRemnantOre);
		Utility.registerBlocks(heliusOre);
		
		Utility.registerBlocks(miraculousWorkBench);
		
		GameRegistry.registerTileEntity(TileEntityMWB.class, "miraculousWorkBenchTile");
		
	}

}
