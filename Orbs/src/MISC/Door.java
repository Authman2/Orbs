package MISC;

import STATES.WorldState;
import WORLD.World;
import visualje.Vector2D;

public class Door {
	
	//The position of the door
	public Vector2D position;
	
	//The world that this door will send the player too
	World destination;
	
	//The world state for grabbing information
	WorldState worldState;
	
	
	
	//////////// Constructors ////////////
	
	public Door(WorldState ws, Vector2D pos) { worldState = ws; position = pos; }

	
	
	//////////// Getters /////////////
	
	/** Returns the destination world. */
	public World getDestination() { return destination; }
	
	
	///////////// Setters /////////////
	
	/** Sets the destination world. */
	public void setDestination(World w) { destination = w; }
	
	
	/** Sends the player to the destination world. */
	public void transport() {
		worldState.setCurrentWorld(destination);
		worldState.getCurrentWorld().initialize();
		worldState.getNPCManager().initialize();
	}
	
}
