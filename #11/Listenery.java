package me.kamilkime.youtube;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

public class Listenery implements Listener{

	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Location to = e.getTo();
		Location from = e.getFrom();
		if((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ())){
			if(Komendy.tp.containsKey(e.getPlayer().getName())){
				((BukkitTask)Komendy.tp.remove(e.getPlayer().getName())).cancel();
				e.getPlayer().sendMessage("§cTeleportacja anulowana!");
			}
		}
	}
}