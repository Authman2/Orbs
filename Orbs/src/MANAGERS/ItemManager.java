package MANAGERS;

import ITEMS.Item;
import ITEMS.Orb;
import WORLD.World;
import visualje.Vector2D;

/** Handles adding all of the items to the game world. */
public class ItemManager {

	//The world, used to access many different elements in the game world.
	World world;
	
	//The different game items that are just lying around the game world, waiting to be picked up.
	Item orb_1, orb_2;
	
	
	
	public ItemManager(World w) {
		world = w;
	}

	
	///////////// Methods ///////////////
	
	public void initialize() {
		orb_1 = new Orb(new Vector2D(35,90).add(world.position));
		orb_2 = new Orb(new Vector2D(82,52).add(world.position));
			orb_2.setSpecial(true, "Container");
	}
	
	public void addToGame() {
		if(world.getName().equals("Main")) {
			world.getDroppedItems().add(orb_1);
			world.getDroppedItems().add(orb_2);
		}
	}
}
