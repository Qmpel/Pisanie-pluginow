package me.kamilkime.youtube;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class Listenery implements Listener{
	
	ItemStack db = new ItemStack(Material.DIAMOND_BLOCK, 1);
	
	@EventHandler
	public void onPrepare(PrepareItemCraftEvent e){
		if(e.getInventory().getResult().equals(db)){
			e.getInventory().setResult(new ItemStack(Material.AIR, 1));
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand() !=null && e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_BARDING)){
			Firework f = e.getClickedBlock().getWorld().spawn(e.getClickedBlock().getLocation().add(0, 1, 0), Firework.class);
			FireworkMeta fm = f.getFireworkMeta();
			fm.addEffect(FireworkEffect.builder()
					.flicker(true)
					.trail(true)
					.with(Type.BALL_LARGE)
					.withColor(Color.WHITE)
					.withColor(Color.RED)
					.withFade(Color.FUCHSIA)
					.build());
			fm.setPower(2);
			f.setFireworkMeta(fm);
		}
	}
	
	@EventHandler
	public void onEnt(PlayerInteractEntityEvent e){
		if(e.getRightClicked() instanceof Cow){
			if(e.getPlayer().getPassenger() !=null){
				e.getPlayer().setPassenger(null);
			}
			e.getPlayer().setPassenger(e.getRightClicked());
		}
	}
}