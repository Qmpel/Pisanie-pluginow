package me.kamilkime.youtube;

import java.util.HashMap;
import java.util.Map;

import kamilkime.KApi.KApi;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

public class AirSigil implements Listener{

	private Map<String, Boolean> fall = new HashMap<String, Boolean>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getPlayer().getItemInHand() !=null){
			if(e.getPlayer().getItemInHand().getType().equals(Material.FEATHER)){
				if(e.getPlayer().getItemInHand().getItemMeta().hasEnchant(Enchantment.PROTECTION_FALL)){
					if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
						if(e.getPlayer().getGameMode().equals(GameMode.SURVIVAL) || e.getPlayer().getGameMode().equals(GameMode.ADVENTURE)){
							KApi.changePlayerVelocity(e.getPlayer(), e.getPlayer().getLocation().getDirection().getX(), e.getPlayer().getLocation().getDirection().getY(), e.getPlayer().getLocation().getDirection().getZ(), 5);
							int i = e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_FALL);
							if(i > 0){
								e.getPlayer().getItemInHand().removeEnchantment(Enchantment.PROTECTION_FALL);
								e.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_FALL, i-1);
								i=0;
}
							else{
								e.getPlayer().getItemInHand().removeEnchantment(Enchantment.PROTECTION_FALL);
}
							fall.put(e.getPlayer().getName(), true);
							return;
}
						if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
							KApi.changePlayerVelocity(e.getPlayer(), e.getPlayer().getLocation().getDirection().getX(), e.getPlayer().getLocation().getDirection().getY(), e.getPlayer().getLocation().getDirection().getZ(), 10);
							e.getPlayer().getItemInHand().removeEnchantment(Enchantment.PROTECTION_FALL);
							e.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 100);
							return;
}
}
}
}
}
}
	@EventHandler
	public void onDmg(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(e.getCause().equals(DamageCause.FALL)){
				if(fall.containsKey(p.getName())){
					e.setDamage(0);
					fall.remove(p.getName());
}
}
}
}
}