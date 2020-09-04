package com.rockets.threads;

import com.rockets.domain.Propeller;
import com.rockets.domain.Rocket;

public class RocketThread implements Runnable {
	
	private Rocket rocket;
	private int powerNeeded;
	
	public RocketThread(Rocket rocket,int powerNeeded) {
		this.rocket = rocket;
		this.powerNeeded = powerNeeded;
	}

	@Override
	public void run() {
		 int possiblePower =0;
		 for(Propeller po: rocket.getPropellers()) {
			 possiblePower += (po.maxPower - po.actualPower);
		 }
		 if(powerNeeded>possiblePower) {
			 System.out.println("The rocket need more propellers to reach that speed.");
		 }else {		 
			 while(powerNeeded>0) {
				 try {
					Thread.currentThread();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
				 for(Propeller p: rocket.getPropellers()) { 
					 if(p.actualPower<p.maxPower && powerNeeded>0) {
						 p.actualPower+= 1;
						 powerNeeded -= 1;
					 }
				 }
				 String rocketData = rocket.rocketData();
				 System.out.println(rocketData);
			}
		 }
		
	}

}
