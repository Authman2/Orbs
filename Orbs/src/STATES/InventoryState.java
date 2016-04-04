package STATES;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import myproject.gos.main.TransitionManager.Transition;
import myproject.gos.main.Vector2D;
import INVENTORY.Inventory;
import INVENTORY.InventorySlot;
import MANAGERS.GameStateManager;
import MISC.OptionBox;
import MISC.TextBox;

public class InventoryState extends GameState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8335748689224611692L;

	//The inventory to gather information from.
	public Inventory inventory;
	
	//What the options and information are displayed on.
	public TextBox infoBox;
	public OptionBox actionBox;
	
	
	//Boolean for whether or not to display the options.
	public transient boolean displayOptions;	
	
	
	public InventoryState(GameStateManager gsm) {
		super(gsm);
	
		
		inventory = new Inventory(new Vector2D(0,0), 8, 8, this);
		actionBox = new OptionBox(new Vector2D(400,5), 200, 300);
		infoBox = new TextBox();
		
		initialize();
	}

	@Override
	public void initialize() {
		//Set the initial transition.
		transitions.SetTransition(Transition.Fade_In, 0.01);
		transitions.BeginTransition();
		
		
		
		inventory.initialize();
		
		actionBox.initialize();
	}

	@Override
	public void update(double time) {
		actionBox.update(time);
		
		if(transitions.transitionSet()) { transitions.update(time); }
		
		//Update the inventory.
		if(inventory.isOpen())
			inventory.update(time);
		
		//If the fading out transition is done, just go back to the world state.
		if(transitions.getTransition() == Transition.Fade_Out && transitions.Finished()) {
			((InventoryState)gsm.inventoryState).inventory.Open = false;
			((WorldState)gsm.states[2]).initialize();
		}
	}

	@Override
	public void draw(Graphics2D g) {
		//A dark gray background
		g.setColor(new Color(80,80,80));
		g.fillRect(0, 0, 640, 470);
		
		if(inventory != null) inventory.draw(g);
		
		//Draw the item info.
		if(inventory != null) {
			
			if(inventory.selectedSlot.HasItem()) {
				
				infoBox.removeAllSpeech();
				infoBox.addText(inventory.selectedSlot.getItem().toString());								

				if(displayOptions == true) {
					actionBox.addHeader(inventory.selectedSlot.getItem().itemName());
					actionBox.setChoices(inventory.selectedSlot.getItem().getOptions());
					actionBox.showChoices = true;
				}				
			} else {
				infoBox.removeAllSpeech();
			}
			
			//Don't draw the option box options if you are not supposed to display them.
			if(displayOptions == false) {
				//Set it back to 1 each time you close the options.
				actionBox.selectedOption = 0;
				actionBox.showChoices = false;
			}
		}
		
		//Draw the inventory
		if(inventory.isOpen())
			inventory.draw(g);
		
		//Draw the action and info boxes.
		actionBox.draw(g);
		infoBox.draw(g);
		
		
		if(transitions.transitionSet()) { transitions.draw(g); }
	}
	
	
	/** Performs a particular action. */
	public void performAction() {
		//Loop through the options
		for(int i = 0; i < inventory.selectedSlot.getItem().getOptions().length; i++) {
			//If the selected option is one of the options
			if(actionBox.selectedOption == i) {
				//Perform the action on that item.
				inventory.selectedSlot.getItem().getOptions()[i].performAction(this);
				break;
			}
		}
	}
	
	
	
}
