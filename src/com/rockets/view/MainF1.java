package com.rockets.view;

import java.util.ArrayList;
import java.util.List;

import com.rockets.domain.Propeller;
import com.rockets.domain.Rocket;

public class MainF1 {

	public static void main(String[] args) {
		List<Propeller> propellersR1 = new ArrayList<Propeller>();
		List<Propeller> propellersR2 = new ArrayList<Propeller>();
		
		Propeller p11 = new Propeller();
		propellersR1.add(p11);
		Propeller p12 = new Propeller();
		propellersR1.add(p12);
		Propeller p13 = new Propeller();
		propellersR1.add(p13);

		Rocket rocketOne = new Rocket("32WESSDS",propellersR1);
		
		Propeller p21 = new Propeller();
		propellersR2.add(p21);
		Propeller p22 = new Propeller();
		propellersR2.add(p22);
		Propeller p23 = new Propeller();
		propellersR2.add(p23);
		Propeller p24 = new Propeller();
		propellersR2.add(p24);
		Propeller p25 = new Propeller();
		propellersR2.add(p25);
		Propeller p26 = new Propeller();
		propellersR2.add(p26);
		
		Rocket rocketTwo = new Rocket("LDSFJA32",propellersR2);
		
		System.out.println("Rocket 1:\n code: " + rocketOne.getCode() + "\n Propellers: " + rocketOne.getPropellers().size());
		System.out.println("Rocket 2:\n code: " + rocketTwo.getCode() + "\n Propellers: " + rocketTwo.getPropellers().size());
		
		
	}

}
