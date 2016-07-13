package MANAGERS;

import ENTITIES.Person;
import ITEMS.Coin;
import ITEMS.Container;
import ITEMS.Coupon;
import ITEMS.Hatchet;
import ITEMS.HazmatSuit;
import ITEMS.Orb;
import ITEMS.Pickaxe;
import ITEMS.SewingKit;
import ITEMS.Water;
import WORLD.World;
import visualje.Vector2D;

/** Handles adding all of the NPCs to the game world. */
public class NPCManager {

	//The world, used to access many different elements in the game world.
	World world;
	
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
	}
	
	/** Creates all of the NPC objects. */
	public void createNPCs() {
		//Create the NPCs. The positions have to be added to the world's position to arrange them properly.
		
		/* NPCs in Main World*/
		randomPerson_1 = new Person(new Vector2D(24,19).add(world.position));
		randomPerson_2 = new Person(new Vector2D(18,12).add(world.position));
		randomPerson_3 = new Person(new Vector2D(12,17).add(world.position));
		randomPerson_4 = new Person(new Vector2D(15,25).add(world.position));
			randomPerson_4.willGiveItem(true);
			Coin coin = new Coin(); coin.setQuantity(5);
			randomPerson_4.setItemToGive(coin);
		randomPerson_5 = new Person(new Vector2D(24,25).add(world.position));
		randomPerson_6 = new Person(new Vector2D(22,61).add(world.position));
		randomPerson_7 = new Person(new Vector2D(18,67).add(world.position));
			randomPerson_7.willGiveItem(true);
			randomPerson_7.setItemToGive(new Coupon());
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
			randomPerson_17.willGiveItem(true);
			randomPerson_17.setItemToGive(new Orb());
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
	
	/** Adds to the list of entities in world. */
	public void addToGame() {
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
	
	
	////////////// Abstract Methods ///////////////
	
	/** This initialize method is responsible for determining the text for each NPC. */
	public void initialize() {
		clearTextBoxes();
		
		//Random person 1
		randomPerson_1.getTextBox().addText("Nice weather we're having, right?");
		randomPerson_1.getTextBox().addText("Not like last week when it was 95 degrees!");
		
		
		//Random person 2
		randomPerson_2.getTextBox().addText("Have you talked to that wierd scientist guy?");
		randomPerson_2.getTextBox().addText("He was blabbing about some orbs or something...");
		randomPerson_2.getTextBox().addText("I couldn't really understand him though. He was talking so fast!");
		
		
		//Random person 3
		randomPerson_3.getTextBox().addText("Have you heard about the burglary that happened last night?");
		randomPerson_3.getTextBox().addText("That's why I'm standing guard here. No criminal is going to break into my house!");
		
		
		//Random person 4
		if(randomPerson_4.getItemToGive() != null) {
			randomPerson_4.getTextBox().addText("Oh, you're going out of town?");
			randomPerson_4.getTextBox().addText("Well you should be careful, with that thief on the loose you should   always stay alert in case a dangerous situation comes up.");
			randomPerson_4.getTextBox().addText("Also, you always carry some change with you in case you need to make  a quick purchase.");
			randomPerson_4.getTextBox().addText("Here, I'll give you some in case you don't have any.");
			
			randomPerson_4.getTextBox().addText("You were given a(n) " + randomPerson_4.getItemToGive().getName() + "!");
		} else {
			randomPerson_4.getTextBox().addText("Good luck out there!");
		}
		
			
		//Random person 5
		randomPerson_5.getTextBox().addText("Everybody in town is worried about being robbed after what happened   to that scientist last night.");
		randomPerson_5.getTextBox().addText("I'm not worried though, I set up a bunch of alarms in my house that   will detect any kind of movement!");
		randomPerson_5.getTextBox().addText("Unfortunately that means that I can't actually go inside my house...");
		
		
		//Random person 6
		randomPerson_6.getTextBox().addText("I heard there is something hidden in one of these trees.");
		randomPerson_6.getTextBox().addText("I hope I can find it before anyone else does!");
		
		
		//Random person 7
		if(randomPerson_7.getItemToGive() != null) {
			randomPerson_7.getTextBox().addText("You should check out my daughter's store on the east side of town.");
			randomPerson_7.getTextBox().addText("It's a coffee shop, and she sells all different kinds of snacks and   beverages.");
			randomPerson_7.getTextBox().addText("It's really quite good! Here, I'll give you a coupon!");
			randomPerson_7.getTextBox().addText("You were given a(n) " + randomPerson_7.getItemToGive().getName() + "!");
		} else {
			randomPerson_7.getTextBox().addText("Please write her a good review. She will definitely appreciate it!");
		}
		
		
		//Random person 8
		randomPerson_8.getTextBox().addText("I love living in this town! It's so big and spacious!");
		randomPerson_8.getTextBox().addText("I have a friend who lives in a town to the north-east, which is much  smaller than this one.");
		randomPerson_8.getTextBox().addText("*Sigh* I'll never understand why he enjoys living in such a small town, but I guess that's just his style!");
		
		
		//Random person 9
		randomPerson_9.getTextBox().addText("I'm trying to stay in shape by running 4 miles every day.");
		randomPerson_9.getTextBox().addText("1 mile down, 3 to go!");
		
		
		//Random person 10
		randomPerson_10.getTextBox().addText("Have you tried the coffee cake? It's delicious!");
		
		//Random person 11
		randomPerson_11.getTextBox().addText("My favorite drink is the strawberry smoothie.");
		randomPerson_11.getTextBox().addText("It's just so refreshing!");
		
		//Random person 12
		randomPerson_12.getTextBox().addText("I've never actually tried any of the food here.");
		randomPerson_12.getTextBox().addText("Is it any good?");

		//Random person 13
		randomPerson_13.getTextBox().addText("I always have a hard time deciding what to get off the menu...");
		
		
		//Random person 14
		randomPerson_14.getTextBox().addText("My house is just outside of town.");
		randomPerson_14.getTextBox().addText("It didn't cost very much either; I guess most people don't like the   idea of living so far away from everything.");
		randomPerson_14.getTextBox().addText("I love it, though! It's so nice and quiet, I never have to worry about distractions when I'm working.");
		
		
		//Random person 15
		randomPerson_15.getTextBox().addText("Did you hear what happened in the town just north of here?");
		randomPerson_15.getTextBox().addText("Apparently there is some sort of orb spilling radio active material   into the air.");
		randomPerson_15.getTextBox().addText("It's making me very worried! My cousin lives there and he texts me    everyday that he is still stuck inside of his house!");
		randomPerson_15.getTextBox().addText("I wish someone would go help them...");
		
		
		//Random person 16
		randomPerson_16.getTextBox().addText("Do you know any place that's hiring right now?");
		randomPerson_16.getTextBox().addText("I really need a job...");
		
		
		//Random person 17
		if(randomPerson_17.getItemToGive() != null) {
			randomPerson_17.getTextBox().addText("Hey, do you want this weird looking basketball?");
			randomPerson_17.getTextBox().addText("We found it in the bushes earlier, but it looks kind of strange and   doesn't bounce very well..");
			randomPerson_17.getTextBox().addText("We tried dribbling it a few times and it started glowing bright red!");
			randomPerson_17.getTextBox().addText("You can have it if you want.");
			randomPerson_17.getTextBox().addText("You'll take it? Cool! Here you go!");
			randomPerson_17.getTextBox().addText("You received a(n) " + randomPerson_17.getItemToGive().getName() + "!");
		} else {
			randomPerson_17.getTextBox().addText("Good luck trying to get that thing to bounce...");
		}
		
		
		//Random person 18
		if(randomPerson_17.getItemToGive() != null) {
			randomPerson_18.getTextBox().addText("Did my friend tell you about the strange basketball we found?");
		} else {
			randomPerson_18.getTextBox().addText("Good luck trying to get that thing to bounce...");
		}
		
		
		//Random person 19
		randomPerson_19.getTextBox().addText("It's so cold here up north!");
		
		
		//Random person 20
		randomPerson_20.getTextBox().addText("Oh, you're planning a vacation to the bahamas?");
		randomPerson_20.getTextBox().addText("That's so cool! Have fun and bring me back a suvineur!");
		randomPerson_20.getTextBox().addText("What? Oh, sorry, I was talking to one of my friends over the phone.");
		randomPerson_20.getTextBox().addText("He's a retired mine worker and lives in the next town over.");
		randomPerson_20.getTextBox().addText("If you ever need mining equipment you should talk to him. He said he's looking to get rid of some of his old stuff.");
		
		
		//Scientist
		if(!world.getWorldState().getPlayer().inventoryContains("Orb")) {
			scientist.getTextBox().addText("Ahh!");
			scientist.getTextBox().addText("I cannot believe this!");
			scientist.getTextBox().addText("All of my orbs! They've been stolen!");
			scientist.getTextBox().addText("Oh no, this is very bad...");
			scientist.getTextBox().addText("I could lose all of my funding for this!");
			scientist.getTextBox().addText("I could even go to jail if they end up in the wrong hands!");
			scientist.getTextBox().addText("Huh? What's that?");
			scientist.getTextBox().addText("Oh, I'm sorry, I didn't hear you. I was too busy worrying about my    experiement...");
			scientist.getTextBox().addText("Would you like to hear about it?");
			scientist.getTextBox().addText("You would? Great! It's very interesting, if I do say so myself!");
			scientist.getTextBox().addText("To put it simply, I have created 20 multi-colored orbs.");
			scientist.getTextBox().addText("Each orb holds great power, and is capable of bending reality at will!");
			scientist.getTextBox().addText("I planned on using them to cure diseases, end world hunger, etc...");
			scientist.getTextBox().addText("Anything you could think of, these orbs could do it!");
			scientist.getTextBox().addText("The only problem is that someone has stolen them out of my laboratory!");
			scientist.getTextBox().addText("I cannot imagine what kind of person would do this...");
			scientist.getTextBox().addText("I would go look for the culprit myself, but I am afraid he might come back and try to steal more inventions out of my lab.");
			scientist.getTextBox().addText("Wait a minute!");
			scientist.getTextBox().addText("You could go look for the criminal, couldn't you? It would surely help a lot.");
			scientist.getTextBox().addText("What do you say?");
			scientist.getTextBox().addText("You'll do it? Oh thank you very much! I really appreciate this!");
			scientist.getTextBox().addText("Now, what you must do is look for all 20 of the orbs.");
			scientist.getTextBox().addText("I have no idea where they might be, so make sure you look beneath     every rock, behind every tree, and right under your nose!");
			scientist.getTextBox().addText("Also ask around! Other people might know where they are, too!");
			scientist.getTextBox().addText("The point is to look everywhere. It is anyone's guess where these orbs may be!");
			scientist.getTextBox().addText("Now go! Please bring back my most powerful inventions!");
			scientist.getTextBox().addText("I will be waiting here when you return!");
		} else {
			scientist.getTextBox().clear();
			scientist.getTextBox().addText("Oh, hello! So you've found some of my orbs?");
			scientist.getTextBox().addText("That's wonderful!");
			scientist.getTextBox().addText("Let's see how many you've found...");
			scientist.getTextBox().addText("Hmm... Well it looks like you have found " + world.getWorldState().getPlayer().getOrbCount() + " out of 20 orbs.");
			scientist.getTextBox().addText("That's good! But there are still more to find.");
			scientist.getTextBox().addText("Please keep on looking and return to me when you have more orbs!      Good luck!");
		}
		
		
		//Chemical Controllers
		if(world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
			chemicalController_2.position.add(new Vector2D(-1,-1));		//Change the position of the NPCs
			chemicalController_3.position.add(new Vector2D(1,-2));
			
			chemicalController_1.getTextBox().addText("You look very well prepared for this job! Please help save the town!");
			chemicalController_2.getTextBox().addText("You look very well prepared for this job! Please help save the town!");
			chemicalController_3.getTextBox().addText("You look very well prepared for this job! Please help save the town!");
		} else {
			chemicalController_1.getTextBox().addText("Stop right there!");
			chemicalController_1.getTextBox().addText("I cannot allow you to enter this town without proper equipment.");
			chemicalController_1.getTextBox().addText("You see, there is some sort of strange object that is emitting what we think is radioactive material in the middle of town.");
			chemicalController_1.getTextBox().addText("While we await more professional help, residents are being advised to stay inside of their homes and close all windows and doors.");
			chemicalController_1.getTextBox().addText("I cannot let you through without a hazmat suit. I apologize for any inconvenience this may cause.");
			
			chemicalController_2.getTextBox().addText("Stop right there!");
			chemicalController_2.getTextBox().addText("I cannot allow you to enter this town without proper equipment.");
			chemicalController_2.getTextBox().addText("You see, there is some sort of strange object that is emitting what we think is radioactive material in the middle of town.");
			chemicalController_2.getTextBox().addText("While we await more professional help, residents are being advised to stay inside of their homes and close all windows and doors.");
			chemicalController_2.getTextBox().addText("I cannot let you through without a hazmat suit. I apologize for any inconvenience this may cause.");
		
			chemicalController_3.getTextBox().addText("Stop right there!");
			chemicalController_3.getTextBox().addText("I cannot allow you to enter this town without proper equipment.");
			chemicalController_3.getTextBox().addText("You see, there is some sort of strange object that is emitting what we think is radioactive material in the middle of town.");
			chemicalController_3.getTextBox().addText("While we await more professional help, residents are being advised to stay inside of their homes and close all windows and doors.");
			chemicalController_3.getTextBox().addText("I cannot let you through without a hazmat suit. I apologize for any inconvenience this may cause.");
		}
		
		
		//The person who blocks the way to the last part of the game
		barrierToLastPart.getTextBox().addText("...");
		
		
		//The player's relative
		player_Relative.getTextBox().addText("Aren't you worried about the robbery that happened last night?");
		player_Relative.getTextBox().addText("I don't even want to leave the house!");
		player_Relative.getTextBox().addText("In fact, I can probably do a better job of protecting our stuff if I'm inside!");
		player_Relative.getTextBox().addText("That settles it! I'll just stay in here until they catch the criminal!");
		
		
		//Tree cutter
		if(!world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			treeCutter.getTextBox().addText("Whew! I've been out here all day chopping wood for the winter.");
			treeCutter.getTextBox().addText("I could really go for a nice, cold drink right about now!");
		}
		if(world.getWorldState().getPlayer().inventoryContains("Water") && !world.getWorldState().getPlayer().inventoryContains("Hatchet")) {
			treeCutter.willGiveItem(true);
			treeCutter.setItemToGive(new Hatchet());
			
			treeCutter.getTextBox().addText("What? A glass of water? For me?");
			treeCutter.getTextBox().addText("Wow! Thanks so much!");
			treeCutter.getTextBox().addText("*Gulp* *Gulp* *Gulp*");
			treeCutter.getTextBox().addText("Ah! That's refreshing!");
			treeCutter.getTextBox().addText("Here, let me repay you for this.");
			treeCutter.getTextBox().addText("I'm done chopping wood for today so you can have this.");
			treeCutter.getTextBox().addText("You were given a(n) " + treeCutter.getItemToGive().getName() + "!");
			
		}
		if(world.getWorldState().getPlayer().inventoryContains("Hatchet") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			//Talk about the hatchet
			treeCutter.getTextBox().addText("That hatchet can be used to cut down certain kinds of trees.");
		}
		
		
		//Tree cutter's friend
		treeCutterFriend.getTextBox().addText("Hi there! I'm Jim.");
		treeCutterFriend.getTextBox().addText("Why am I standing in front of this house, you ask?");
		treeCutterFriend.getTextBox().addText("Well, it's actually not my house. It belongs to a friend.");
		treeCutterFriend.getTextBox().addText("He asked me to watch it for him while he's out chopping fire-wood.");
		treeCutterFriend.getTextBox().addText("Can't let that thief steal any of our logs, now can we?");
		
		
		//Water giving person
		if(!world.getWorldState().getPlayer().inventoryContains("Coupon") && !world.getWorldState().getPlayer().inventoryContains("Water")) {
			giveWaterPerson.getTextBox().addText("Hi there! What would you like to order?");
			giveWaterPerson.getTextBox().addText("What's that? You don't have any money?");
			giveWaterPerson.getTextBox().addText("I can't sell you anything if you don't have any money!");
			giveWaterPerson.getTextBox().addText("Please come back when you have enough money.");
		}
		if(!world.getWorldState().getPlayer().inventoryContains("Water") && world.getWorldState().getPlayer().inventoryContains("Coupon")) {
			giveWaterPerson.willGiveItem(true);
			giveWaterPerson.setItemToGive(new Water());
			
			giveWaterPerson.getTextBox().addText("Hi there! What can I get for you?");
			giveWaterPerson.getTextBox().addText("Oh, my mom gave you a coupon for a free sparkling water?");
			giveWaterPerson.getTextBox().addText("That was nice of her! Let me get you that water.");
			giveWaterPerson.getTextBox().addText("...");
			giveWaterPerson.getTextBox().addText("...");
			giveWaterPerson.getTextBox().addText("Here you go! Enjoy!");
			giveWaterPerson.getTextBox().addText("You received a(n) " + giveWaterPerson.getItemToGive().getName() + "!");
		} 
		if(giveWaterPerson.getItemToGive() == null) {
			if(world.getWorldState().getPlayer().inventoryContains("Water") || world.getWorldState().getPlayer().inventoryContains("Hatchet") || world.getWorldState().getPlayer().inventoryContains("Coupon"))
				giveWaterPerson.getTextBox().addText("Enjoy your sparkling water!");
			
		}
		
		
		//Random person 21
		randomPerson_21.getTextBox().addText("This is my favorite place to get lunch!");
		
		
		//Sewing shop owner
		if(!world.getWorldState().getPlayer().inventoryContains("Coin") && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			sewingShopOwner.getTextBox().addText("Hello there! I'm Gina and this is my sewing shop.");
			sewingShopOwner.getTextBox().addText("If you would like to buy a sewing kit you will have to pay $12.");
			sewingShopOwner.getTextBox().addText("I'm sorry, it looks like you don't have enough money to buy one.");
			sewingShopOwner.getTextBox().addText("Please come back when you have enough.");
		} 
		if(world.getWorldState().getPlayer().inventoryContains("Coin") && !world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			sewingShopOwner.willGiveItem(true);
			sewingShopOwner.setItemToGive(new SewingKit());
			
			sewingShopOwner.getTextBox().addText("Hello there! I'm Gina and this is my sewing shop.");
			sewingShopOwner.getTextBox().addText("If you would like to buy a sewing kit you will have to pay $12.");
			sewingShopOwner.getTextBox().addText("Looks like you have just enough!");
			sewingShopOwner.getTextBox().addText("Here is your sewing kit!");
			sewingShopOwner.getTextBox().addText("You pay $12 and receive a(n) " + sewingShopOwner.getItemToGive().getName() + "!");
			world.getWorldState().getPlayer().getInventoryItem("Coin").setQuantity(world.getWorldState().getPlayer().getInventoryItem("Coin").getQuantity() - 12);
		}
		if(sewingShopOwner.getItemToGive() == null && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			sewingShopOwner.getTextBox().addText("Have fun sewing!");	
		}
		
		
		//Hazmat suit giver
		if(!world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && !world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
			hazmatSuitGiver.getTextBox().addText("Hi, are you one of the volunteers that are supposed to help with the  radiation issue?");
			hazmatSuitGiver.getTextBox().addText("You are? Great! You'll need a hazmat suit to be able to walk into town safely, though.");
			hazmatSuitGiver.getTextBox().addText("I have one here, but unfortunately there is a hole in it...");
			hazmatSuitGiver.getTextBox().addText("I'll need to borrow a sewing kit to patch it up quickly, but I have no idea where to get one.");
			hazmatSuitGiver.getTextBox().addText("If you could do me a favor and get me a sewing kit, I can have your   hazmat suit ready in a couple of minutes.");
			hazmatSuitGiver.getTextBox().addText("Come back when you have one.");
		}
		if(!world.getWorldState().getPlayer().inventoryContains("Hazmat Suit") && world.getWorldState().getPlayer().inventoryContains("Sewing Kit")) {
			hazmatSuitGiver.willGiveItem(true);
			hazmatSuitGiver.setItemToGive(new HazmatSuit());
			
			hazmatSuitGiver.getTextBox().addText("You have a sewing kit? Perfect! Let me just patch up the suit quickly.");
			hazmatSuitGiver.getTextBox().addText("...");
			hazmatSuitGiver.getTextBox().addText("...");
			hazmatSuitGiver.getTextBox().addText("...");
			hazmatSuitGiver.getTextBox().addText("Almost done...");
			hazmatSuitGiver.getTextBox().addText("Finished! Here you go!");
			hazmatSuitGiver.getTextBox().addText("You received a(n) " + hazmatSuitGiver.getItemToGive().getName() + "!");
			hazmatSuitGiver.getTextBox().addText("Good luck taking care of the radio active      material!");
		}
		if(world.getWorldState().getPlayer().inventoryContains("Sewing Kit") && world.getWorldState().getPlayer().inventoryContains("Hazmat Suit")) {
			hazmatSuitGiver.getTextBox().addText("Good luck!");
		}
		
		
		//Hazmat suit giver's wife
		hazmatSuitGiverWife.getTextBox().addText("My husband works at a company that makes hazmat suits, so he always   has some lying around the house.");
		hazmatSuitGiverWife.getTextBox().addText("You should talk to him if you need one.");
		
		
		//Container seller
		if(!world.getWorldState().getPlayer().inventoryContains("Container") && (world.getWorldState().getPlayer().inventoryContains("Coin") && world.getWorldState().getPlayer().getQuantity("Coin") >= 40)) {
			containerSeller.willGiveItem(true);
			containerSeller.setItemToGive(new Container());
			
			containerSeller.getTextBox().addText("Hi there! I sell all sorts of jars and containers.");
			containerSeller.getTextBox().addText("Would you like to hear about our item of the day? It is a small, square box used to store potentially dangerous materials.");
			containerSeller.getTextBox().addText("Nothing will slip out of this container! It can handle anything you put into it, and it's perfect for any type of storage!");
			containerSeller.getTextBox().addText("If you're interested, I can sell it to you for $40.");
			containerSeller.getTextBox().addText("You'll take it? Great! Here you go!");
			containerSeller.getTextBox().addText("You pay $40 receive a(n) " + containerSeller.getItemToGive().getName() + "!");
			containerSeller.getTextBox().addText("Thank you for shopping with us!");
			world.getWorldState().getPlayer().getInventoryItem("Coin").setQuantity(world.getWorldState().getPlayer().getInventoryItem("Coin").getQuantity() - 40);
		} 
		if(!world.getWorldState().getPlayer().inventoryContains("Container") && (!world.getWorldState().getPlayer().inventoryContains("Coin") || world.getWorldState().getPlayer().getQuantity("Coin") < 40)) {
			containerSeller.getTextBox().addText("Hi there! I sell all sorts of jars and containers.");
			containerSeller.getTextBox().addText("Would you like to hear about our item of the day? It's a small, square container used to store potentially dangerous materials.");
			containerSeller.getTextBox().addText("Nothing will slip out of this container! It can handle anything you   put into it, and it's perfect for any type of storage!");
			containerSeller.getTextBox().addText("If you're interested, I can sell it to you for $40.");
			containerSeller.getTextBox().addText("I'm sorry, it looks like you don't have enough money to purchase this product.");
			containerSeller.getTextBox().addText("Come back when you have enough! I'll hold it for you until you return!");
		}
		if(world.getWorldState().getPlayer().inventoryContains("Container")) {
			containerSeller.getTextBox().addText("Thank you for shopping with us!");
		}
		
		
		//Retired Mine Worker
		if(!world.getWorldState().getPlayer().inventoryContains("Pickaxe")) {
			retiredMineWorker.willGiveItem(true);
			retiredMineWorker.setItemToGive(new Pickaxe());
			
			retiredMineWorker.getTextBox().addText("Hello there!");
			retiredMineWorker.getTextBox().addText("What's that? You're looking for some mining equipment?");
			retiredMineWorker.getTextBox().addText("Perfect! I was hoping to get rid of some of this old junk anyway.");
			retiredMineWorker.getTextBox().addText("Hmm... Let's see...");
			retiredMineWorker.getTextBox().addText("Ah! How about this pickaxe? It's perfect for chipping away at rocks.");
			retiredMineWorker.getTextBox().addText("How much does it cost? Don't even worry about that. You can have it for free.");
			retiredMineWorker.getTextBox().addText("But be careful, that pickaxe is very old. Wouldn't want it to break now would we?");
			retiredMineWorker.getTextBox().addText("You received a(n) " + retiredMineWorker.getItemToGive().getName() + "!");
		} else {
			retiredMineWorker.getTextBox().addText("Take good care of the pickaxe!");
		}
	}
	
	
}
