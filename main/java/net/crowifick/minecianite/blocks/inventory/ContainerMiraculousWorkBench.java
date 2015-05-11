package net.crowifick.minecianite.blocks.inventory;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.blocks.tileentitys.TileEntityMWB;
import net.crowifick.minecianite.recipes.MWBCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerMiraculousWorkBench extends Container {
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    
    private World worldObj;
    
    private int posX;
    private int posY;
    private int posZ;

    public ContainerMiraculousWorkBench(InventoryPlayer playerInventory, TileEntityMWB tile, World world, int x, int y, int z) {
    	
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        int l;
        int i1;

        for (l = 0; l < 3; ++l) {
        	
            for (i1 = 0; i1 < 3; ++i1) {
            	
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            
            }
            
        }

        for (l = 0; l < 3; ++l) {
        	
            for (i1 = 0; i1 < 9; ++i1) {
            	
                this.addSlotToContainer(new Slot(playerInventory, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            
            }
            
        }

        for (l = 0; l < 9; ++l) {
        	
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    
    }

    public void onCraftMatrixChanged(IInventory iventory) {
    	
        this.craftResult.setInventorySlotContents(0, MWBCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    
    }

    public void onContainerClosed(EntityPlayer p_75134_1_) {
    	
        super.onContainerClosed(p_75134_1_);

        if (!this.worldObj.isRemote) {
        	
            for (int i = 0; i < 9; ++i) {
            	
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null) {
                	
                    p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
              
                }
                
            }
            
        }
        
    }

    public boolean canInteractWith(EntityPlayer player) {
    	
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != MTBlock.miraculousWorkBench ? 
        		false : player.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
    	
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
        	
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotIndex == 0) {
            	
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                	
                    return null;
                
                }

                slot.onSlotChange(itemstack1, itemstack);
            
            } else if (slotIndex >= 10 && slotIndex < 37) {
            	
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                	
                    return null;
                
                }
                
            } else if (slotIndex >= 37 && slotIndex < 46) {
            	
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    
                	return null;
            
                }
                
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
            	
                return null;
            
            }

            if (itemstack1.stackSize == 0) {
            	
                slot.putStack((ItemStack)null);
            
            } else {
            	
                slot.onSlotChanged();
            
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
            	
                return null;
            
            }

            slot.onPickupFromSlot(player, itemstack1);
        
        }

        return itemstack;
    
    }

    public boolean func_94530_a(ItemStack itemStack, Slot slot) {
    	
        return slot.inventory != this.craftResult && super.func_94530_a(itemStack, slot);
    
    }
    
}
