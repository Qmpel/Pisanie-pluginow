package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main instance;
	private List<String> msgs = new ArrayList<String>();{
		msgs.add("§6§lAutoMsg 1");
		msgs.add("§c§lAutoMsg 2");
		msgs.add("§a§lAutoMsg 3");
		msgs.add("§b§lAutoMsg 4");
		msgs.add("§d§lAutoMsg 5");
		msgs.add("§5§lAutoMsg 6");
	}
	private int msgNum;
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		getCommand("timer").setExecutor(new Schedulery());
		Bukkit.getPluginManager().registerEvents(new Schedulery(), this);
		msgNum = 0;
		autoMsg(msgs);
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
	
	private void autoMsg(final List<String> msg){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run(){
				Bukkit.broadcastMessage("§7§l[INFO] " + msg.get(msgNum));
				msgNum++;
				if(msgNum == 6){
					msgNum = 0;
				}
			}
		}, 0, 10*20);
	}
}