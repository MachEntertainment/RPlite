package com.machentertainment.RPlite;
 
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
 
public class RPliteBlockBreakListener implements Listener {
       
        private RPlite plugin;
       
        public RPliteBlockBreakListener(RPlite instance) {
                plugin = instance;
        }
 
        @EventHandler
        public void onBlockBreak(BlockBreakEvent event, World world){
                Player player = event.getPlayer();
                Block block = event.getBlock();
        }
 
}