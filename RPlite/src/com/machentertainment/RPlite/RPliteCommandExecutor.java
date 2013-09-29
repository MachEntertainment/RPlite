package com.machentertainment.RPlite;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class RPliteCommandExecutor implements CommandExecutor{
	
	private RPlite plugin;
	RPlitePaymentProcessor payment = new RPlitePaymentProcessor(plugin);
	RPlitePermissionProcessor perm = new RPlitePermissionProcessor(plugin);
	
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
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Select a class to join.  Type /Mach classes to see the list.");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("classes")){
					plugin.sendPlayer(playerObj, ChatColor.GOLD + "____RPLite Class List____");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Class - Description");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Baker - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Banker - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Blacksmith - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Farmer - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Merchant - (MORE INFO HERE)");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Noble - (MORE INFO HERE)");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("help")){
					plugin.sendPlayer(playerObj, ChatColor.GOLD + "____RPLite Help Menu____");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Command: Description");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "/mach: Does something when we code it to");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "/mach help: Displays help menu");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "/mach classes: Lists classes");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "/mach join <class>: Joins a class");
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "/mach leaveclass: Leaves current class");
				}
				//TODO
			}
			if(args.length == 1){
				if(args[1].equalsIgnoreCase("leaveclass")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully left your class!");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Blacksmith")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Blacksmith");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Farmer")){
					int classCost = 100;
					
					if(payment.paymentSub(classCost, playerName) == true){
						
						
						plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Farmer");	
					}
					
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Merchant")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Merchant");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Baker")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Baker");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Banker")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Banker");
				}
				//TODO
			}
			if(args.length == 2){
				if(args[2].equalsIgnoreCase("Noble")){
					plugin.sendPlayer(playerObj, ChatColor.GREEN + "Successfully joined Noble");
				}
				//TODO
			}
		}
		
		return false;
	}

}
