package com.machentertainment.RPlite;

import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
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
		
		if(this.getConfig().getInt("Version") != 1){
			this.saveDefaultConfig();
			getLogger().severe("The config file was malformed or missing.  Saving default config.");
		}
		
		if(this.getConfig().getBoolean("Verbose") == true) {
			verbose = true;
		}else{
			verbose = false;
		}
		
		sendLog("info", "Registering player commands");
		//Start getting commands
		getCommand("mach").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach classes").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach help").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach leave").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join farmer").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join blacksmith").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join banker").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join baker").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join merchant").setExecutor(new RPliteCommandExecutor(this));
		getCommand("mach join noble").setExecutor(new RPliteCommandExecutor(this));
		
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
		player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "RPLite" + ChatColor.GOLD + "]: " + ChatColor.GREEN + message);
	}
	
	public void sendMessage(CommandSender sender, String message){
  		sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED + "RPLite" + ChatColor.GOLD + "]: " + ChatColor.GREEN + message);
  	}
	
	//Console Logging (Config based)
	public void sendLog(String level, String Message){
		
		if(verbose == true){
			if(level.equalsIgnoreCase("info")){
				getLogger().info(Message);
			}else{
				getLogger().warning(Message);
			}
		}
	}


}
