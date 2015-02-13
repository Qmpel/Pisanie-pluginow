package me.kamilkime.youtube;

import java.util.List;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Configi implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("warp")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					Set<String> keys = Main.getInst().getConfig().getKeys(false);
					String lista = "";
					for(String s : keys){
						if(!s.equals("autoMsg")){
							lista += ", " + s;
						}
					}
					sender.sendMessage("§bWarpy: §6" + lista.replaceFirst(", ", ""));
				}
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("set")){
					if(Main.getInst().getConfig().get(args[1]) !=null){
						return true;
					}
					Main.getInst().getConfig().set(args[1] + ".x", 0);
					Main.getInst().getConfig().set(args[1] + ".y", 100);
					Main.getInst().getConfig().set(args[1] + ".z", 0);
					Main.getInst().getConfig().set(args[1] + ".world", "world");
					Main.getInst().saveConfig();
				}
				if(args[0].equalsIgnoreCase("remove")){
					if(Main.getInst().getConfig().get(args[1]) !=null){
						Main.getInst().getConfig().set(args[1], null);
						Main.getInst().saveConfig();
					}
				}
			} else{
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("automsg")){
			if(args.length == 0){
				sender.sendMessage("§cZa malo argumentow!");
				return true;
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("list")){
					for(int i = 0; i<Main.getInst().msgs.size(); i++){
						sender.sendMessage("§bID §6" + i + "§7: " + Main.getInst().msgs.get(i));
					}
				}
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("remove")){
					int numer = Integer.parseInt(args[1]);
					Main.getInst().msgs.remove(numer);
					Main.getInst().getConfig().set("autoMsg", Main.getInst().msgs);
				}
			} else{
				if(args[0].equalsIgnoreCase("add")){
					String msg = "";
					for(int i = 1; i<args.length; i++){
						msg += " " + args[i];
					}
					msg.replaceFirst(" ", "");
					List<String> msgs = Main.getInst().getConfig().getStringList("autoMsg");
					msgs.add(msg);
					Main.getInst().msgs = msgs;
					Main.getInst().getConfig().set("autoMsg", msgs);
					Main.getInst().saveConfig();
				}
			}
		}
		return false;
	}
}