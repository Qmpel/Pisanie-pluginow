package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompletion implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("komenda")){
			List<String> tab = new ArrayList<String>();
			if(args.length == 1){
				String a = args[0].toLowerCase();
				if(a.startsWith("s")){
					tab.add("string");
					return tab;
				}
				if(a.startsWith("d")){
					tab.add("double");
					return tab;
				}
				if(a.startsWith("i")){
					tab.add("int");
					return tab;
				}
				if(a.startsWith("b")){
					tab.add("boolean");
					return tab;
				}
				if(a.startsWith("l")){
					tab.add("long");
					return tab;
				}
				if(a.startsWith("v")){
					tab.add("void");
					return tab;
				}
				if(a.equalsIgnoreCase("")){
					tab.add("string");
					tab.add("double");
					tab.add("int");
					tab.add("boolean");
					tab.add("long");
					tab.add("void");
					Collections.sort(tab);
					return tab;
				}
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("file")){
					if(args[1].toLowerCase().startsWith("y")){
						tab.add("yamlcfg");
						return tab;
					}
					if(args[1].toLowerCase().startsWith("f")){
						tab.add("filecfg");
						return tab;
					}
					if(args[1].equalsIgnoreCase("")){
						tab.add("filecfg");
						tab.add("yamlcfg");
						Collections.sort(tab);
						return tab;
					}
				}
				if(args[0].equalsIgnoreCase("type")){
					if(args[1].toLowerCase().startsWith("s")){
						tab.add("static");
						return tab;
					}
					if(args[1].toLowerCase().startsWith("f")){
						tab.add("final");
						return tab;
					}
					if(args[1].equalsIgnoreCase("")){
						tab.add("static");
						tab.add("final");
						Collections.sort(tab);
						return tab;
					}
				}
			}
		}
		return null;
	}
}