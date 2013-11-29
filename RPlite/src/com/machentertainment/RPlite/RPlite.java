package com.machentertainment.RPlite;

import java.util.List;
import java.util.logging.Logger;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class RPlite extends JavaPlugin{
	
	Boolean verbose;
//	private static final Logger log = Logger.getLogger("Minecraft");
    public static Economy econ = null;
    public static Permission perms = null;
    public static Chat chat = null;
    public RPliteAnnouncer announce = new RPliteAnnouncer(this);
    
    RPliteLogger log = new RPliteLogger(this);
	
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		
		getLogger().info("RPlite is now starting.");
		
		this.saveDefaultConfig();
		if(this.getConfig().getInt("config") != 3){
			this.saveDefaultConfig();
			getLogger().severe("The config file was malformed or missing.  Please delete the old config for a new one.");
		}else{
			getLogger().info("Loaded config file.");
		}	
		
		getLogger().info("Registering player commands");
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
		
		getLogger().info("Registering listeners");
		//Event listeners
		pm.registerEvents(new RPliteBlockBreakListener(this), this);
		pm.registerEvents(new RPlitePlayerInteractListener(this), this);
		pm.registerEvents(new RPliteCraftingListener(this), this);
		
		//Scheduled Events
		announce.broadcastAnnouncerThread();
		
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
		log.info("RPLite has been disabled");
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
	
	//Configuration Files
	public List<String> getAnnouncements(){
		List<String> announcements = getConfig().getStringList("broadcast.broadcasts");
		
		return announcements;
	}
	
	public int getAnnouncementInterval(){
		int broadcastInterval = getConfig().getInt("broadcast.interval") * 20;
		
		return broadcastInterval;
	}
	
	public boolean getVerbose(){
		boolean verbose = getConfig().getBoolean("verbose", true);
		
		return verbose;
	}
}
