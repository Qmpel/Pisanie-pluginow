package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin{

	private static Main instance;
	public static Scoreboard sb;
	private Objective ob;
	public static List<String> nicks = new ArrayList<String>();
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new Listenery(), this);
		
		ScoreboardManager sm = Bukkit.getScoreboardManager();
		sb = sm.getNewScoreboard();
		Objective hp = sb.registerNewObjective("hpGracza", "health");
		ob = sb.registerNewObjective("obj", "dummy");
		hp.setDisplayName(ChatColor.RED + "♥");
		ob.setDisplayName("§a§lNazwa tablicy");
		hp.setDisplaySlot(DisplaySlot.BELOW_NAME);
		ob.setDisplaySlot(DisplaySlot.SIDEBAR);
		refresh();
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
	
	/*
	  Poprawiono loop'a for(String s : nicks)
	  Nie wywala już bledu 'ConcurrentModificationException'
	*/
	
	private void refresh(){
		Bukkit.getScheduler().runTaskTimer(this, new Runnable(){
			public void run(){
				for(String s : nicks){
					if(Bukkit.getPlayer(s) !=null){
						Player p = Bukkit.getPlayer(s);
						Score s1 = ob.getScore(Bukkit.getOfflinePlayer(""));
						s1.setScore(4);
						Score s2 = ob.getScore(Bukkit.getOfflinePlayer("Kills: §a67"));
						s2.setScore(3);
						Score s3 = ob.getScore(Bukkit.getOfflinePlayer("Deaths: §638"));
						s3.setScore(2);
						p.setScoreboard(sb);
						Bukkit.broadcastMessage(s);
					}
				}
			}
		}, 0, 40);
	}
}
