package MAIN;

import java.awt.image.BufferedImage;

/** A class used for creating 2D animations. 
 * 
 * Originally written by TheIndieDeveloper (https://www.youtube.com/user/InidDevo/about)
 */
public class Animator {
	
	//The images of the animation
	BufferedImage[] images;
	
	
	//Is the animation running?
	volatile boolean running = false;
	
	
	//The sprite that is currently being shown
	public BufferedImage sprite;
	
	
	//The time and speed of the animation
	private long prevTime, speed;
	
	
	//The frame at a particular time
	private int frameatPause, currentFrame;

	
	//////////// Constructor ////////////
	public Animator(BufferedImage[] imgs) { 
		images = imgs; 
	}
	
	
	
	//////////// Method ////////////
	
	/** Sets the speed of the animation */
	public void setSpeed(long speed){ this.speed = speed; }

	/** Updates the animation. */
	public void update(long time){
		if(running){
			if(time - prevTime >= speed){
				currentFrame++;
				try{
					if(currentFrame <= images.length){
						sprite = images[currentFrame];
					}else{
						reset();
					}
				}catch(IndexOutOfBoundsException e){
					reset();
					sprite = images[currentFrame];
				}
				prevTime = time;
			}
		}
	}
	
	/** Play the animation. */
	public void play(){
		running = true;
		prevTime = 0;
		frameatPause = 0;
		currentFrame = 0;
	}
	
	/** Stop the animation. */
	public void stop(){
		running = false;
		prevTime = 0;
		frameatPause = 0;
		currentFrame = 0;
	}
	
	/** Pause the animation. */
	public void pause(){
		frameatPause = currentFrame;
		running = false;
	}
	
	/** Resume the animation after pausing. */
	public void resume(){
		currentFrame = frameatPause;
	}
	
	/** Reset the animation. */
	public void reset(){
		currentFrame = 0;
	}
	
	/** Returns whether or not the animation is done. */
	public boolean isDoneAnimating(){
		if(currentFrame == images.length){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	

}
