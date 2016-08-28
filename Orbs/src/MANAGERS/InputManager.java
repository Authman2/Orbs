package MANAGERS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.Person;
import ENTITIES.SearchableEntity;
import ITEMS.Coin;
import ITEMS.Item;
import ITEMS.Orb;
import MISC.Door;
import MISC.TextBox;
import STATES.ControlsState;
import STATES.GameFinishState;
import STATES.MenuState;
import STATES.WorldState;

public class InputManager implements KeyListener {

	//The game states
	public MenuState menuState;
	public WorldState worldState;
	public GameFinishState gameFinishState;
	public ControlsState controlsState;
	
	//The game state manager
	public GameStateManager gsm;
	

	
	///////////// Constructor //////////////
	
	public InputManager(GameStateManager gsm) {
		this.gsm = gsm;
	}

	
	
	////////////// Key Functions ///////////////

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(gsm.currentState == menuState) {
			
			MenuStateActions(e);
			
		}
		
		if(gsm.currentState == worldState) {
			
			WorldStateActions(e);
			
		}
		
		if(gsm.currentState == gameFinishState) {
			
			if(gameFinishState.timer <= 0) {
				GameFinishStateActions(e);
			}
		}
		
		if(gsm.currentState == controlsState) {
			
			ControlStateActions(e);
			
		}
	}
	
	
	/** Navigating the main menu. */
	private void MenuStateActions(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(menuState.selectedOption > 0) {
				menuState.selectedOption--;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(menuState.selectedOption < 2) {
				menuState.selectedOption++;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C) {
			if(menuState.selectedOption == 0) {
				gsm.currentState = gsm.gameStates[1];
			}
			if(menuState.selectedOption == 1) {
				gsm.currentState = gsm.gameStates[3];
			}
			if(menuState.selectedOption == 2) {
				System.exit(0);
			}
		}
	}
	
	/** Navigating the game finish scene. */
	private void GameFinishStateActions(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			gameFinishState.selectedOption = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			gameFinishState.selectedOption = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C) {
			if(gameFinishState.selectedOption == 0) {
				gsm.resetGame();
			}
			if(gameFinishState.selectedOption == 1) {
				gsm.currentState = gsm.gameStates[0];
			}
		}
	}
	
	/** Controls state actions. */
	public void ControlStateActions(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
			gsm.currentState = gsm.gameStates[0];
		}
		
	}
	
	/** Moving about the game world. */
	private void WorldStateActions(KeyEvent e) {
		
		//Check if there is a text box open. The player cannot move if they are already interacting with someone/something.
		if(!worldState.textBoxesOpen()) {
			/* MOVING THE MAP*/
			mapMovement(e);
		}
		
		
		/* FORCE EXIT TEXT BOX */
		//Used to force quit any text boxes. This is temporary and only used or debugging.
		if(e.getKeyCode() == KeyEvent.VK_T) {
			for(TextBox t : worldState.getTextBoxes()) {
				t.setOpen(false);
			}
		}
		
		//Print out all of the id's of the orbs.
		if(e.getKeyCode() == KeyEvent.VK_U) {
			for(Orb orb : worldState.getPlayer().getOrbs()) {
				System.out.println(orb.getID());
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_O) {
			for(Coin orb : worldState.getPlayer().getCoins()) {
				System.out.println(orb.getID());
			}
		}
		
		
		/* INTERACTION */
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C)
			PlayerInteractions(e);
		
		if(worldState.textBoxesOpen() && e.getKeyCode() == KeyEvent.VK_X)
			PlayerInteractions(e);
		
		//Action box options
		for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) {
			
			if(ae.getActionBox().isOpen() && e.getKeyCode() == KeyEvent.VK_DOWN) {
				ae.getActionBox().setCurrentOption(1);
			}
			
			if(ae.getActionBox().isOpen() && e.getKeyCode() == KeyEvent.VK_UP) {
				ae.getActionBox().setCurrentOption(0);
			}
			
		}
		
		/* LOOKING THROUGH ITEMS */
		if(e.getKeyCode() == KeyEvent.VK_I)
			Inventory(e);
		
	}
	
	
	/** Handles all of the movement of the map based on arrow key clicks. */
	public void mapMovement(KeyEvent e) {
		/* MOVING THE GAME MAP */
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			worldState.getPlayer().setDirection(2);
					
			if(worldState.getCurrentWorld().canMoveUp()) {
				
				worldState.getCurrentWorld().position.Y++;
				for(Entity ent : worldState.getCurrentWorld().getEntities()) ent.position.Y++;
				for(Item itm : worldState.getCurrentWorld().getDroppedItems()) itm.position.Y++;
				for(SearchableEntity tree : worldState.getCurrentWorld().getSearchables()) tree.position.Y++;
				for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) ae.position.Y++;
				for(Door door : worldState.getCurrentWorld().getDoors()) door.position.Y++;
				worldState.getCurrentWorld().up = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			worldState.getPlayer().setDirection(0);
			
			if(worldState.getCurrentWorld().canMoveDown()) {
				worldState.getCurrentWorld().position.Y--; 
				for(Entity ent : worldState.getCurrentWorld().getEntities()) ent.position.Y--;
				for(Item itm : worldState.getCurrentWorld().getDroppedItems()) itm.position.Y--;
				for(SearchableEntity tree : worldState.getCurrentWorld().getSearchables()) tree.position.Y--;
				for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) ae.position.Y--;
				for(Door door : worldState.getCurrentWorld().getDoors()) door.position.Y--;
				worldState.getCurrentWorld().down = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			worldState.getPlayer().setDirection(1);
			
			if(worldState.getCurrentWorld().canMoveRight()) {
				worldState.getCurrentWorld().position.X--; 
				for(Entity ent : worldState.getCurrentWorld().getEntities()) ent.position.X--;
				for(Item itm : worldState.getCurrentWorld().getDroppedItems()) itm.position.X--;
				for(SearchableEntity tree : worldState.getCurrentWorld().getSearchables()) tree.position.X--;
				for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) ae.position.X--;
				for(Door door : worldState.getCurrentWorld().getDoors()) door.position.X--;
				worldState.getCurrentWorld().right = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			worldState.getPlayer().setDirection(3);
			
			if(worldState.getCurrentWorld().canMoveLeft()) {						
				worldState.getCurrentWorld().position.X++; 
				for(Entity ent : worldState.getCurrentWorld().getEntities()) ent.position.X++;
				for(Item itm : worldState.getCurrentWorld().getDroppedItems()) itm.position.X++;
				for(SearchableEntity tree : worldState.getCurrentWorld().getSearchables()) tree.position.X++;
				for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) ae.position.X++;
				for(Door door : worldState.getCurrentWorld().getDoors()) door.position.X++;
				worldState.getCurrentWorld().left = true;
			}
		}
		
	
	}
	
	
	/** Interacting with entities and items in the game world. */
	private void PlayerInteractions(KeyEvent e) {

		/* ENTITIES */
		entities();
		

		/* ITEMS */
		items();
		
		
		/* SEARCHABLE ENTITIES */
		searchableEntities();
		
		
		/* ACTION ENTITIES */
		actionEntities();
		
	}
	
	
	/** Handling all of the inventory stuff. */
	private void Inventory(KeyEvent e) {
		
		if(!worldState.textBoxesOpen())
			worldState.getInventoryTextBox().toggle();
		else 
			if(worldState.getInventoryTextBox().isOpen()) 
				worldState.getInventoryTextBox().nextSlide();
	}
	
	
	/** Deals with interacting with entities that happen to be NPCs. */
	public void entities() {
		
		for(Entity ent : worldState.getCurrentWorld().getEntities()) {
			
			// Cast it to a person object, since that is most likely what this method is looking for.
			Person person = (Person)ent;
			
			// Next to player
			if(person.isNextTo(worldState.getPlayer())) {
				
				// Text box is open
				if(person.getTextBox().isOpen()) {
					
					person.getTextBox().nextSlide();
					
					
					// If you're on the last slide, check for item giving.
					if(person.getTextBox().onLast()) {
						
						if(person == worldState.getCurrentWorld().getNPCManager().scientist) {
							if(worldState.getPlayer().getQuantity("Orb") >= 10) {
								gsm.currentState = gameFinishState;
							}
						}
						
						// If the person will take an item
						if(person.getItemToTake() != null) {
							
							// If the player has the item that the npc wants to take (by ID or name).
							if(worldState.getPlayer().containsID(person.getItemToTake()) 
								|| worldState.getPlayer().inventoryContains(person.getItemToTake())) {
								
								worldState.getPlayer().removeFromInventory(person.getItemToTake());
								worldState.updatePlayersItems();
								((Person)ent).removeItemToTake();
								
							}
							
						}
						
						// If the person is supposed to give an item
						if(person.getItemToGive() != null) {
							
							// If you don't have an item with that name or you don't have that id, add it.
							if(!worldState.getPlayer().containsID(person.getItemToGive().getID())) {
								
								worldState.getPlayer().addItemToInventory(person.getItemToGive());
								worldState.updatePlayersItems();
								person.removeItemToGive();
								
							}
						}
					}
					
				// Text box is closed	
				} else {
					
					person.getTextBox().toggle();
					worldState.getCurrentWorld().getNPCManager().loadNPCText();
					
				}
				
			}
		}
		
	}

	
	/** Deals with interacting with searchable entities like certain tries and paintings. */
	public void searchableEntities() {
		//Loop through all of the searchable entities in the game world.
		for(SearchableEntity se : worldState.getCurrentWorld().getSearchables()) {
			
			//If an S.E is next to the player
			if(se.isNextTo(worldState.getPlayer())) {
				
				//If no other text boxes are opened, then open one up.
				if(!worldState.textBoxesOpen()) {
					
					//Change the text of the S.E interaction based on whether or not it has an item in it.
					if(se.getContainedItem() == null || worldState.getPlayer().hasOrb(se.getContainedItem().getID()) || worldState.getPlayer().hasCoin(se.getContainedItem().getID())) {
						se.getTextBox().clear();
						se.getTextBox().addText("There are no items in this " + se.getName() + ". ");
					} else {
						se.getTextBox().clear();
						se.getTextBox().addText("You search the " + se.getName() + " and find a(n) " + se.getContainedItem().getName() + "! ");
					}
					
					//Toggle the text box
					se.getTextBox().toggle();
					
				} else {
					
					//Close the text box
					se.getTextBox().nextSlide();
					
					//If there was an item in the S.E, add it to the player's inventory.
				if(se.getContainedItem() != null && !worldState.getPlayer().hasOrb(se.getContainedItem().getID()) && !worldState.getPlayer().hasCoin(se.getContainedItem().getID())) {
						worldState.getPlayer().addItemToInventory(se.getContainedItem());
						worldState.updatePlayersItems();
						
						se.removeContainedItem();
					}
					
				}
				
			}
		}
	}
	
	
	/** Deals with interacting with action entities. */
	public void actionEntities() {
		//Loop through all of the action entities
		for(ActionEntity ae : worldState.getCurrentWorld().getActionEntities()) {
			
			//The action entity is next to the player
			if(ae.isNextTo(worldState.getPlayer())) {
				
				//There are no text boxes open already
				if(!worldState.textBoxesOpen()) {
					
					//Open a text and action box
					ae.getTextBox().toggle();
					ae.getActionBox().toggle();
					
				} else {
					
					//The player is not currently being told that he/she does not have the appropraite item
					if(ae.getTextBox().getTextSlides().size() <= 1) {
						
						//The tree
						if(ae.getName().equals("tree_3")) {
							
							//The "Yes" option
							if(ae.getActionBox().getCurrentOption() == 0) {
								
								//If the player has the item, then get rid of the A.E.
								if(worldState.getPlayer().inventoryContains("Hatchet")) {
									worldState.getCurrentWorld().getActionEntities().remove(ae);
									break;
								} else {
									ae.getActionBox().setOpen(false);
									ae.getTextBox().addText("You do not have the proper item to perform this task. ");
									ae.getTextBox().nextSlide();
								}
								
							//The "No" option	
							} else {
								
								ae.getActionBox().setOpen(false);
								ae.getActionBox().setCurrentOption(0);
								ae.getTextBox().setOpen(false);
								
							}
						}
						
						//The rock
						if(ae.getName().equals("rock")) {
							
							//The "Yes" option
							if(ae.getActionBox().getCurrentOption() == 0) {
							
								//If the player has the item, then get rid of the A.E.
								if(worldState.getPlayer().inventoryContains("Pickaxe")) {
									worldState.getCurrentWorld().getActionEntities().remove(ae);
									break;
								} else {
									ae.getActionBox().setOpen(false);
									ae.getTextBox().addText("You do not have the proper item to perform this task. ");
									ae.getTextBox().nextSlide();
								}
								
							//The "No" option	
							} else {
								
								ae.getActionBox().setOpen(false);
								ae.getActionBox().setCurrentOption(0);
								ae.getTextBox().setOpen(false);
								
							}
							
						}
						
					//The player IS currently being told that he/she does not have the appropriate item.
					} else {
						
						ae.getTextBox().setOpen(false);
						ae.getTextBox().setCurrentSlide(0);
						ae.getTextBox().removeLast();
						
					}
					
				}
				
			}
			
		}
	}
	
	
	/** Deals with interacting with items that are just on the ground. */
	public void items() {
		//Check if the player is trying to interact with an item on the ground
		for(Item itm : worldState.getCurrentWorld().getDroppedItems()) {
			
			//If an item's text box is not already open
			if(!itm.getTextBox().isOpen()) {
				
				//If you are next to a dropped item and try to interact with it, pick it up and display the acquired message.
				if(itm.isNextTo(worldState.getPlayer())) {
					
					if(!itm.isSpecial() || (itm.isSpecial() && worldState.getPlayer().inventoryContains(itm.getRequiredItem())) ) {
						itm.getTextBox().toggle();						//Open a text box to tell the user what he/she got
						worldState.getPlayer().addItemToInventory(itm);		//Add that item to the user's list of items
						worldState.updatePlayersItems();				//Update which items the player has
					}
					if(itm.isSpecial() && !worldState.getPlayer().inventoryContains(itm.getRequiredItem()) ){
						itm.getTextBox().clear();
						itm.getTextBox().addText("You need a " + itm.getRequiredItem() + " to acquire this item. ");
						itm.getTextBox().toggle();
					}
					
					//If the item was an orb and a first orb has not been collected already...
					if(itm instanceof Orb) {
						worldState.getCurrentWorld().getNPCManager().loadNPCText();
					}
					
				}
			//If there is an item's text box open, then just close it and remove the item from the game world's floor
			} else {
				if(!itm.isSpecial() || (itm.isSpecial() && worldState.getPlayer().inventoryContains(itm.getRequiredItem())) ) {
					itm.getTextBox().toggle();
					worldState.getCurrentWorld().getDroppedItems().remove(itm);
				} else {
					itm.getTextBox().nextSlide();
				}
				
				break;
				
			}
		}
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		//Stop moving in all directions if the keys are not being held down.
		
		if(worldState.getCurrentWorld() != null) {
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) worldState.getCurrentWorld().up = false;
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) worldState.getCurrentWorld().down = false;
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) worldState.getCurrentWorld().right = false;
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) worldState.getCurrentWorld().left = false;
		}
	}
}