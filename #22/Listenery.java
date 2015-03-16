package me.kamilkime.youtube;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listenery implements Listener{
	
	/*
	  Umieszczono dodawanie board'a w tasku.
	  Nie wiadomo czemu, ale tak po prostu musi być :/
	  W przeciwnym razie - wywala blad...
	*/
	
	@EventHandler
	public void onJoin(final PlayerJoinEvent e){
		new BukkitRunnable() {
			public void run() {
				e.getPlayer().setScoreboard(Main.sb);
				Main.nicks.add(e.getPlayer().getName());
			}
		}.runTask(Main.getInst());
	}

}
