package com.machentertainment.RPlite;

import org.bukkit.entity.Player;

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
		
		RPlite.perms.playerAddGroup(world, playerName, group);
		
	}
	
	/**
	 * Removes player from a group.
	 * @param world - String name
	 * @param playerName - String player's name
	 * @param group - String group to test
	 */
	
	public void groupSub(String world, String playerName, String group){
		
		RPlite.perms.playerRemoveGroup(world, playerName, group);
		
	}
	
	
	/**
	 * Tests is player is within a defined group.
	 * @param world - String name
	 * @param PlayerObj - Player player entity
	 * @return True is the player has a group, false otherwise.
	 */
	public boolean isInGroup(String world, Player PlayerObj){
		plugin.sendLog("info","Permission Processor: Running a check to see if " + PlayerObj.getDisplayName() + "is in group.");
		
		String[] classGroups = {"farmer", "blacksmith", "baker", "merchang", "noble"};
		Boolean hasGroup = false;
		
		for(String group : classGroups){
			if(RPlite.perms.playerInGroup(PlayerObj, group) == true){
				hasGroup = true;
			}
		}
		
		if(hasGroup == true){
			return true;
		}else{
			return false;
		}
	}
	
	

}
