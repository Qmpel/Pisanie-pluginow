package me.kamilkime.youtube;

import org.bukkit.Bukkit;
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
		if(cmd.getName().equalsIgnoreCase("gracz")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				p.sendMessage("Jestes graczem!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("konsola")){
			sender.sendMessage("Jestes konsola!");
		}
		if(cmd.getName().equalsIgnoreCase("ulecz")){
			if(args.length == 0){
				if(!(sender instanceof Player)){
					sender.sendMessage("§cNie jestes graczem!");
					return false;
				}
				Player p = (Player) sender;
				p.setHealth(20);
				p.setFoodLevel(20);
				p.setFireTicks(0);
				p.sendMessage("Zostales uleczony!");
			}
			if(args.length >= 1){
				String pName = args[0];
				if(Bukkit.getPlayer(pName) !=null){
					Player p = Bukkit.getPlayer(pName);
					p.setHealth(20);
					p.setFoodLevel(20);
					p.setFireTicks(0);
					p.sendMessage("Zostales uleczony!");
				} else{
					sender.sendMessage("§c§lNie ma takiego gracza na serwerze!");
				}
			}
		}
		return false;
	}
}