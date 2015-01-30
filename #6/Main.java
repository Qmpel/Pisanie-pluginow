package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		System.out.println("Uruchamianie...");
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		
		getCommand("spawn").setExecutor(new Cmds());
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
}