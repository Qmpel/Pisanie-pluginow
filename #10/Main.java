package me.kamilkime.youtube;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main instance;
	public List<String> msgs;
	int i;
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		getCommand("automsg").setExecutor(new Configi());
		getCommand("warp").setExecutor(new Configi());
		saveDefaultConfig();
		msgs = getConfig().getStringList("autoMsg");
		autoMsg();
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
	
	private void autoMsg(){
		i = 0;
		Bukkit.getScheduler().runTaskTimer(this, new Runnable(){
			public void run(){
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msgs.get(i)));
				i++;
				if(i == msgs.size()){
					i = 0;
				}
			}
		}, 0, 100);
	}
}