package tutorial.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;


public class ConfigHandler {
public static void init(File configFile) {
Configuration config = new Configuration(configFile);

config.load();

// Blocks
IDs.tutorialBlock_actual = config.getBlock(Names.tutorialBlock_name, IDs.tutorialBlock_default).getInt();
// ***
IDs.tutorialslabBlock_actual = config.getBlock(Names.tutorialslabBlock_name, IDs.tutorialslabBlock_default).getInt();
IDs.tutorialhalfslabBlock_actual = config.getBlock(Names.tutorialhalfslabBlock_name, IDs.tutorialhalfslabBlock_default).getInt();

// Items

IDs.tutorialItem_actual = config.getItem(Names.tutorialItem_name, IDs.tutorialItem_default).getInt() - 256;
// ***
IDs.tutorialslabItem_actual = config.getItem(Names.tutorialslabItem_name, IDs.tutorialslabItem_default).getInt() - 256;
config.save();
}
}