package MANAGERS;

import java.awt.Graphics2D;

import myproject.gos.main.IUD;
import INVENTORY.Inventory;
import INVENTORY.InventorySlot;
import STATES.CreatePlayerState;
import STATES.GameState;
import STATES.InventoryState;
import STATES.LoadState;
import STATES.MenuState;
import STATES.SaveState;
import STATES.StatsState;
import STATES.WorldState;

public class GameStateManager implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7085666548082066428L;
	public InputManager input;
	public GameState[] states;
	public GameState currentState;
	public GameState inventoryState, statsState;
	
	//The save state
	public SaveState saver;
	
	public GameStateManager() throws Exception {
		saver = new SaveState(this);
		
		states = new GameState[3];
		/* Main States */
		states[0] = new MenuState(this);		//First scene is the main menu.
		states[1] = new CreatePlayerState(this);//Then you create your player.	
		if(!MenuState.load) {					//If you're not loading a world state, then just start a new one
			states[2] = new WorldState(this);
		} else {
			load();
		}
		/* Extra States */
		inventoryState = new InventoryState(this);//An extra state for the inventory.
		statsState = new StatsState(this);		  //A state for displaying player's info.
		
		//Create input.
		input = new InputManager(this);
		
		//Define input variables
		defineInput();
		
		//Set the initial current state
		currentState = states[0];
		
		
		initialize();
	}
	
	private void defineInput() {
		//Define the different states so that the input manager knows what they are.
		input.menuState = (MenuState)states[0];
		input.createPlayer = (CreatePlayerState)states[1];
		if(!input.menuState.load)
			input.worldState = (WorldState)states[2];
		
		input.worldState.world = ((WorldState)states[2]).world;
		input.inventoryState = (InventoryState)inventoryState;
		input.statsState = (StatsState)statsState;
		
		//Define the player
		input.inventoryState.inventory.player = input.worldState.player;
		input.player = input.inventoryState.inventory.player;
		input.saveTB = saver.saveSuccessTextbox;
	}
	
	
	public void save() {
		
		//Save the world state.
		saver.SaveGame(((WorldState)states[2]), "Orbs_Data");
		saver.SaveGame(input, "Orbs_Input_Data");
		saver.SaveGame(input.inventoryState.inventory, "Inventory_Data");
	}
	public void load() {
		LoadState loader = new LoadState(this);
		states[2] = (WorldState) loader.LoadGame(((WorldState)states[2]), "Orbs_Data");
		currentState = ((WorldState)states[2]);
		
		input = (InputManager) loader.LoadGame(input, "Orbs_Input_Data");
		input.worldState = (WorldState)currentState;
		
		((InventoryState)inventoryState).inventory = (Inventory) loader.LoadGame((Inventory)input.inventoryState.inventory, "Inventory_Data");
		
		initialize();
	}
	
	
	@Override
	public void initialize() {
		currentState.initialize();
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(((StatsState)statsState).Open == true) 
			statsState.draw(g);
		else if(((InventoryState)inventoryState).inventory.Open == true) 
			inventoryState.draw(g);
		else 
			currentState.draw(g);
		
		saver.draw(g);
	}

	@Override
	public void update(double time) {
		currentState.update(time);
		saver.update(time);
		
		if(((InventoryState)inventoryState).inventory.Open == true)
			inventoryState.update(time);

		if(((StatsState)statsState).Open == true) 
			statsState.update(time);
	}

}
