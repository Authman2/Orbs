package MANAGERS;

import ITEMS.Item;
import ITEMS.Orb;
import STATES.WorldState;
import visualje.Vector2D;

/** Handles adding all of the items to the game world. */
public class ItemManager {

	//The world state, used to access many different elements in the game world.
	WorldState worldState;
	
	//The different game items that are just lying around the game world, waiting to be picked up.
	Item orb_1;
	
	
	
	public ItemManager(WorldState ws) {
		worldState = ws;
		
		orb_1 = new Orb(new Vector2D(35,90).add(worldState.getCurrentWorld().position));
		
		initialize();
	}

	
	///////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Add the items that are on the game floor to the list of items in the world
		worldState.getCurrentWorld().getDroppedItems().add(orb_1);
	}
	
}
