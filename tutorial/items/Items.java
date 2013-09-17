package tutorial.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.registry.LanguageRegistry;

import tutorial.lib.config.IDs;
import tutorial.lib.config.Names;

public class Items {
//Section for public static names
public static Item tutorialItem;
// ***
public static Item tutorialslabItem;
public static Item tutorialhalfslabItem;

public static void init() {
//Section for adding the items
tutorialItem = new TutorialItem(IDs.tutorialItem_actual);
// ***
// Sets the ID of the slab item to the ID of the slab block, but minus 256. Also gets the true/false for if slab is one slab or two stacked slabs.
tutorialhalfslabItem = new TutorialSlabItem(tutorial.blocks.Blocks.tutorialhalfslabBlock.blockID - 256, tutorial.blocks.Blocks.tutorialhalfslabBlock, tutorial.blocks.Blocks.tutorialslabBlock, false);
tutorialslabItem = new TutorialSlabItem(tutorial.blocks.Blocks.tutorialslabBlock.blockID - 256, tutorial.blocks.Blocks.tutorialhalfslabBlock, tutorial.blocks.Blocks.tutorialslabBlock, true);
}

public static void addNames() {
//Section for registering item names
LanguageRegistry.addName(tutorialItem, Names.tutorialItem_name);
// ***
LanguageRegistry.addName(tutorialslabItem, Names.tutorialslabItem_name);

}
}