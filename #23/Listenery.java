package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listenery implements Listener, CommandExecutor{
	
	public static Boolean chat;
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if(!chat){
			if(!e.getPlayer().hasPermission("chat.bypass")){
				e.getPlayer().sendMessage("§cChat wylaczony!");
				e.setCancelled(true);
			}
		}
		if(e.getPlayer().isOp()){
			e.setFormat("§7§l[§c§lOP§7§l] §a%s§8§l: §b§l%s");
		} else{
			e.setFormat("§9%s§8§l: §7%s");
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("chat")){
			if(args.length !=1){
				return true;
			}
			if(args[0].equalsIgnoreCase("on")){
				if(chat){
					sender.sendMessage("chat wlaczony!");
					return true;
				}
				chat = true;
			}
			if(args[0].equalsIgnoreCase("off")){
				if(!chat){
					sender.sendMessage("chat wylaczony!");
					return true;
				}
				chat = false;
			}
			if(args[0].equalsIgnoreCase("toggle")){
				chat = !chat;
			}
			if(args[0].equalsIgnoreCase("clear")){
				int i = 0;
				while(i < 101){
					Bukkit.broadcastMessage("");
					i++;
				}
				Bukkit.broadcastMessage("§a§lChat wyczyszczony!");
			}
		}
		return false;
	}
}