package MANAGERS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import myproject.gos.main.TransitionManager.Transition;
import INVENTORY.Item;
import INVENTORY.Item.ItemType;
import MISC.KeyboardKey;
import MISC.TextBox;
import MOVEABLE.Entity;
import MOVEABLE.NPC;
import MOVEABLE.Player;
import STATES.CreatePlayerState;
import STATES.InventoryState;
import STATES.MenuState;
import STATES.StatsState;
import STATES.WorldState;
import WORLD.Tile;

public class InputManager implements KeyListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5749004983566885846L;
	//All the different states that require input.
	public MenuState menuState;
	public CreatePlayerState createPlayer;
	public WorldState worldState;
	public InventoryState inventoryState;
	public StatsState statsState;
	
	//Other classes needed
	public Player player;
	public TextBox saveTB;
	
	//The gamestatemanager.
	public GameStateManager myGsm;
	
	
	public InputManager(GameStateManager g) {
		myGsm = g;
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		/* MAIN MENU */
		if(myGsm.currentState == myGsm.states[0]) {
			MenuStateActions(e);
		}
		
		/* CREATING PLAYER */
		if(myGsm.currentState == myGsm.states[1]) {
			CreatePlayerStateActions(e);
		}
		
		/* MOVING ABOUT THE WORLD*/
		if(myGsm.currentState == myGsm.states[2] || myGsm.currentState == worldState) {
			//If the menu is open
			if(worldState.hud.menu.Open && !TextBox.Open) {
				MenuActions(e);
				if(e.getKeyCode() == KeyEvent.VK_M) {
					worldState.hud.menu.Open = !worldState.hud.menu.Open;
				}
				
			//If the inventory is open
			} else if(((InventoryState)myGsm.inventoryState).inventory.Open) {
				
				if(!inventoryState.displayOptions) {
					InventoryActions(e);
				} else {
					InventoryOptions(e);
				}
			
			//If the stats window is open
			} else if(((StatsState)myGsm.statsState).Open){
				StatsStateActions(e);
				
			} else if(TextBox.Open) {
				
				TextBoxActions(e);
				
			//Otherwise just look for the general world.
			} else {
				WorldStateActions(e);
				/* OPEN MENU */
				if(e.getKeyCode() == KeyEvent.VK_M) {
					worldState.hud.menu.Open = !worldState.hud.menu.Open;
				}
			}
		}
		
		
		
	}


	private void MenuStateActions(KeyEvent e) {
		//Options up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(menuState.selectedOption > 0) {
				menuState.selectedOption--;
			} else {
				menuState.selectedOption = 2;
			}
		}
		//Options down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(menuState.selectedOption < 2) {
				menuState.selectedOption++;
			} else {
				menuState.selectedOption = 0;
			}
		}
		//Going to start a new game
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {
			//Start a new game
			if(menuState.selectedOption == 0) {
				System.out.println("Starting new game.");
				//Transition out
				menuState.transitions.SetTransition(Transition.Fade_Out, 0.0035);
				menuState.transitions.BeginTransition();
			}
			//Load a game
			if(menuState.selectedOption == 1) {
				menuState.load = true;
				//Transition out
				menuState.transitions.SetTransition(Transition.Fade_Out, 0.0035);
				menuState.transitions.BeginTransition();
			}
			//Quit
			if(menuState.selectedOption == 2) {
				System.exit(0);
			}
		}
	}
	
	private void CreatePlayerStateActions(KeyEvent e) {
		//Keyboard up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			int x = -1, y = -1;
			for(int i = 0; i < createPlayer.keyboard.keys.length; i++) {
				for(int j = 0; j < createPlayer.keyboard.keys[0].length; j++) {
					if(createPlayer.keyboard.selectedKey == ((KeyboardKey)createPlayer.keyboard.keys[i][j]) ) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				createPlayer.keyboard.selectedKey = ((KeyboardKey)createPlayer.keyboard.keys[x][y-1]);
			} catch(ArrayIndexOutOfBoundsException err) {
				System.err.println("No item above.");
			}
		}
		//Keyboard down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			int x = -1, y = -1;
			for(int i = 0; i < createPlayer.keyboard.keys.length; i++) {
				for(int j = 0; j < createPlayer.keyboard.keys[0].length; j++) {
					if(createPlayer.keyboard.selectedKey == ((KeyboardKey)createPlayer.keyboard.keys[i][j]) ) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				createPlayer.keyboard.selectedKey = ((KeyboardKey)createPlayer.keyboard.keys[x][y+1]);
			} catch(ArrayIndexOutOfBoundsException err) {
				System.err.println("No item below.");
			}
		}
		//Keyboard left
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			int x = -1, y = -1;
			for(int i = 0; i < createPlayer.keyboard.keys.length; i++) {
				for(int j = 0; j < createPlayer.keyboard.keys[0].length; j++) {
					if(createPlayer.keyboard.selectedKey == ((KeyboardKey)createPlayer.keyboard.keys[i][j]) ) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				createPlayer.keyboard.selectedKey = ((KeyboardKey)createPlayer.keyboard.keys[x-1][y]);
			} catch(ArrayIndexOutOfBoundsException err) {
				System.err.println("No item to the left.");
			}
		}
		//Keyboard right
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			int x = -1, y = -1;
			for(int i = 0; i < createPlayer.keyboard.keys.length; i++) {
				for(int j = 0; j < createPlayer.keyboard.keys[0].length; j++) {
					if(createPlayer.keyboard.selectedKey == ((KeyboardKey)createPlayer.keyboard.keys[i][j]) ) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				createPlayer.keyboard.selectedKey = ((KeyboardKey)createPlayer.keyboard.keys[x+1][y]);
			} catch(ArrayIndexOutOfBoundsException err) {
				System.err.println("No item to the right.");
			}
		}
		//Select
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C) {
			//Done
			if(createPlayer.keyboard.selectedKey.getKeyChar().equals("Done")) {
				createPlayer.transitions.SetTransition(Transition.Fade_Out, 0.0085);
				createPlayer.transitions.BeginTransition();
				
			//Remove a character
			} else if(createPlayer.keyboard.selectedKey.getKeyChar().equals("←")) {
				if(createPlayer.playerName.length() > 1) {
					createPlayer.playerName = createPlayer.playerName.substring(0, createPlayer.playerName.length()-1);
				}
			} else {
				//Handle other key events.
				createPlayer.playerName += createPlayer.keyboard.selectedKey.getKeyChar();
			}

			System.out.print(createPlayer.playerName);
		}
		//Remove character
		if(e.getKeyCode() == KeyEvent.VK_X) {
			if(createPlayer.playerName.length() > 1) {
				createPlayer.playerName = createPlayer.playerName.substring(0, createPlayer.playerName.length()-1);
			}

			System.out.print(createPlayer.playerName);
		}
	}
	
	private void WorldStateActions(KeyEvent e) {

		/* First, make sure that the text box is not open and the player is not interacting */
		if(!TextBox.Open && player.interacting == false) {
			
			//Move right
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(!((WorldState)myGsm.currentState).world.left && !((WorldState)myGsm.currentState).world.up && !((WorldState)myGsm.currentState).world.down) {
					if(((WorldState)myGsm.currentState).world.canMoveRight)
						//worldState.world.right = true;
						((WorldState)myGsm.currentState).world.right = true;
						player.facing = 1;
						player.animationState = 1;
				}
			}
			//Move left
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(!((WorldState)myGsm.currentState).world.right && !((WorldState)myGsm.currentState).world.up && !((WorldState)myGsm.currentState).world.down) {
					if(((WorldState)myGsm.currentState).world.canMoveLeft)
						//worldState.world.left = true;
						((WorldState)myGsm.currentState).world.left = true;
						player.facing = 3;
						player.animationState = 3;
				}
			}
			//Move down
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(!((WorldState)myGsm.currentState).world.left && !((WorldState)myGsm.currentState).world.up && !((WorldState)myGsm.currentState).world.right) {
					if(((WorldState)myGsm.currentState).world.canMoveDown)
						//worldState.world.down = true;
						((WorldState)myGsm.currentState).world.down = true;
						player.facing = 0;
						player.animationState = 0;
				}
			}
			//Move up
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				if(!((WorldState)myGsm.currentState).world.left && !((WorldState)myGsm.currentState).world.right && !((WorldState)myGsm.currentState).world.down) {
					if(((WorldState)myGsm.currentState).world.canMoveUp)
						//worldState.world.up = true;
						((WorldState)myGsm.currentState).world.up = true;
						player.facing = 2;
						player.animationState = 2;
				}
			}
	
			//Interact
			if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {		
				
				/* Looking at tile info. */
				for(Tile[] t : worldState.world.tiles) {
					for(Tile t2 : t) {
						if(t2.isAbove() && player.facing == 0 || t2.isLeft() && player.facing == 1 ||
							t2.isRight() && player.facing == 3 || t2.isBelow() && player.facing == 1) {
							
							if(t2.tileInfo() != null && !t2.tilesWorld.equals("")) {
								System.out.println(t2.tileInfo());
							}
								
						}
					}
				} //End of for-loop
				
				/* Interacting with NPCs. */
				for(Entity ent : worldState.world.entities) {
					if(ent instanceof NPC) {
						if(((NPC)ent).isNextToPlayer()) {
							
							if(!TextBox.Open && !player.interacting) {
								
								if( (((NPC) ent).isAbove() && player.facing == 0) ||//npc is above, player is looking up
									(((NPC) ent).isLeft() && player.facing == 1) ||//npc is left, player is looking left
									(((NPC) ent).isRight() && player.facing == 3) ||//npc is right, player looking right
									(((NPC) ent).isBelow() && player.facing == 2)) {//npc is below, player looking down
										TextBox.Open = true;
										player.interacting = true;
								}
								
							}
							
						}
					}
				} //End of for-loop
			}
		//The text box is open
		} else {
			TextBoxActions(e);
		}
	}
	
	private void MenuActions(KeyEvent e) {
		//Option up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(worldState.hud.menu.selectedOption > 0) {
				worldState.hud.menu.selectedOption--;
			} else {
				worldState.hud.menu.selectedOption = worldState.hud.menu.numChoices() - 1;
			}
		}
		//Option down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(worldState.hud.menu.selectedOption < worldState.hud.menu.numChoices() - 1) {
				worldState.hud.menu.selectedOption++;
			} else {
				worldState.hud.menu.selectedOption = 0;
			}
		}
		
		//Perform action
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			//Fade out, then from another class open up a particular state.
			if(worldState.hud.menu.selectedOption != worldState.hud.menu.maxSelect) {
				
				//Go to inventory
				if(worldState.hud.menu.selectedOption == 0) {
					((InventoryState)myGsm.inventoryState).inventory.Open = true;
					((InventoryState)myGsm.inventoryState).initialize();
					worldState.hud.menu.Open = false;
				}
				if(worldState.hud.menu.selectedOption == 1) {
					
				}
				if(worldState.hud.menu.selectedOption == 2) {
					((StatsState)myGsm.statsState).Open = true;
					((StatsState)myGsm.statsState).initialize();
					worldState.hud.menu.Open = false;
				}
				
				
			} else {
				myGsm.save();
			}
		}
		
		//Close menu
		if(e.getKeyCode() == KeyEvent.VK_X) {
			worldState.hud.menu.Open = false;
		}
	}
	
	private void InventoryActions(KeyEvent e) {
		/* Add a new random item. TEMPORARY */
		if(e.getKeyCode() == KeyEvent.VK_N) {
			ArrayList<Item> items = new ArrayList<Item>();
			items.add(new Item(ItemType.Apple));
			items.add(new Item(ItemType.Fish));
			items.add(new Item(ItemType.Hatchet));
			items.add(new Item(ItemType.Money));
			items.add(new Item(ItemType.Orange));
			
			Random rand = new Random();
			inventoryState.inventory.addItem(items.get(rand.nextInt(5)));
		}
		//Inventory Down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			int x = -1, y = -1;
			for(int i = 0; i < inventoryState.inventory.Width; i++) {
				for(int j = 0; j < inventoryState.inventory.Height; j++) {
					if(inventoryState.inventory.selectedSlot == inventoryState.inventory.slots[i][j]) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				inventoryState.inventory.selectedSlot = inventoryState.inventory.slots[x][y+1];
			} catch (Exception e1) {
				System.err.println("No slot below");
			}
		}
		//Inventory Up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			int x = -1, y = -1;
			for(int i = 0; i < inventoryState.inventory.Width; i++) {
				for(int j = 0; j < inventoryState.inventory.Height; j++) {
					if(inventoryState.inventory.selectedSlot == inventoryState.inventory.slots[i][j]) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				inventoryState.inventory.selectedSlot = inventoryState.inventory.slots[x][y-1];
			} catch (Exception e1) {
				System.err.println("No slot above");
			}
		}
		//Inventory Left
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			int x = -1, y = -1;
			for(int i = 0; i < inventoryState.inventory.Width; i++) {
				for(int j = 0; j < inventoryState.inventory.Height; j++) {
					if(inventoryState.inventory.selectedSlot == inventoryState.inventory.slots[i][j]) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				inventoryState.inventory.selectedSlot = inventoryState.inventory.slots[x-1][y];
			} catch (Exception e1) {
				System.err.println("No slot to the left");
			}
		}
		//Inventory Right
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			int x = -1, y = -1;
			for(int i = 0; i < inventoryState.inventory.Width; i++) {
				for(int j = 0; j < inventoryState.inventory.Height; j++) {
					if(inventoryState.inventory.selectedSlot == inventoryState.inventory.slots[i][j]) {
						x = i; y = j;
						break;
					}
				}
				if(x != -1) break;
			}
			try {
				inventoryState.inventory.selectedSlot = inventoryState.inventory.slots[x+1][y];
			} catch (Exception e1) {
				System.err.println("No slot to the right");
			}
		}
		
		//Start fading out so you can exit the inventory.
		if(e.getKeyCode() == KeyEvent.VK_X) {
			inventoryState.transitions.SetTransition(Transition.Fade_Out, 0.01);
			inventoryState.transitions.BeginTransition();
		}
		
		//Select an item in the inventory
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(inventoryState.inventory.selectedSlot.HasItem()) {
				if(inventoryState.displayOptions == false) {
					inventoryState.displayOptions = true;
				}
			}
		}
	}
	
	private void InventoryOptions(KeyEvent e) {
		//Options up
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(inventoryState.actionBox.selectedOption > 0) {
				inventoryState.actionBox.selectedOption--;
			} else {
				inventoryState.actionBox.selectedOption = inventoryState.actionBox.maxSelect;
			}
		}
		//Options down
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(inventoryState.actionBox.selectedOption < inventoryState.actionBox.maxSelect) {
				inventoryState.actionBox.selectedOption++;
			} else {
				inventoryState.actionBox.selectedOption = 0;
			}
		}
		//Perform option actions
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {
			inventoryState.performAction();
		}
		//Close options
		if(e.getKeyCode() == KeyEvent.VK_X) {
			inventoryState.displayOptions = false;
			inventoryState.actionBox.selectedOption = 0;
		}
	}
	
	private void StatsStateActions(KeyEvent e) {
		//Start fading out so you can exit the inventory. For the stats state you can really only look then exit it.
		if(e.getKeyCode() == KeyEvent.VK_X) {
			statsState.transitions.SetTransition(Transition.Fade_Out, 0.01);
			statsState.transitions.BeginTransition();
		}
	}
	
	private void TextBoxActions(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_ENTER) {
			/* SAVE GAME TEXT BOX */
			if(myGsm.saver.saveSuccessful == true) {
				worldState.hud.menu.Open = false;
				if(saveTB.goToNext()) {
					//Don't need to actually do anything here.
				} else {
					player.interacting = false;
					myGsm.saver.saveSuccessful = false;
				}
			}
				
				
			/* NPC TEXT BOX */
			for(Entity ent : worldState.world.entities) {
				if(ent instanceof NPC) {
					if(((NPC)ent).isNextToPlayer()) {
						if(((NPC) ent).textBox.goToNext()) {
							//Don't do anything.
						} else {
							player.interacting = false;
						}
					}
				}
			}
			
		} //End of key input
		
		
		
	}
	
	
	
	



	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}