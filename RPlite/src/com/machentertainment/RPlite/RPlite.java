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
		getCommand("phoenix").setExecutor(new RPliteCommandExecutor(this));
		getCommand("phoenix status").setExecutor(new RPliteCommandExecutor (this));
		getCommand("phoenix join").setExecutor(new RPliteCommandExecutor(this));
		getCommand("phoenix list").setExecutor(new RPliteCommandExecutor(this));
		getCommand("phoenix version").setExecutor(new RPliteCommandExecutor(this));
		
		
	}

}
