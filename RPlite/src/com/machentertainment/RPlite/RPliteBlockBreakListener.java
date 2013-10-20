package com.machentertainment.RPlite;
 
import java.util.Arrays;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
 
public class RPliteBlockBreakListener implements Listener {
       
        private RPlite plugin;
        RPlitePermissionProcessor permission = new RPlitePermissionProcessor(plugin);
       
        public RPliteBlockBreakListener(RPlite instance) {
                plugin = instance;
        }
        
        public Material[] diggingBlocks = {Material.GRASS, Material.DIRT, Material.SOIL, Material.GRAVEL, Material.SAND, Material.CLAY};
        public Material[] miningBlocks = {Material.STONE, Material.COBBLESTONE, Material.COBBLE_WALL, Material.COBBLESTONE_STAIRS, Material.MOSSY_COBBLESTONE, Material.COAL_ORE, Material.COAL_BLOCK, Material.IRON_ORE, Material.DIAMOND_ORE, Material.REDSTONE_ORE, Material.REDSTONE_BLOCK}; //TODO
        public Material[] farmingBlocks = {Material.GRASS, Material.DIRT};
        public Material[] choppingBlocks = {Material.LOG, Material.WOOD, Material.WOOD_STAIRS, Material.WOOD_STEP, Material.WOOD_DOUBLE_STEP, Material.BOOKSHELF, Material.WOOD_DOOR};
        
        public Material[] diggingTools = {Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.GOLD_SPADE, Material.DIAMOND_SPADE};
        public Material[] miningTools = {Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE};
        public Material[] farmingTools = {Material.WOOD_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.GOLD_HOE, Material.DIAMOND_HOE};
        public Material[] choppingTools = {Material.WOOD_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.GOLD_AXE, Material.DIAMOND_AXE};
 
        @EventHandler(priority = EventPriority.NORMAL)
        public void onBlockBreak(BlockBreakEvent event){
                Player player = event.getPlayer();
                String playerName = player.getName();
                String world = player.getWorld().getName();
                Block block = event.getBlock();
                Material blockType = block.getType();
                Material tool = event.getPlayer().getItemInHand().getType();
                
                if(Arrays.asList(diggingBlocks).contains(blockType) && !(Arrays.asList(diggingTools).contains(tool)) && permission.hasPerm(world, playerName, "rplite.admin") == false && !(player.getGameMode() == GameMode.CREATIVE)){
                	plugin.getLogger().info("Block listener: Dig event canelled.");
                	event.setCancelled(true);
                	plugin.sendPlayer(player, "You do not have the right tool");
                }
                
                if(Arrays.asList(miningBlocks).contains(blockType) && !(Arrays.asList(miningTools).contains(tool)) && permission.hasPerm(world, playerName, "rplite.admin") == false && !(player.getGameMode() == GameMode.CREATIVE)){
                	plugin.getLogger().info("Block listener: Mining event canelled.");
                	event.setCancelled(true);
                	plugin.sendPlayer(player, "You do not have the right tool");
                }
                
                if(Arrays.asList(choppingBlocks).contains(blockType) && !(Arrays.asList(choppingTools).contains(tool)) && permission.hasPerm(world, playerName, "rplite.admin") == false && !(player.getGameMode() == GameMode.CREATIVE)){
                	plugin.getLogger().info("Block listener: Chopping event canelled.");
                	event.setCancelled(true);
                	plugin.sendPlayer(player, "You do not have the right tool");
                }
        }
 
}