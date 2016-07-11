package STATES;

import java.awt.Graphics2D;
import java.util.ArrayList;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.NPC;
import ENTITIES.Player;
import ENTITIES.SearchableEntity;
import ITEMS.Item;
import MANAGERS.GameStateManager;
import MANAGERS.ItemManager;
import MANAGERS.NPCManager;
import MISC.Door;
import MISC.TextBox;
import WORLD.World;
import visualje.Vector2D;

public class WorldState extends GameState {

	
	//The current world that is currently being displayed
	World currentWorld;
	
	//The house that the player is currently in
	World room;
	
	//All of the doors in the outdoor part of the game
	ArrayList<Door> doors;
	ArrayList<Door> houseDoors;
	
	//The player
	Player player;
	
	//The NPC manager
	NPCManager npcManager;
	
	//The Item Manager
	ItemManager itemManager;
	
	//A text box for displaying all of the items that the player has
	TextBox inventoryTextBox;
	
	
	public WorldState(GameStateManager gsm) {
		super(gsm);
		
		//Create the main game world and the house world
		currentWorld = new World("Main", 100, 100, 0, this);
			currentWorld.setOpen(true);
			currentWorld.setPosition(new Vector2D(-5,-4));
		room = new World("House_1", 12, 9, 1, this);
			room.setPosition(new Vector2D(2,-2));
		
		player = new Player(this);
		npcManager = new NPCManager(this);
		itemManager = new ItemManager(this);
		inventoryTextBox = new TextBox();
		updatePlayersItems();
		
		//Setup the door destinations
		doors = new ArrayList<Door>();
		houseDoors = new ArrayList<Door>();
		setupDoorDestinations();
	}
	
	
	////////////// Getters /////////////
	
	/** Returns the world that is being displayed in this world state. */
	public World getCurrentWorld() { return currentWorld; }
	
	
	/** Returns the room that is the inside of a house. */
	public World getHouse() { return room; }
	
	
	/** Returns the player. */
	public Player getPlayer() { return player; }
	
	
	/** Returns whether or not a text box is open by an NPC. */
	public boolean textBoxesOpen() { 
		boolean open = false;
		
		//Go through each entity
		for(Entity ent : currentWorld.getEntities()) { 
			if( ((NPC)ent).getTextBox().isOpen()) {
				open = true; 
			}
		}

		//Go through each item on the ground
		for(Item itm : currentWorld.getDroppedItems()) {
			if(itm.getTextBox().isOpen()) {
				open = true;
			}
		}
		
		//Go through each searchable entity
		for(SearchableEntity se : currentWorld.getSearchables()) {
			if(se.getTextBox().isOpen()) {
				open = true;
			}
		}
		
		//Go through each action entity
		for(ActionEntity ae : currentWorld.getActionEntities()) {
			if(ae.getTextBox().isOpen()) {
				open = true;
			}
		}

		
		if(inventoryTextBox.isOpen()) {
			open = true;
		}
		
		return open; 
	}
	
	
	/** Returns the text box that displays all of the player's items. */
	public TextBox getInventoryTextBox() { return inventoryTextBox; }
	
	
	/** Returns the npc manager, which can then be used for performing actions on NPCs. */
	public NPCManager getNPCManager() { return npcManager; }
	
	
	/** Returns whether or not the player is currently inside of a house. */
	public boolean insideHouse() { return room.isOpen(); }
	
	
	/** Returns all of the doors in the outdoor part of the game. */
	public ArrayList<Door> getDoors() { return doors; }
	
	
	/** Returns all of the doors in the outdoor part of the game. */
	public ArrayList<Door> getHouseDoors() { return houseDoors; }
	
	
	////////////// Setters /////////////
	
	/** Updates what the text box that shows the items that the player has should display. */
	public void updatePlayersItems() {
		//Remove whatever is already there so there are no duplicates
		inventoryTextBox.getTextSlides().removeAll(inventoryTextBox.getTextSlides());
		
		if(getPlayer().getInventory().size() > 0) {
			//Add an introductory line of text
			inventoryTextBox.addText("The player currently has these items: ");
			
			//Add descriptions for each item that the player has.
			for(Item itm : getPlayer().getInventory()) {
				inventoryTextBox.addText("" + itm.getQuantity() + " " + itm.getName() + "(s)");
			}
		} else {
			inventoryTextBox.addText("The player has no items.");
		}
	}

	
	/** Sets what the current game world should be. */
	public void setCurrentWorld(World world) { currentWorld = world; }

	
	/** Sets up all of the door destinations based on their location, then fill the list with all of the doors. */
	public void setupDoorDestinations() {
		doors.clear();
		
		/* THE MAIN GAME WORLD */
		for(int x = 0; x < currentWorld.getWidth(); x++) {
			for(int y = 0; y < currentWorld.getHeight(); y++) {
				int worldX = (int)currentWorld.position.X;
				int worldY = (int)currentWorld.position.Y;
				
				if(x == 13 + worldX && y == 9 + worldY) {
					Door door = new Door(this, new Vector2D(x,y));
					
					door.setCurrentWorld(currentWorld);
					door.setDestination(room);
					
					door.setActive(true);
					
					doors.add(door);
				}
			}
		}
		
		/* THE HOUSE */
		for(int x = 0; x < room.getWidth(); x++) {
			for(int y = 0; y < room.getHeight(); y++) {
				int worldX = (int)room.position.X;
				int worldY = (int)room.position.Y;
				
				if(x == 5 + worldX && y == 8 + worldY) {
					Door door = new Door(this, new Vector2D(x,y));
					
					door.setCurrentWorld(room);
					door.setDestination(currentWorld);
					
					door.setActive(false);
					
					houseDoors.add(door);
				}
			}
		}
		
		
		
	}
	
	
	////////////// Abstract Methods /////////////
	 
	@Override
	public void initialize() {
		if(currentWorld != null) {
			currentWorld.initialize();
			room.initialize();
			
			player.initialize();
			npcManager.initialize();
			itemManager.initialize();
		}
	}

	@Override
	public void update(double time) {
		if(currentWorld != null) {
			
			//Only update the one that is open
			if(currentWorld.isOpen()) {  
				currentWorld.update(time); 
				for(Door door : doors) { door.setActive(true); door.update(time); }
				for(Door door : houseDoors) { door.setActive(false); door.update(time); }
			} 
			if(room.isOpen()) { 
				room.update(time);  
				for(Door door : doors) { door.setActive(false); door.update(time); }
				for(Door door : houseDoors) { door.setActive(true); door.update(time); }
			}
			
			
			player.update(time);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if(currentWorld != null) {
			
			//Only draw the one that is open
			if(currentWorld.isOpen()) { currentWorld.draw(g); }
			if(room.isOpen()) room.draw(g);
			
			player.draw(g);
			if(inventoryTextBox.isOpen()) inventoryTextBox.draw(g);
		}
	}
	
}
