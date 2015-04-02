package me.kamilkime.youtube;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathListener implements Listener{

	@EventHandler
	public void onDeath(EntityDeathEvent e){
		for(ItemToDrop i : Main.drops){
			if(i.getType().equals(DropType.MOB)){
				if(Utils.getChance(i.getChance())){
					if(i.getMob().equals(e.getEntityType())){
						if(e.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
							EntityDamageByEntityEvent ed = (EntityDamageByEntityEvent) e.getEntity().getLastDamageCause();
							if(ed.getDamager() instanceof Player){
								Player p = (Player) ed.getDamager();
								if(!i.getUseTools() || i.getTools().contains(p.getItemInHand().getType())){
									ItemStack toDrop = i.getDrop();
									int amount = Utils.getRandInt(i.getMinAmount() + p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS),
											i.getMaxAmount() + p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS));
									toDrop.setAmount(amount);
									e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), toDrop);
								}
							}
						}
					}
				}
			}
		}
	}
}