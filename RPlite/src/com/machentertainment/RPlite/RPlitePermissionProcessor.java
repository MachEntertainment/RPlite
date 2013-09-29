package com.machentertainment.RPlite;

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
	
	public boolean isInGroup(String world, String playerName, String group){
		//TODO
		
		return false;
	}
	
	

}
