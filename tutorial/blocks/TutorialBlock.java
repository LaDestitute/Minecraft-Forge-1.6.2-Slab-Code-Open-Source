package tutorial.blocks;

import tutorial.TutorialMain;
import tutorial.lib.config.Names;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class TutorialBlock extends Block
{

	public TutorialBlock(int id)
	{

		//Don't forget the setUnlocalizedName part. It's vital.
		super(id, Material.rock);
		this.setUnlocalizedName(Names.tutorialBlock_unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(Block.soundStoneFootstep);
		this.setHardness(2.5F);
		this.setResistance(5.0F);

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(tutorial.lib.ModInfo.MODID + ":" + (this.getUnlocalizedName().substring(5)));
	}

}