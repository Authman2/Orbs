package MAIN;

import java.awt.image.BufferedImage;

import visualje.JEImage;

public class Assets {
	
	//The environment sprite sheet
	JEImage environmentSpriteSheet;
	
	//The individual parts of the environment
	public static BufferedImage grass_1, tree_1, tree_2;
	
	
	public void initialize() {
		environmentSpriteSheet = new JEImage(Orbs.class, "/IMAGES/Environment.png");
		
		
		grass_1 = environmentSpriteSheet.getPart(0, 0, 32, 32);
		tree_1 = environmentSpriteSheet.getPart(96, 0, 32, 32);
		tree_2 = environmentSpriteSheet.getPart(128, 0, 32, 32);
	}
	
}