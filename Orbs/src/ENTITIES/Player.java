package ENTITIES;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import MAIN.Animator;
import MAIN.Assets;
import STATES.WorldState;
import visualje.Vector2D;

public class Player extends Entity {
	
	//Animator for the player
	Animator walk_down, walk_up, walk_right, walk_left;
	
	//The world state that this player is in
	WorldState worldState;
	
	
	public Player(WorldState ws) {
		position = new Vector2D(8,6);
		worldState = ws;
		initialize();
	}
	
	

	//////////// Abstract Methods ///////////////
	
	@Override
	public void initialize() {
		BufferedImage[] walkDown = {Assets.player_down_walk1, Assets.player_down, Assets.player_down_walk2};
		walk_down = new Animator(walkDown);
		walk_down.setSpeed(180);
		walk_down.play();

		BufferedImage[] walkUp = {Assets.player_up_walk1, Assets.player_up, Assets.player_up_walk2};
		walk_up = new Animator(walkUp);
		walk_up.setSpeed(180);
		walk_up.play();
		
		BufferedImage[] walkRight = {Assets.player_right_walk1, Assets.player_right, Assets.player_right_walk2};
		walk_right = new Animator(walkRight);
		walk_right.setSpeed(180);
		walk_right.play();
		
		BufferedImage[] walkLeft = {Assets.player_left_walk1, Assets.player_left, Assets.player_left_walk2};
		walk_left = new Animator(walkLeft);
		walk_left.setSpeed(180);
		walk_left.play();
	}

	@Override
	public void update(double time) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		if(facing == 0) {
			if(worldState.getWorld().down) {
				g.drawImage(walk_down.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_down.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_down, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
		
		if(facing == 1) {
			if(worldState.getWorld().right) {
				g.drawImage(walk_right.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_right.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_right, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
			
		if(facing == 2) {
			if(worldState.getWorld().up) {
				g.drawImage(walk_up.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_up.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_up, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
		
		if(facing == 3) {
			if(worldState.getWorld().left) {
				g.drawImage(walk_left.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_left.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_left, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
	}
	

} //End of class
