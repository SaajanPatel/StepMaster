package com.fam.step.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.fam.step.graphic.stage.GameStageImage;
import com.fam.step.graphic.stage.IntroStage;

public class GameCanvas extends Canvas {
	
	private int bufferWidth;
	private int bufferHeight;
	private Image bufferImage;
	private Graphics bufferGraphics;

	
	public GameCanvas() {
		super();
		bufferWidth = this.getWidth();
		bufferHeight = this.getHeight();
	}
	
	@Override
	public void update(Graphics g){
	    paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		
	    if(bufferWidth!=getSize().width ||
	    	      bufferHeight!=getSize().height ||
	    	      bufferImage==null || bufferGraphics==null)
	    	        resetBuffer();
		
	    if(bufferGraphics != null){
	        //this clears the offscreen image, not the onscreen one
	        bufferGraphics.clearRect(0,0,bufferWidth,bufferHeight);

	        //calls the paintbuffer method with 
	        //the offscreen graphics as a param
	        paintBuffer(bufferGraphics);

	        //we finaly paint the offscreen image onto the onscreen image
	        g.drawImage(bufferImage,0,0,this);
	    }
	}
	
	private void resetBuffer(){
	    // always keep track of the image size
	    bufferWidth=getSize().width;
	    bufferHeight=getSize().height;

	    //    clean up the previous image
	    if(bufferGraphics!=null){
	        bufferGraphics.dispose();
	        bufferGraphics=null;
	    }
	    if(bufferImage!=null){
	        bufferImage.flush();
	        bufferImage=null;
	    }
	    System.gc();

	    //    create the new image with the size of the panel
	    bufferImage=createImage(bufferWidth,bufferHeight);
	    bufferGraphics=bufferImage.getGraphics();
	}
	
	public void paintBuffer(Graphics g) {

	}
	
	GameState state = GameState.INTRO;
	
	enum GameState {
		INTRO(IntroStage.class);
		
		GameState(Class<GameStageImage> type) {
			
		}
	}

}
