package net.crowifick.minecianite.client.guis.blocks;

import net.crowifick.minecianite.blocks.inventory.ContainerMiraculousWorkBench;
import net.crowifick.minecianite.blocks.tileentitys.TileEntityMWB;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMWBCrafting extends GuiContainer {
	
    private static final ResourceLocation MWBGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");

    public GuiMWBCrafting(InventoryPlayer inventoryPlayer, TileEntityMWB tile, World world, int x, int y, int z) {
    
    	super(new ContainerMiraculousWorkBench(inventoryPlayer, tile, world, x, y, z));
    
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
    	
        this.fontRendererObj.drawString(I18n.format("container.mwbCrafting", new Object[0]), 28, 6, 4210752);
    
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    
    }

    protected void drawGuiContainerBackgroundLayer(float floaty, int i, int j) {
    	
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(MWBGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    
    }
    
}
