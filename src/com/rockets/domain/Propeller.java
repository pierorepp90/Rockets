package com.rockets.domain;

public class Propeller{

	public int actualPower;
	public int maxPower;
	
	public int getActualPower() {
		return actualPower;
	}

	public int getMaxPower() {
		return maxPower;
	}
	
	
	public void setActualPower(int actualPower) {
		this.actualPower = actualPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}


	public Propeller(int maxPower) {
		this.maxPower=maxPower;
		this.actualPower=0;
	}


	public Propeller() {

	}
	

	
}
