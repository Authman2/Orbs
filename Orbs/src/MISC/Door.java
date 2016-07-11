package MISC;

import java.awt.Graphics2D;

import STATES.WorldState;
import WORLD.World;
import visualje.Vector2D;

/** Doors are sort of "empty entities" in the game. They are not drawn on the screen, but are still updated. When the player 
 * steps on a door entity, it will transport the player to a different World. It does not actually change the world, however.
 * It just opens up the destination world on top of the main world and basically disables the main world for a while. */
public class Door {
	
	//The position of the door in world space
	public Vector2D position;
	
	
	//The world that the player is currently in
	World current;
	
	
	//The world that this door will take the player to
	World destination;
	
	
	//The world state used for grabbing information from different places
	WorldState worldState;

	
	//Whether or not this door is active
	boolean active;
	
	
	
	
	//////////// Constructors /////////////
	
	public Door() { position = new Vector2D(); }
	public Door(Vector2D pos) { position = pos; }
	public Door(WorldState ws, Vector2D pos) { worldState = ws; position = pos; }

	
	
	///////////// Setters /////////////
	
	/** Sets the world that the player is currently in. */
	public void setCurrentWorld(World w) { current = w; }
	
	
	/** Sets the destination world for this door to take the player to. */
	public void setDestination(World w) { destination = w; }
	
	
	/** Sends the player to the destination world. */
	public void transport() {
		if(destination != null) {
			destination.setOpen(true);
			current.setOpen(false);
			
			World temp = current;
			current = destination;
			destination = temp;
		} else {
			System.err.println("There is no destination world to send the player to.");
		}
	}
	
	
	/** Sets whether or not this door is active. */
	public void setActive(boolean b) { active = b; }
	
	
	///////////// Getters /////////////
	
	/** Returns the destination world. */
	public World getDestination() { return destination; }
	
	
	/** Returns the current world. */
	public World getCurrentWorld() { return current; }
	
	
	/** Returns whether or not this door is active. */
	public boolean isActive() { return active; }
	
	
	
	//////////// Abstract Methods /////////////
	
	public void initialize() {}
	
	
	public void update(double time) {
		
	}

	
	public void draw(Graphics2D g) {}
}
