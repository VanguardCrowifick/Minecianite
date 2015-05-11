package net.crowifick.minecianite.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crowifick.minecianite.Minecianite;
import net.crowifick.minecianite.blocks.tileentitys.TileEntityMWB;
import net.crowifick.minecianite.util.GuiID;
import net.crowifick.minecianite.util.Utility;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMiraculousWorkBench extends BlockContainer {

	@SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon sides;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;
    
    private String tName;
	
	public BlockMiraculousWorkBench(String name, Material material, float hardness, float resistance) {
		
		super(material);
		setBlockName(name);
		setHardness(hardness);
		setResistance(resistance);	
		setCreativeTab(CreativeTabs.tabBlock);
		tName = name;
		
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j) {
		
        return i == 1 ? this.top : (i == 0 ? this.bottom : (i != 2 && i != 4 ? this.sides : this.sides));
    
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.top = icon.registerIcon(Utility.TPATH + this.tName + "Top");
        this.sides = icon.registerIcon(Utility.TPATH + this.tName + "Side");
        this.bottom = icon.registerIcon(Utility.TPATH + this.tName + "Bottom");
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
        if (world.isRemote) {
        	
            return true;
        
        } else {
        
        	
        	TileEntityMWB tileentityMWB = (TileEntityMWB)world.getTileEntity(x, y, z);

            if (tileentityMWB != null)
            {
            	player.openGui(Minecianite.instance, GuiID.miraculousWorkBench, world, x, y, z);
            }
        
            return true;
        
        }
        
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileEntityMWB();
	
	}
	
}
