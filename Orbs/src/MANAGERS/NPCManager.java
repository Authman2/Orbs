package MANAGERS;

import java.awt.Graphics2D;
import java.util.ArrayList;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MOVEABLE.NPC;
import WORLD.World;

/** Just used for creating all the different NPCs. */
public class NPCManager implements IUD  {
	private static final long serialVersionUID = -191426110156570151L;
	
	
	World world;
	public ArrayList<NPC> npcs = new ArrayList<NPC>();
	
	//First NPC.
	NPC goodScientist, //The good scientist who runs the laboratory in starter town.
		badScientist,  //The bad scientist who steals the orbs and hides them across the country.
		randomNPC1;     //A random NPC that will say something to the player, and maybe give an item.
	
	
	public NPCManager(World w) { 
		world = w;
	}
	
	
	private void createNPCObjects() {
		goodScientist = new NPC("Good Scientist",world.worldstate.worlds[0]);
		badScientist = new NPC("Bad Scientist",world.worldstate.worlds[0]);
		randomNPC1 = new NPC("Bob",world.worldstate.worlds[2]);
	}
	
	private void setNPCTexts() {
		goodScientist.textBox.addText("Hello, player! It's nice to finally meet you!");
		goodScientist.textBox.addText("Listen, I'm in a little bit of a predicament right now and I need your help.");
		
		badScientist.textBox.addText("Hahahahahahahahahaha!");
		badScientist.textBox.addText("You fools! There is nothing you can do to stop me now!!!");
		
		randomNPC1.textBox.addText("Have you heard what happened to BLAH BLAH BLAH?");
		randomNPC1.textBox.addText("His laboratory was robbed last night!");
		
	}
	
	private void setNPCPositions() {
		goodScientist.setPosition(new Vector2D(10,8));
		badScientist.setPosition(new Vector2D(20,20));
		randomNPC1.setPosition(new Vector2D(12,0));
	}
	
	
	@Override
	public void initialize() {
		/* CREATE NEW NPC OBJECTS */
		createNPCObjects();
		
		
		/* WRITE OUT WHAT THEY WILL SAY */
		setNPCTexts();
		
		
		/* SET THEIR POSITIONS */
		setNPCPositions();
		
		/* ADD ALL THE NPCS */
		npcs.add(goodScientist);
		npcs.add(badScientist);
		npcs.add(randomNPC1);
		
	}

	@Override
	public void update(double time) {
		for(NPC n : npcs) {
			n.update(time);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		for(NPC n : npcs) {
			n.draw(g);
		}
	}

}
