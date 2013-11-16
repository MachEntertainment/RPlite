package com.machentertainment.RPlite;

import java.util.logging.Logger;

public class RPliteLogger {
	private RPlite plugin;
	private final Logger verbose = Logger.getLogger("Minecraft");
	private boolean configVerbose = plugin.getConfig().getBoolean("Verbose");
	
	public RPliteLogger(RPlite plugin){
		this.plugin = plugin;
	}
	
	public void info(String message){
		if(configVerbose == true){
			verbose.info(message);
		}
	}
	
	public void severe(String message){
		if(configVerbose == true){
			verbose.severe(message);
		}
	}
}
