package me.kamilkime.youtube;

import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class Listenery implements Listener{

	@EventHandler
	public void onClose(InventoryCloseEvent e){
		if(e.getInventory().getType().equals(InventoryType.FURNACE)){
			if(Komendy.fur.containsKey(e.getPlayer().getName())){
				Furnace f = Komendy.fur.get(e.getPlayer().getName());
				/* Zapomniałem powiedzieć!
				   getContents() - służy do zwrócenia tabeli, której zawartość 
				   stanowią wszystkie ItemStacki znajdujące się w danym Inventory﻿
				*/
				for(ItemStack is : f.getInventory().getContents()){
					if(is !=null && is.getType() !=null && is.getType() != Material.AIR){
						e.getPlayer().getInventory().addItem(is);
					}
				}
				f.getInventory().setContents(new ItemStack[3]);
				f.getBlock().setType(Material.AIR);
				Komendy.fur.remove(e.getPlayer().getName());
			}
		}
	}
}
