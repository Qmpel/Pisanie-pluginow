package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listenery implements Listener{
	
	Inventory inv;
	
	public Listenery(){
		inv = Bukkit.createInventory(null, 9, "§5§lTeleportation menu");{
			inv.setItem(0, blank);
			inv.setItem(1, blank);
			inv.setItem(2, ow);
			inv.setItem(3, blank);
			inv.setItem(4, nw);
			inv.setItem(5, blank);
			inv.setItem(6, ew);
			inv.setItem(7, blank);
			inv.setItem(8, blank);
		}
	}
	
	ItemStack compass = new ItemStack(Material.COMPASS, 1);{
		ItemMeta im = compass.getItemMeta();
		im.setDisplayName("§c§lTeleporter");
		compass.setItemMeta(im);
	}
	
	ItemStack ow = new ItemStack(Material.GRASS, 1);{
		ItemMeta im = ow.getItemMeta();
		im.setDisplayName("§a§lOverworld");
		ow.setItemMeta(im);
	}
	
	ItemStack nw = new ItemStack(Material.NETHERRACK, 1);{
		ItemMeta im = nw.getItemMeta();
		im.setDisplayName("§4§lNether");
		nw.setItemMeta(im);
	}
	
	ItemStack ew = new ItemStack(Material.ENDER_STONE, 1);{
		ItemMeta im = ew.getItemMeta();
		im.setDisplayName("§9§lEnd");
		ew.setItemMeta(im);
	}
	
	ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);{
		ItemMeta im = blank.getItemMeta();
		im.setDisplayName(" ");
		blank.setItemMeta(im);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(!e.getPlayer().getInventory().containsAtLeast(compass, 1)){
			e.getPlayer().getInventory().addItem(compass);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getPlayer().getItemInHand() !=null && e.getPlayer().getItemInHand().getType().equals(Material.COMPASS)
				&& e.getPlayer().getItemInHand().getItemMeta().hasDisplayName()
				&& e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(compass.getItemMeta().getDisplayName())){
			e.getPlayer().openInventory(inv);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Inventory i = e.getInventory();
		if(i == null){
			return;
		}
		if(i !=null){
			if(!i.getName().equals(inv.getTitle())){
				return;
			}
			if (e.getCurrentItem() == null){
				return;
			}
			else{
				if(e.getCurrentItem().getItemMeta() == null){
					return;
				}
			}
		}
		if(e.getWhoClicked() instanceof Player){
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem().getItemMeta() !=null){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ow.getItemMeta().getDisplayName())){
					p.teleport(new Location(Bukkit.getWorlds().get(0), 0, 100, 0));
					e.setCancelled(true);
					e.setCursor(new ItemStack(Material.AIR, 1));
					p.updateInventory();
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals(nw.getItemMeta().getDisplayName())){
					p.teleport(new Location(Bukkit.getWorlds().get(1), 0, 132, 0));
					e.setCancelled(true);
					e.setCursor(new ItemStack(Material.AIR, 1));
					p.updateInventory();
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ew.getItemMeta().getDisplayName())){
					p.teleport(new Location(Bukkit.getWorlds().get(2), 0, 100, 0));
					e.setCancelled(true);
					e.setCursor(new ItemStack(Material.AIR, 1));
					p.updateInventory();
				} else{
					e.setCancelled(true);
					e.setCursor(new ItemStack(Material.AIR, 1));
					p.updateInventory();
					p.closeInventory();
				}
			}
		}
	}
}