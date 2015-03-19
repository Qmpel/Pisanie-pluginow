package me.kamilkime.youtube;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

@SuppressWarnings("deprecation")
public class Komendy implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("spawn")){
			if(args.length !=1){
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("v")){
				Villager v = p.getWorld().spawn(p.getLocation(), Villager.class);
				v.setProfession(Profession.LIBRARIAN);
				v.setBaby();
				v.setCustomName("Enpec");
			}
			if(args[0].equalsIgnoreCase("s")){
				Skeleton s = p.getWorld().spawn(p.getLocation(), Skeleton.class);
				s.setSkeletonType(SkeletonType.WITHER);
				s.getEquipment().setItemInHand(new ItemStack(Material.NETHER_STAR, 1));
				s.getEquipment().setItemInHandDropChance(100);
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
				SkullMeta sm = (SkullMeta) skull.getItemMeta();
				sm.setOwner(p.getName());
				skull.setItemMeta(sm);
				s.getEquipment().setHelmet(skull);
			}
			if(args[0].equalsIgnoreCase("c")){
				Cow c = p.getWorld().spawn(p.getLocation(), Cow.class);
				c.setCustomName("Krowa");
				c.setRemoveWhenFarAway(false);
				c.setBreed(false);
			}
			if(args[0].equalsIgnoreCase("ed")){
				EnderDragon ed = p.getWorld().spawn(p.getLocation(), EnderDragon.class);
				ed.setPassenger(p);
			}
		}
		if(cmd.getName().equalsIgnoreCase("spawner")){
			if(args.length !=1){
				return true;
			}
			String arg0 = args[0];
			List<String> types = new ArrayList<String>();
			for(CreatureType ct : CreatureType.values()){
				types.add(ct.getName().toUpperCase());
			}
			if(types.contains(arg0.toUpperCase())){
				Block b = ((Player)sender).getTargetBlock(null, 5);
				if(b.getType().equals(Material.MOB_SPAWNER)){
					CreatureSpawner cs = (CreatureSpawner) b.getState();
					cs.setCreatureTypeByName(arg0);
					cs.update();
				}
			}
		}
		return false;
	}
}