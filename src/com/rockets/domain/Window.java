package com.rockets.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends JFrame implements ActionListener {

    private JLabel infoR1, infoR2;           
    private JButton boton1, boton2, boton3, boton4, boton5;          
    public Window() {
        super();                   
        configureWindow();        
        inicializeComponents();   
    }

    private void configureWindow() {
        this.setTitle("Rocket Race");                   
        this.setSize(800, 500);                                 
        this.setLocationRelativeTo(null);                      
        this.setLayout(null);                                   
        this.setResizable(false);                               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }

    private void inicializeComponents() {

        infoR1 = new JLabel("Rocket 1");
        infoR2 = new JLabel("Rocket 2");
        boton1 = new JButton("Speed up");  
        boton2 = new JButton("Brake");
        boton3 = new JButton("Speed up");
        boton4 = new JButton("Brake");
        boton5 = new JButton("Show Info");
        

        infoR1.setBounds(50, 10, 200, 250);   
        infoR2.setBounds(450, 10, 200, 250);       
        boton1.setBounds(100, 370, 100, 50);  
        boton1.addActionListener(this);    
        boton2.setBounds(210, 370, 100, 50); 
        boton2.addActionListener(this);
        boton3.setBounds(450, 370, 100, 50); 
        boton3.addActionListener(this);
        boton4.setBounds(560, 370, 100, 50); 
        boton4.addActionListener(this);
        boton5.setBounds(330, 270, 100, 100); 
        boton5.addActionListener(this);

        this.add(infoR1);
        this.add(infoR2);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
    }
	Rocket rocketOne = Rocket.createRocketOne();
	Rocket rocketTwo = Rocket.createRocketTwo();
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
    	if (e.getSource()==boton1) { 
    		rocketOne.speedUp();
    	}
    	if (e.getSource()==boton2) {
    		rocketOne.brake();
    	}
    	if (e.getSource()==boton3) {
    		rocketTwo.speedUp();
    	}
    	if (e.getSource()==boton4) {
    		rocketTwo.brake();
    	}
    	if(e.getSource()==boton5) {
    			infoR1.setText(rocketOne.rocketData());			
    			infoR2.setText(rocketTwo.rocketData());		
    		}
    	}
    }

