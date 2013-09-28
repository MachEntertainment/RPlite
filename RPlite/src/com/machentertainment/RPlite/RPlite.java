package com.machentertainment.RPlite;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public final class RPlite extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("RPlite is now starting.");
		
		
		//Start getting commands
		getCommand("mach").setExecutor(new RPliteCommandExecutor(this));
		
		
	}
	
	@Override
	public void onDisable(){
		getLogger().info("RPLite has been disabled");
	}
	
	//Preformated message sending.
	public void sendPlayer(Player player, String message){
		player.sendMessage("[RPlite]: " + message);
	}
	
	//Console Logging (Config based)
	public void sendLog(String level, String Message){
		
		if(con)
			if(level.equalsIgnoreCase(info)){
				getLogger().info(Message);
			}else{
				getLogger().warning(Message);
			}
	}

}
