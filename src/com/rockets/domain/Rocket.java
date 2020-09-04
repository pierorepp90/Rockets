package com.rockets.domain;

import java.util.ArrayList;
import java.util.List;

import com.rockets.threads.PropellerBrakeThread;
import com.rockets.threads.PropellerThread;
import com.rockets.threads.RocketThread;

public class Rocket {

	protected String code;																		
	protected List<Propeller> propellers = new ArrayList<Propeller>();
	protected List<Thread> threadsSpeed = new ArrayList<Thread>();
	protected List<Thread> threadsBrake = new ArrayList<Thread>();
	
	public String getCode() {
		return code;
	}

	public List<Propeller> getPropellers() {
		return propellers;
	}
	
	public List<Thread> getThreadsSpeed(){
		return threadsSpeed;
	}
	
	public List<Thread> getThreadsBrake(){
		return threadsBrake;
	}

	
	public Rocket(String code, List<Propeller> propellers) {
		
		this.code=code;
		this.propellers=propellers;
	}
	
	public void speedUp() {

			for(int i=0; i<this.getThreadsBrake().size(); i++) {
				this.getThreadsBrake().get(i).interrupt();
			}
			for(Propeller p: this.propellers) {
				Runnable r = new PropellerThread(p);
				Thread t = new Thread(r);
				t.start();
				this.getThreadsSpeed().add(t);
				System.out.println("Propeller with " + p.maxPower + " of max power: inicialized");
			}
			
	}
	
	public void brake() {

		for(int i=0; i<this.getThreadsSpeed().size(); i++) {
			this.getThreadsSpeed().get(i).interrupt();
			System.out.println(this.getThreadsSpeed().get(i).getName() + " interrupted: " + this.getThreadsSpeed().get(i).isInterrupted());
			}
		for(Propeller p: this.propellers) {
			Runnable r = new PropellerBrakeThread(p);
			Thread t = new Thread(r);
			t.start();
			this.getThreadsBrake().add(t);
		}
			
	}
	
	
	 public int setSpeed(int speed) {
		double totalPower = 0;
		for(Propeller p: this.propellers) {
			totalPower += p.actualPower;
		}
		double initialSpeed = 100*(Math.sqrt(totalPower));
		double powerNeeded = 0;
		if(speed>initialSpeed) {
			powerNeeded = (Math.pow(((speed - initialSpeed)/100), 2));
		}else {
			System.out.println("We are here to race,MORE SPEED!");
		}
		
		return (int)powerNeeded;
	}
	 

	 public void administratePower(int powerNeeded) {
		 for(int i=0; i<this.getThreadsSpeed().size(); i++) {
				this.getThreadsSpeed().get(i).interrupt();
				}
		for(int i=0; i<this.getThreadsBrake().size(); i++) {
			this.getThreadsBrake().get(i).interrupt();
		}
		 
		 Runnable r = new RocketThread(this, powerNeeded);
		 Thread t = new Thread(r);
		 t.start();
	 }
	 
	 
	public String rocketData() {
		String rocketData = this.getCode() + ": ";
		
		for(int i=0; i<this.getPropellers().size(); i++) {
			if(i==this.getPropellers().size()-1) {
				rocketData += this.getPropellers().get(i).getActualPower() + ".";
			}else {
				rocketData += this.getPropellers().get(i).getActualPower() + ",";
			}
		}
		return rocketData;
	}
	
	
	public static Rocket createRocketOne() {
		List<Propeller> propellersR1 = new ArrayList<Propeller>();
		Propeller p11 = new Propeller(10);
		propellersR1.add(p11);
		Propeller p12 = new Propeller(30);
		propellersR1.add(p12);
		Propeller p13 = new Propeller(80);
		propellersR1.add(p13);

		Rocket rocketOne = new Rocket("32WESSDS",propellersR1);
		return rocketOne;
	}
	
	
	public static Rocket createRocketTwo() {
		List<Propeller> propellersR2 = new ArrayList<Propeller>();
		Propeller p21 = new Propeller(30);
		propellersR2.add(p21);
		Propeller p22 = new Propeller(40);
		propellersR2.add(p22);
		Propeller p23 = new Propeller(50);
		propellersR2.add(p23);
		Propeller p24 = new Propeller(50);
		propellersR2.add(p24);
		Propeller p25 = new Propeller(30);
		propellersR2.add(p25);
		Propeller p26 = new Propeller(10);
		propellersR2.add(p26);
		
		Rocket rocketTwo = new Rocket("LDSFJA32",propellersR2);
		return rocketTwo;
	}
}

