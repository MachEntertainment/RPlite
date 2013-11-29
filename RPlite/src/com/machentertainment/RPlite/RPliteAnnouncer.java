package com.machentertainment.RPlite;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitScheduler;

public class RPliteAnnouncer{
	
	private RPlite plugin;
	
	
	public int broadcastNumber;
	public int broadcastInterval;
	public int broadcastLimit;
	public BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	public List<String> announcements;
	
	public RPliteAnnouncer(RPlite instance){
		plugin = instance;
	}
	
	public void broadcastAnnouncerThread(){
		
		RPliteLogger log = new RPliteLogger(plugin);
		
		broadcastInterval = plugin.getAnnouncementInterval();
		announcements = plugin.getAnnouncements();
		broadcastLimit = announcements.size();
		
		log.info("Scheduler enabling");
		
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable(){
				
			public void run(){
				broadcastAnnouncer(announcements.get(broadcastNumber));
				broadcastNumber++;
				
				if(broadcastNumber >= broadcastLimit){
					broadcastNumber = 0;
				}
			}
		}, broadcastInterval, broadcastInterval);
	}
	
	public void broadcastAnnouncer(String broadcastMessage){
		Bukkit.broadcastMessage(ChatColor.GOLD + "[" + ChatColor.RED + "RPLite Announcement" + ChatColor.GOLD + "]: " + ChatColor.GRAY + broadcastMessage);
	}
	
	public void refreshAnnouncer(){
		broadcastInterval = plugin.getAnnouncementInterval();
		announcements = plugin.getAnnouncements();
		broadcastNumber = 0;
		broadcastLimit = announcements.size();
		
		
	}
	
	
}
