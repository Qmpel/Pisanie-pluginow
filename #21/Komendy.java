package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Komendy implements CommandExecutor{

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("kban")){
			OfflinePlayer p;
			try{
				p = Bukkit.getOfflinePlayer(args[0]);
			} catch(Exception e){
				return true;
			}
			
			p.setBanned(true);
			if(p.isOnline()){
				Player op = (Player) p;
				op.kickPlayer("Zostales zbanowany!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("kkick")){
			Player p;
			try{
				p = Bukkit.getPlayer(args[0]);
			} catch(Exception e){
				return true;
			}
			p.kickPlayer("Zostales wyrzucony z serwera!");
		}
		if(cmd.getName().equalsIgnoreCase("klist")){
			Player[] plrs = Bukkit.getOnlinePlayers();
			String s = "";
			for(int i = 0; i < plrs.length; i++){
				s += ChatColor.AQUA + ", " + ChatColor.GRAY + plrs[i].getName();
			}
			sender.sendMessage("§6§lAktualnie on-line:" + s.replaceFirst(", ", " "));
		}
		return false;
	}
}