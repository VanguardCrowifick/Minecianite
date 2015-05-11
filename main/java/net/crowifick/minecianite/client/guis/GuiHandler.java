package net.crowifick.minecianite.client.guis;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.blocks.inventory.ContainerMiraculousWorkBench;
import net.crowifick.minecianite.blocks.tileentitys.TileEntityMWB;
import net.crowifick.minecianite.client.guis.blocks.GuiMWBCrafting;
import net.crowifick.minecianite.util.GuiID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);

        if(tileEntity != null) {
        	
        	switch(ID) {
        	
        		case GuiID.miraculousWorkBench: return new ContainerMiraculousWorkBench(player.inventory, (TileEntityMWB)tileEntity, world, x, y, z);
        		
        	}
        	
        }
		
		return null;
       
	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (tileEntity != null) {
        	
        	switch(ID) {
        	
        		case GuiID.miraculousWorkBench: return new GuiMWBCrafting(player.inventory, (TileEntityMWB) tileEntity, world, z, z, z);
        	
        	}
        
        }
              
		return null;
	
	}

}
