package MANAGERS;

import java.awt.Graphics2D;
import java.util.ArrayList;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MOVEABLE.NPC;
import STATES.WorldState;
import WORLD.World;

/** Just used for creating all the different NPCs. */
public class NPCManager implements IUD  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -191426110156570151L;
	World world;
	public ArrayList<NPC> npcs = new ArrayList<NPC>();
	
	//First NPC.
	NPC goodScientist, //The good scientist who runs the laboratory in starter town.
		badScientist; //The bad scientist who steals the orbs and hides them across the country.
	
	
	public NPCManager(World w) { 
		world = w;
		
		/* CREATE NEW NPC OBJECTS */
		createNPCObjects();
		
		
		/* WRITE OUT WHAT THEY WILL SAY */
		setNPCTexts();
		
		
		/* SET THEIR POSITIONS */
		setNPCPositions();
	}
	
	
	private void createNPCObjects() {
		goodScientist = new NPC("Good Scientist",world);
		badScientist = new NPC("Bad Scientist",world);
	}
	
	private void setNPCTexts() {
		goodScientist.textBox.addText("Hello, player! It's nice to finally meet you!");
		goodScientist.textBox.addText("Listen, I'm in a little bit of a predicament right now and I need your help.");
		
		badScientist.textBox.addText("Hahahahahahahahahaha!");
		badScientist.textBox.addText("You fools! There is nothing you can do to stop me now!!!");
	}
	
	private void setNPCPositions() {
		goodScientist.setPosition(new Vector2D(10,8));
		badScientist.setPosition(new Vector2D(20,20));
	}
	
	
	@Override
	public void initialize() {
		
		/* ADD ALL THE NPCS */
		npcs.add(goodScientist);
		npcs.add(badScientist);
		
		
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
