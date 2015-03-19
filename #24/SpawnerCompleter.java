package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.CreatureType;

@SuppressWarnings("deprecation")
public class SpawnerCompleter implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawner")){
			if(args.length !=1){
				return null;
			}
			String arg0 = args[0];
			List<String> types = new ArrayList<String>();
			for(CreatureType ct : CreatureType.values()){
				types.add(ct.getName().toUpperCase());
			}
			if(arg0.equalsIgnoreCase("")){
				return types;
			}
			List<String> toReturn = new ArrayList<String>();
			for(String s : types){
				if(s.startsWith(arg0.toUpperCase())){
					toReturn.add(s);
				}
			}
			return toReturn;
		}
		return null;
	}
}