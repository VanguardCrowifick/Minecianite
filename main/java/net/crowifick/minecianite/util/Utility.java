package net.crowifick.minecianite.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Utility {
	
	public static final String MODID = "minecianite";
	public static final String NAME = "Minecianite";
	public static final String VERSION = "1.0.0";
	
	public static final String CLIENT = "net.crowifick.minecianite.proxys.ClientProxy";
	public static final String SERVER = "net.crowifick.minecianite.proxys.CommontProxy";
	
	public static final String TPATH = MODID + ":";
	
	/**
	 * 
	 * Register's Item
	 * 
	 * @param item
	 */
	public static void registerItems(Item item) {
		
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		
	}
	
	/**
	 * 
	 * Register's Block
	 * 
	 * @param block
	 */
	public static void registerBlocks(Block block) {
		
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		
	}
	
	public static void addPickaxeRecipe(Item material, Item stickMaterial, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "MMM", " S ", " S ", 'M', material, 'S', stickMaterial);
		
	}
	
	public static void addAxeRecipe(Item material, Item stickMaterial, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "MM ", "MS ", " S ", 'M', material, 'S', stickMaterial);
		
	}
	
	public static void addSwordRecipe(Item material, Item stickMaterial, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), " M ", " S ", " S ", 'M', material, 'S', stickMaterial);
		
	}

	public static void addShovelRecipe(Item material, Item stickMaterial, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), " M ", " S ", " S ", 'M', material, 'S', stickMaterial);
	
	}

	public static void addHoeRecipe(Item material, Item stickMaterial, Item outputItem) {
	
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "MM ", " S ", " S ", 'M', material, 'S', stickMaterial);
	
	}
	
	public static void addHelmetRecipe(Item material, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "MMM", "M M", "   ", 'M', material);
	
	}
	
	public static void addChestplateRecipe(Item material, Item outputItem) {
		
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "M M", "MMM", "MMM", 'M', material);
	
	}

	public static void addLeggingsRecipe(Item material, Item outputItem) {
	
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "MMM", "M M", "M M", 'M', material);

	}

	public static void addBootsRecipe(Item material, Item outputItem) {
	
		GameRegistry.addShapedRecipe(new ItemStack(outputItem, 1), "M M", "M M", "   ", 'M', material);

	}

}
