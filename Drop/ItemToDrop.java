package me.kamilkime.youtube;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class ItemToDrop {
	private DropType type;
	private EntityType fromEnt;
	private Material fromBlock;
	private ItemStack drop;
	private double chance;
	private int minY;
	private int minAmount;
	private int maxAmount;
	private boolean useY;
	private boolean useTool;
	private List<Material> tools;

	public DropType getType() {
		return this.type;
	}

	public EntityType getMob() {
		return this.fromEnt;
	}

	public Material getBlock() {
		return this.fromBlock;
	}

	public ItemStack getDrop() {
		return this.drop;
	}

	public double getChance() {
		return this.chance;
	}

	public int getMinY() {
		return this.minY;
	}

	public int getMinAmount() {
		return this.minAmount;
	}

	public int getMaxAmount() {
		return this.maxAmount;
	}

	public boolean getUseY() {
		return this.useY;
	}

	public boolean getUseTools() {
		return this.useTool;
	}

	public List<Material> getTools() {
		return this.tools;
	}

	public void setType(DropType type) {
		this.type = type;
	}

	public void setMob(EntityType type) {
		this.fromEnt = type;
	}

	public void setBlock(Material block) {
		this.fromBlock = block;
	}

	public void setDrop(ItemStack drop) {
		this.drop = drop;
	}

	public void setChance(double chance) {
		this.chance = chance;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public void setUseY(Boolean useY) {
		this.useY = useY.booleanValue();
	}

	public void setUseTools(Boolean useTool) {
		this.useTool = useTool.booleanValue();
	}

	public void setTools(List<Material> tools) {
		this.tools = tools;
	}
}