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
import STATES.MenuState;
import STATES.WorldState;

public class InputManager implements KeyListener {

	//The game states
	public MenuState menuState;
	public WorldState worldState;
	
	//The game state manager
	public GameStateManager gsm;
	

	
	public InputManager(GameStateManager gsm) {
		this.gsm = gsm;
	}


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
			
			/* MOVING THE GAME MAP */
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				worldState.getPlayer().setDirection(2);
				
				if(worldState.getWorld().canMoveUp()) {
					
					worldState.getWorld().position.Y++;
					for(Entity ent : worldState.getWorld().getEntities()) ent.position.Y++;
					for(Item itm : worldState.getWorld().getDroppedItems()) itm.position.Y++;
					for(SearchableEntity tree : worldState.getWorld().getSearchables()) tree.position.Y++;
					for(ActionEntity ae : worldState.getWorld().getActionEntities()) ae.position.Y++;
					worldState.getWorld().up = true;
					
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				worldState.getPlayer().setDirection(0);
				
				if(worldState.getWorld().canMoveDown()) {
					
					worldState.getWorld().position.Y--; 
					for(Entity ent : worldState.getWorld().getEntities()) ent.position.Y--;
					for(Item itm : worldState.getWorld().getDroppedItems()) itm.position.Y--;
					for(SearchableEntity tree : worldState.getWorld().getSearchables()) tree.position.Y--;
					for(ActionEntity ae : worldState.getWorld().getActionEntities()) ae.position.Y--;
					worldState.getWorld().down = true;
					
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				worldState.getPlayer().setDirection(1);
				
				if(worldState.getWorld().canMoveRight()) {
					
					worldState.getWorld().position.X--; 
					for(Entity ent : worldState.getWorld().getEntities()) ent.position.X--;
					for(Item itm : worldState.getWorld().getDroppedItems()) itm.position.X--;
					for(SearchableEntity tree : worldState.getWorld().getSearchables()) tree.position.X--;
					for(ActionEntity ae : worldState.getWorld().getActionEntities()) ae.position.X--;
					worldState.getWorld().right = true;
					
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				worldState.getPlayer().setDirection(3);
				
				if(worldState.getWorld().canMoveLeft()) {
					
					worldState.getWorld().position.X++; 
					for(Entity ent : worldState.getWorld().getEntities()) ent.position.X++;
					for(Item itm : worldState.getWorld().getDroppedItems()) itm.position.X++;
					for(SearchableEntity tree : worldState.getWorld().getSearchables()) tree.position.X++;
					for(ActionEntity ae : worldState.getWorld().getActionEntities()) ae.position.X++;
					worldState.getWorld().left = true;
				}
				
			}
			
		}
		
		
		/* INTERACTION */
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C)
			PlayerInteractions(e);
		
		if(worldState.textBoxesOpen() && e.getKeyCode() == KeyEvent.VK_X)
			PlayerInteractions(e);
		
		//Action box options
		for(ActionEntity ae : worldState.getWorld().getActionEntities()) {
			
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
		if(!Orb.pickedUpFirstOrb) {
			Orb.setFirstCollected();
		}

		worldState.getNPCManager().scientist.getTextBox().clear();
		worldState.getNPCManager().scientist.getTextBox().addText("Oh, hello! So you've found some of my orbs?");
		worldState.getNPCManager().scientist.getTextBox().addText("That's wonderful!");
		worldState.getNPCManager().scientist.getTextBox().addText("Let's see how many you've found...");
		worldState.getNPCManager().scientist.getTextBox().addText("Hmm... Well it looks like you have found " + worldState.getPlayer().getOrbCount() + " out of 20 orbs.");
		worldState.getNPCManager().scientist.getTextBox().addText("That's good! But there are still more to find.");
		worldState.getNPCManager().scientist.getTextBox().addText("Please keep on looking and return to me when you have more orbs! Good luck!");
	}
	
	
	/** Deals with interacting with entities. */
	public void entities() {
		//First check if there is already a text box open
		for(Entity ent : worldState.getWorld().getEntities()) {
			
			if(ent instanceof NPC && !(ent instanceof SearchableEntity)) {
				//If a text box IS open, then just go through each slide as you normally would.
				if( ((NPC) ent).getTextBox().isOpen() ) {
					
					((NPC) ent).getTextBox().nextSlide();
					
					//If  it is a person and they have an item, give it to the player.
					if(((Person)ent).getItemToGive() != null) {
						worldState.getPlayer().addItemToInventory(((Person)ent).getItemToGive());
						worldState.updatePlayersItems();
						((Person)ent).removeItemToGive();
					}
					
				} else {
					
					//If a text box was not already open, then open one up.
					if(((NPC) ent).isNextTo(worldState.getPlayer())) {
						
						((NPC) ent).getTextBox().toggle();
						
					}
				}
			}
		}
	}

	
	/** Deals with interacting with searchable entities like certain tries and paintings. */
	public void searchableEntities() {
		//Loop through all of the searchable entities in the game world.
		for(SearchableEntity se : worldState.getWorld().getSearchables()) {
			
			//If an S.E is next to the player
			if(se.isNextTo(worldState.getPlayer())) {
				
				//If no other text boxes are opened, then open one up.
				if(!worldState.textBoxesOpen()) {
					
					//Change the text of the S.E interaction based on whether or not it has an item in it.
					if(se.getContainedItem() == null) {
						se.getTextBox().clear();
						se.getTextBox().addText("There are no items in this " + se.getName() + ".");
					} else {
						se.getTextBox().clear();
						se.getTextBox().addText("You search the " + se.getName() + " and find a(n) " + se.getContainedItem().getName() + "!");
					}
					
					//Toggle the text box
					se.getTextBox().toggle();
					
				} else {
					
					//Close the text box
					se.getTextBox().nextSlide();
					
					//If there was an item in the S.E, add it to the player's inventory.
					if(se.getContainedItem() != null) {
						worldState.getPlayer().addItemToInventory(se.getContainedItem());
						worldState.updatePlayersItems();
						
						//If the item was an orb and a first orb has not been collected already...
						if(se.getContainedItem() instanceof Orb) {
							editScientistSpeech(se.getContainedItem());
						}
						
						se.removeContainedItem();
						
					}
					
				}
				
			}
		}
	}
	
	
	/** Deals with interacting with action entities. */
	public void actionEntities() {
		//Loop through all of the action entities
		for(ActionEntity ae : worldState.getWorld().getActionEntities()) {
			
			//The action entity is next to the player
			if(ae.isNextTo(worldState.getPlayer())) {
				
				//There are no text boxes open already
				if(!worldState.textBoxesOpen()) {
					
					ae.getTextBox().toggle();
					ae.getActionBox().toggle();
					
				} else {
					
					//The "Yes" option
					if(ae.getActionBox().getCurrentOption() == 0) {
						
						//If the player has the required item...
						if(worldState.getPlayer().inventoryContains("Hatchet") && ae.getName().equals("tree_3")) {
							worldState.getWorld().getActionEntities().remove(ae);
						} else {
							//If not, add an extra slide to the text box
							if(ae.getTextBox().getTextSlides().size() <= 1) {
								ae.getActionBox().setOpen(false);
								ae.getTextBox().addText("You do not have the proper item to perform this task.");
								ae.getTextBox().nextSlide();
							} else {
								ae.getActionBox().setOpen(false);
								ae.getTextBox().toggle();
							}
							break;
						}
						
						if(worldState.getPlayer().inventoryContains("Pickaxe") && ae.getName().equals("rock")) {
							worldState.getWorld().getActionEntities().remove(ae);
						} else {
							//If not, add an extra slide to the text box
							if(ae.getTextBox().getTextSlides().size() <= 1) {
								ae.getActionBox().setOpen(false);
								ae.getTextBox().addText("You do not have the proper item to perform this task.");
								ae.getTextBox().nextSlide();
							} else {
								ae.getActionBox().setOpen(false);
								ae.getTextBox().toggle();
							}
							break;
						}
					}
					
					//The "No" option
					if(ae.getActionBox().getCurrentOption() == 1) {
						ae.getActionBox().toggle();
						ae.getTextBox().toggle();
					}
					
					break;
				}
				
			}
			
		}
	}
	
	
	/** Deals with interacting with items that are just on the ground. */
	public void items() {
		//Check if the player is trying to interact with an item on the ground
		for(Item itm : worldState.getWorld().getDroppedItems()) {
			
			//If an item's text box is not already open
			if(!itm.getTextBox().isOpen()) {
				
				//If you are next to a dropped item and try to interact with it, pick it up and display the acquired message.
				if(itm.isNextTo(worldState.getPlayer())) {
					
					itm.getTextBox().toggle();						//Open a text box to tell the user what he/she got
					worldState.getPlayer().addItemToInventory(itm);		//Add that item to the user's list of items
					worldState.updatePlayersItems();				//Update which items the player has
					
					
					//If the item was an orb and a first orb has not been collected already...
					if(itm instanceof Orb) {
						editScientistSpeech(itm);
					}
					
				}
			//If there is an item's text box open, then just close it and remove the item from the game world's floor
			} else {
				
				itm.getTextBox().toggle();
				worldState.getWorld().getDroppedItems().remove(itm);
				break;
				
			}
		}
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		//Stop moving in all directions if the keys are not being held down.
		
		if(e.getKeyCode() == KeyEvent.VK_UP) worldState.getWorld().up = false;
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) worldState.getWorld().down = false;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) worldState.getWorld().right = false;
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) worldState.getWorld().left = false;
	}
}
