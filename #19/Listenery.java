package me.kamilkime.youtube;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Listenery implements Listener{
	
	private ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);{
		BookMeta bm = (BookMeta) book.getItemMeta();
		bm.setDisplayName("§b§lInfo o gildiach");
		bm.setAuthor("Kraina Przygody");
		bm.setTitle("Gildie");
		bm.addPage("Strona 1","Strona 2\n\nTo jest 2 strona","Strona 3\nTo jest nast. linijka");
		book.setItemMeta(bm);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(!e.getPlayer().getInventory().containsAtLeast(book, 1)){
			e.getPlayer().getInventory().addItem(book);
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta sm = (SkullMeta) skull.getItemMeta();
		sm.setOwner(e.getEntity().getName());
		skull.setItemMeta(sm);
		e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), skull);
	}
}