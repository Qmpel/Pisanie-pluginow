package me.kamilkime.youtube;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LaunchPad implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Location to = e.getTo(); 
		Location from = e.getFrom();
		Location l = e.getPlayer().getLocation();
		if ((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ()) || (from.getWorld() != to.getWorld())) {
			if(l.getBlock().getType().equals(Material.STONE_PLATE) && l.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.EMERALD_BLOCK)){
				e.getPlayer().setVelocity(new Vector(l.getDirection().getX(), l.getDirection().getY() + 0.5, l.getDirection().getZ()).multiply(2));
			}
		}
	}
}