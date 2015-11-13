package com.fam.step.graphic;

import java.awt.Frame;

public class GameFrame extends Frame {
	
	public GameFrame() {
		super("StepMaster");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        
	    this.setSize(1000,650);
	    this.setResizable(false);
	    
	    this.add(new GameCanvas());
	    
        this.setVisible(true);
	}
	
}