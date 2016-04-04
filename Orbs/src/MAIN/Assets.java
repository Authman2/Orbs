package MAIN;

import java.awt.image.BufferedImage;

import myproject.gos.main.SpriteSheet;
import myproject.gos.main.loadImageFrom;

public class Assets {
	
	public static SpriteSheet playerss = new SpriteSheet();
	SpriteSheet environment = new SpriteSheet();
	SpriteSheet gameobjects = new SpriteSheet();
	SpriteSheet misc = new SpriteSheet();
	
	/* PLAYER */
	public static BufferedImage playerIdleUp, playerIdleDown, playerIdleLeft, playerIdleRight;
	public static BufferedImage playerAttackUp1, playerAttackDown1, playerAttackLeft1, playerAttackRight1;
	public static BufferedImage playerAttackUp2, playerAttackDown2, playerAttackLeft2, playerAttackRight2;
	
	/* ENVIRONMENT */
	public static BufferedImage Grass_1, Grass_2, Cave_Entry, Rock_On_Grass, Flower, Bush, Sand, Water_TopLeft, Water_Top,
								Water_TopRight, Red_Brick, Gray_Brick, Cave_Floor, Tree_Top, Dead_Tree, City_Tile,
								Window, Water_Left, Water_Base, Water_Right, Wood_Door, Wood_Top, Rock_On_CaveFloor,
								Tree_Bottom, Water_BottomLeft, Water_Bottom, Water_BottomRight, Wood_Floor, Wood_Base,
								Rock, CaveEntry_OnDirt, Bridge_Left, Bridge_Top, Bridge_Base, Rock_On_Dirt, Bridge_Bottom,
								Bridge_BaseSide, Bridge_Right, Dirt_TopLeft, Dirt_Top, Dirt_TopRight, Dirt_Left, Dirt_Base,
								Dirt_Right, Dirt_BottomLeft, Dirt_Bottom, Dirt_BottomRight;
	
	/* GAME OBJECTS */
	public static BufferedImage apple, orange, money_1, money_2, money_3, fish, hatchet, wood_log, boat, pickaxe;
	
	/* BUTTONS && MISC */
	public static BufferedImage inventorySlotBG, textBoxClick, optionClick, optionBox, textBox, selectedslotimg;

	
	
	public void init() {
		playerss.setSpriteSheet(loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/playerSpriteSheet.png"));
		environment.setSpriteSheet(loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/environmentSpriteSheet.png"));
		gameobjects.setSpriteSheet(loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/gameObjectsSpriteSheet.png"));
		misc.setSpriteSheet(loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/miscSpriteSheet.png"));
		
		/* PLAYER */
		playerIdleUp = playerss.getTile(0, 32, 32, 32);
		playerIdleDown = playerss.getTile(0, 0, 32, 32);
		playerIdleLeft = playerss.getTile(0, 64, 32, 32);
		playerIdleRight = playerss.getTile(0, 96, 32, 32);
		playerAttackUp1 = playerss.getTile(96, 32, 32, 32);
		playerAttackDown1 = playerss.getTile(96, 0, 32, 32);
		playerAttackLeft1 = playerss.getTile(96, 64, 32, 32);
		playerAttackRight1 = playerss.getTile(96, 96, 32, 32);
		playerAttackUp2 = playerss.getTile(128, 32, 32, 32);
		playerAttackDown2 = playerss.getTile(128, 0, 32, 32);
		playerAttackLeft2 = playerss.getTile(128, 64, 32, 32);
		playerAttackRight2 = playerss.getTile(128, 96, 32, 32);
		
		
		/* ENVIRONMENT */
		Grass_1 = environment.getTile(0, 0, 32, 32);
		Grass_2 = environment.getTile(32, 0, 32, 32);
		Cave_Entry = environment.getTile(64, 0, 32, 32);
		Rock_On_Grass = environment.getTile(96, 0, 32, 32);
		Flower = environment.getTile(128, 0, 32, 32);
		Bush = environment.getTile(160, 0, 32, 32);
		Sand = environment.getTile(192, 0, 32, 32);
		Water_TopLeft = environment.getTile(224, 0, 32, 32);
		Water_Top = environment.getTile(256, 0, 32, 32);
		Water_TopRight = environment.getTile(288, 0, 32, 32);
		Red_Brick = environment.getTile(0, 32, 32, 32);
		Gray_Brick = environment.getTile(32, 32, 32, 32);
		Cave_Floor = environment.getTile(64, 32, 32, 32);
		Tree_Top = environment.getTile(96, 32, 32, 32);
		Dead_Tree = environment.getTile(128, 32, 32, 32);
		City_Tile = environment.getTile(160, 32, 32, 32);
		Window = environment.getTile(192, 32, 32, 32);
		Water_Left = environment.getTile(224, 32, 32, 32);
		Water_Base = environment.getTile(256, 32, 32, 32);
		Water_Right = environment.getTile(288, 32, 32, 32);
		Wood_Door = environment.getTile(0, 64, 32, 32);
		Wood_Top = environment.getTile(32, 64, 32, 32);
		Rock_On_CaveFloor = environment.getTile(64, 64, 32, 32);
		Tree_Bottom = environment.getTile(96, 64, 32, 32);
		Water_BottomLeft = environment.getTile(224, 64, 32, 32);
		Water_Bottom = environment.getTile(256, 64, 32, 32);
		Water_BottomRight = environment.getTile(288, 64, 32, 32);
		Wood_Floor = environment.getTile(0, 96, 32, 32);
		Wood_Base = environment.getTile(32, 96, 32, 32);
		Rock = environment.getTile(64, 96, 32, 32);
		CaveEntry_OnDirt = environment.getTile(96, 96, 32, 32);
		Bridge_Left = environment.getTile(224, 96, 32, 32);
		Bridge_Top = environment.getTile(256, 96, 32, 32);
		Bridge_Base = environment.getTile(288, 96, 32, 32);
		Rock_On_Dirt = environment.getTile(64, 128, 32, 32);
		Bridge_Bottom = environment.getTile(224, 128, 32, 32);
		Bridge_BaseSide = environment.getTile(256, 128, 32, 32);
		Bridge_Right = environment.getTile(288, 128, 32, 32);
		Dirt_TopLeft = environment.getTile(224, 160, 32, 32);
		Dirt_Top = environment.getTile(256, 160, 32, 32);
		Dirt_TopRight = environment.getTile(288, 160, 32, 32);
		Dirt_Left = environment.getTile(224, 192, 32, 32);
		Dirt_Base = environment.getTile(256, 192, 32, 32);
		Dirt_Right = environment.getTile(288, 192, 32, 32);
		Dirt_BottomLeft = environment.getTile(224, 224, 32, 32);
		Dirt_Bottom = environment.getTile(256, 224, 32, 32);
		Dirt_BottomRight = environment.getTile(288, 224, 32, 32);;
		
		
		/* GAME OBJECTS */
		apple = gameobjects.getTile(0, 0, 32, 32);
		orange = gameobjects.getTile(32, 0, 32, 32);
		money_1 = gameobjects.getTile(64, 0, 32, 32);
		money_2 = gameobjects.getTile(96, 0, 32, 32);
		money_3 = gameobjects.getTile(128, 0, 32, 32);
		fish = gameobjects.getTile(0, 32, 32, 32);
		hatchet = gameobjects.getTile(32, 32, 32, 32);
		wood_log = gameobjects.getTile(64, 32, 32, 32);
		boat = gameobjects.getTile(96, 32, 32, 32);
		pickaxe = gameobjects.getTile(128, 32, 32, 32);
		
		
		/* MISC */
		inventorySlotBG = misc.getTile(64, 0, 32, 32);
		textBoxClick = misc.getTile(96, 0, 32, 32);
		optionClick = misc.getTile(128, 0, 32, 32);
		selectedslotimg = misc.getTile(0, 32, 32, 32);
		optionBox = loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/OptionBox.png");
		textBox = loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/TextBox.png");
	}
	
	public static BufferedImage getPlayerIdle_Up() { return playerIdleUp; }
	
	public static BufferedImage getPlayerIdle_Down() { return playerIdleDown; }
	
	public static BufferedImage getPlayerIdle_Left() { return playerIdleLeft; }
	
	public static BufferedImage getPlayerIdle_Right() { return playerIdleRight; }
	
	public static BufferedImage getPlayerAttackUp_1() { return playerAttackUp1; }
	
	public static BufferedImage getPlayerAttackUp_2() { return playerAttackUp2; }
	
	public static BufferedImage getPlayerAttackDown_1() { return playerAttackDown1; }
	
	public static BufferedImage getPlayerAttackDown_2() { return playerAttackDown2; }
	
	public static BufferedImage getPlayerAttackLeft_1() { return playerAttackLeft1; }
	
	public static BufferedImage getPlayerAttackLeft_2() { return playerAttackLeft2; }
	
	public static BufferedImage getPlayerAttackRight_1() { return playerAttackRight1; }
	
	public static BufferedImage getPlayerAttackRight_2() { return playerAttackRight2; }

	public static BufferedImage getApple() { return apple; }

	public static BufferedImage getOrange() { return orange; }

	public static BufferedImage getMoney_2() { return money_2; }

	public static BufferedImage getFish() { return fish; }

	public static BufferedImage getHatchet() { return hatchet; }

	public static BufferedImage getWoodLog() { return wood_log; }

	public static BufferedImage getBoat() { return boat; }
	
	public static BufferedImage getPickaxe() { return pickaxe; }

	public static BufferedImage getMap(String path) { return loadImageFrom.LoadImageFrom(Orbs.class, "/IMAGES/"+path); 	}
	
	public static BufferedImage getInventorBG() { return inventorySlotBG; }
	
	public static BufferedImage getTextBoxClick() { return textBoxClick; }
	
	public static BufferedImage getOptionBoxImage() { return optionBox; }
}