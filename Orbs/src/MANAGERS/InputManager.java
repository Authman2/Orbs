package MANAGERS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ENTITIES.ActionEntity;
import ENTITIES.Entity;
import ENTITIES.NPC;
import ENTITIES.Person;
import ENTITIES.SearchableEntity;
import ITEMS.Item;
import ITEMS.Orb;
import MISC.Door;
import STATES.MenuState;
import STATES.WorldState;

public class InputManager implements KeyListener {

	//The game states
	public MenuState menuState;
	public WorldState worldState;
	
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
	}
	
	
	/** Navigating the main menu. */
	private void MenuStateActions(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			menuState.selectedOption = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			menuState.selectedOption = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(menuState.selectedOption == 0) {
				gsm.currentState = gsm.gameStates[1];
			}
			if(menuState.selectedOption == 1) {
				System.exit(0);
			}
		}
	}
	
	
	/** Moving about the game world. */
	private void WorldStateActions(KeyEvent e) {
		
		
		
		//Check if there is a text box open. The player cannot move if they are already interacting with someone/something.
		if(!worldState.textBoxesOpen()) {
			/* MOVING THE MAP*/
			mapMovement(e);
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
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
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
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
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
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
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
	
	
	/** Edits the speech of the scientist based on whether or not the player has already collected an orb. */
	private void editScientistSpeech(Item itm) {
		if(worldState.getPlayer().inventoryContains("Orb")) {
			Orb.setFirstCollected();
		}

		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().clear();
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("Oh, hello! So you've found some of my orbs?");
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("That's wonderful!");
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("Let's see how many you've found...");
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("Hmm... Well it looks like you have found " + worldState.getPlayer().getOrbCount() + " out of 20 orbs.");
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("That's good! But there are still more to find.");
		worldState.getCurrentWorld().getNPCManager().scientist.getTextBox().addText("Please keep on looking and return to me when you have more orbs! Good luck!");
	}
	
	
	/** Deals with interacting with entities that happen to be NPCs. */
	public void entities() {
		//First check if there is already a text box open
		for(Entity ent : worldState.getCurrentWorld().getEntities()) {
			
			if(ent instanceof NPC && !(ent instanceof SearchableEntity)) {
				
				//If a text box IS open, then just go through each slide as you normally would.
				if( ((NPC) ent).getTextBox().isOpen() ) {
					
					((NPC) ent).getTextBox().nextSlide();
					
					
					//If it is a person and they have an item, give it to the player.
					if(((Person)ent).getItemToGive() != null) {
						
						//Only add the item if you are on the last text slide.
						if(((Person)ent).getTextBox().onLast()) {
							worldState.getPlayer().addItemToInventory(((Person)ent).getItemToGive());
							worldState.updatePlayersItems();
							((Person)ent).removeItemToGive();
						}
						
					} else {
						
						if(((Person)ent).willGiveItem()) {
							//Re-assign the text boxes of each NPC
							worldState.getCurrentWorld().getNPCManager().clearTextBoxes();
							try { worldState.getCurrentWorld().getNPCManager().loadNPCText(); } catch(Exception err) { err.printStackTrace(); }
							//worldState.getCurrentWorld().getNPCManager().initialize();
						}
					}
					
				} else {
					
					//If a text box was not already open, then open one up.
					if(((NPC) ent).isNextTo(worldState.getPlayer())) {
						
						((NPC) ent).getTextBox().toggle();
						
						//Change the direction of the NPC
						if(worldState.getPlayer().getDirection() == 0)
							((NPC)ent).setDirection(2);
						else if(worldState.getPlayer().getDirection() == 1)
							((NPC)ent).setDirection(3);
						else if(worldState.getPlayer().getDirection() == 2)
							((NPC)ent).setDirection(0);
						else if(worldState.getPlayer().getDirection() == 3)
							((NPC)ent).setDirection(1);
						
					}
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
					if(se.getContainedItem() == null || worldState.getPlayer().containsID(se.getContainedItem().getID())) {
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
					if(se.getContainedItem() != null && !worldState.getPlayer().containsID(se.getContainedItem().getID())) {
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
						editScientistSpeech(itm);
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
			if(e.getKeyCode() == KeyEvent.VK_UP) worldState.getCurrentWorld().up = false;
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN) worldState.getCurrentWorld().down = false;
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) worldState.getCurrentWorld().right = false;
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT) worldState.getCurrentWorld().left = false;
		}
	}
}
