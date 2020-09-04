package com.rockets.view;

import com.rockets.domain.Rocket;

public class MainF4 {

	public static void main(String[] args) {
		Rocket rocketOne = Rocket.createRocketOne();
		Rocket rocketTwo = Rocket.createRocketTwo();
		
		rocketOne.speedUp();
		rocketTwo.speedUp();
		
		try {
			Thread.currentThread();
			Thread.sleep((int)Math.floor(Math.random() * 2500));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rocketOne.administratePower(rocketOne.setSpeed((int)Math.floor(Math.random() * 800)));
		rocketTwo.administratePower(rocketTwo.setSpeed((int)Math.floor(Math.random() * 1200)));
	}

}
