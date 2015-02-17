package me.kamilkime.youtube;

import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

public class Craftingi{
	
	public static ShapedRecipe sr = new ShapedRecipe(Main.is).shape("d d"," g ","d d").setIngredient('d', Material.DIAMOND_BLOCK).setIngredient('g', Material.GOLD_BLOCK);
}