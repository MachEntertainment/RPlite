package com.machentertainment.RPlite;

import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RPlitePlayerInteractListener implements Listener{
	
	private RPlite plugin;
	RPlitePermissionProcessor permission = new RPlitePermissionProcessor(plugin);
	
	public RPlitePlayerInteractListener(RPlite instance){
		plugin = instance;
	}
	
	public Material[] farmingBlocks = {Material.GRASS, Material.DIRT};
	public Material[] farmingTools = {Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE};
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
    	Player player = event.getPlayer();
    	Material block = event.getClickedBlock().getType();
    	Material tool = event.getPlayer().getItemInHand().getType();
    	Action click = event.getAction();
    	String world = player.getWorld().getName();
    	
    	if(block != null){
	    	if(Arrays.asList(farmingBlocks).contains(block) && Arrays.asList(farmingTools).contains(tool) && click == Action.RIGHT_CLICK_BLOCK && RPlite.perms.playerHas(world, player.getName(), "rplite.farmer") == false){
	    		if(permission.hasPerm(world, player.getName(), "rplite.admin") == false && !(player.getGameMode() == GameMode.CREATIVE)){
		    		plugin.getLogger().info("InteractListener: Farm event cancelled");
		    		event.setCancelled(true);
	    		}
	    	}
    	}
	}
}
