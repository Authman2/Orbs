package STATES;

import java.awt.Graphics2D;

import ENTITIES.Entity;
import ENTITIES.NPC;
import ENTITIES.Player;
import ENTITIES.Tree;
import MANAGERS.GameStateManager;
import MANAGERS.ItemManager;
import MANAGERS.NPCManager;
import MISC.Item;
import MISC.TextBox;
import WORLD.World;

public class WorldState extends GameState {

	
	//The world that is currently being displayed
	World world;
	
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
		
		world = new World(40,40, this);
		player = new Player(this);
		npcManager = new NPCManager(this);
		itemManager = new ItemManager(this);
		inventoryTextBox = new TextBox();
		updatePlayersItems();
	}
	
	
	////////////// Getters /////////////
	
	/** Returns the world that is being displayed in this world state. */
	public World getWorld() { return world; }
	
	/** Returns the player. */
	public Player getPlayer() { return player; }
	
	/** Returns whether or not a text box is open by an NPC. */
	public boolean textBoxesOpen() { 
		boolean open = false;
		
		//Go through each entity
		for(Entity ent : world.getEntities()) { 
			if( ((NPC)ent).getTextBox().isOpen()) {
				open = true; 
			}
		}

		//Go through each item on the ground
		for(Item itm : world.getDroppedItems()) {
			if(itm.getTextBox().isOpen()) {
				open = true;
			}
		}
		
		
		//Go through each item on the ground
		for(Tree tree : world.getTrees()) {
			if(tree.getTextBox().isOpen()) {
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
	
	
	

	////////////// Abstract Methods /////////////
	 
	@Override
	public void initialize() {
		if(world != null) {
			world.initialize();
			player.initialize();
			npcManager.initialize();
			itemManager.initialize();
		}
	}

	@Override
	public void update(double time) {
		if(world != null) {
			world.update(time);
			player.update(time);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		if(world != null) {
			world.draw(g);
			player.draw(g);
			if(inventoryTextBox.isOpen()) inventoryTextBox.draw(g);
		}
	}
	
}
