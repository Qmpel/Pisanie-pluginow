package me.kamilkime.youtube;

import java.util.HashMap;
import java.util.Map;

import kamilkime.KApi.KApi;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Schedulery implements CommandExecutor, Listener{

	private int i;
	private int taskID;
	private Map<String, Integer> timer = new HashMap<String, Integer>();
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(cmd.getName().equalsIgnoreCase("timer")){
			if(args.length !=1){
				return false;
			}
			try{
				i = Integer.parseInt(args[0]);
			} catch(Exception e){
				return false;
			}
			if(timer.containsKey("Timer")){
				Bukkit.getScheduler().cancelTask(timer.get("Timer"));
				timer.remove("Timer");
			}
			taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInst(), new Runnable(){
				public void run(){
					if(!(i <= -1)){
						if(i == 0){
							Bukkit.broadcastMessage("§a§lStart!");
							i--;
							Bukkit.getScheduler().cancelTask(taskID);
							timer.remove("Timer");
						} else{
							Bukkit.broadcastMessage("§7§l[Timer] §6§l" + i);
							i--;
						}
					}
				}
			}, 0, 20);
			timer.put("Timer", taskID);
		}
		return false;
	}
	
	@EventHandler
	public void onJoin(final PlayerJoinEvent e){
		Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable(){
			public void run(){
				KApi.sendClickableMessage(e.getPlayer(), "§a§lClick me!", "§6§lYES, CLICK ME !!!", "open_url", "http://youtube.pl/kamilkime");
			}
		}, 5*20);
	}
}