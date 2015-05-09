package net.crowifick.minecianite;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.items.MTItem;
import net.crowifick.minecianite.proxys.CommonProxy;
import net.crowifick.minecianite.util.Utility;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Utility.NAME, modid = Utility.MODID, version = Utility.VERSION)
public class Minecianite {
	
	@Mod.Instance(Utility.MODID)
	public Minecianite instance;
	
	@SidedProxy(clientSide = Utility.CLIENT, serverSide = Utility.SERVER)
	public static CommonProxy proxy;
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		MTItem.init();
		MTBlock.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		
		
	}

	@Mod.EventHandler
	public void preInit(FMLPostInitializationEvent event) {
	
	
		
	}
	
}
