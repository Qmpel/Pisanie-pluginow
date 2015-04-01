package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class DataLoader{

	public static void loadBlocks(){
		ConfigurationSection cs1 = Main.getInst().getConfig().getConfigurationSection("blockDrop");
		ItemToDrop drop = new ItemToDrop();
		drop.setType(DropType.BLOCK);
		for(String s : cs1.getKeys(false)){
			ConfigurationSection cs = cs1.getConfigurationSection(s);
			Material from = Material.matchMaterial(cs.getString("from").toUpperCase());
			if(from == null){
				Utils.ERROR(s + " -> wrong 'from' type");
				Bukkit.getPluginManager().disablePlugin(Main.getInst());
			}
			drop.setBlock(from);
			Material dm = Material.matchMaterial(cs.getString("drop").toUpperCase());
			if(dm == null){
				Utils.ERROR(s + " -> wrong 'drop' type");
				Bukkit.getPluginManager().disablePlugin(Main.getInst());
			}
			drop.setDrop(new ItemStack(dm, 1, (short) (cs.get("dropData") !=null ? (short)cs.getInt("dropData") : 0)));
			drop.setChance(cs.getDouble("chance"));
			drop.setUseY(cs.getBoolean("useY"));
			if(cs.getBoolean("useY")){
				drop.setMinY(cs.getInt("minY"));
			}
			drop.setMinAmount(cs.getInt("minAmount"));
			drop.setMaxAmount(cs.getInt("maxAmount"));
			drop.setUseTools(cs.getBoolean("useTools"));
			if(cs.getBoolean("useTools")){
				List<Material> m = new ArrayList<Material>();
				for(String t : cs.getStringList("tools")){
					Material tm = Material.matchMaterial(t.toUpperCase());
					if(tm == null){
						Utils.ERROR(s + " -> wrong 'tools' content");
						Bukkit.getPluginManager().disablePlugin(Main.getInst());
					}
					m.add(tm);
				}
				drop.setTools(m);
			}
		}
		Main.drops.add(drop);
	}
	public static void loadMobs(){
		ConfigurationSection cs1 = Main.getInst().getConfig().getConfigurationSection("mobDrop");
		ItemToDrop drop = new ItemToDrop();
		drop.setType(DropType.MOB);
		for(String s : cs1.getKeys(false)){
			ConfigurationSection cs = cs1.getConfigurationSection(s);
			if(EntityType.fromName(cs.getString("from").toUpperCase()) == null){
				Utils.ERROR(s + " -> wrong 'from' type");
				Bukkit.getPluginManager().disablePlugin(Main.getInst());
			}
			drop.setMob(EntityType.fromName(cs.getString("from").toUpperCase()));
			Material dm = Material.matchMaterial(cs.getString("drop").toUpperCase());
			if(dm == null){
				Utils.ERROR(s + " -> wrong 'drop' type");
				Bukkit.getPluginManager().disablePlugin(Main.getInst());
			}
			drop.setDrop(new ItemStack(dm, 1, (short) (cs.get("dropData") !=null ? (short)cs.getInt("dropData") : 0)));
			drop.setChance(cs.getDouble("chance"));
			drop.setMinAmount(cs.getInt("minAmount"));
			drop.setMaxAmount(cs.getInt("maxAmount"));
			drop.setUseTools(cs.getBoolean("useTools"));
			if(cs.getBoolean("useTools")){
				List<Material> m = new ArrayList<Material>();
				for(String t : cs.getStringList("tools")){
					Material tm = Material.matchMaterial(t.toUpperCase());
					if(tm == null){
						Utils.ERROR(s + " -> wrong 'tools' content");
						Bukkit.getPluginManager().disablePlugin(Main.getInst());
					}
					m.add(tm);
				}
				drop.setTools(m);
			}
		}
		Main.drops.add(drop);
	}
}