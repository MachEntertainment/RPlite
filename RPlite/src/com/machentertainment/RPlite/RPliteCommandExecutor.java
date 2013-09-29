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
					sender.sendMessage(ChatColor.GOLD + "____RPLite Class List____");
					sender.sendMessage(ChatColor.GREEN + "Class - Description");
					sender.sendMessage(ChatColor.GREEN + "Baker - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Banker - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Blacksmith - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Farmer - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Merchant - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Noble - (MORE INFO HERE)");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("help")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Help Menu____");
					sender.sendMessage(ChatColor.GREEN + "Command: Description");
					sender.sendMessage(ChatColor.GREEN + "/mach: Does something when we code it to");
					sender.sendMessage(ChatColor.GREEN + "/mach help: Displays help menu");
					sender.sendMessage(ChatColor.GREEN + "/mach classes: Lists classes");
					sender.sendMessage(ChatColor.GREEN + "/mach join <class>: Joins a class");
					sender.sendMessage(ChatColor.GREEN + "/mach leaveclass: Leaves current class");
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
