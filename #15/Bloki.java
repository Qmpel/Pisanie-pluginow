package me.kamilkime.youtube;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class Bloki implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand() !=null && e.getPlayer().getItemInHand().getType().equals(Material.GOLD_SWORD)){
			Block b = e.getPlayer().getTargetBlock(null, 5);
			FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
			b.setType(Material.AIR);
			fb.setVelocity(new Vector(fb.getVelocity().getX(), 2, fb.getVelocity().getZ()));
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), e.getBlock().getType(), e.getBlock().getData());
		e.getBlock().setType(Material.AIR);
	}
}