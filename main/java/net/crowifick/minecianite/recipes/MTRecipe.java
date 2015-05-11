package net.crowifick.minecianite.recipes;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.items.MTItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MTRecipe {

	public static void init() {
		
		GameRegistry.addShapedRecipe(new ItemStack(MTBlock.miraculousWorkBench, 1), "LCL", "RHR", "LRL", 'L', Blocks.log, 'R', MTItem.depletedRemnant, 'C', Blocks.crafting_table, 'H', MTItem.heliusDepletedRemnantCapsule);
		GameRegistry.addShapedRecipe(new ItemStack(MTItem.heliusCapsule, 1), " G ", "H H", " H ", 'G', Blocks.glass, 'H', MTItem.heliusIngot);
		GameRegistry.addShapelessRecipe(new ItemStack(MTItem.heliusDepletedRemnantCapsule, 1), MTItem.depletedRemnant, MTItem.heliusCapsule);
		
		GameRegistry.addSmelting(MTBlock.heliusOre, new ItemStack(MTItem.heliusIngot, 1), 1.07f);
		
	}
	
}
