package MANAGERS;

import MISC.Item;
import MISC.Orb;
import STATES.WorldState;
import visualje.Vector2D;

/** Handles adding all of the items to the game world. */
public class ItemManager {

	//The world state, used to access many different elements in the game world.
	WorldState worldState;
	
	//The different game items that are just lying around the game world, waiting to be picked up.
	Item orb;
	
	
	public ItemManager(WorldState ws) {
		worldState = ws;
		orb = new Orb(new Vector2D(10,9));
		initialize();
	}

	
	///////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Add the items that are on the game floor to the list of items in
		worldState.getWorld().getDroppedItem().add(orb);
	}
	
}
