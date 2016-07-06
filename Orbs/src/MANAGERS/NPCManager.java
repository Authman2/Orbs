package MANAGERS;

import ENTITIES.Person;
import STATES.WorldState;
import visualje.Vector2D;

/** Handles adding all of the NPCs to the game world. */
public class NPCManager {

	//The world state, used to access many different elements in the game world.
	WorldState worldState;
	
	//The NPCs
	Person randomGuy_1, randomGuy_2, scientist;
	
	
	////////////// Constructor ///////////////	
	public NPCManager(WorldState ws) { 
		worldState = ws;
		
		//Create the NPCs
		randomGuy_1 = new Person(new Vector2D(10,6));
		randomGuy_2 = new Person(new Vector2D(13,12));
		scientist = new Person(new Vector2D(30, 6));
		
		
		initialize();
	}
	
	////////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Random guy 1
		randomGuy_1.getTextBox().addText("Nice weather we're having, right?");
		randomGuy_1.getTextBox().addText("Not like last week when it was 95 degrees!");
		
		//Random guy 2
		randomGuy_2.getTextBox().addText("Have you talked to that wierd scientist guy?");
		randomGuy_2.getTextBox().addText("He was blabbing about some multi-colored orbs or something...");
		randomGuy_2.getTextBox().addText("I couldn't really understand him though. He was talking so fast!");
		
		//Scientist
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
		
		
		//Once you are done setting them up, add them to the list of entities.
		worldState.getWorld().addEntity(randomGuy_1);
		worldState.getWorld().addEntity(randomGuy_2);
		worldState.getWorld().addEntity(scientist);
	}
	
	
}
