package com.machentertainment.RPlite;

import net.milkbowl.vault.economy.EconomyResponse;

public class RPlitePaymentProcessor {
	
	private RPlite plugin;
	
	public RPlitePaymentProcessor(RPlite plugin){
		this.plugin = plugin;
	}
	
	public void paymentAdd(int payment, String name){
		
			EconomyResponse r = plugin.econ.depositPlayer(name, payment);
		
	}
	
	public boolean paymentSub(int payment, String name){
		
		if(plugin.econ.has(name, payment) == true){
			EconomyResponse r = plugin.econ.withdrawPlayer(name, payment);
			return true;
		}else{
			return false;
		}
	}

}
