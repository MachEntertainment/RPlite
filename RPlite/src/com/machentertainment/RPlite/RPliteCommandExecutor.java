package com.machentertainment.RPlite;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class RPliteCommandExecutor implements CommandExecutor{
	
	private RPlite plugin;
	
	public RPliteCommandExecutor(RPlite plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand (org.bukkit.command.CommandSender sender,org.bukkit.command.Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("Mach")) {
			
			String playerName = sender.getName();
			Player playerObj = plugin.getServer().getPlayer(playerName);
			
			if(args.length == 0){
				plugin.sendPlayer(playerObj, "Under Construction");
				
				return true;
			}
		}
		
		return false;
	}

}
