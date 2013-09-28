package com.machentertainment.RPlite;

import java.util.List;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public final class RPlite extends JavaPlugin{
	
	Boolean verbose;
	private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;
	
	@Override
	public void onEnable() {
		getLogger().info("RPlite is now starting.");
		
		if(this.getConfig().getBoolean("Verbose") == true) {
			verbose = true;
		}else{
			verbose = false;
		}
		
		
		//Start getting commands
		getCommand("mach").setExecutor(new RPliteCommandExecutor(this));
		
		//Vault
		if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
		
		
	}
	
	@Override
	public void onDisable(){
		getLogger().info("RPLite has been disabled");
	}
	
	//Vault
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
	
	//Preformated message sending.
	public void sendPlayer(Player player, String message){
		player.sendMessage("[RPlite]: " + message);
	}
	
	//Console Logging (Config based)
	public void sendLog(String level, String Message){
		
		if(verbose = true){
			if(level.equalsIgnoreCase("info")){
				getLogger().info(Message);
			}else{
				getLogger().warning(Message);
			}
		}
	}

}
