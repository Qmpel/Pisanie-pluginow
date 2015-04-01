package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main instance;
	public static List<ItemToDrop> drops = new ArrayList<ItemToDrop>();
	
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		DataLoader.loadBlocks();
		DataLoader.loadMobs();
	}
	
	public void onDisable() {}

	public static Main getInst() {
		return instance;
	}
}