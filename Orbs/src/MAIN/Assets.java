package MAIN;

import java.awt.image.BufferedImage;

import visualje.JEImage;

public class Assets {
	
	//The sprite sheet
	JEImage spritesheet;
	
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
	
	
	/* NPCs */
	public static BufferedImage scientist_down, scientist_up, scientist_left, scientist_right,
								catNPC_down, catNPC_up, catNPC_left, catNPC_right,
								thief_left, thief_right,
								chemContr1_down, chemContr1_up, chemContr1_left, chemContr1_right,
								chemContr2_down, chemContr2_up, chemContr2_left, chemContr2_right,
								chemContr3_down, chemContr3_up, chemContr3_left, chemContr3_right,
								lumberjack_down, lumberjack_up, lumberjack_left, lumberjack_right,
								randomMan1_down, randomMan1_up, randomMan1_left, randomMan1_right,
								randomMan2_down, randomMan2_up, randomMan2_left, randomMan2_right,
								randomMan3_down, randomMan3_up, randomMan3_left, randomMan3_right,
								randomMan4_down, randomMan4_up, randomMan4_left, randomMan4_right,
								randomMan5_down, randomMan5_up, randomMan5_left, randomMan5_right,
								randomWoman1_down, randomWoman1_up, randomWoman1_left, randomWoman1_right,
								randomWoman2_down, randomWoman2_up, randomWoman2_left, randomWoman2_right,
								randomWoman3_down, randomWoman3_up, randomWoman3_left, randomWoman3_right,
								randomWoman4_down, randomWoman4_up, randomWoman4_left, randomWoman4_right,
								randomWoman5_down, randomWoman5_up, randomWoman5_left, randomWoman5_right,
								randomWoman6_down, randomWoman6_up, randomWoman6_left, randomWoman6_right;
	
	
	public void initialize() {
		//Create the sprite sheet image
		spritesheet = new JEImage(Orbs.class, "/IMAGES/GameSpriteSheet.png");
		
		//NPCs
		scientist_down = spritesheet.getPart(0, 160, 32, 32);
		scientist_up = spritesheet.getPart(32, 160, 32, 32);
		scientist_left = spritesheet.getPart(32, 192, 32, 32);
		scientist_right = spritesheet.getPart(0, 192, 32, 32);
		
		catNPC_down = spritesheet.getPart(160, 288, 32, 32);
		catNPC_up = spritesheet.getPart(160, 320, 32, 32);
		catNPC_left = spritesheet.getPart(160, 384, 32, 32);
		catNPC_right = spritesheet.getPart(160, 352, 32, 32);
		
		thief_left = spritesheet.getPart(224, 288, 32, 32);
		thief_right = spritesheet.getPart(192, 288, 32, 32);
		
		chemContr1_down = spritesheet.getPart(160, 160, 32, 32);
		chemContr1_up = spritesheet.getPart(160, 192, 32, 32);
		chemContr1_left = spritesheet.getPart(160, 256, 32, 32);
		chemContr1_right = spritesheet.getPart(160, 224, 32, 32);
		
		chemContr2_down = spritesheet.getPart(192, 160, 32, 32);
		chemContr2_up = spritesheet.getPart(192, 192, 32, 32);
		chemContr2_left = spritesheet.getPart(192, 256, 32, 32);
		chemContr2_right = spritesheet.getPart(192, 224, 32, 32);
		
		chemContr3_down = spritesheet.getPart(224, 160, 32, 32);
		chemContr3_up = spritesheet.getPart(224, 192, 32, 32);
		chemContr3_left = spritesheet.getPart(224, 256, 32, 32);
		chemContr3_right = spritesheet.getPart(224, 224, 32, 32);
		
		lumberjack_down = spritesheet.getPart(0, 288, 32, 32);
		lumberjack_up = spritesheet.getPart(32, 288, 32, 32);
		lumberjack_left = spritesheet.getPart(32, 320, 32, 32);
		lumberjack_right = spritesheet.getPart(0, 320, 32, 32);
		
		randomMan1_down = spritesheet.getPart(0, 224, 32, 32);
		randomMan1_up = spritesheet.getPart(32, 224, 32, 32);
		randomMan1_left = spritesheet.getPart(32, 256, 32, 32);
		randomMan1_right = spritesheet.getPart(0, 256, 32, 32);
		
		randomMan2_down = spritesheet.getPart(0, 352, 32, 32);
		randomMan2_up = spritesheet.getPart(32, 352, 32, 32);
		randomMan2_left = spritesheet.getPart(32, 384, 32, 32);
		randomMan2_right = spritesheet.getPart(0, 384, 32, 32);
		
		randomMan3_down = spritesheet.getPart(0, 416, 32, 32);
		randomMan3_up = spritesheet.getPart(32, 416, 32, 32);
		randomMan3_left = spritesheet.getPart(32, 448, 32, 32);
		randomMan3_right = spritesheet.getPart(0, 448, 32, 32);
		
		randomMan4_down = spritesheet.getPart(64, 160, 32, 32);
		randomMan4_up = spritesheet.getPart(64, 192, 32, 32);
		randomMan4_left = spritesheet.getPart(64, 256, 32, 32);
		randomMan4_right = spritesheet.getPart(64, 224, 32, 32);
		
		randomMan5_down = spritesheet.getPart(128, 160, 32, 32);
		randomMan5_up = spritesheet.getPart(128, 192, 32, 32);
		randomMan5_left = spritesheet.getPart(128, 256, 32, 32);
		randomMan5_right = spritesheet.getPart(128, 224, 32, 32);
		
		randomWoman1_down = spritesheet.getPart(64, 288, 32, 32);
		randomWoman1_up = spritesheet.getPart(64, 320, 32, 32);
		randomWoman1_left = spritesheet.getPart(64, 384, 32, 32);
		randomWoman1_right = spritesheet.getPart(64, 352, 32, 32);
		
		randomWoman2_down = spritesheet.getPart(96, 160, 32, 32);
		randomWoman2_up = spritesheet.getPart(96, 192, 32, 32);
		randomWoman2_left = spritesheet.getPart(96, 256, 32, 32);
		randomWoman2_right = spritesheet.getPart(96, 224, 32, 32);
		
		randomWoman3_down = spritesheet.getPart(96, 288, 32, 32);
		randomWoman3_up = spritesheet.getPart(96, 320, 32, 32);
		randomWoman3_left = spritesheet.getPart(96, 384, 32, 32);
		randomWoman3_right = spritesheet.getPart(96, 352, 32, 32);
		
		randomWoman4_down = spritesheet.getPart(64, 416, 32, 32);
		randomWoman4_up = spritesheet.getPart(64, 448, 32, 32);
		randomWoman4_left = spritesheet.getPart(96, 448, 32, 32);
		randomWoman4_right = spritesheet.getPart(96, 416, 32, 32);
		
		randomWoman5_down = spritesheet.getPart(128, 288, 32, 32);
		randomWoman5_up = spritesheet.getPart(128, 320, 32, 32);
		randomWoman5_left = spritesheet.getPart(128, 384, 32, 32);
		randomWoman5_right = spritesheet.getPart(128, 352, 32, 32);
		
		randomWoman6_down = spritesheet.getPart(128, 416, 32, 32);
		randomWoman6_up = spritesheet.getPart(160, 416, 32, 32);
		randomWoman6_left = spritesheet.getPart(160, 448, 32, 32);
		randomWoman6_right = spritesheet.getPart(128, 448, 32, 32);
		
		//Idle player positions
		player_down = spritesheet.getPart(0, 32, 32, 32);
		player_up = spritesheet.getPart(0, 64, 32, 32);
		player_left = spritesheet.getPart(0, 96, 32, 32);
		player_right = spritesheet.getPart(64, 128, 32, 32);
		
		//Moving player positions
		player_down_walk1 = spritesheet.getPart(32, 32, 32, 32);
		player_down_walk2 = spritesheet.getPart(64, 32, 32, 32);
		player_up_walk1 = spritesheet.getPart(32, 64, 32, 32);
		player_up_walk2 = spritesheet.getPart(64, 64, 32, 32);
		player_left_walk1 = spritesheet.getPart(32, 96, 32, 32);
		player_left_walk2 = spritesheet.getPart(64, 96, 32, 32);
		player_right_walk1 = spritesheet.getPart(0, 128, 32, 32);
		player_right_walk2 = spritesheet.getPart(32, 128, 32, 32);
	
		//Environment
		grass_1 = spritesheet.getPart(0, 0, 32, 32);
		tree_1 = spritesheet.getPart(96, 0, 32, 32);
		tree_2 = spritesheet.getPart(128, 0, 32, 32);
		house_topLeft = spritesheet.getPart(160, 0, 32, 32);
		house_topMiddle = spritesheet.getPart(192, 0, 32, 32);
		house_topRight = spritesheet.getPart(224, 0, 32, 32);
		house_bottomLeft = spritesheet.getPart(160, 32, 32, 32);
		house_bottomMiddle = spritesheet.getPart(192, 32, 32, 32);
		house_bottomRight = spritesheet.getPart(224, 32, 32, 32);
		house_door = spritesheet.getPart(192, 64, 32, 32);
		tree_3 = spritesheet.getPart(96, 32, 32, 32);
		rock = spritesheet.getPart(128, 32, 32, 32);
		wood_floor = spritesheet.getPart(96, 64, 32, 32);
		rug_left = spritesheet.getPart(128, 64, 32, 32);
		rug_right = spritesheet.getPart(160, 96, 32, 32);
		black_space = spritesheet.getPart(96, 96, 32, 32);
	}
	
}