package com.machentertainment.RPlite;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public final class RPlite extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("RPlite is now starting.");
		
		
		//Start getting commands
		getCommand("mach").setExecutor(new RPliteCommandExecutor);
		
		
	}

}
