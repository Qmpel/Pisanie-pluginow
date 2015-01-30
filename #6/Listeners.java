package me.kamilkime.youtube;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Listeners implements Listener{

	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		if(e.getEntity().getType().equals(EntityType.PRIMED_TNT)){
			e.getLocation().getWorld().spawnEntity(e.getLocation().add(1, 1, 1), EntityType.PRIMED_TNT);
			e.getLocation().getWorld().spawnEntity(e.getLocation().subtract(1, 0, 1), EntityType.PRIMED_TNT);
		}
	}
}