package tutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
// *** V
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tutorial.lib.config.IDs;
import tutorial.lib.config.Names;

public class Blocks {
public static Block tutorialBlock;
// ***
public static BlockHalfSlab tutorialslabBlock;
public static BlockHalfSlab tutorialhalfslabBlock;

public static void init() {
tutorialBlock = new TutorialBlock(IDs.tutorialBlock_actual);
GameRegistry.registerBlock(tutorialBlock, Names.tutorialBlock_name);
MinecraftForge.setBlockHarvestLevel(tutorialBlock, "pickaxe", 1);

// ***
tutorialslabBlock = new TutorialSlabBlock(IDs.tutorialslabBlock_actual, true, null);
GameRegistry.registerBlock(tutorialslabBlock, Names.tutorialslabBlock_name);
MinecraftForge.setBlockHarvestLevel(tutorialslabBlock, "pickaxe", 1);

// ***
tutorialhalfslabBlock = new TutorialSlabBlock(IDs.tutorialhalfslabBlock_actual, false, null);
GameRegistry.registerBlock(tutorialhalfslabBlock, Names.tutorialhalfslabBlock_name);
MinecraftForge.setBlockHarvestLevel(tutorialhalfslabBlock, "pickaxe", 1);

}

public static void addNames() {
LanguageRegistry.addName(tutorialBlock, Names.tutorialBlock_name);
// ***
LanguageRegistry.addName(tutorialslabBlock, Names.tutorialslabBlock_name);

}

}