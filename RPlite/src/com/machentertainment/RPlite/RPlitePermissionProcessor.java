package com.machentertainment.RPlite;

import org.bukkit.entity.Player;

public class RPlitePermissionProcessor {
	
	private RPlite plugin;
	
	public RPlitePermissionProcessor(RPlite plugin){
		this.plugin = plugin;
	}
	
	public void groupAdd(String world, String playerName, String group){
		
		RPlite.perms.playerAddGroup(world, playerName, group);
		
	}
	
	public void groupSub(String world, String playerName, String group){
		
		RPlite.perms.playerRemoveGroup(world, playerName, group);
		
	}
	
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
