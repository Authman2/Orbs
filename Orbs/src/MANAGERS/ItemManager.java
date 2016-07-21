package MANAGERS;

import ITEMS.Coin;
import ITEMS.Container;
import ITEMS.Coupon;
import ITEMS.Hatchet;
import ITEMS.HazmatSuit;
import ITEMS.Item;
import ITEMS.Orb;
import ITEMS.Pickaxe;
import ITEMS.SewingKit;
import ITEMS.Water;
import WORLD.World;
import visualje.Vector2D;

/** Handles adding all of the items to the game world. */
public class ItemManager {

	//The world, used to access many different elements in the game world.
	World world;
	
	//An array of items that the NPCs have.
	Item[] npcItems;
	
	//The different game items that are just lying around the game world, waiting to be picked up.
	Item orb_1, orb_2;
	
	
	
	public ItemManager(World w) {
		world = w;
		npcItems = new Item[10];
	}

	
	///////////// Methods ///////////////
	
	/** Create a bunch of items. */
	public void createItems() {
		orb_1 = new Orb(new Vector2D(35,90).add(world.position));
			orb_1.setID("groundOrb");
		orb_2 = new Orb(new Vector2D(82,52).add(world.position));
			orb_2.setSpecial(true, "Container");
			orb_2.setID("specialOrb");
			
			Coin coin = new Coin(5);
			coin.setID("coin_person4");
		npcItems[0] = coin;
		npcItems[1] = new Coupon();
			Orb basketball_Orb = new Orb();
			basketball_Orb.setID("bball_Orb");
		npcItems[2] = basketball_Orb;
			Orb catOrb = new Orb();
			catOrb.setID("Cat_Orb");
		npcItems[3] = catOrb;
		npcItems[4] = new Container();
		npcItems[5] = new Hatchet();
		npcItems[6] = new Water();
		npcItems[7] = new SewingKit();
		npcItems[8] = new HazmatSuit();
		npcItems[9] = new Pickaxe();
	}
	
	
	/** Returns the item at the "i"th index. */
	public Item getNPCItem(int i) { return npcItems[i]; }
	
	public void addToGame() {
		if(world.getName().equals("Main")) {
			if(!world.getWorldState().getPlayer().containsID("groundOrb")) {
				world.getDroppedItems().add(orb_1);
			}
			if(!world.getWorldState().getPlayer().containsID("specialOrb")) {
				world.getDroppedItems().add(orb_2);
			}			
		}
	}
}
