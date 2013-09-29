package com.machentertainment.RPlite;

import org.bukkit.ChatColor;
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
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("join")){
					plugin.sendPlayer(playerObj, "Select a class to join.  Type /Mach classes to see the list.");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("classes")){
					plugin.sendPlayer(playerObj, ChatColor.GOLD + "____RPLite Class List____");
					plugin.sendPlayer(playerObj, "Class - Description");
					plugin.sendPlayer(playerObj, "Baker - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, "Banker - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, "Blacksmith - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, "Farmer - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, "Merchant - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, "Noble - (MORE INFO HERE)");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("help")){
					plugin.sendPlayer(playerObj, ChatColor.GOLD + "____RPLite Help Menu____");
					plugin.sendPlayer(playerObj, "Command: Description");
					plugin.sendPlayer(playerObj, "/mach: Does something when we code it to");
					plugin.sendPlayer(playerObj, "/mach help: Displays help menu");
					plugin.sendPlayer(playerObj, "/mach classes: Lists classes");
					plugin.sendPlayer(playerObj, "/mach join <class>: Joins a class");
					plugin.sendPlayer(playerObj, "/mach leaveclass: Leaves current class");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("leaveclass")){
					plugin.sendPlayer(playerObj, "Successfully left your class!");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Blacksmith")){
					plugin.sendPlayer(playerObj, "Successfully joined Blacksmith");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Farmer")){
					plugin.sendPlayer(playerObj, "Successfully joined Farmer");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Merchant")){
					plugin.sendPlayer(playerObj, "Successfully joined Merchant");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Baker")){
					plugin.sendPlayer(playerObj, "Successfully joined Baker");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Banker")){
					plugin.sendPlayer(playerObj, "Successfully joined Banker");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Noble")){
					plugin.sendPlayer(playerObj, "Successfully joined Noble");
				}
				//TODO
			}
		}
		
		return false;
	}

}
