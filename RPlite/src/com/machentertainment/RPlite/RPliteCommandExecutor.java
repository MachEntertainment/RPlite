package com.machentertainment.RPlite;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RPliteCommandExecutor implements CommandExecutor{
	
	private RPlite plugin;
	
	RPlitePaymentProcessor payment = new RPlitePaymentProcessor(plugin);
	RPlitePermissionProcessor permission = new RPlitePermissionProcessor(plugin);
	
	
	public RPliteCommandExecutor(RPlite plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("mach")) {
			
			String playerName = sender.getName();
			Player playerObj = plugin.getServer().getPlayer(playerName);
			Boolean isPlayer = false;
			String world = null;
			
				
			if (sender instanceof Player){
				isPlayer = true;
				world = playerObj.getWorld().getName();
				
			}
			
			plugin.sendLog("info", "A command is being executed.");
			plugin.sendLog("info", "Player: " + sender);
			plugin.sendLog("info", "Command executing :" + cmd.toString());
			plugin.sendLog("info", "Command Arguments: " + args.toString());
			
			if(args.length == 0){
					sender.sendMessage("Under Construction");
				
				return true;
			}
			if(args.length == 1){
				
				if(args[0].equalsIgnoreCase("classes")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Class List____");
					sender.sendMessage(ChatColor.GREEN + "Class - Description");
					sender.sendMessage(ChatColor.GREEN + "Baker - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Banker - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Blacksmith - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Farmer - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Merchant - (MORE INFO HERE)");
					sender.sendMessage(ChatColor.GREEN + "Noble - (MORE INFO HERE)");
					
					//TODO
					return true;
				}
				
				if(args[0].equalsIgnoreCase("help")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Help Menu____");
					sender.sendMessage(ChatColor.GREEN + "Command: Description");
					sender.sendMessage(ChatColor.GREEN + "/mach: Does something when we code it to");
					sender.sendMessage(ChatColor.GREEN + "/mach help: Displays help menu");
					sender.sendMessage(ChatColor.GREEN + "/mach classes: Lists classes");
					sender.sendMessage(ChatColor.GREEN + "/mach join <class>: Joins a class");
					sender.sendMessage(ChatColor.GREEN + "/mach leaveclass: Leaves current class");
					
					//TODO
					return true;
				}
				
				if(args[0].equalsIgnoreCase("join")){
					if(isPlayer == true){
						plugin.sendPlayer(playerObj, "Select a class to join.  Type /Mach classes to see the list.");
						return true;
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						return true;
					}
					
					//TODO
				}
				
				if(args[0].equalsIgnoreCase("leaveclass")){
					if(isPlayer == true){
						plugin.sendPlayer(playerObj, "Successfully left your class!");
						return true;
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						return true;
					}
					//TODO
				}
			}
			
			if(args.length == 2){
				
				if(args[1].equalsIgnoreCase("Blacksmith")){
					int price = 300;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.groupAdd(world, playerName, "blacksmith");
							plugin.sendPlayer(playerObj, "Successfully joined Blacksmith");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do not have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}

				if(args[1].equalsIgnoreCase("Farmer")){
					int price = 100;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.isInGroup(world, playerObj);
							
							permission.groupAdd(world, playerName, "farmer");
							plugin.sendPlayer(playerObj, "Successfully joined Farmer");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}

				if(args[1].equalsIgnoreCase("Merchant")){
					int price = 500;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.groupAdd(world, playerName, "merchant");
							plugin.sendPlayer(playerObj, "Successfully joined Merchant");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do not have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}

				if(args[1].equalsIgnoreCase("Baker")){
					int price = 300;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.groupAdd(world, playerName, "baker");
							plugin.sendPlayer(playerObj, "Successfully joined Baker");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do not have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}

				if(args[1].equalsIgnoreCase("Banker")){
					int price = 500;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.groupAdd(world, playerName, "banker");
							plugin.sendPlayer(playerObj, "Successfully joined Banker");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do not have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}

				if(args[1].equalsIgnoreCase("Noble")){
					int price = 1000;
					
					if(isPlayer == true){
						if(payment.paymentSub(price, playerName) == true){
							
							permission.groupAdd(world, playerName, "noble");
							plugin.sendPlayer(playerObj, "Successfully joined Noble");
							
							return true;
						}else{
							plugin.sendPlayer(playerObj, "You do not have sufficient funds!");
							
							return true;
						}
					}else{
						plugin.sendMessage(sender, "Error you must be a player to use that command");
						
						return true;
					}
					
					//TODO
				}
			}
		}
		
		return false;
	}

}
