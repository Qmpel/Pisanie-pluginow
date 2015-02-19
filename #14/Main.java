package me.kamilkime.youtube;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
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
		Bukkit.getPluginManager().registerEvents(new Craftingi(), this);
		getServer().addRecipe(sr);
	}
	
	@Override
	public void onDisable(){
		System.out.println("Wylaczanie...");
	}
	
	public static Main getInst(){
		return instance;
	}
	ShapedRecipe sr = new ShapedRecipe(is).shape("dkd","dkd","dkd").setIngredient('d', Material.DIAMOND_BLOCK).setIngredient('k', Material.DIAMOND_CHESTPLATE);
}