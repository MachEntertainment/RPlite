package com.machentertainment.RPlite;

public class RPlitePermissionProcessor {
	
	private RPlite plugin;
	
	
	public RPlitePermissionProcessor(RPlite plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Adds player to a group.
	 * @param world - String world name
	 * @param playerName - String player's name
	 * @param group - String group name to add
	 */
	
	public void groupAdd(String world, String playerName, String group){
		
//		plugin.sendLog("info", "Adding " + playerName + "to group " + group);
		RPlite.perms.playerAddGroup(world, playerName, group);
		
	}
	
	/**
	 * Removes player from a group.
	 * @param world - String name
	 * @param playerName - String player's name
	 * @param group - String group to test
	 */
	
	public void groupSub(String world, String playerName, String group){
		
//		plugin.sendLog("info", "Removing " + playerName + " from group " + group);
		RPlite.perms.playerRemoveGroup(world, playerName, group);
		
	}
	/**
	 * 
	 * @param world - String name of world to test.
	 * @param playerName - String player's name.
	 * @param perm - String permission to test.
	 * @return True if player has given permission, false otherwise.
	 */
	public boolean hasPerm(String world, String playerName, String perm){
		
		if(RPlite.perms.playerHas(world, playerName, perm) == true){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * Tests is player is within a defined group.
	 * @param world - String name
	 * @param PlayerObj - Player player entity
	 * @return True if the player has a group, false otherwise.
	 */
	public boolean isInGroup(String world, String player){
		
		if(player == null){
//			plugin.sendLog("severe", "ERROR!! playerObj was NULL!!");
			
			return false;
		}
		if(world == null){
//			plugin.sendLog("severe", "ERROR!! world was NULL!!");
			
			return false;
		}
		
//		plugin.sendLog("info","Permission Processor: Running a check to see if " + player + "is in group.");
		
		String[] classGroups = {"farmer", "blacksmith", "baker", "merchang", "noble"};
		Boolean hasGroup = false;
		
		for(String group : classGroups){
			if(RPlite.perms.playerInGroup(world, player, group) == true){

				hasGroup = true;
			}
		}
		
		if(hasGroup == true){
//			plugin.sendLog("info", "Permission Processor: The Player is in a group.");
			return true;
		}else{
//			plugin.sendLog("info", "Permission Processor: The Player is not in a group.");
			return false;
		}
		


	}
	
	

}
