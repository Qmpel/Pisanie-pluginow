package me.kamilkime.youtube;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class Craftingi implements Listener{
	
	@EventHandler
	public void onPrepare(PrepareItemCraftEvent e){
		if(e.isRepair()){
			e.getInventory().setResult(new ItemStack(Material.AIR, 1));
		}
		if((e.getInventory().getResult() !=null) && (e.getInventory().getResult().equals(Main.is))){
			if((e.getInventory().getItem(2) !=null) && (e.getInventory().getItem(2).hasItemMeta()) && (e.getInventory().getItem(2).getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)) && (e.getInventory().getItem(2).getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4)
					&& (e.getInventory().getItem(5) !=null) && (e.getInventory().getItem(5).hasItemMeta()) && (e.getInventory().getItem(5).getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)) && (e.getInventory().getItem(5).getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4)
					&& (e.getInventory().getItem(8) !=null) && (e.getInventory().getItem(8).hasItemMeta()) && (e.getInventory().getItem(8).getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)) && (e.getInventory().getItem(8).getItemMeta().getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4)){
				return;
			} else{
				e.getInventory().setResult(new ItemStack(Material.AIR, 1));
			}
		}
	}
}