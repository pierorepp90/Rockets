package com.rockets.view;

import java.util.ArrayList;
import java.util.List;

import com.rockets.domain.Propeller;
import com.rockets.domain.Rocket;

public class MainF2 {

	public static void main(String[] args) {
		List<Propeller> propellersR1 = new ArrayList<Propeller>();
		List<Propeller> propellersR2 = new ArrayList<Propeller>();
		
		Propeller p11 = new Propeller(10);
		propellersR1.add(p11);
		Propeller p12 = new Propeller(30);
		propellersR1.add(p12);
		Propeller p13 = new Propeller(80);
		propellersR1.add(p13);

		Rocket rocketOne = new Rocket("32WESSDS",propellersR1);
		
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
		
		String rocketData = rocketOne.getCode() + ": ";
		
		for(int i=0; i<rocketOne.getPropellers().size(); i++) {
			if(i==rocketOne.getPropellers().size()-1) {
				rocketData += rocketOne.getPropellers().get(i).getMaxPower() + ".";
			}else {
				rocketData += rocketOne.getPropellers().get(i).getMaxPower() + ",";
			}
		}
		rocketData += "\n" + rocketTwo.getCode() + ":";
		for(int i=0; i<rocketTwo.getPropellers().size(); i++) {
			if(i==rocketTwo.getPropellers().size()-1) {
				rocketData += rocketTwo.getPropellers().get(i).getMaxPower() + ".";
			}else {
				rocketData += rocketTwo.getPropellers().get(i).getMaxPower() + ",";
			}
		}
		System.out.println(rocketData);
	}
	
}