package MANAGERS;

import ENTITIES.Person;
import ITEMS.Orb;
import WORLD.World;
import visualje.Vector2D;

/** Handles adding all of the NPCs to the game world. */
public class NPCManager {

	//The world, used to access many different elements in the game world.
	World world;
	
	//The NPCs
	Person randomGuy_1, randomGuy_2, randomGuy_3, randomGuy_4, randomGuy_5;
	Person scientist;
	Person chemicalController_1, chemicalController_2, chemicalController_3;
	Person barrierToLastPart;
	
	
	////////////// Constructor ///////////////	
	public NPCManager(World w) { 
		world = w;
	}
	
	
	//////////// Setters ////////////
	
	/** Clears the text boxes for each NPC. */
	public void clearTextBoxes() {
		randomGuy_1.getTextBox().clear();
		randomGuy_2.getTextBox().clear();
		randomGuy_3.getTextBox().clear();
		randomGuy_4.getTextBox().clear();
		randomGuy_5.getTextBox().clear();
		scientist.getTextBox().clear();
		chemicalController_1.getTextBox().clear();
		chemicalController_2.getTextBox().clear();
		chemicalController_3.getTextBox().clear();
		barrierToLastPart.getTextBox().clear();
	}
	
	/** Creates all of the NPC objects. */
	public void createNPCs() {
		//Create the NPCs. The positions have to be added to the world's position to arrange them properly.
		randomGuy_1 = new Person(new Vector2D(24,19).add(world.position));
		randomGuy_2 = new Person(new Vector2D(18,12).add(world.position));
		randomGuy_3 = new Person(new Vector2D(12,17).add(world.position));
		randomGuy_4 = new Person(new Vector2D(15,25).add(world.position));
			randomGuy_4.willGiveItem(true);
			randomGuy_4.setItemToGive(new Orb());
		randomGuy_5 = new Person(new Vector2D(24,25).add(world.position));
		scientist = new Person(new Vector2D(24, 11).add(world.position));
		chemicalController_1 = new Person(new Vector2D(62,55).add(world.position));
		chemicalController_2 = new Person(new Vector2D(62,56).add(world.position));
		chemicalController_3 = new Person(new Vector2D(62,57).add(world.position));
		barrierToLastPart = new Person(new Vector2D(46,29).add(world.position));
	}
	
	/** Adds to the list of entities in world. */
	public void addToGame() {
		//Once you are done setting them up, add them to the list of entities.
		world.addEntity(randomGuy_1);
		world.addEntity(randomGuy_2);
		world.addEntity(randomGuy_3);
		world.addEntity(randomGuy_4);
		world.addEntity(randomGuy_5);
		world.addEntity(scientist);
		world.addEntity(chemicalController_1);
		world.addEntity(chemicalController_2);
		world.addEntity(chemicalController_3);
	}
	
	
	////////////// Abstract Methods ///////////////
	
	public void initialize() {
		clearTextBoxes();
		
		//Random guy 1
		randomGuy_1.getTextBox().addText("Nice weather we're having, right?");
		randomGuy_1.getTextBox().addText("Not like last week when it was 95 degrees!");
		
		
		//Random guy 2
		randomGuy_2.getTextBox().addText("Have you talked to that wierd scientist guy?");
		randomGuy_2.getTextBox().addText("He was blabbing about some orbs or something...");
		randomGuy_2.getTextBox().addText("I couldn't really understand him though. He was talking so fast!");
		
		
		//Random guy 3
		randomGuy_3.getTextBox().addText("Have you heard about the burglary that happened last night?");
		randomGuy_3.getTextBox().addText("That's why I'm standing guard here. No criminal is going to break into my house!");
		
		
		//Random guy 4
		if(randomGuy_4.getItemToGive() != null) {
			randomGuy_4.getTextBox().addText("Oh, you're going out of town?");
			randomGuy_4.getTextBox().addText("Well you should be careful, with that thief on the loose you never know what might happen to you.");
			randomGuy_4.getTextBox().addText("You know what, I admire your bravery. I'm way too scared to leave town knowing that I might run into the criminal!");
			randomGuy_4.getTextBox().addText("Here, take this. It may not be much, but I just feel like you should be rewarded for having the courage to find the thief.");
			randomGuy_4.getTextBox().addText("Good luck, and I hope you can get to the bottom of this case!");
			randomGuy_4.getTextBox().addText("You were given a(n) " + randomGuy_4.getItemToGive().getName() + "!");
		} else {
			randomGuy_4.getTextBox().addText("Good luck out there!");
		}
		
			
		//Random guy 5
		randomGuy_5.getTextBox().addText("Everybody in town is worried about being robbed after what happened to that scientist last night.");
		randomGuy_5.getTextBox().addText("I'm not worried though, I set up a bunch of alarms in my house that will detect any kind of movement!");
		randomGuy_5.getTextBox().addText("Unfortunately that means that I can't actually go inside my house...");
		
		
		//Scientist
		if(!Orb.pickedUpFirstOrb) {
			scientist.getTextBox().addText("Ahh!");
			scientist.getTextBox().addText("I cannot believe this!");
			scientist.getTextBox().addText("All of my orbs! They've been stolen!");
			scientist.getTextBox().addText("Oh no, this is very bad...");
			scientist.getTextBox().addText("I could lose all of my funding for this!");
			scientist.getTextBox().addText("I could even go to jail if they end up in the wrong hands!");
			scientist.getTextBox().addText("Huh? What's that?");
			scientist.getTextBox().addText("Oh, I'm sorry, I didn't hear you. I was too busy worrying about my experiement...");
			scientist.getTextBox().addText("Would you like to hear about it?");
			scientist.getTextBox().addText("You would? Great! It's very simple, but very powerful at the same time.");
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
			scientist.getTextBox().addText("I have no idea where they might be, so make sure you look beneath every rock, behind every tree, and right under your nose!");
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
			scientist.getTextBox().addText("Please keep on looking and return to me when you have more orbs! Good luck!");
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
		
		//addToGame();
	}
	
	
}
