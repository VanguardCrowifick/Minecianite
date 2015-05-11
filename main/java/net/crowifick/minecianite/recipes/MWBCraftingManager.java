package net.crowifick.minecianite.recipes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class MWBCraftingManager {
	
	private static final MWBCraftingManager instance = new MWBCraftingManager();
	
    private List recipes = new ArrayList();

    public static final MWBCraftingManager getInstance() {
    	
        return instance;
    
    }

    private MWBCraftingManager() {
    	
    	this.addRecipe(new ItemStack(Items.arrow, 20), "SSS", "SSS", "SSS", 'S', Blocks.cobblestone);
    	
    }
    
    public ShapedRecipes addRecipe(ItemStack itemStack, Object ... stringMap) {
    	
        String s = "";
        
        int i = 0;
        int j = 0;
        int k = 0;

        if (stringMap[i] instanceof String[]) {
        	
            String[] astring = (String[])((String[])stringMap[i++]);

            for (int l = 0; l < astring.length; ++l) {
            	
                String s1 = astring[l];
                
                ++k;
                j = s1.length();
                s = s + s1;
            
            }
            
        } else {
        	
            while (stringMap[i] instanceof String) {
            	
                String s2 = (String)stringMap[i++];
                
                ++k;
                j = s2.length();
                s = s + s2;
            
            }
            
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < stringMap.length; i += 2) {
        	
            Character character = (Character)stringMap[i];
            
            ItemStack itemstack1 = null;

            if (stringMap[i + 1] instanceof Item) {
            	
                itemstack1 = new ItemStack((Item)stringMap[i + 1]);
            
            } else if (stringMap[i + 1] instanceof Block) {
            	
                itemstack1 = new ItemStack((Block)stringMap[i + 1], 1, 32767);
            
            } else if (stringMap[i + 1] instanceof ItemStack) {
            	
                itemstack1 = (ItemStack)stringMap[i + 1];
            
            }

            hashmap.put(character, itemstack1);
        
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1) {
        	
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0))) {
            	
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            
            } else {
            	
                aitemstack[i1] = null;
            
            }
            
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, itemStack);
        this.recipes.add(shapedrecipes);
        
        return shapedrecipes;
    
    }

    public void addShapelessRecipe(ItemStack itemStack, Object ... stringMap) {
    	
        ArrayList arraylist = new ArrayList();
        
        Object[] aobject = stringMap;
        
        int i = stringMap.length;

        for (int j = 0; j < i; ++j) {
        	
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack) {
            	
                arraylist.add(((ItemStack)object1).copy());
            
            } else if (object1 instanceof Item) {
            	
                arraylist.add(new ItemStack((Item)object1));
            
            } else {
            	
                if (!(object1 instanceof Block)) {
                	
                    throw new RuntimeException("Invalid shapeless recipe!");
                
                }

                arraylist.add(new ItemStack((Block)object1));
            
            }
            
        }

        this.recipes.add(new ShapelessRecipes(itemStack, arraylist));
        
    }

    public ItemStack findMatchingRecipe(InventoryCrafting inventoryCrafting, World world) {
    	
        int i = 0;
        
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        
        int j;

        for (j = 0; j < inventoryCrafting.getSizeInventory(); ++j) {
        	
            ItemStack itemstack2 = inventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null) {
            	
                if (i == 0) {
                	
                    itemstack = itemstack2;
                
                }

                if (i == 1) {
                	
                    itemstack1 = itemstack2;
                
                }

                ++i;
            
            }
            
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
        	
            Item item = itemstack.getItem();
            
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0) {
            	
                i1 = 0;
            
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        
        } else {
        	
            for (j = 0; j < this.recipes.size(); ++j) {
            	
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(inventoryCrafting, world)) {
                	
                    return irecipe.getCraftingResult(inventoryCrafting);
                
                }
                
            }

            return null;
        
        }
        
    }

    public List getRecipeList() {
    	
        return this.recipes;
    
    }
	
}