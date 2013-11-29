package com.machentertainment.RPlite;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RPliteCommandExecutor implements CommandExecutor{
	
	private RPlite plugin;
	
	RPlitePaymentProcessor payment = new RPlitePaymentProcessor(plugin);
	RPlitePermissionProcessor permission = new RPlitePermissionProcessor(plugin);
	RPliteAnnouncer announcer = new RPliteAnnouncer(plugin);
	
	public int bakerPrice = 300;
	public int bankerPrice = 500;
	public int blacksmithPrice = 300;
	public int farmerPrice = 100;
	public int loggerPrice = 200;
	public int minerPrice = 200;
	public int merchantPrice = 500;
	public int noblePrice = 1000;
	
	public RPliteCommandExecutor(RPlite plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args){
		
		RPliteLogger log = new RPliteLogger(plugin);
		
		if(cmd.getName().equalsIgnoreCase("mach")) {
			
			String playerName = sender.getName();
			Player playerObj = plugin.getServer().getPlayer(playerName);
			Boolean isPlayer = false;
			String world = null;
			
				
			if (sender instanceof Player){
				isPlayer = true;
				world = playerObj.getWorld().getName();
				
			}
			
//			log.info("A command is being executed.");
//			log.info("Player: " + sender);
//			log.info("Command executing :" + cmd.toString());
//			log.info("Command Arguments: " + args.toString());
			
			if(args.length == 0){
					plugin.sendMessage(sender, "Type /mach help for help or /mach classes for classes.");
					plugin.sendMessage(sender, "Version: " + plugin.getDescription().getVersion());
				
				return true;
			}
			if(args.length >= 1){
				
				if(args[0].equalsIgnoreCase("classes")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Class List____");
					sender.sendMessage(ChatColor.DARK_GREEN + "Class - Description");
					sender.sendMessage(ChatColor.GREEN + "Farmer " + ChatColor.GRAY + "- Has the ability to farm food items.");
					sender.sendMessage(ChatColor.GREEN + "Logger " + ChatColor.GRAY + "- Has the ability to cut down wood.");
					sender.sendMessage(ChatColor.GREEN + "Miner " + ChatColor.GRAY + "- Has the ability to mine for ores.");
					sender.sendMessage(ChatColor.GREEN + "Baker " + ChatColor.GRAY + "- Has the ability to cook advanced foods." + ChatColor.RED + "(Not implemented)");
					sender.sendMessage(ChatColor.GREEN + "Blacksmith " + ChatColor.GRAY + "- Has the ability to create tools, weapons, and armour.");
					sender.sendMessage(ChatColor.GREEN + "Banker " + ChatColor.GRAY + "- Has the ability to loan money to players." + ChatColor.RED + "(Not implemented)");
					sender.sendMessage(ChatColor.GREEN + "Merchant " + ChatColor.GRAY + "- Has the ability to create shops. " + ChatColor.RED + "(Not implemented)");
					sender.sendMessage(ChatColor.GREEN + "Noble " + ChatColor.GRAY + "- Asthetic rank when a certain monetary amount is reached.");
					
					//TODO
					return true;
				}
				
				if(args[0].equalsIgnoreCase("prices")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Price List____");
					sender.sendMessage(ChatColor.DARK_GREEN + "Class - Description");
					sender.sendMessage(ChatColor.GREEN + "Farmer " + ChatColor.GRAY + "- " + farmerPrice);
					sender.sendMessage(ChatColor.GREEN + "Logger " + ChatColor.GRAY + "- " + loggerPrice);
					sender.sendMessage(ChatColor.GREEN + "Miner " + ChatColor.GRAY + "- " + minerPrice);
					sender.sendMessage(ChatColor.GREEN + "Baker " + ChatColor.GRAY + "- " + bakerPrice);
					sender.sendMessage(ChatColor.GREEN + "Blacksmith " + ChatColor.GRAY + "- " + blacksmithPrice);
					sender.sendMessage(ChatColor.GREEN + "Banker " + ChatColor.GRAY + "- " + bankerPrice);
					sender.sendMessage(ChatColor.GREEN + "Merchant " + ChatColor.GRAY + "- " + merchantPrice);
					sender.sendMessage(ChatColor.GREEN + "Noble " + ChatColor.GRAY + "- " + noblePrice);
					
					//TODO
					return true;
				}
				
				if(args[0].equalsIgnoreCase("help")){
					sender.sendMessage(ChatColor.GOLD + "____RPLite Help Menu____");
					sender.sendMessage(ChatColor.GREEN + "Command: Description");
					sender.sendMessage(ChatColor.GREEN + "/mach: " + ChatColor.GRAY + " Does something when we code it to");
					sender.sendMessage(ChatColor.GREEN + "/mach help: " + ChatColor.GRAY + " Displays help menu");
					sender.sendMessage(ChatColor.GREEN + "/mach classes: " + ChatColor.GRAY + " Lists classes");
					sender.sendMessage(ChatColor.GREEN + "/mach prices: " + ChatColor.GRAY + " Get the prices for the classes.");
					sender.sendMessage(ChatColor.GREEN + "/mach join <class>: " + ChatColor.GRAY + " Joins a class");
					sender.sendMessage(ChatColor.GREEN + "/mach leave <class>: " + ChatColor.GRAY + " Leaves the designated class.");
					sender.sendMessage(ChatColor.GREEN + "/mach declare <message>: " + ChatColor.GRAY + " Broadcast a message to all players.");
					
					return true;
				}
				
				if(args[0].equalsIgnoreCase("reload")){
					plugin.reloadConfig();
					plugin.announce.refreshAnnouncer();
					log.reload();
					plugin.sendMessage(sender, "Config reloaded.");
					plugin.sendMessage(sender, "Announcer reloaded.");
					plugin.sendMessage(sender, "Verbose reloaded.");
					plugin.sendMessage(sender, "Version: " + plugin.getDescription().getVersion());
					
					return true;
				}
				
				if(args[0].equalsIgnoreCase("declare")){
					if(permission.hasPerm(world, playerName, "rplite.merchant")){
						if(args.length == 1){
							if(isPlayer == true){
								plugin.sendPlayer(playerObj, "A message is needed.");
								return true;
							}else{
								plugin.sendMessage(sender, "Error you must be a player to use that command");
								return true;
							}
						}else{
							if(args.length >= 2){
								String anno = "";
								
								for(String string : args){
									anno = (anno + string +" ");
								}
								
								String announcement = anno.replaceFirst("declare", "");
								Bukkit.broadcastMessage(ChatColor.BLUE + "[" + ChatColor.RED + "RPlite Announce " + ChatColor.BLUE + "] " + ChatColor.GRAY + sender.getName() + ": " + ChatColor.GREEN + ChatColor.translateAlternateColorCodes('&', announcement));
								return true;
							}
						}
					}else{
						plugin.sendPlayer(playerObj, "Only merchants may announce.");
						return true;
					}
				}
				
				if(args[0].equalsIgnoreCase("join")){
					if(args.length == 1){
						if(isPlayer == true){
							plugin.sendPlayer(playerObj, "Select a class to join.  Type /Mach classes to see the list.");
							return true;
						}else{
							plugin.sendMessage(sender, "Error you must be a player to use that command");
							return true;
						}
					}else{
						if(args.length == 2){
							
							if(args[1].equalsIgnoreCase("Blacksmith")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(blacksmithPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "blacksmith");
											plugin.sendPlayer(playerObj, "Successfully joined Blacksmith");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(blacksmithPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}

							if(args[1].equalsIgnoreCase("Farmer")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(farmerPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "farmer");
											plugin.sendPlayer(playerObj, "Successfully joined Farmer");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(farmerPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}
							
							if(args[1].equalsIgnoreCase("Miner")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(minerPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "miner");
											plugin.sendPlayer(playerObj, "Successfully joined Miner");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(minerPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}
							
							if(args[1].equalsIgnoreCase("Logger")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(loggerPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "logger");
											plugin.sendPlayer(playerObj, "Successfully joined Logger");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(loggerPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}

							if(args[1].equalsIgnoreCase("Merchant")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(merchantPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "merchant");
											plugin.sendPlayer(playerObj, "Successfully joined Merchant");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(merchantPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}

							if(args[1].equalsIgnoreCase("Baker")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(bakerPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "baker");
											plugin.sendPlayer(playerObj, "Successfully joined Baker");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(bakerPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}

							if(args[1].equalsIgnoreCase("Banker")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(bankerPrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "banker");
											plugin.sendPlayer(playerObj, "Successfully joined Banker");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(bankerPrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}

							if(args[1].equalsIgnoreCase("Noble")){
								
								if(isPlayer == true){
									if(permission.isInGroup(world, playerName) == false){
											
										if(payment.paymentSub(noblePrice, playerName) == true){
										
											permission.groupAdd(world, playerName, "noble");
											plugin.sendPlayer(playerObj, "Successfully joined Noble");
											
											return true;
										}else{
											plugin.sendPlayer(playerObj, "You do no have sufficient funds!");
											plugin.sendPlayer(playerObj, "You need " + payment.paymentOverCharge(noblePrice, playerName));
											
											return true;
										}
									}else{
										plugin.sendPlayer(playerObj, "You are already in a class!");
										
										return true;
									}
								}else{
									plugin.sendMessage(sender, "Error you must be a player to use that command");
									
									return true;
								}
								
							}
						}else{
							return false;
						}
					}
					
				}
				
				if(args[0].equalsIgnoreCase("leave")){
					if(args.length == 2){
						if(isPlayer == true){
							
							if(permission.isInGroup(world, playerName) == true){
								
//								log.info(playerName + " is leaving class: " + args[1].toString());
								permission.groupSub(world, playerName, args[1].toString());
								
								if(permission.isInGroup(world, playerName) == true){
									plugin.sendPlayer(playerObj, ChatColor.RED + "ERROR: "+ ChatColor.GREEN +"You may have left the group, but you are still in a class.");
									return true;
								}else{
									plugin.sendPlayer(playerObj, "Successfully left your class!");
									return true;
								}
							}else{
								plugin.sendMessage(playerObj, "RPlite detects you are not in a group.  If this is an error, contact an Admin.");
								return true;
							}
						}else{
							plugin.sendMessage(sender, ChatColor.RED + "ERROR: "+ ChatColor.GREEN +" you must be a player to use that command");
							return true;
						}
					}else{
						plugin.sendMessage(playerObj, "/Mach leave <class>: Used to leave the designated class.");
						return true;
				}
			}
		}else{
			plugin.sendMessage(playerObj, ChatColor.RED + "ERROR: "+ ChatColor.GREEN +" could not find the command entered!!");
		}
	}
	return false;
	}
}
