package me.kamilkime.youtube;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main instance;
	public static ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 5, (short) 1);{
		is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("§6§lKOX");
		im.setLore(Arrays.asList("§aLinijka 1","§bLinijka 2"));
		is.setItemMeta(im);
	}
	
	@Override
	public void onEnable(){
		instance = this;
		System.out.println("Uruchamianie...");
		saveDefaultConfig();
		getServer().addRecipe(sr);
		getServer().addRecipe(fr);
		getServer().addRecipe(Craftingi.sr);
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
	ShapelessRecipe sr = new ShapelessRecipe(is).addIngredient(5, Material.EMERALD_BLOCK).addIngredient(4,Material.GOLD_INGOT);
	FurnaceRecipe fr = new FurnaceRecipe(is,Material.NETHER_STAR);
}