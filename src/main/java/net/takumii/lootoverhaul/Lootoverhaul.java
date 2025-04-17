package net.takumii.lootoverhaul;

import net.fabricmc.api.ModInitializer;

import net.takumii.lootoverhaul.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Just getting started with this mod. It's going to be good
public class Lootoverhaul implements ModInitializer {
	public static final String MOD_ID = "lootoverhaul";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		System.out.println("Loot Overhaul has loaded!");
		ModLootTableModifiers.modifyLootTables();




	}
}