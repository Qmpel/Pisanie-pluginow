package me.kamilkime.youtube;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main instance;
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		getCommand("config").setExecutor(new Configi());
		getCommand("spawn").setExecutor(new Configi());
		
		/* getConfig().options().copyDefaults(true);
		saveConfig(); */
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
}