package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable(){
		System.out.println("Uruchamianie...");
		Bukkit.getPluginManager().registerEvents(new Main(), this);
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	@EventHandler(ignoreCancelled=true, priority=EventPriority.HIGH)
	public void onPlace(BlockPlaceEvent e){
		if(e.getBlock().getType().equals(Material.TNT)){
			e.setCancelled(true);
		}
	}
}