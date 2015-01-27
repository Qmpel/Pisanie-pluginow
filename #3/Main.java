package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;
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
		if(cmd.getName().equalsIgnoreCase("pogoda")){
			if(args.length == 1){
				if(sender instanceof Player){
					World w = ((Player)sender).getWorld();
					if(args[0].equalsIgnoreCase("s")){
						w.setStorm(false);
						w.setThundering(false);
						return true;
					}
					if(args[0].equalsIgnoreCase("d")){
						w.setStorm(true);
						w.setThundering(false);
						return true;
					}
					if(args[0].equalsIgnoreCase("b")){
						w.setStorm(true);
						w.setThundering(true);
						return true;
					} else {
						sender.sendMessage("§cMozliwe argumenty: s, d, b");
					}
				}
			}
			if(args.length == 2){
				String nazwa = args[1];
				if(Bukkit.getWorld(nazwa) !=null){
					World w = Bukkit.getWorld(nazwa);
					if(args[0].equalsIgnoreCase("s")){
						w.setStorm(false);
						w.setThundering(false);
						return true;
					}
					if(args[0].equalsIgnoreCase("d")){
						w.setStorm(true);
						w.setThundering(false);
						return true;
					}
					if(args[0].equalsIgnoreCase("b")){
						w.setStorm(true);
						w.setThundering(true);
						return true;
					} else {
						sender.sendMessage("§cMozliwe argumenty: s, d, b");
					}
				} else{
					sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nie ma takiego swiata!");
				}
			} 
			else{
				sender.sendMessage("§cZla liczba argumentow!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("czas")){
			if(sender.hasPermission("youtube.czas")){
				if(args.length == 2){
					String nazwa = args[1];
					if(Bukkit.getWorld(nazwa) !=null){
						World w = Bukkit.getWorld(nazwa);
						Long l = Long.parseLong(args[0]);
						w.setTime(l);
					} else{
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nie ma takiego swiata!");
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("reverse")){
			if(!sender.hasPermission("youtube.reverse")){
				return false;
			}
			if(args.length !=1){
				return false;
			}
			String nazwa = args[0];
			if(Bukkit.getWorld(nazwa) !=null){
				World w = Bukkit.getWorld(nazwa);
				w.setPVP(!w.getPVP());
				w.setDifficulty(Difficulty.EASY);
			}
		}
		return false;
	}
}