package me.kamilkime.youtube;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listenery implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.getPlayer().setScoreboard(Main.sb);
		Main.nicks.add(e.getPlayer().getName());
	}
}