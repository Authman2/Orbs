package MANAGERS;

import ENTITIES.Person;
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
	Person randomPerson_1, randomPerson_2, randomPerson_3, randomPerson_4, randomPerson_5, randomPerson_6, randomPerson_7,
			randomPerson_8, randomPerson_9, randomPerson_10, randomPerson_11, randomPerson_12, randomPerson_13, randomPerson_14,
			randomPerson_15, randomPerson_16, randomPerson_17, randomPerson_18, randomPerson_19, randomPerson_20;
	Person scientist;
	Person chemicalController_1, chemicalController_2, chemicalController_3;
	Person barrierToLastPart;
	Person treeCutter, treeCutterFriend;
	
	//The NPCs in house_1
	Person player_Relative;
	
	//The NPCs in house_2
	Person giveWaterPerson;
	Person randomPerson_21;
	
	//The NPCs in house_10
	Person catNPC;
	
	//The NPCs in house_12
	Person sewingShopOwner;
	
	//The NPCs in house_13
	Person hazmatSuitGiver;
	Person hazmatSuitGiverWife;
	
	//The NPCs in house_24
	Person containerSeller;
	
	//The NPCs in house_28
	Person retiredMineWorker;
	
	
	////////////// Constructor ///////////////	
	public NPCManager(World w) { 
		world = w;
		reader = new ReadFile();
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
		barrierToLastPart.getTextBox().clear();
		player_Relative.getTextBox().clear();
		randomPerson_21.getTextBox().clear();
		giveWaterPerson.getTextBox().clear();
		sewingShopOwner.getTextBox().clear();
		hazmatSuitGiver.getTextBox().clear();
		hazmatSuitGiverWife.getTextBox().clear();
		retiredMineWorker.getTextBox().clear();
		containerSeller.getTextBox().clear();
		catNPC.getTextBox().clear();
	}
	
	
	/** Gives items to certain NPCs depending on whether or not they have been interacted with. */
	public void giveItems() {
		
		if(!world.getWorldState().getPlayer().containsID("coin_person4")) {
			randomPerson_4.willGiveItem(true);
			randomPerson_4.setItemToGive(world.getItemManager().getNPCItem(0));
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			randomPerson_7.willGiveItem(true);
			randomPerson_7.setItemToGive(world.getItemManager().getNPCItem(1));
		}
		
		if(!world.getWorldState().getPlayer().containsID("bball_Orb")) {
			randomPerson_17.willGiveItem(true);
			randomPerson_17.setItemToGive(world.getItemManager().getNPCItem(2));
		}
		
		if(!world.getWorldState().getPlayer().containsID("Cat_Orb")) {
			catNPC.willGiveItem(true);
			catNPC.setItemToGive(world.getItemManager().getNPCItem(3));
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Container") && (world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 40)) {
			containerSeller.willGiveItem(true);
			containerSeller.setItemToGive(world.getItemManager().getNPCItem(4));	
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			treeCutter.willGiveItem(true);
			treeCutter.setItemToGive(world.getItemManager().getNPCItem(5));
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Water") && world.getWorldState().getPlayer().inventoryContains("Coupon")) {
			giveWaterPerson.willGiveItem(true);
			giveWaterPerson.setItemToGive(world.getItemManager().getNPCItem(6));
		}
		
		if(world.getWorldState().getPlayer().inventoryContains("Coin") && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			sewingShopOwner.willGiveItem(true);
			sewingShopOwner.setItemToGive(world.getItemManager().getNPCItem(7));
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit") && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			hazmatSuitGiver.willGiveItem(true);
			hazmatSuitGiver.setItemToGive(world.getItemManager().getNPCItem(8));
		}
		
		if(!world.getWorldState().getPlayer().inventoryContains("Pickaxe")) {
			retiredMineWorker.willGiveItem(true);
			retiredMineWorker.setItemToGive(world.getItemManager().getNPCItem(9));
		}
			
			
	}

	
	/** Creates all of the NPC objects. */
	public void createNPCs() {
		//Create the NPCs. The positions have to be added to the world's position to arrange them properly.
		
		/* NPCs in Main World*/
		randomPerson_1 = new Person(new Vector2D(24,19).add(world.position));
		randomPerson_2 = new Person(new Vector2D(18,12).add(world.position));
		randomPerson_3 = new Person(new Vector2D(12,17).add(world.position));
		randomPerson_4 = new Person(new Vector2D(15,25).add(world.position));
		randomPerson_5 = new Person(new Vector2D(24,25).add(world.position));
		randomPerson_6 = new Person(new Vector2D(22,61).add(world.position));
		randomPerson_7 = new Person(new Vector2D(18,67).add(world.position));
		randomPerson_8 = new Person(new Vector2D(32, 67).add(world.position));
		randomPerson_9 = new Person(new Vector2D(9,58).add(world.position));
		randomPerson_10 = new Person(new Vector2D(32,75).add(world.position));
		randomPerson_11 = new Person(new Vector2D(35,76).add(world.position));
		randomPerson_12 = new Person(new Vector2D(34,78).add(world.position));
		randomPerson_13 = new Person(new Vector2D(31,77).add(world.position));
		randomPerson_14 = new Person(new Vector2D(57,82).add(world.position));
		randomPerson_15 = new Person(new Vector2D(84,86).add(world.position));
		randomPerson_16 = new Person(new Vector2D(79,77).add(world.position));
		randomPerson_17 = new Person(new Vector2D(88,75).add(world.position));
		randomPerson_18 = new Person(new Vector2D(89,75).add(world.position));
		randomPerson_19 = new Person(new Vector2D(60,9).add(world.position));
		randomPerson_20 = new Person(new Vector2D(57,23).add(world.position));
		scientist = new Person(new Vector2D(24, 11).add(world.position));
		chemicalController_1 = new Person(new Vector2D(62,55).add(world.position));
		chemicalController_2 = new Person(new Vector2D(62,56).add(world.position));
		chemicalController_3 = new Person(new Vector2D(62,57).add(world.position));
		barrierToLastPart = new Person(new Vector2D(46,29).add(world.position));
		treeCutter = new Person(new Vector2D(18,38).add(world.position));
		treeCutterFriend = new Person(new Vector2D(10, 46).add(world.position));
		
		/* House 1 NPCs */
		player_Relative = new Person(new Vector2D(9,5).add(world.position));
		
		/* House 2 NPCs */
		giveWaterPerson = new Person(new Vector2D(7,1).add(world.position));
		randomPerson_21 = new Person(new Vector2D(9,5).add(world.position));
		
		/* House 10 NPCs */
		catNPC = new Person(new Vector2D(7,5).add(world.position));
		
		/* House 12 NPCs */
		sewingShopOwner = new Person(new Vector2D(7,2).add(world.position));
		
		/* House 13 NPCs */
		hazmatSuitGiver = new Person(new Vector2D(4,5).add(world.position));
		hazmatSuitGiverWife = new Person(new Vector2D(9,3).add(world.position));
		
		/* House 24 NPCs */
		containerSeller = new Person(new Vector2D(7,2).add(world.position));
		
		/* House 28 NPCs */
		retiredMineWorker = new Person(new Vector2D(11,2).add(world.position));
	}

	
	/** Loads the text for each NPC to say. */
	public void loadNPCText() throws Exception {
		clearTextBoxes();
		int i = 0; //The current line
		
		//Barrier NPC
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_BarrierNPC.txt");
		lines = reader.numLines();
		while(i < lines) { barrierToLastPart.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Cat NPC
		if(!world.getWorldState().getPlayer().containsID("Cat_Orb")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_CatNPC_1.txt");
			lines = reader.numLines();
			while(i < lines) { catNPC.getTextBox().addText(reader.readThrough("\n")); i++; }
			catNPC.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(3) + "!");
			i = 0;
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_CatNPC_2.txt");
			lines = reader.numLines();
			while(i < lines) { catNPC.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		
		//Chemical Controllers
		if(!world.getWorldState().getPlayer().inventoryContains("Hazmat_Suit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_ChemicalControllers_1.txt");
		} else {
			chemicalController_1.position.add(new Vector2D());
			chemicalController_2.position.add(new Vector2D());
			chemicalController_3.position.add(new Vector2D());
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_ChemicalControllers_2.txt");
		}
		lines = reader.numLines();
		while(i < lines) { 
			chemicalController_1.getTextBox().addText(reader.readThrough("\n")); 
			chemicalController_2.getTextBox().addText(reader.readThrough("\n")); 
			chemicalController_3.getTextBox().addText(reader.readThrough("\n")); 
			i++; 
		}
		i = 0;
		
		
		//Container Seller
		if(!world.getWorldState().getPlayer().inventoryContains("Container") && (world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 40)) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_ContainerSeller_1.txt");
			lines = reader.numLines();
			while(i < lines) { containerSeller.getTextBox().addText(reader.readThrough("\n")); i++; }
			containerSeller.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(4) + "!");
			i = 0;
		} else if(!world.getWorldState().getPlayer().inventoryContains("Container") && (!world.getWorldState().getPlayer().inventoryContains("Coin") || world.getWorldState().getPlayer().getQuantity("Coin") < 40)) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_ContainerSeller_2.txt");
			lines = reader.numLines();
			while(i < lines) { containerSeller.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Container")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_ContainerSeller_3.txt");
			lines = reader.numLines();
			while(i < lines) { containerSeller.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Hazmat Suit Giver
		if(!world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && !world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_HazmatSuitGiver_1.txt");
			lines = reader.numLines();
			while(i < lines) { hazmatSuitGiver.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit") && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_HazmatSuitGiver_2.txt");
			lines = reader.numLines();
			while(i < lines) { hazmatSuitGiver.getTextBox().addText(reader.readThrough("\n")); i++; }
			hazmatSuitGiver.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(8) + "!");
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_HazmatSuitGiver_3.txt");
			lines = reader.numLines();
			while(i < lines) { hazmatSuitGiver.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Hazmat suit giver wife
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_HazmatSuitGiverWife.txt");
		lines = reader.numLines();
		while(i < lines) { hazmatSuitGiverWife.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Player's relative
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_PlayersRelative.txt");
		lines = reader.numLines();
		while(i < lines) { player_Relative.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 1
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson1.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_1.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 2
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson2.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_2.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 3
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson3.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_3.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 4
		if(!world.getWorldState().getPlayer().containsID("coin_person4")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson4_1.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_4.getTextBox().addText(reader.readThrough("\n")); i++; }
			randomPerson_4.getTextBox().addText("You received a(n) " +world.getItemManager().getNPCItem(0)  + "!");
			i = 0;
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson4_2.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_4.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Random person 5
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson5.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_5.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 6
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson6.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_6.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 7
		if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson7_1.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_7.getTextBox().addText(reader.readThrough("\n")); i++; }
			randomPerson_7.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(1) + "!");
			i = 0;
		} else if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && world.getWorldState().getPlayer().inventoryContains("Water")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson7_2.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_7.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Random person 8
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson8.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_8.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 9
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson9.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_9.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 10
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson10.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_10.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 11
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson11.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_11.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 12
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson12.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_12.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 13
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson13.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_13.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 14
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson14.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_14.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 15
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson15.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_15.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 16
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson16.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_16.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 17
		if(!world.getWorldState().getPlayer().containsID("bball_Orb")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson17_1.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_17.getTextBox().addText(reader.readThrough("\n")); i++; }
			randomPerson_17.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(2) + "!");
			i = 0;
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson17_2.txt");
			lines = reader.numLines();
			while(i < lines) { randomPerson_17.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Random person 18
		if(!world.getWorldState().getPlayer().containsID("bball_Orb")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson18_1.txt");
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson18_2.txt");
		}
		lines = reader.numLines();
		while(i < lines) { randomPerson_18.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 19
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson19.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_19.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 20
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson20.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_20.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Random person 21
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RandomPerson21.txt");
		lines = reader.numLines();
		while(i < lines) { randomPerson_21.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Retired Mine Worker
		if(!world.getWorldState().getPlayer().inventoryContains("Pickaxe")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RetiredMineWorker_1.txt");
			lines = reader.numLines();
			while(i < lines) { retiredMineWorker.getTextBox().addText(reader.readThrough("\n")); i++; }
			retiredMineWorker.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(9) + "!");
			i = 0;
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_RetiredMineWorker_2.txt");
			lines = reader.numLines();
			while(i < lines) { retiredMineWorker.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Scientist
		if(!world.getWorldState().getPlayer().inventoryContains("Orb")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_Scientist_1.txt");
			lines = reader.numLines();
			while(i < lines) { scientist.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_Scientist_2.txt");
			lines = reader.numLines();
			while(i < lines) { scientist.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
			scientist.getTextBox().setText("Hmm... Well it looks like you have found " + world.getWorldState().getPlayer().getOrbCount() + " out of 20 orbs.", 3);
		}
		
		
		
		//Sewing Shop Owner
		if(!world.getWorldState().getPlayer().inventoryContains("Coin") && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_SewingShopOwner_1.txt");
			lines = reader.numLines();
			while(i < lines) { sewingShopOwner.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 12 && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_SewingShopOwner_2.txt");
			lines = reader.numLines();
			while(i < lines) { sewingShopOwner.getTextBox().addText(reader.readThrough("\n")); i++; }
			sewingShopOwner.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(7) + "!");
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_SewingShopOwner_3.txt");
			lines = reader.numLines();
			while(i < lines) { sewingShopOwner.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Tree Cutter
		if(!world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_TreeCutter_1.txt");
			lines = reader.numLines();
			while(i < lines) { treeCutter.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_TreeCutter_2.txt");
			lines = reader.numLines();
			while(i < lines) { treeCutter.getTextBox().addText(reader.readThrough("\n")); i++; }
			treeCutter.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(5) + "!");
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Hatchet") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_TreeCutter_3.txt");
			lines = reader.numLines();
			while(i < lines) { treeCutter.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}
		
		
		//Tree Cutter Friend
		reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_TreeCutterFriend.txt");
		lines = reader.numLines();
		while(i < lines) { treeCutterFriend.getTextBox().addText(reader.readThrough("\n")); i++; }
		i = 0;
		
		
		//Water Giving Person
		if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_WaterGivingPerson_1.txt");
			lines = reader.numLines();
			while(i < lines) { giveWaterPerson.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		} else if(!world.getWorldState().getPlayer().inventoryContains("Water") && world.getWorldState().getPlayer().inventoryContains("Coupon")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_WaterGivingPerson_2.txt");
			lines = reader.numLines();
			while(i < lines) { giveWaterPerson.getTextBox().addText(reader.readThrough("\n")); i++; }
			giveWaterPerson.getTextBox().addText("You received a(n) " + world.getItemManager().getNPCItem(6) + "!");
			i = 0;
		} else if(world.getWorldState().getPlayer().inventoryContains("Water") || world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			reader = new ReadFile("/Users/adeolauthman/Documents/AdeolasCodingStuff/JavaPrograms/Orbs/src/NPCSpeech/OrbsNPCSpeech_WaterGivingPerson_3.txt");
			lines = reader.numLines();
			while(i < lines) { giveWaterPerson.getTextBox().addText(reader.readThrough("\n")); i++; }
			i = 0;
		}

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
			world.addEntity(barrierToLastPart);
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
		
		if(world.getName().equals("House_24")) {
			world.addEntity(containerSeller);
		}
		
		if(world.getName().equals("House_28")) {
			world.addEntity(retiredMineWorker);
		}
	}
	
}
