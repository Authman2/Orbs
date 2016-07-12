package MAIN;

import java.awt.image.BufferedImage;

import visualje.JEImage;

public class Assets {
	
	//The sprite sheet
	JEImage spriteSheet;
	
	/* The individual parts of the environment */
	
	//The ground
	public static BufferedImage grass_1, tree_1, tree_2, tree_3, rock;
	
	//A house
	public static BufferedImage house_topLeft, house_topMiddle, house_topRight,
								house_bottomLeft, house_bottomMiddle, house_bottomRight,
								house_door, wood_floor, rug_left, rug_right;
	
	//Black space
	public static BufferedImage black_space;
	
	/* The player sprites */
	
	//Stills
	public static BufferedImage player_down, player_up, player_left, player_right;
	
	//Walking
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
		house_topLeft = spriteSheet.getPart(160, 0, 32, 32);
		house_topMiddle = spriteSheet.getPart(192, 0, 32, 32);
		house_topRight = spriteSheet.getPart(224, 0, 32, 32);
		house_bottomLeft = spriteSheet.getPart(160, 32, 32, 32);
		house_bottomMiddle = spriteSheet.getPart(192, 32, 32, 32);
		house_bottomRight = spriteSheet.getPart(224, 32, 32, 32);
		house_door = spriteSheet.getPart(192, 64, 32, 32);
		tree_3 = spriteSheet.getPart(96, 32, 32, 32);
		rock = spriteSheet.getPart(128, 32, 32, 32);
		wood_floor = spriteSheet.getPart(96, 64, 32, 32);
		rug_left = spriteSheet.getPart(128, 64, 32, 32);
		rug_right = spriteSheet.getPart(160, 96, 32, 32);
		black_space = spriteSheet.getPart(96, 96, 32, 32);
	}
	
}