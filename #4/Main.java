package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		System.out.println("Uruchamianie...");
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tp")){
			if(args.length == 1){
				if(!(sender instanceof Player)){
					sender.sendMessage("§cNie ma cie na serwerze!");
					return false;
				}
				if(!(Bukkit.getPlayer(args[0]) !=null)){
					sender.sendMessage("§cNie ma takiego gracza!");
					return false;
				}
				Player cel = Bukkit.getPlayer(args[0]);
				Location l = cel.getLocation();
				((Player)sender).teleport(l);
				return true;
			}
			if(args.length == 2){
				if(!(Bukkit.getPlayer(args[0]) !=null)){
					sender.sendMessage("§cNie ma takiego gracza! (args 0)");
					return false;
				}
				if(!(Bukkit.getPlayer(args[1]) !=null)){
					sender.sendMessage("§cNie ma takiego gracza! (args 1)");
					return false;
				}
				Player p = Bukkit.getPlayer(args[0]);
				Player cel = Bukkit.getPlayer(args[1]);
				Location l = new Location(cel.getLocation().getWorld(), cel.getLocation().getX(), cel.getLocation().getY(), cel.getLocation().getZ());
				p.teleport(l);
				return true;
			} else{
				sender.sendMessage("§cZa malo argumentow!");
				return false;
			}
		}
		return false;
	}
}