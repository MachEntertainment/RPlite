package com.machentertainment.RPlite;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;

public class RPliteCraftingListener implements Listener{
	
	private RPlite plugin;
	RPlitePermissionProcessor permission = new RPlitePermissionProcessor(plugin);
		Material blacksmithCreations[] = {
		Material.LEATHER_BOOTS, Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET, Material.LEATHER_LEGGINGS, 
		Material.IRON_BOOTS, Material.IRON_CHESTPLATE, Material.IRON_HELMET, Material.IRON_LEGGINGS,
		Material.GOLD_BOOTS, Material.GOLD_CHESTPLATE, Material.GOLD_HELMET, Material.GOLD_LEGGINGS,
		Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_LEGGINGS,
		Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD, 
		Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE, 
		Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE, 
		Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE, 
		Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE};
	
	public RPliteCraftingListener(RPlite instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onCraftingEvent(CraftItemEvent event){
		String playerName = event.getView().getPlayer().getName();
		Player player = plugin.getServer().getPlayer(playerName);
		Recipe recipe = event.getRecipe();
		String world = event.getView().getPlayer().getWorld().getName();
		
		plugin.getLogger().info("Player: " + playerName);
		plugin.getLogger().info("Recipe: " + recipe.getResult().getType().toString());
		plugin.getLogger().info("World : " + world);
		
		if(Arrays.asList(blacksmithCreations).contains(recipe.getResult().getType()) && !(permission.hasPerm(world, playerName, "rplite.admin")) && player.getGameMode() != GameMode.CREATIVE){
			if(!(permission.hasPerm(world, playerName, "rplite.blacksmith"))){
				plugin.sendPlayer(player, "You do not have the skill to do that.");
				event.setCancelled(true);
			}
		}
	}
}

