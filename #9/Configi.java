package me.kamilkime.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Configi implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("config")){
			if(args.length !=1){
				return true;
			}
			if(!(sender instanceof Player)){
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("set")){
				String pn = p.getName().toLowerCase();
				String ip = p.getAddress().getAddress().toString().replaceAll("/", "");
				String uuid = p.getUniqueId().toString();
				Main.getInst().getConfig().set("players." + pn + ".uuid", uuid);
				Main.getInst().getConfig().set("players." + pn + ".ip", ip);
				Main.getInst().saveConfig();
				return true;
			}
			if(args[0].equalsIgnoreCase("get")){
				String pn = p.getName().toLowerCase();
				if(Main.getInst().getConfig().get("players." + pn) !=null){
					p.sendMessage("§6§lIP adress: §7§l" + Main.getInst().getConfig().getString("players." + pn + ".ip"));
					p.sendMessage("§6§lUUID: §7§l" + Main.getInst().getConfig().getString("players." + pn + ".uuid"));
				}
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(args.length !=1){
				return true;
			}
			if(!(sender instanceof Player)){
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("set")){
				Location l = p.getLocation();
				Main.getInst().getConfig().set("spawnLocX", l.getX());
				Main.getInst().getConfig().set("spawnLocY", l.getY());
				Main.getInst().getConfig().set("spawnLocZ", l.getZ());
				Main.getInst().getConfig().set("spawnLocWorld", l.getWorld().getName());
				Main.getInst().saveConfig();
				return true;
			}
			if(args[0].equalsIgnoreCase("get")){
				double x = Main.getInst().getConfig().getDouble("spawnLocX");
				double y = Main.getInst().getConfig().getDouble("spawnLocY");
				double z = Main.getInst().getConfig().getDouble("spawnLocZ");
				String wName =  Main.getInst().getConfig().getString("spawnLocWorld");
				Location l = new Location(Bukkit.getWorld(wName),x,y,z);
				p.teleport(l);
				return true;
			}
		}
		return false;
	}
}