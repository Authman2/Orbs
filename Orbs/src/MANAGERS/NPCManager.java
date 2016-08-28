package MANAGERS;

import ENTITIES.Direction;
import ENTITIES.Person;
import ITEMS.BakeryReceipt;
import ITEMS.BookstoreReceipt;
import ITEMS.BoxOfTextBooks;
import ITEMS.Cake;
import ITEMS.Coin;
import ITEMS.Container;
import ITEMS.Coupon;
import ITEMS.Hatchet;
import ITEMS.HazmatSuit;
import ITEMS.Item;
import ITEMS.Orb;
import ITEMS.Pickaxe;
import ITEMS.SewingKit;
import ITEMS.Textbook;
import ITEMS.Water;
import MAIN.Assets;
import WORLD.World;
import filesje.ReadFile;
import visualje.Vector2D;

/** Handles adding all of the NPCs to the game world. */
public class NPCManager {

	//The world, used to access many different elements in the game world.
	World world;
	
	//For reading the text for the NPCs
	ReadFile reader;
	
	//The number of lines each npc has
	int lines;
	
	
	
	//The NPCs in the main world
	
	//An array of items that the NPCs have.
	Item[] npcItems;
		
	Person randomPerson_1, randomPerson_2, randomPerson_3, randomPerson_4, randomPerson_5, randomPerson_6, randomPerson_7,
			randomPerson_8, randomPerson_9, randomPerson_10, randomPerson_11, randomPerson_12, randomPerson_13, randomPerson_14,
			randomPerson_15, randomPerson_16, randomPerson_17, randomPerson_18, randomPerson_19, randomPerson_20;
	Person scientist;
	Person chemicalController_1, chemicalController_2, chemicalController_3;
	Person thiefNPC;
	Person treeCutter, treeCutterFriend;
	
	//The NPCs in house_1
	Person player_Relative;
	
	//The NPCs in house_2
	Person giveWaterPerson;
	Person randomPerson_21;
	
	//The NPCs in house_4
	Person randomPerson_22;
	Person randomPerson_23;
	Person randomPerson_24;
	
	//The NPCs in house_10
	Person catNPC;
	
	//The NPCs in house_12
	Person sewingShopOwner;
	
	//The NPCs in house_13
	Person hazmatSuitGiver;
	Person hazmatSuitGiverWife;
	
	//The NPCs in house_17
	Person cakeGiver;
	
	//The NPCs in house_18
	Person student1, student2, student3, student4, student5;
	Person teacher;
	
	//The NPCs in house_22
	Person bookStoreOwner;
	
	//The NPCs in house_24
	Person containerSeller;
	
	//The NPCs in house_26
	Person randomPerson_25, randomPerson_26;
	
	//The NPCs in house_28
	Person retiredMineWorker;
	
	
	////////////// Constructor ///////////////	
	public NPCManager(World w) { 
		world = w;
		reader = new ReadFile();
		
		//Items that the NPCs give to the player
		npcItems = new Item[17];
			Coin coin = new Coin(5);
			coin.setID("coin_person4");
		npcItems[0] = coin;
		npcItems[1] = new Coupon();
			Orb basketball_Orb = new Orb();
			basketball_Orb.setID("bball_Orb");
		npcItems[2] = basketball_Orb;
			Orb catOrb = new Orb();
			catOrb.setID("Cat_Orb");
		npcItems[3] = catOrb;
		npcItems[4] = new Container();
		npcItems[5] = new Hatchet();
		npcItems[6] = new Water();
		npcItems[7] = new SewingKit();
		npcItems[8] = new HazmatSuit();
		npcItems[9] = new Pickaxe();
		npcItems[10] = new BakeryReceipt();
		npcItems[11] = new Cake();
			Orb cakeOrb = new Orb();
			cakeOrb.setID("cake_orb");
		npcItems[12] = cakeOrb;
		npcItems[13] = new BookstoreReceipt();
		npcItems[14] = new Textbook();
		npcItems[15] = new BoxOfTextBooks();
			Orb textbookOrb = new Orb();
			textbookOrb.setID("textbook_Orb");
		npcItems[16] = textbookOrb;
	}
	
	
	//////////// Setters ////////////
	
	/** Clears the text boxes for each NPC. */
	public void clearTextBoxes() {
		randomPerson_1.getTextBox().clear();
		randomPerson_2.getTextBox().clear();
		randomPerson_3.getTextBox().clear();
		randomPerson_4.getTextBox().clear();
		randomPerson_5.getTextBox().clear();
		randomPerson_6.getTextBox().clear();
		randomPerson_7.getTextBox().clear();
		randomPerson_8.getTextBox().clear();
		randomPerson_9.getTextBox().clear();
		randomPerson_10.getTextBox().clear();
		randomPerson_11.getTextBox().clear();
		randomPerson_12.getTextBox().clear();
		randomPerson_13.getTextBox().clear();
		randomPerson_14.getTextBox().clear();
		randomPerson_15.getTextBox().clear();
		randomPerson_16.getTextBox().clear();
		randomPerson_17.getTextBox().clear();
		randomPerson_18.getTextBox().clear();
		randomPerson_19.getTextBox().clear();
		randomPerson_20.getTextBox().clear();
		treeCutter.getTextBox().clear();
		treeCutterFriend.getTextBox().clear();
		scientist.getTextBox().clear();
		chemicalController_1.getTextBox().clear();
		chemicalController_2.getTextBox().clear();
		chemicalController_3.getTextBox().clear();
		thiefNPC.getTextBox().clear();
		player_Relative.getTextBox().clear();
		randomPerson_21.getTextBox().clear();
		giveWaterPerson.getTextBox().clear();
		sewingShopOwner.getTextBox().clear();
		hazmatSuitGiver.getTextBox().clear();
		hazmatSuitGiverWife.getTextBox().clear();
		retiredMineWorker.getTextBox().clear();
		containerSeller.getTextBox().clear();
		catNPC.getTextBox().clear();
		randomPerson_22.getTextBox().clear();
		randomPerson_23.getTextBox().clear();
		randomPerson_24.getTextBox().clear();
		cakeGiver.getTextBox().clear();
		student1.getTextBox().clear();
		student2.getTextBox().clear();
		student3.getTextBox().clear();
		student4.getTextBox().clear();
		student5.getTextBox().clear();
		teacher.getTextBox().clear();
		bookStoreOwner.getTextBox().clear();
		randomPerson_25.getTextBox().clear();
		randomPerson_26.getTextBox().clear();
	}
	
	
	/** Loads the text. 
	 * @throws Exception */
	private void loadText(String fileName, Person person) throws Exception {
		int i = 0; //The current line
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/" + fileName + ".txt");
		lines = reader.numLines();
		while(i < lines) { person.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
	}
	
	
	/** Gives items to certain NPCs depending on whether or not they have been interacted with. */
	public void giveItems() {
		
		if(!world.getWorldState().getPlayer().containsID("coin_person4")) {
			randomPerson_4.willGiveItem(true);
			randomPerson_4.setItemToGive(npcItems[0]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			randomPerson_7.willGiveItem(true);
			randomPerson_7.setItemToGive(npcItems[1]);
		}
		
		if(!world.getWorldState().getPlayer().hasOrb("bball_Orb")) {
			randomPerson_17.willGiveItem(true);
			randomPerson_17.setItemToGive(npcItems[2]);
		}
		
		if(!world.getWorldState().getPlayer().hasOrb("Cat_Orb")) {
			catNPC.willGiveItem(true);
			catNPC.setItemToGive(npcItems[3]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Container") && (world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 40)) {
			containerSeller.willGiveItem(true);
			containerSeller.setItemToGive(npcItems[4]);	
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			treeCutter.willGiveItem(true);
			treeCutter.setItemToGive(npcItems[5]);
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Coupon")) {
			giveWaterPerson.willGiveItem(true);
			giveWaterPerson.setItemToGive(npcItems[6]);
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Coin") && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			sewingShopOwner.willGiveItem(true);
			sewingShopOwner.setItemToGive(npcItems[7]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit") && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			hazmatSuitGiver.willGiveItem(true);
			hazmatSuitGiver.setItemToGive(npcItems[8]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Pickaxe")) {
			retiredMineWorker.willGiveItem(true);
			retiredMineWorker.setItemToGive(npcItems[9]);
		}
			
		if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
			randomPerson_22.willGiveItem(true);
			randomPerson_22.setItemToGive(npcItems[10]);
			randomPerson_23.willGiveItem(true);
			randomPerson_23.setItemToGive(npcItems[10]);
		}
		
		if(!world.getWorldState().getPlayer().hasOrb("cake_orb") && world.getWorldState().getPlayer().inventoryContains("Cake")) {
			randomPerson_22.willGiveItem(true);
			randomPerson_22.setItemToGive(npcItems[12]);
			randomPerson_23.willGiveItem(true);
			randomPerson_23.setItemToGive(npcItems[12]);
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
			cakeGiver.willGiveItem(true);
			cakeGiver.setItemToGive(npcItems[11]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
			teacher.willGiveItem(true);
			teacher.setItemToGive(npcItems[13]);
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
			teacher.willGiveItem(true);
			teacher.setItemToGive(npcItems[14]);
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt")) {
			bookStoreOwner.willGiveItem(true);
			bookStoreOwner.setItemToGive(npcItems[15]);
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Textbook") && !world.getWorldState().getPlayer().hasOrb("textbook_Orb")) {
			randomPerson_25.willTakeItem(true);
			randomPerson_25.setItemToTake("Textbook");
			randomPerson_25.willGiveItem(true);
			randomPerson_25.setItemToGive(npcItems[16]);
		}
	}

	
	/** Creates all of the NPC objects. */
	public void createNPCs() {
		//Create the NPCs. The positions have to be added to the world's position to arrange them properly.
		
		/* NPCs in Main World*/
		randomPerson_1 = new Person(new Vector2D(24,19).add(world.position));
			randomPerson_1.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
		randomPerson_2 = new Person(new Vector2D(18,12).add(world.position));
			randomPerson_2.setDirectionSprites(Assets.randomMan3_down, Assets.randomMan3_up, Assets.randomMan3_left, Assets.randomMan3_right);
		randomPerson_3 = new Person(new Vector2D(12,17).add(world.position));
			randomPerson_3.setDirectionSprites(Assets.randomMan4_down, Assets.randomMan4_up, Assets.randomMan4_left, Assets.randomMan4_right);
		randomPerson_4 = new Person(new Vector2D(15,25).add(world.position));
			randomPerson_4.setDirectionSprites(Assets.randomMan1_down,Assets.randomMan1_up,Assets.randomMan1_left,Assets.randomMan1_right);
			randomPerson_4.setDirection(Direction.East);
		randomPerson_5 = new Person(new Vector2D(24,25).add(world.position));
			randomPerson_5.setDirectionSprites(Assets.randomWoman5_down, Assets.randomWoman5_up, Assets.randomWoman5_left, Assets.randomWoman5_right);
		randomPerson_6 = new Person(new Vector2D(22,61).add(world.position));
			randomPerson_6.setDirectionSprites(Assets.randomMan4_down, Assets.randomMan4_up, Assets.randomMan4_left, Assets.randomMan4_right);
		randomPerson_7 = new Person(new Vector2D(18,67).add(world.position));
			randomPerson_7.setDirectionSprites(Assets.randomWoman2_down,Assets.randomWoman2_up,Assets.randomWoman2_left,Assets.randomWoman2_right);
		randomPerson_8 = new Person(new Vector2D(32, 67).add(world.position));
			randomPerson_8.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
			randomPerson_8.setDirection(Direction.West);
		randomPerson_9 = new Person(new Vector2D(9,58).add(world.position));
			randomPerson_9.setDirectionSprites(Assets.randomWoman6_down, Assets.randomWoman6_up, Assets.randomWoman6_left, Assets.randomWoman6_right);
		randomPerson_10 = new Person(new Vector2D(32,75).add(world.position));
			randomPerson_10.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
			randomPerson_10.setDirection(Direction.East);
		randomPerson_11 = new Person(new Vector2D(35,76).add(world.position));
			randomPerson_11.setDirectionSprites(Assets.randomMan4_down, Assets.randomMan4_up, Assets.randomMan4_left, Assets.randomMan4_right);
			randomPerson_11.setDirection(Direction.West);
		randomPerson_12 = new Person(new Vector2D(34,78).add(world.position));
			randomPerson_12.setDirectionSprites(Assets.randomMan1_down, Assets.randomMan1_up, Assets.randomMan1_left, Assets.randomMan1_right);
			randomPerson_12.setDirection(Direction.East);
		randomPerson_13 = new Person(new Vector2D(31,77).add(world.position));
			randomPerson_13.setDirectionSprites(Assets.randomMan3_down, Assets.randomMan3_up, Assets.randomMan3_left, Assets.randomMan3_right);	
		randomPerson_14 = new Person(new Vector2D(57,82).add(world.position));
			randomPerson_14.setDirectionSprites(Assets.randomMan3_down, Assets.randomMan3_up, Assets.randomMan3_left, Assets.randomMan3_right);
		randomPerson_15 = new Person(new Vector2D(84,86).add(world.position));
			randomPerson_15.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
		randomPerson_16 = new Person(new Vector2D(79,77).add(world.position));
			randomPerson_16.setDirectionSprites(Assets.randomMan5_down, Assets.randomMan5_up, Assets.randomMan5_left, Assets.randomMan5_right);
		randomPerson_17 = new Person(new Vector2D(88,75).add(world.position));
			randomPerson_17.setDirectionSprites(Assets.randomMan4_down, Assets.randomMan4_up, Assets.randomMan4_left, Assets.randomMan4_right);
		randomPerson_18 = new Person(new Vector2D(89,75).add(world.position));
			randomPerson_18.setDirectionSprites(Assets.randomMan1_down, Assets.randomMan1_up, Assets.randomMan1_left, Assets.randomMan1_right);
		randomPerson_19 = new Person(new Vector2D(60,9).add(world.position));
			randomPerson_19.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
		randomPerson_20 = new Person(new Vector2D(57,23).add(world.position));
			randomPerson_20.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
		scientist = new Person(new Vector2D(24, 11).add(world.position));
			scientist.setDirectionSprites(Assets.scientist_down, Assets.scientist_up, Assets.scientist_left, Assets.scientist_right);
		chemicalController_1 = new Person(new Vector2D(62,55).add(world.position));
			chemicalController_1.setDirectionSprites(Assets.chemContr1_down, Assets.chemContr1_up, Assets.chemContr1_left, Assets.chemContr1_right);
			chemicalController_1.setDirection(Direction.West);
		chemicalController_2 = new Person(new Vector2D(62,56).add(world.position));
			chemicalController_2.setDirectionSprites(Assets.chemContr2_down, Assets.chemContr2_up, Assets.chemContr2_left, Assets.chemContr2_right);
			chemicalController_2.setDirection(Direction.West);
		chemicalController_3 = new Person(new Vector2D(62,57).add(world.position));
			chemicalController_3.setDirectionSprites(Assets.chemContr3_down, Assets.chemContr3_up, Assets.chemContr3_left, Assets.chemContr3_right);
			chemicalController_3.setDirection(Direction.West);
		thiefNPC = new Person(new Vector2D(46,29).add(world.position));
			thiefNPC.setDirectionSprites(Assets.randomMan1_down, Assets.randomMan1_up, Assets.thief_left, Assets.thief_right);
			thiefNPC.setDirection(Direction.West);
		treeCutter = new Person(new Vector2D(18,38).add(world.position));
			treeCutter.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
			treeCutter.setDirection(Direction.East);
		treeCutterFriend = new Person(new Vector2D(10, 46).add(world.position));
			treeCutterFriend.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
		
			
		/* House 1 NPCs */
		player_Relative = new Person(new Vector2D(9,5).add(world.position));
			player_Relative.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
		
			
		/* House 2 NPCs */
		giveWaterPerson = new Person(new Vector2D(7,1).add(world.position));
			giveWaterPerson.setDirectionSprites(Assets.randomWoman1_down, Assets.randomWoman1_up, Assets.randomWoman1_left, Assets.randomWoman1_right);
		randomPerson_21 = new Person(new Vector2D(9,5).add(world.position));
			randomPerson_21.setDirectionSprites(Assets.randomMan4_down, Assets.randomMan4_up, Assets.randomMan4_left, Assets.randomMan4_right);
		
			
		/* House 4 NPCs */
		randomPerson_22 = new Person(new Vector2D(9,2).add(world.position));
			randomPerson_22.setDirectionSprites(Assets.randomWoman6_down, Assets.randomWoman6_up, Assets.randomWoman6_left, Assets.randomWoman6_right);
		randomPerson_23 = new Person(new Vector2D(10,2).add(world.position));
			randomPerson_23.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
		randomPerson_24 = new Person(new Vector2D(3,7).add(world.position));
			randomPerson_24.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
			
			
		/* House 10 NPCs */
		catNPC = new Person(new Vector2D(7,5).add(world.position));
			catNPC.setDirectionSprites(Assets.catNPC_down, Assets.catNPC_up, Assets.catNPC_left, Assets.catNPC_right);
		
			
		/* House 12 NPCs */
		sewingShopOwner = new Person(new Vector2D(7,2).add(world.position));
			sewingShopOwner.setDirectionSprites(Assets.randomWoman3_down, Assets.randomWoman3_up, Assets.randomWoman3_left, Assets.randomWoman3_right);
		
			
		/* House 13 NPCs */
		hazmatSuitGiver = new Person(new Vector2D(4,5).add(world.position));
			hazmatSuitGiver.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
		hazmatSuitGiverWife = new Person(new Vector2D(9,3).add(world.position));
			hazmatSuitGiverWife.setDirectionSprites(Assets.randomWoman5_down, Assets.randomWoman5_up, Assets.randomWoman5_left, Assets.randomWoman5_right);
		
			
		/* House 17 NPCs */
		cakeGiver = new Person(new Vector2D(7,2).add(world.position));
			cakeGiver.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
			
			
		/* House 18 NPCs */
		student1 = new Person(new Vector2D(4,3).add(world.position));
			student1.setDirection(Direction.North);
			student1.setDirectionSprites(Assets.randomMan1_down, Assets.randomMan1_up, Assets.randomMan1_left, Assets.randomMan1_right);
		student2 = new Person(new Vector2D(7,3).add(world.position));
			student2.setDirection(Direction.North);
			student2.setDirectionSprites(Assets.randomMan3_down, Assets.randomMan3_up, Assets.randomMan3_left, Assets.randomMan3_right);
		student3 = new Person(new Vector2D(10,3).add(world.position));
			student3.setDirection(Direction.North);
			student3.setDirectionSprites(Assets.randomWoman1_down, Assets.randomWoman1_up, Assets.randomWoman1_left, Assets.randomWoman1_right);
		student4 = new Person(new Vector2D(4,7).add(world.position));
			student4.setDirection(Direction.North);
			student4.setDirectionSprites(Assets.randomMan2_down, Assets.randomMan2_up, Assets.randomMan2_left, Assets.randomMan2_right);
		student5 = new Person(new Vector2D(5,7).add(world.position));
			student5.setDirection(Direction.North);
			student5.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
		teacher = new Person(new Vector2D(6,1).add(world.position));
			teacher.setDirectionSprites(Assets.randomWoman3_down, Assets.randomWoman3_up, Assets.randomWoman3_left, Assets.randomWoman3_right);
			
			
		/* House 22 NPCs */
		bookStoreOwner = new Person(new Vector2D(4,5).add(world.position));
			bookStoreOwner.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
			
			
		/* House 24 NPCs */
		containerSeller = new Person(new Vector2D(7,2).add(world.position));
			containerSeller.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
		
			
		/* House 26 NPCs */
		randomPerson_25 = new Person(new Vector2D(7,3).add(world.position));
			randomPerson_25.setDirection(Direction.East);
			randomPerson_25.setDirectionSprites(Assets.randomWoman4_down, Assets.randomWoman4_up, Assets.randomWoman4_left, Assets.randomWoman4_right);
		randomPerson_26 = new Person(new Vector2D(4,5).add(world.position));
			randomPerson_26.setDirectionSprites(Assets.randomMan1_down, Assets.randomMan1_up, Assets.randomMan1_left, Assets.randomMan1_right);
				
			
		/* House 28 NPCs */
		retiredMineWorker = new Person(new Vector2D(11,2).add(world.position));
			retiredMineWorker.setDirectionSprites(Assets.lumberjack_down, Assets.lumberjack_up, Assets.lumberjack_left, Assets.lumberjack_right);
	}

	
	/** Loads the text for each NPC to say. */
	public void loadNPCText() {
		try {
			clearTextBoxes();
			
			//Barrier NPC
			loadText("OrbsNPCSpeech_BarrierNPC", thiefNPC);
			
			
			//Cat NPC
			if(!world.getWorldState().getPlayer().hasOrb("Cat_Orb")) {
				loadText("OrbsNPCSpeech_CatNPC_1", catNPC);
				catNPC.getTextBox().addText("You received a(n) " + npcItems[3] + "! ");
			} else {
				loadText("OrbsNPCSpeech_CatNPC_2", catNPC);
			}
			
			
			//Chemical Controllers
			if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
				loadText("OrbsNPCSpeech_ChemicalControllers_1", chemicalController_1);
				loadText("OrbsNPCSpeech_ChemicalControllers_1", chemicalController_2);
				loadText("OrbsNPCSpeech_ChemicalControllers_1", chemicalController_3);
			} else {
				chemicalController_2.position.X -= 1; chemicalController_2.position.Y -= 1; chemicalController_3.position.X += 1; chemicalController_3.position.Y -= 2;
				chemicalController_1.setDirection(Direction.South); chemicalController_2.setDirection(Direction.South); chemicalController_3.setDirection(Direction.South);
				
				loadText("OrbsNPCSpeech_ChemicalControllers_2", chemicalController_1);
				loadText("OrbsNPCSpeech_ChemicalControllers_2", chemicalController_2);
				loadText("OrbsNPCSpeech_ChemicalControllers_2", chemicalController_3);
			}
			
			
			//Container Seller
			if(!world.getWorldState().getPlayer().inventoryContains("Container") && (world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 40)) {
				loadText("OrbsNPCSpeech_ContainerSeller_1", containerSeller);
				containerSeller.getTextBox().addText("You received a(n) " + npcItems[4] + "! ");
			} else if(!world.getWorldState().getPlayer().inventoryContains("Container") && (!world.getWorldState().getPlayer().inventoryContains("Coin") || world.getWorldState().getPlayer().getQuantity("Coin") < 40)) {
				loadText("OrbsNPCSpeech_ContainerSeller_2", containerSeller);
			} else if(world.getWorldState().getPlayer().inventoryContains("Container")) {
				loadText("OrbsNPCSpeech_ContainerSeller_3", containerSeller);
			}
			
			
			//Hazmat Suit Giver
			if(!world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && !world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
				loadText("OrbsNPCSpeech_HazmatSuitGiver_1", hazmatSuitGiver);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit") && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
				loadText("OrbsNPCSpeech_HazmatSuitGiver_2", hazmatSuitGiver);
				hazmatSuitGiver.getTextBox().addText("You received a(n) " + npcItems[8] + "! ");
			} else if(world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
				loadText("OrbsNPCSpeech_HazmatSuitGiver_3", hazmatSuitGiver);
			}
			
			
			//Hazmat suit giver wife
			loadText("OrbsNPCSpeech_HazmatSuitGiverWife", hazmatSuitGiverWife);
			
			
			//Player's relative
			loadText("OrbsNPCSpeech_PlayersRelative", player_Relative);
			
			
			//Random person 1
			loadText("OrbsNPCSpeech_RandomPerson1",randomPerson_1);
			
			
			//Random person 2
			loadText("OrbsNPCSpeech_RandomPerson2",randomPerson_2);
			
			
			//Random person 3
			loadText("OrbsNPCSpeech_RandomPerson3",randomPerson_3);
			
			
			//Random person 4
			if(!world.getWorldState().getPlayer().containsID("coin_person4")) {
				loadText("OrbsNPCSpeech_RandomPerson4_1",randomPerson_4);
				randomPerson_4.getTextBox().addText("You received a(n) " + npcItems[0]  + "! ");
			} else {
				loadText("OrbsNPCSpeech_RandomPerson4_2",randomPerson_4);
			}
			
			
			//Random person 5
			loadText("OrbsNPCSpeech_RandomPerson5",randomPerson_5);
			
			
			//Random person 6
			loadText("OrbsNPCSpeech_RandomPerson6",randomPerson_6);
			
			
			//Random person 7
			if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
				loadText("OrbsNPCSpeech_RandomPerson7_1",randomPerson_7);
				randomPerson_7.getTextBox().addText("You received a(n) " + npcItems[1] + "! ");
			} else {
				loadText("OrbsNPCSpeech_RandomPerson7_2",randomPerson_7);
			}
			
			
			//Random person 8
			loadText("OrbsNPCSpeech_RandomPerson8",randomPerson_8);
			
			//Random person 9
			loadText("OrbsNPCSpeech_RandomPerson9",randomPerson_9);
			
			//Random person 10
			loadText("OrbsNPCSpeech_RandomPerson10",randomPerson_10);
			
			//Random person 11
			loadText("OrbsNPCSpeech_RandomPerson11",randomPerson_11);
			
			//Random person 12
			loadText("OrbsNPCSpeech_RandomPerson12",randomPerson_12);
			
			//Random person 13
			loadText("OrbsNPCSpeech_RandomPerson13",randomPerson_13);
			
			//Random person 14
			loadText("OrbsNPCSpeech_RandomPerson14",randomPerson_14);
			
			//Random person 15
			loadText("OrbsNPCSpeech_RandomPerson15",randomPerson_15);
			
			//Random person 16
			loadText("OrbsNPCSpeech_RandomPerson16",randomPerson_16);
			
			
			//Random person 17
			if(!world.getWorldState().getPlayer().hasOrb("bball_Orb")) {
				loadText("OrbsNPCSpeech_RandomPerson17_1",randomPerson_17);
				randomPerson_17.getTextBox().addText("You received a(n) " + npcItems[2] + "! ");
			} else {
				loadText("OrbsNPCSpeech_RandomPerson17_2",randomPerson_17);
			}
			
			
			//Random person 18
			if(!world.getWorldState().getPlayer().hasOrb("bball_Orb")) {
				loadText("OrbsNPCSpeech_RandomPerson18_1",randomPerson_18);
			} else {
				loadText("OrbsNPCSpeech_RandomPerson18_2",randomPerson_18);
			}
			
			
			//Random person 19
			loadText("OrbsNPCSpeech_RandomPerson19",randomPerson_19);
			
			
			//Random person 20
			loadText("OrbsNPCSpeech_RandomPerson19",randomPerson_19);
			
			
			//Random person 21
			loadText("OrbsNPCSpeech_RandomPerson21",randomPerson_21);
			
			
			//Random person 22
			if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
				loadText("OrbsNPCSpeech_RandomPerson22_1",randomPerson_22);
				randomPerson_22.getTextBox().addText("You received a(n) " + npcItems[10] + "! ");
				randomPerson_22.getTextBox().addText("They will give you the cake once you hand them the receipt.");
				randomPerson_22.getTextBox().addText("Please hurry back! The party starts in a few hours!");
			} else if(world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {		
				loadText("OrbsNPCSpeech_RandomPerson22_2",randomPerson_22);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
				loadText("OrbsNPCSpeech_RandomPerson22_3",randomPerson_22);
				randomPerson_22.getTextBox().addText("You received a(n) " + npcItems[12] + "! ");
			} else if(world.getWorldState().getPlayer().hasOrb("cake_orb") && !world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake")) {
				loadText("OrbsNPCSpeech_RandomPerson22_3",randomPerson_22);
			}
			
			
			//Random person 23
			if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
				loadText("OrbsNPCSpeech_RandomPerson22_1",randomPerson_23);
				randomPerson_23.getTextBox().addText("You received a(n) " + npcItems[10] + "! ");
				randomPerson_23.getTextBox().addText("They will give you the cake once you hand them the receipt.");
				randomPerson_23.getTextBox().addText("Please hurry back! The party starts in a few hours!");
			} else if(world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {		
				loadText("OrbsNPCSpeech_RandomPerson22_2",randomPerson_23);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().hasOrb("cake_orb")) {
				loadText("OrbsNPCSpeech_RandomPerson22_3",randomPerson_23);
				randomPerson_23.getTextBox().addText("You received a(n) " + npcItems[12] + "! ");
			} else if(world.getWorldState().getPlayer().hasOrb("cake_orb") && !world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake")) {
				loadText("OrbsNPCSpeech_RandomPerson22_3",randomPerson_23);
			}
			
			
			//Retired Mine Worker
			if(!world.getWorldState().getPlayer().inventoryContains("Pickaxe")) {
				loadText("OrbsNPCSpeech_RetiredMineWorker_1", retiredMineWorker);
				retiredMineWorker.getTextBox().addText("You received a(n) " + npcItems[9] + "! ");
			} else {
				loadText("OrbsNPCSpeech_RetiredMineWorker_1", retiredMineWorker);
			}
			
			
			//Scientist
			if(!world.getWorldState().getPlayer().inventoryContains("Orb")) {
				loadText("OrbsNPCSpeech_Scientist_1", scientist);
			} else if(world.getWorldState().getPlayer().inventoryContains("Orb") && world.getWorldState().getPlayer().getQuantity("Orb") < 10) {
				loadText("OrbsNPCSpeech_Scientist_2", scientist);
				scientist.getTextBox().setText("Hmm... Well it looks like you have found " + world.getWorldState().getPlayer().getOrbCount() + " out of 20 orbs. ", 3);
			} else if(world.getWorldState().getPlayer().inventoryContains("Orb") && world.getWorldState().getPlayer().getQuantity("Orb") >= 10) {
				loadText("OrbsNPCSpeech_Scientist_3", scientist);
			}
			
			
			
			//Sewing Shop Owner
			if((!world.getWorldState().getPlayer().inventoryContains("Coin") || world.getWorldState().getPlayer().getQuantity("Coin") < 12) && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
				loadText("OrbsNPCSpeech_SewingShopOwner_1", sewingShopOwner);
			} else if((world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 12) && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
				loadText("OrbsNPCSpeech_SewingShopOwner_2", sewingShopOwner);
				sewingShopOwner.getTextBox().addText("You received a(n) " + npcItems[7] + "! ");
			} else if(world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
				loadText("OrbsNPCSpeech_SewingShopOwner_1", sewingShopOwner);
			}
			
			
			//Tree Cutter
			if(!world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
				loadText("OrbsNPCSpeech_TreeCutter_1", treeCutter);
			} else if(world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
				loadText("OrbsNPCSpeech_TreeCutter_2", treeCutter);
				treeCutter.getTextBox().addText("You received a(n) " + npcItems[5] + "! ");
			} else if(world.getWorldState().getPlayer().inventoryContains("Hatchet") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
				loadText("OrbsNPCSpeech_TreeCutter_3", treeCutter);
			}
			
			
			//Tree Cutter Friend
			loadText("OrbsNPCSpeech_TreeCutterFriend", treeCutterFriend);
			
			
			//Water Giving Person
			if(!world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Coupon")) {
				loadText("OrbsNPCSpeech_WaterGivingPerson_1", giveWaterPerson);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Water") && world.getWorldState().getPlayer().inventoryContains("Coupon")) {
				loadText("OrbsNPCSpeech_WaterGivingPerson_2", giveWaterPerson);
				giveWaterPerson.getTextBox().addText("You received a(n) " + npcItems[6] + "! ");
			} else if(world.getWorldState().getPlayer().inventoryContains("Water") || !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
				loadText("OrbsNPCSpeech_WaterGivingPerson_3", giveWaterPerson);
			}
			
			
			//Cake giver
			if(!world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().containsID("cake_orb")) {
				loadText("OrbsNPCSpeech_CakeGiver_1", cakeGiver);
			} else if(world.getWorldState().getPlayer().inventoryContains("Bakery Receipt") && !world.getWorldState().getPlayer().inventoryContains("Cake") && !world.getWorldState().getPlayer().containsID("cake_orb")) {
				loadText("OrbsNPCSpeech_CakeGiver_2", cakeGiver);
				cakeGiver.getTextBox().addText("You received a(n) " + npcItems[11] + "! ");
			} else if(world.getWorldState().getPlayer().inventoryContains("Cake") || world.getWorldState().getPlayer().containsID("cake_orb")) {
				loadText("OrbsNPCSpeech_CakeGiver_3", cakeGiver);
			}
			
			
			//Students
			if(!world.getWorldState().getPlayer().inventoryContains("Textbook")) {
				loadText("OrbsNPCSpeech_Students_1", student1);
				loadText("OrbsNPCSpeech_Students_1", student2);
				loadText("OrbsNPCSpeech_Students_1", student3);
				loadText("OrbsNPCSpeech_Students_1", student4);
				loadText("OrbsNPCSpeech_Students_1", student5);
			} else {
				loadText("OrbsNPCSpeech_Students_2", student1);
				loadText("OrbsNPCSpeech_Students_2", student2);
				loadText("OrbsNPCSpeech_Students_2", student3);
				loadText("OrbsNPCSpeech_Students_2", student4);
				loadText("OrbsNPCSpeech_Students_2", student5);
			}
			
			
			//Teacher
			if(!world.getWorldState().getPlayer().hasOrb("specialOrb")) {
				
				if(!world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_1", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_2", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_3", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Textbook") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks")) {
					loadText("OrbsNPCSpeech_Teacher_4", teacher);
				}
				
			} else {
				
				if(!world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_1_other", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_2", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Textbook")) {
					loadText("OrbsNPCSpeech_Teacher_3", teacher);
				} else if(world.getWorldState().getPlayer().inventoryContains("Textbook") && !world.getWorldState().getPlayer().inventoryContains("Box of Textbooks")) {
					loadText("OrbsNPCSpeech_Teacher_4", teacher);
				}
			}
			
			
			//Book store owner
			if(!world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && !world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt")) {
				loadText("OrbsNPCSpeech_BookstoreOwner_1", bookStoreOwner);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") && world.getWorldState().getPlayer().inventoryContains("Bookstore Receipt")) {
				loadText("OrbsNPCSpeech_BookstoreOwner_2", bookStoreOwner);
			} else if(world.getWorldState().getPlayer().inventoryContains("Box of Textbooks") || world.getWorldState().getPlayer().inventoryContains("Textbook")) {
				loadText("OrbsNPCSpeech_BookstoreOwner_1", bookStoreOwner);
			}
			
			
			//Textbook child
			if(!world.getWorldState().getPlayer().inventoryContains("Textbook") && !world.getWorldState().getPlayer().hasOrb("textbook_Orb")) {
				loadText("OrbsNPCSpeech_TextbookChild_1", randomPerson_25);
			} else if(world.getWorldState().getPlayer().inventoryContains("Textbook") && !world.getWorldState().getPlayer().hasOrb("textbook_Orb")) {
				loadText("OrbsNPCSpeech_TextbookChild_2", randomPerson_25);
			} else if(!world.getWorldState().getPlayer().inventoryContains("Textbook") && world.getWorldState().getPlayer().hasOrb("textbook_Orb")) {
				loadText("OrbsNPCSpeech_TextbookChild_3", randomPerson_25);
			}
			
			//Textbook parent
			loadText("OrbsNPCSpeech_TextbookParent", randomPerson_26);
			
		} catch(Exception err) { err.printStackTrace(); }
	}
	
	
	/** Adds to the list of entities in world. */
	public void addToGame() {
		world.getEntities().clear();
		
		if(world.getName().equals("Main")) {
			//Once you are done setting them up, add them to the list of entities.
			world.addEntity(randomPerson_1);
			world.addEntity(randomPerson_2);
			world.addEntity(randomPerson_3);
			world.addEntity(randomPerson_4);
			world.addEntity(randomPerson_5);
			world.addEntity(randomPerson_6);
			world.addEntity(randomPerson_7);
			world.addEntity(randomPerson_8);
			world.addEntity(randomPerson_9);
			world.addEntity(randomPerson_10);
			world.addEntity(randomPerson_11);
			world.addEntity(randomPerson_12);
			world.addEntity(randomPerson_13);
			world.addEntity(randomPerson_14);
			world.addEntity(randomPerson_15);
			world.addEntity(randomPerson_16);
			world.addEntity(randomPerson_17);
			world.addEntity(randomPerson_18);
			world.addEntity(randomPerson_19);
			world.addEntity(randomPerson_20);
			world.addEntity(scientist);
			world.addEntity(chemicalController_1);
			world.addEntity(chemicalController_2);
			world.addEntity(chemicalController_3);
			world.addEntity(thiefNPC);
			world.addEntity(treeCutter);
			world.addEntity(treeCutterFriend);
		}
		
		if(world.getName().equals("House_1")) {
			world.addEntity(player_Relative);
		}
		
		if(world.getName().equals("House_2")) {
			world.addEntity(giveWaterPerson);
			world.addEntity(randomPerson_21);
		}
		
		if(world.getName().equals("House_4")) {
			world.addEntity(randomPerson_22);
			world.addEntity(randomPerson_23);
			world.addEntity(randomPerson_24);
		}
		
		if(world.getName().equals("House_10")) {
			world.addEntity(catNPC);
		}
		
		if(world.getName().equals("House_12")) {
			world.addEntity(sewingShopOwner);
		}
		
		if(world.getName().equals("House_13")) {
			world.addEntity(hazmatSuitGiver);
			world.addEntity(hazmatSuitGiverWife);
		}
		
		if(world.getName().equals("House_17")) {
			world.addEntity(cakeGiver);
		}
		
		if(world.getName().equals("House_18")) {
			world.addEntity(student1);
			world.addEntity(student2);
			world.addEntity(student3);
			world.addEntity(student4);
			world.addEntity(student5);
			world.addEntity(teacher);
		}
		
		if(world.getName().equals("House_22")) {
			world.addEntity(bookStoreOwner);
		}
		
		if(world.getName().equals("House_24")) {
			world.addEntity(containerSeller);
		}
		
		if(world.getName().equals("House_26")) {
			world.addEntity(randomPerson_25);
			world.addEntity(randomPerson_26);
		}
		
		if(world.getName().equals("House_28")) {
			world.addEntity(retiredMineWorker);
		}
	}
	
}
