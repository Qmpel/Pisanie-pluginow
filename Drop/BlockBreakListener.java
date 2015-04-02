package me.kamilkime.youtube;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener{

	@EventHandler
	public void onBreak(BlockBreakEvent e){
		for(ItemToDrop i : Main.drops){
			if(i.getType().equals(DropType.BLOCK)){
				if(Utils.getChance(i.getChance())){
					if(i.getBlock().equals(e.getBlock().getType())){
						if(!i.getUseY() || e.getBlock().getY() <= i.getMinY()){
							if(!i.getUseTools() || i.getTools().contains(e.getPlayer().getItemInHand().getType())){
								ItemStack toDrop = i.getDrop();
								int amount = Utils.getRandInt(i.getMinAmount() + e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS),
										i.getMaxAmount() + e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS));
								toDrop.setAmount(amount);
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), toDrop);
								e.getBlock().getWorld().spawn(e.getBlock().getLocation(), ExperienceOrb.class).setExperience(1
										+ e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS));;
							}
						}
					}
				}
			}
		}
	}
}