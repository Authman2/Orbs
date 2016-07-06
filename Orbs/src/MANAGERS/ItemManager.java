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
	Item orb_1, orb_2, orb_3, orb_4, orb_5;
	
	
	public ItemManager(WorldState ws) {
		worldState = ws;
		orb_1 = new Orb(new Vector2D(10,9));
		orb_2 = new Orb(new Vector2D(30,10));
		orb_3 = new Orb(new Vector2D(4,30));
		orb_4 = new Orb(new Vector2D(15,15));
		orb_5 = new Orb(new Vector2D(23,27));
		initialize();
	}

	
	///////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Add the items that are on the game floor to the list of items in the world
		worldState.getWorld().getDroppedItems().add(orb_1);
		worldState.getWorld().getDroppedItems().add(orb_2);
		worldState.getWorld().getDroppedItems().add(orb_3);
		worldState.getWorld().getDroppedItems().add(orb_4);
		worldState.getWorld().getDroppedItems().add(orb_5);
	}
	
}
