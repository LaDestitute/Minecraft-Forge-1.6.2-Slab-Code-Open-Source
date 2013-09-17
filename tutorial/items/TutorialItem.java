package tutorial.items;

import tutorial.TutorialMain;
import tutorial.lib.config.Names;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TutorialItem extends Item {

	public TutorialItem(int id) 
	{
		super(id);
		this.setUnlocalizedName(Names.tutorialItem_unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(tutorial.lib.ModInfo.MODID + ":" + (this.getUnlocalizedName().substring(5)));
	}

}