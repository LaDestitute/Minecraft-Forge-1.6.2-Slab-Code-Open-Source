package tutorial.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import tutorial.TutorialMain;
import tutorial.lib.config.Names;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

  public class TutorialSlabBlock extends BlockHalfSlab {
	  
	  // String for setting slab sub-types. Haven't figured this out, so this will come later.
    public static String[] blockStepTypes = new String[]{ "sapphireSlab" };
    
    @SideOnly(Side.CLIENT)
    private Icon sideIcon[];

	public TutorialSlabBlock(int id, boolean DoubleSlab, Material par3Material) {
	// You can customize the Material, Hardness, Resistance, StepSound if you wish.
	// I recommend:
	// 5.0F(Hardness)/30.0F(Resistance) for metal and gemstone
    // 3.0F(Hardness)/20.0F(Resistance) for stone
	// 2.0F(Hardness)/15.0F(Resistance) for wood
    // Also, for wood, don't forget to add:
	// setBurnProperties(this.blockID, 5, 20);
    super(id, DoubleSlab, Material.rock);
    this.setCreativeTab(CreativeTabs.tabBlock);
    setHardness(3.0F);
    setResistance(20.0F);
    setStepSound(soundStoneFootstep);
    // The flag for if this block should use neighbor blocks as it's brightness value
    useNeighborBrightness[this.blockID] = true;
  }

	// A bit for getting the full slab name, depending on sub-type
  @Override
  public String getFullSlabName(int meta) {
    if (meta < 0 || meta >= blockStepTypes.length) {
      meta = 0;
    }

    return getUnlocalizedName() + "." + blockStepTypes[meta];
  }

  // Registering the textures for the slab. 
  // This has support for side and multiple sub-type textures!
  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister par1IconRegister) {
    sideIcon = new Icon[2];
    blockIcon = par1IconRegister.registerIcon("ladestitute_tutorial:tutorialslabBlock");
    sideIcon[0] = par1IconRegister.registerIcon("ladestitute_tutorial:tutorialslabsideBlock");
  }

  /**
   * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
   */
  @SideOnly(Side.CLIENT)
  public Icon getBlockTextureFromSideAndMetadata(int side, int metadata) {
    int k = metadata & 7;
    if (k == 1) return sideIcon[1];
    if (isDoubleSlab && (metadata & 8) != 0) {
      side = 1;
    }
    return (side != 1 || side != 0) ? blockIcon : sideIcon[0];
  }

  /**
   * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
   */
  @SideOnly(Side.CLIENT)
  public Icon getIcon(int side, int meta) {
    int k = meta & 7;

    if (k == 0) {
      if (side == 0 || side == 1) return blockIcon;
      return sideIcon[0];
    }
    return sideIcon[k];
  }

  /**
   * Takes a block ID, returns true if it's the same as the ID for a stone or wooden single slab.
   */
  @SideOnly(Side.CLIENT)
  private static boolean isBlockSingleSlab(int par0) {
    return par0 == tutorial.blocks.Blocks.tutorialhalfslabBlock.blockID;
  }

  /**
   * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
   */
  @SideOnly(Side.CLIENT)
  public int idPicked(World par1World, int par2, int par3, int par4) {
    return tutorial.blocks.Blocks.tutorialhalfslabBlock.blockID;
  }

  //Tells game what slab sub-type drops on destruction
  public int idDropped(int par1, Random par2Random, int par3) {
    return tutorial.blocks.Blocks.tutorialhalfslabBlock.blockID;
  }

  // The bit of code that creates a stacked slab block if two are stacked together
  @Override
  protected ItemStack createStackedBlock(int meta) {
    return new ItemStack(tutorial.blocks.Blocks.tutorialhalfslabBlock.blockID, 2, meta & 7);
  }

  // Gets the sub-block type
  @SuppressWarnings("unchecked")
  @Override
  public void getSubBlocks(int id, CreativeTabs par2CreativeTabs, List par3List) {
    if (id != tutorial.blocks.Blocks.tutorialslabBlock.blockID) {
      for (int i = 0; i < blockStepTypes.length; i++) {
        par3List.add(new ItemStack(id, 1, i));
      }
    }
  }

}