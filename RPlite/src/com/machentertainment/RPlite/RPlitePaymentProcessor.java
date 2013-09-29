package com.machentertainment.RPlite;


public class RPlitePaymentProcessor {
	
	private RPlite plugin;
	
	public RPlitePaymentProcessor(RPlite plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Takes a integer to add to the player's bank account.
	 * @param payment - A positive integer, DO NOT PASS NEGATIVES
	 * @param playerName - String player's name.
	 */
	
	public void paymentAdd(int payment, String playerName){
		
			RPlite.econ.depositPlayer(playerName, payment);
		
	}
	
	/**
	 * Takes a integer to subtract from the player's bank account.
	 * @param payment - A positive integer, DO NOT PASS NEGATIVES
	 * @param playerName - String player's name.
	 * @return TRUE if the payment succeeded, FALSE if the payment failed.
	 */
	public boolean paymentSub(int payment, String playerName){
		
		if(RPlite.econ.has(playerName, payment) == true){
			RPlite.econ.withdrawPlayer(playerName, payment);
			return true;
		}else{
			return false;
		}
		
	}

}
