package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main instance;
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new Listenery(), this);
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
}