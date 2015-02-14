package me.kamilkime.youtube;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Komendy implements CommandExecutor{

	public static Map<String, BukkitTask> tp = new HashMap<String, BukkitTask>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(!(sender instanceof Player)){
				sender.sendMessage("§cMusisz byc na serwerze!");
				return true;
			}
			final Player p = (Player) sender;
			if(tp.containsKey(p.getName())){
				((BukkitTask)tp.remove(p.getName())).cancel();
			}
			p.sendMessage("§aTeleportacja nastapi za 5 sek.");
			BukkitTask bt = Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable(){
				public void run(){
					p.teleport(p.getWorld().getSpawnLocation());
					((BukkitTask)tp.remove(p.getName())).cancel();
				}
			}, 5*20);
			tp.put(p.getName(), bt);
		}
		return false;
	}
}