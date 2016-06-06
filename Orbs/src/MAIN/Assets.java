package MAIN;

import java.awt.image.BufferedImage;

import visualje.JEImage;

public class Assets {
	
	//The environment sprite sheet
	JEImage spriteSheet;
	
	//The individual parts of the environment
	public static BufferedImage grass_1, tree_1, tree_2;
	
	//The player sprites
	public static BufferedImage player_down, player_up, player_left, player_right;
	public static BufferedImage player_down_walk1, player_down_walk2,
								player_up_walk1, player_up_walk2,
								player_left_walk1, player_left_walk2,
								player_right_walk1, player_right_walk2;
	
	
	public void initialize() {
		//Create the sprite sheet image
		spriteSheet = new JEImage(Orbs.class, "/IMAGES/GameSpriteSheet.png");
		
		//Idle player positions
		player_down = spriteSheet.getPart(0, 32, 32, 32);
		player_up = spriteSheet.getPart(0, 64, 32, 32);
		player_left = spriteSheet.getPart(0, 96, 32, 32);
		player_right = spriteSheet.getPart(64, 128, 32, 32);
		
		//Moving player positions
		player_down_walk1 = spriteSheet.getPart(32, 32, 32, 32);
		player_down_walk2 = spriteSheet.getPart(64, 32, 32, 32);
		player_up_walk1 = spriteSheet.getPart(32, 64, 32, 32);
		player_up_walk2 = spriteSheet.getPart(64, 64, 32, 32);
		player_left_walk1 = spriteSheet.getPart(32, 96, 32, 32);
		player_left_walk2 = spriteSheet.getPart(64, 96, 32, 32);
		player_right_walk1 = spriteSheet.getPart(0, 128, 32, 32);
		player_right_walk2 = spriteSheet.getPart(32, 128, 32, 32);
	
		//Environment
		grass_1 = spriteSheet.getPart(0, 0, 32, 32);
		tree_1 = spriteSheet.getPart(96, 0, 32, 32);
		tree_2 = spriteSheet.getPart(128, 0, 32, 32);
	}
	
}