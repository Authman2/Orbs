package ENTITIES;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ITEMS.Coin;
import ITEMS.Item;
import ITEMS.Orb;
import MAIN.Animator;
import MAIN.Assets;
import STATES.WorldState;
import visualje.Vector2D;

public class Player extends Entity {
	
	//Animators for the player
	Animator walk_down, walk_up, walk_right, walk_left;
	
	//The world state that this player is in
	WorldState worldState;
	
	//A list of the items that the player currently has
	ArrayList<Item> items;
	
	//A list of the orbs that the player has
	ArrayList<Orb> orbs;
	
	//All of the coins that the player has
	ArrayList<Coin> coins;
	
	//Step counter for a particular task in the game
	int steps = -1;
	
	//When to start counting steps
	boolean startCountingSteps;
	
	
	
	/////////// Constructor ////////////
	
	public Player(WorldState ws) {
		position = new Vector2D(8,6);
		items = new ArrayList<Item>();
		orbs = new ArrayList<Orb>();
		coins = new ArrayList<Coin>();
		worldState = ws;
		initialize();
	}
	
	
	///////// Getters //////////
	
	/** Returns the list of items that the player has (the inventory). */
	public ArrayList<Item> getInventory() { return items; }
	
	
	/** Returns all of the orbs that the player has. */
	public ArrayList<Orb> getOrbs() { return orbs; }
	
	
	/** Returns all of the orbs that the player has. */
	public ArrayList<Coin> getCoins() { return coins; }
	
	
	/** Returns the number of steps the player has taken (certain task in game). */
	public int getSteps() { return steps; }
	
	
	/** Returns an item at a particular index of the list of items. */
	public Item getItem(int i) { return items.get(i); }
	
	
	/** Returns the number of orbs that the player currently has. */
	public int getOrbCount() { 
		for(Item itm : items) {
			if(itm.getName().equals("Orb")) {
				return itm.getQuantity();
			}
		}
		return 0;
	}
	
	
	/** Returns whether or not the player has an item with the specified name in the inventory. */
	public boolean inventoryContains(String name) {
		for(Item itm : items) {
			if(itm.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	
	/** Returns whether or not the player has an item with the particular ID in the inventory. */
	public boolean containsID(String id) {
		for(Item itm : items) {
			if(itm.getID().equals(id)) {
				return true;
			}
		}
		for(Orb itm : orbs) {
			if(itm.getID().equals(id)) {
				return true;
			}
		}
		for(Coin itm : coins) {
			if(itm.getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	/** Returns whether or not the player has a particular orb based on its ID. */
	public boolean hasOrb(String id) {
		for(Orb o : orbs) {
			if(o.getID().equals(id))
				return true;
		}
		return false;
	}
	
	
	/** Returns whether or not the player has a particular orb based on its ID. */
	public boolean hasCoin(String id) {
		for(Coin o : coins) {
			if(o.getID().equals(id))
				return true;
		}
		return false;
	}
	
	
	/** Returns the quantity of a particular item in the player's inventory. */
	public int getQuantity(String name) {
		for(Item itm : items) {
			if(itm.getName().equals(name)) {
				return itm.getQuantity();
			}
		}
		return 0;
	}
	
	
	/** Returns a particular item from the player's inventory. */
	public Item getInventoryItem(String name) {
		for(Item itm : items) {
			if(itm.getName().equals(name)) {
				return itm;
			}
		}
		return null;
	}
	
	
	/** Returns the total number of coins. */
	public int getTotalCoins() {
		int num = 0;
		for(Coin c : coins) {
			num += c.getQuantity();
		}
		return num;
	}
	
	
	/** Returns whether or not the steps are being counted. */
	public boolean isCountingSteps() { return startCountingSteps; }
	
	
	
	
	///////// Setters //////////
	
	/** Returns a list of the items that the player has acquired. */
	public void addItemToInventory(Item itm) { 
		if(!(itm instanceof Orb) && !(itm instanceof Coin)) {
			//The counter
			int i = 0;
			
			//Loop through and check if there is already an item with the same name in the player's inventory.
			for(Item it : items) {
				
				//If there is, update the quantity of that item.
				if(it.getName().equals(itm.getName())) {
					it.setQuantity(it.getQuantity() + itm.getQuantity());
					break;
				}
				
				//Increment the counter
				i++;
			}
			
			/* If you reach the end of the item list (the counter is >= to the size), you know that the item was not already
			 * in the player's inventory, so it should add it onto the end. */
			if(i >= items.size()) {
				items.add(itm);
			}
		} else if(!(itm instanceof Orb) && (itm instanceof Coin)){
			coins.add((Coin)itm);
			removeFromInventory("Coin");
			items.add(new Coin(getTotalCoins()));
		} else if((itm instanceof Orb) && !(itm instanceof Coin)) {
			orbs.add((Orb)itm);
			//Remove all of the orbs that are already in the inventory, then add a new orb with the particular quantity.
			removeFromInventory("Orb");
			items.add(new Orb(orbs.size()));
			
		}

	}
	

	/** Removes an item from the player's inventory. */
	public void removeFromInventory(String name) {
		for(Item itm : items) {
			if(itm.getName().equals(name)) {
				items.remove(itm);
				break;
			}
		}
	}
	
	
	/** Set the quantity of a particular item in the player's inventory. */
	public void setQuantity(String name, int i) {
		for(Item itm : items) {
			if(itm.getName().equals(name)) {
				itm.setQuantity(i);
			}
		}
	}
	
	
	/** Set the quantity of a particular item in the player's inventory. */
	public void setQuantity(int i, String id) {
		for(Item itm : items) {
			if(itm.getID().equals(id)) {
				itm.setQuantity(i);
			}
		}
	}
	
	
	/** Sets the number of steps the player has taken (certain task in game). */
	public void setSteps(int i) { steps = i; }
	
	
	/** Starts counting the steps. */
	public void startCountingSteps() { startCountingSteps = true; }
	
	
	
	//////////// Abstract Methods ///////////////
	
	@Override
	public void initialize() {
		BufferedImage[] walkDown = {Assets.player_down_walk1, Assets.player_down, Assets.player_down_walk2};
		walk_down = new Animator(walkDown);
		walk_down.setSpeed(180);
		walk_down.play();

		BufferedImage[] walkUp = {Assets.player_up_walk1, Assets.player_up, Assets.player_up_walk2};
		walk_up = new Animator(walkUp);
		walk_up.setSpeed(180);
		walk_up.play();
		
		BufferedImage[] walkRight = {Assets.player_right_walk1, Assets.player_right, Assets.player_right_walk2};
		walk_right = new Animator(walkRight);
		walk_right.setSpeed(180);
		walk_right.play();
		
		BufferedImage[] walkLeft = {Assets.player_left_walk1, Assets.player_left, Assets.player_left_walk2};
		walk_left = new Animator(walkLeft);
		walk_left.setSpeed(180);
		walk_left.play();
	}

	@Override
	public void update(double time) {
		//You cannot have water and a hatchet in the inventory at the same time since you have to give it to an NPC.
		if(inventoryContains("Hatchet")) {
			if(inventoryContains("Water")) {
				removeFromInventory("Water");
				worldState.updatePlayersItems();
			}
		}
		//You cannot have water and a coupon in your inventory at the same time
		if(inventoryContains("Water")) { 
			if(inventoryContains("Coupon")) {
				removeFromInventory("Coupon");
				worldState.updatePlayersItems();
			}
		}
		//Get rid of any coins that you have if the quantity is <= 0.
		if(inventoryContains("Coin")) {
			if(getQuantity("Coin") <= 0) {
				removeFromInventory("Coin");
				worldState.updatePlayersItems();
			}
		}
		//You cannot have the bakery receipt and the cake at the same time
		if(inventoryContains("Bakery Receipt")) {
			if(inventoryContains("Cake")) {
				removeFromInventory("Bakery Receipt");
				worldState.updatePlayersItems();
			}
		}
		//You cannot have the cake and the cake orb at the same time
		if(inventoryContains("Cake")) {
			if(containsID("cake_orb")) {
				removeFromInventory("Cake");
				worldState.updatePlayersItems();
			}
		}
		//You cannot have a box of text books and a bookstore receipt
		if(inventoryContains("Box of Textbooks")) {
			if(inventoryContains("Bookstore Receipt")) {
				removeFromInventory("Bookstore Receipt");
				worldState.updatePlayersItems();
			}
		}
		//You cannot have a box of text books and a textbook
		if(inventoryContains("Box of Textbooks")) {
			if(inventoryContains("Textbook")) {
				removeFromInventory("Box of Textbooks");
				worldState.updatePlayersItems();
			}
		}
		//Keep certain items' quantities to just 1
		if(inventoryContains("Bakery Receipt")) { setQuantity("Bakery Receipt", 1); worldState.updatePlayersItems(); }
	}

	@Override
	public void draw(Graphics2D g) {
		
		if(facing == 0) {
			if(worldState.getCurrentWorld().down) {
				g.drawImage(walk_down.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_down.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_down, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
		
		if(facing == 1) {
			if(worldState.getCurrentWorld().right) {
				g.drawImage(walk_right.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_right.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_right, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
			
		if(facing == 2) {
			if(worldState.getCurrentWorld().up) {
				g.drawImage(walk_up.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_up.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_up, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
		
		if(facing == 3) {
			if(worldState.getCurrentWorld().left) {
				g.drawImage(walk_left.sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				walk_left.update(System.currentTimeMillis());
			} else {
				g.drawImage(Assets.player_left, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
	}
	

} //End of class
