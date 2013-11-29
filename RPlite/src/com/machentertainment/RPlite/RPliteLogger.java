package com.machentertainment.RPlite;


public class RPliteLogger {
	private RPlite plugin;
	public boolean verbose = true;
	
	public RPliteLogger(RPlite instance){
		plugin = instance;
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
	
	public void reload(){
		verbose = plugin.getVerbose();
	}
}
