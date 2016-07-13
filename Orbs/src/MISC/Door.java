package MISC;

import STATES.WorldState;
import WORLD.World;
import visualje.Vector2D;

/** Doors are these sort of "trigger tiles" that perform a certain task upon stepping on them. As of right now, there is no
 * actual class called TriggerTile or TriggerEntity; it is just a way to describe them. TriggerTiles, such as this, are
 * invisible, as in they are not drawn on screen. However, for this door, when the player steps on it, the game will change 
 * the current world that the player is in to the destination world. */
public class Door {
	
	//The position of the door
	public Vector2D position;
	
	//The world that this door will send the player too
	World destination;
	
	//The world state for grabbing information
	WorldState worldState;
	
	//The map offset for moving between worlds
	int offset;
	
	
	//////////// Constructors ////////////
	
	public Door(int offset, WorldState ws, Vector2D pos) { this.offset = offset; worldState = ws; position = pos; }

	
	
	//////////// Getters /////////////
	
	/** Returns the destination world. */
	public World getDestination() { return destination; }
	
	
	///////////// Setters /////////////
	
	/** Sets the destination world. */
	public void setDestination(World w) { destination = w; }
	
	
	/** Sends the player to the destination world. */
	public void transport() {
		worldState.setCurrentWorld(getDestination());
		worldState.getCurrentWorld().setPosition(worldState.getCurrentWorld().position.add(new Vector2D(0,offset)));
		worldState.getCurrentWorld().initialize();
	}
	
}
