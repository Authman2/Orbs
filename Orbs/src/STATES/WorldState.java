package STATES;

import java.awt.Graphics2D;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.NPC;
import ENTITIES.Player;
import ENTITIES.SearchableEntity;
import ITEMS.Item;
import MANAGERS.GameStateManager;
import MISC.Door;
import MISC.TextBox;
import WORLD.World;
import visualje.Vector2D;

public class WorldState extends GameState {

	
	//The current world that is currently being displayed
	World currentWorld;
	
	//The main world map world
	World mainWorld;
	
	//An array of houses
	World[] houses;
	
	//The player
	Player player;
	
	//A text box for displaying all of the items that the player has
	TextBox inventoryTextBox;
	
	
	public WorldState(GameStateManager gsm) {
		super(gsm);
		
		//Create the game worlds
		createWorlds();
			
		player = new Player(this);
		inventoryTextBox = new TextBox();
		updatePlayersItems();
		
		
		initialize();
	}
	
	
	////////////// Getters /////////////
	
	/** Returns the world that is being displayed in this world state. */
	public World getCurrentWorld() { return currentWorld; }
	
	
	/** Returns the main game world. */
	public World getMainWorld() { return mainWorld; }

	
	/** Returns a particular house. */
	public World getHouse(int index) { return houses[index]; }
	
	
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
	
	
	
	////////////// Setters /////////////
	
	/** Create the different worlds for the game*/
	public void createWorlds() {
		houses = new World[28];
		
		mainWorld = new World("Main", 100, 100, 0, this);
			mainWorld.setPosition(new Vector2D(-5,-4));
			
		//Loop through, creating houses (Worlds).
		for(int i = 0; i < 28; i++) {	
			World house = new World("House_"+(i+1), 14, 11, 1, this);
			house.setPosition(new Vector2D(1,-3));
			
			houses[i] = house;
		}


		//Set the current world
		currentWorld = mainWorld;
			currentWorld.setOpen(true);
	}
	
	
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


	/** Sets what the current world should be. */
	public void setCurrentWorld(World w) { currentWorld = w; }
	
	
	/** Determines what to do based on whether or not the player is standing on a door. */
	public void enteringDoors() {
		for(Door door : currentWorld.getDoors()) {
			if(door.position.equals(player.position)) {
				door.transport();
			}
		}
	}
	
	
	
	////////////// Abstract Methods /////////////
	 
	@Override
	public void initialize() {
		if(currentWorld != null) {
			currentWorld.initialize();
			currentWorld.createNPCsAndItems();
			
			player.initialize();
		}
	}

	@Override
	public void update(double time) {
		if(currentWorld != null) {
			
			//Only update the one that is open
			currentWorld.update(time);
			
			//Check for doors
			enteringDoors();
			
			player.update(time);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if(currentWorld != null) {
			
			//Only draw the one that is open
			currentWorld.draw(g);
			
			player.draw(g);
			if(inventoryTextBox.isOpen()) inventoryTextBox.draw(g);
		}
	}
	
}
