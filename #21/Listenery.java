package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listenery implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.getPlayer().sendMessage("§6§lAktualnie on-line: §a§l" + Bukkit.getOnlinePlayers().length + " §6§lgraczy");
		e.getPlayer().sendMessage("§6§lDotad odwiedzilo nas: §a§l" + Bukkit.getOfflinePlayers().length + " §6§lgraczy");
	}
}