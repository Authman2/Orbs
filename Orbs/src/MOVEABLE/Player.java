package MOVEABLE;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Animator;
import MAIN.Assets;
import STATES.WorldState;

public class Player extends Entity implements IUD, Serializable {
	private static final long serialVersionUID = 70648151348581551L;

	
	//World state
	WorldState worldstate;
	
	//The player's name
	public String playerName = "";
	
	//The direction the player is facing
	/* 0 = down
	 * 1 = right 
	 * 2 = up 
	 * 3 = left */
	public int facing;
	
	//Animators
	public int animationState = 0;
	private ArrayList<BufferedImage> walkUp, walkDown, walkLeft, walkRight;
	Animator anim_up, anim_down, anim_left, anim_right;
	
	
	//Stats (health, level, etc.) for the player.
	PlayerStats stats = new PlayerStats();
	
	//Interaction
	public static boolean interacting;

	
	public Player(WorldState  w) {
		worldstate = w;
		position = new Vector2D(10,7);
		this.isPlayer(true);
	}
	
	@Override
	public void initialize() {	
		facing = 0;
		
		startAnimations();
	}

	

	@Override
	public void draw(Graphics2D g) {
		//g.setColor(Color.black);
		//g.fillRect((int)position.X*32, (int)position.Y*32, 32, 32);
		
		AffineTransform t = new AffineTransform();
		t.translate(position.X*32, position.Y*32);
		t.scale(1.15, 1.15);

		//Set the animation state to the idle state if not moving
		if(!worldstate.world.up && !worldstate.world.down && !worldstate.world.right && !worldstate.world.left) {
			animationState = 4;
		}
		
		//Draw the animation sprite while the animation state is not 4.
		if(animationState == 0)
			g.drawImage(anim_down.sprite, t, null);
			if(worldstate.world.down) {
				anim_down.update(System.currentTimeMillis());
			}
		else if(animationState == 1)
			g.drawImage(anim_right.sprite, t, null);
			if(worldstate.world.right) {
				anim_right.update(System.currentTimeMillis());
			}
		else if(animationState == 2)
			g.drawImage(anim_up.sprite, t, null);
			if(worldstate.world.up) {
				anim_up.update(System.currentTimeMillis());
			}
		else if(animationState == 3)
			g.drawImage(anim_left.sprite, t, null);
			if(worldstate.world.left) {
				anim_left.update(System.currentTimeMillis());
			}
			
		//If the animation state is 4, then draw the idle image depending on where player is facing.
		else
			if(facing == 0) {
				g.drawImage(Assets.playerIdleDown, t, null);
			} else if(facing == 1) {
				g.drawImage(Assets.playerIdleRight, t, null);
			} else if(facing == 2) {
				g.drawImage(Assets.playerIdleUp, t, null);
			} else if(facing == 3) {
				g.drawImage(Assets.playerIdleLeft, t, null);
			}
		
		//Draw interaction box
		g.setColor(Color.black);
	}
	
	@Override
	public void update(double time) {
		
	}
	
	
	public PlayerStats getStats() { return stats; }
	
	private void startAnimations() {
		//Arraylists of animations
		walkUp = new ArrayList<BufferedImage>();
		walkDown = new ArrayList<BufferedImage>();
		walkLeft = new ArrayList<BufferedImage>();
		walkRight = new ArrayList<BufferedImage>();
		
		//Add the appropriate sprites for each animation
		walkUp.add(Assets.playerWalkUp1);
		walkUp.add(Assets.playerIdleUp);
		walkUp.add(Assets.playerWalkUp2);
		
		walkDown.add(Assets.playerWalkDown1);
		walkDown.add(Assets.playerIdleDown);
		walkDown.add(Assets.playerWalkDown2);
		
		walkRight.add(Assets.playerWalkRight1);
		walkRight.add(Assets.playerIdleRight);
		walkRight.add(Assets.playerWalkRight2);
		
		walkLeft.add(Assets.playerWalkLeft1);
		walkLeft.add(Assets.playerIdleLeft);
		walkLeft.add(Assets.playerWalkLeft2);
		
		//Configure the animators
		anim_up = new Animator(walkUp);
		anim_up.setSpeed(60);
		anim_up.play();
		anim_down = new Animator(walkDown);
		anim_down.setSpeed(60);
		anim_down.play();
		anim_left = new Animator(walkLeft);
		anim_left.setSpeed(60);
		anim_left.play();
		anim_right = new Animator(walkRight);
		anim_right.setSpeed(60);
		anim_right.play();
	}
	
	
} //End of Player class.
