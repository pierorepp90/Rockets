package com.rockets.threads;

import com.rockets.domain.Propeller;

public class PropellerThread implements Runnable {
	
	public PropellerThread(Propeller propeller) {
		this.propeller = propeller;

	}
	
	private Propeller propeller;

	@Override
	public void run() {
		while(propeller.getActualPower()<propeller.getMaxPower()) {
			propeller.setActualPower(propeller.getActualPower()+ 1);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
		
		}
		
	}		
}


