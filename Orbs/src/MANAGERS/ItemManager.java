package MANAGERS;

import STATES.WorldState;

/** Handles adding all of the items to the game world. */
public class ItemManager {

	//The world state, used to access many different elements in the game world.
	WorldState worldState;
	
	//The different game items that are just lying around the game world, waiting to be picked up.
	//Item orb_1, orb_2, orb_3, orb_4, orb_5;
	
	
	
	public ItemManager(WorldState ws) {
		worldState = ws;
		initialize();
	}

	
	///////////// Abstract Methods ///////////////
	
	public void initialize() {
		//Add the items that are on the game floor to the list of items in the world
		
	}
	
}
