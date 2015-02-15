package me.kamilkime.youtube;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Komendy implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("komenda")){
			if(args.length == 1){
				if(args[0].equals("string")){
					sender.sendMessage("STRING");
				}
				if(args[0].equals("int")){
					sender.sendMessage("INT");
				}
				if(args[0].equals("double")){
					sender.sendMessage("DOUBLE");
				}
				if(args[0].equals("long")){
					sender.sendMessage("LONG");
				}
				if(args[0].equals("boolean")){
					sender.sendMessage("BOOLEAN");
				}
				if(args[0].equals("void")){
					sender.sendMessage("VOID");
				}
			}
			if(args.length == 2){
				if(args[0].equals("file")){
					if(args[1].equalsIgnoreCase("yamlcfg")){
						sender.sendMessage("YAMLCONFIGURATION");
					}
					if(args[1].equalsIgnoreCase("filecfg")){
						sender.sendMessage("FILECONFIGURATION");
					}
				}
				if(args[0].equals("type")){
					if(args[1].equalsIgnoreCase("static")){
						sender.sendMessage("STATIC");
					}
					if(args[1].equalsIgnoreCase("final")){
						sender.sendMessage("FINAL");
					}
				}
			} else{
				return true;
			}
		}
		return false;
	}
}