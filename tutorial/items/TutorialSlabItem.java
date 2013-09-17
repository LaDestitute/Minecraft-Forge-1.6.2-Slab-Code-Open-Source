package tutorial.items;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.Icon;

import tutorial.items.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TutorialSlabItem extends ItemSlab {

	// Sets the ID, and half/double state for the slab.
  public TutorialSlabItem(int id, BlockHalfSlab halfSlab, BlockHalfSlab doubleSlab, boolean par4) {
    super(id, halfSlab, doubleSlab, par4);
  }

}