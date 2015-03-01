package me.kamilkime.youtube;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class Komendy implements CommandExecutor{
	
	public static Map<String, Furnace> fur = new HashMap<String, Furnace>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("inv")){
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("w")){
				p.openWorkbench(p.getLocation(), true);
			}
			if(args[0].equalsIgnoreCase("b")){
				Inventory inv = Bukkit.createInventory(p, InventoryType.BREWING);
				p.openInventory(inv);
			}
			if(args[0].equalsIgnoreCase("a")){
				Inventory inv = Bukkit.createInventory(p, InventoryType.ANVIL);
				p.openInventory(inv);
			}
			if(args[0].equalsIgnoreCase("e")){
				Inventory inv = Bukkit.createInventory(p, InventoryType.ENCHANTING);
				p.openInventory(inv);
			}
			if(args[0].equalsIgnoreCase("e2")){
				p.openEnchanting(p.getLocation(), true);
			}
			if(args[0].equalsIgnoreCase("f")){
				Location l = p.getLocation();
				l.setY(255);
				l.getBlock().setType(Material.FURNACE);
				Furnace f = (Furnace) l.getBlock().getState();
				fur.put(p.getName(), f);
				p.openInventory(f.getInventory());
			}
		}
		return false;
	}
}