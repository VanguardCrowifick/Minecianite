package net.crowifick.minecianite;

import net.crowifick.minecianite.blocks.MTBlock;
import net.crowifick.minecianite.client.guis.GuiHandler;
import net.crowifick.minecianite.items.MTItem;
import net.crowifick.minecianite.proxys.CommonProxy;
import net.crowifick.minecianite.recipes.MTRecipe;
import net.crowifick.minecianite.util.Utility;
import net.crowifick.minecianite.world.gen.MinecianiteWorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = Utility.NAME, modid = Utility.MODID, version = Utility.VERSION)
public class Minecianite {
	
	@Mod.Instance(Utility.MODID)
	public static Minecianite instance;
	
	@SidedProxy(clientSide = Utility.CLIENT, serverSide = Utility.SERVER)
	public static CommonProxy proxy;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		MTItem.init();
		MTBlock.init();
		MTRecipe.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
		GameRegistry.registerWorldGenerator(new MinecianiteWorldGen(), 3);
		
	}

	@Mod.EventHandler
	public void preInit(FMLPostInitializationEvent event) {
	
	
		
	}
	
}
