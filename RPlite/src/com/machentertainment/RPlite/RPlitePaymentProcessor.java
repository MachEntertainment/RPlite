package com.machentertainment.RPlite;


public class RPlitePaymentProcessor {
	
	private RPlite plugin;
	
	public RPlitePaymentProcessor(RPlite plugin){
		this.plugin = plugin;
	}
	
	public void paymentAdd(int payment, String playerName){
		
			RPlite.econ.depositPlayer(playerName, payment);
		
	}
	
	public boolean paymentSub(int payment, String playerName){
		
		if(RPlite.econ.has(playerName, payment) == true){
			RPlite.econ.withdrawPlayer(playerName, payment);
			return true;
		}else{
			return false;
		}
		
	}

}
