package com.machentertainment.RPlite;


public class RPliteLogger {
	private RPlite plugin;
	public boolean verbose = true;
	
	public RPliteLogger(RPlite plugin){
		this.plugin = plugin;
	}
	
	public void info(String message){
		if(verbose == true){
			plugin.getLogger().info(message);
		}
	}
	
	public void severe(String message){
		if(verbose == true){
			plugin.getLogger().severe(message);
		}
	}
}
