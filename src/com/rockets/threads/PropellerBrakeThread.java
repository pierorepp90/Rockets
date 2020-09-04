package com.rockets.threads;

import com.rockets.domain.Propeller;

public class PropellerBrakeThread implements Runnable {
	
	public PropellerBrakeThread(Propeller propeller) {
		this.propeller = propeller;

	}
	
	private Propeller propeller;


	@Override
	public void run() {
		while(propeller.getActualPower()>0) {
			propeller.setActualPower(propeller.getActualPower()- 1);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
		}		
	}
		
}