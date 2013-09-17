package tutorial;

// Comments that have a *** in any classes after the double-backslash are required for slab code.

import java.util.logging.Level;

import net.minecraftforge.common.MinecraftForge;
// ***
import net.minecraft.block.BlockHalfSlab;
import tutorial.blocks.Blocks;
import tutorial.blocks.TutorialSlabBlock;
import tutorial.items.Items;
import tutorial.lib.LogHelper;
import tutorial.lib.ModInfo;
import tutorial.lib.Recipes;
import tutorial.lib.config.ConfigHandler;
import tutorial.proxies.*;
// ***
import tutorial.items.TutorialSlabItem;
// ***
import net.minecraft.item.ItemSlab;
//***
import net.minecraft.block.BlockHalfSlab;
// ***
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod( channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false)
public class TutorialMain
{
	public static final String modid = ModInfo.MODID;

	@Instance(value = ModInfo.MODID)
	public static TutorialMain instance;

	@SidedProxy( clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LogHelper.init();
		LogHelper.log(Level.INFO, "Loading LogHelper...");

		//Proxy Renderers & sounds
		LogHelper.log(Level.INFO, "Preparing renderers and sounds");
		proxy.initRenderers();
		proxy.initSounds();
		LogHelper.log(Level.INFO, "Renderers and sounds loaded");

		// Blocks
		LogHelper.log(Level.INFO, "Preparing blocks");
		Blocks.init();
		Blocks.addNames();
		LogHelper.log(Level.INFO, "Blocks loaded");

		// Items
		LogHelper.log(Level.INFO, "Preparing items");
		Items.init();
		Items.addNames();
		LogHelper.log(Level.INFO, "Items loaded");

		// Recipes
		LogHelper.log(Level.INFO, "Preparing recipes");
		Recipes.init();
		LogHelper.log(Level.INFO, "Recipes loaded");
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		// ***
		// Kind of not sure what this does. Differencing between slab sub-types? Correction/confirmation is apprciated.
		for (int i=0; i<TutorialSlabBlock.blockStepTypes.length; i++) {
			ItemStack tutorialslab = new ItemStack(tutorial.blocks.Blocks.tutorialhalfslabBlock, 1, i);
			LanguageRegistry.addName(tutorialslab, TutorialSlabBlock.blockStepTypes[i]);
		    }
		
		// ***
		// Adds the slab name, via string and config classes
		LanguageRegistry.instance().addStringLocalization(((tutorial.blocks.TutorialSlabBlock)tutorial.blocks.Blocks.tutorialslabBlock).getFullSlabName(0)+".name", tutorial.lib.config.Names.tutorialslabBlock_name);
	}

	@EventHandler
	public void load(FMLPostInitializationEvent event)
	{

	}

}