package MISC;

import java.io.Serializable;

import STATES.InventoryState;

/** A class that handles all of the options for a particular item. In the item class, there will be a list of options. */
public class Option implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7399381347524013554L;
	private OptionType type;
	private String optionName;
	
	public Option(String name, OptionType t) {
		optionName = name;
		type = t;
	}
	public String Name() {
		return optionName;
	}
	public OptionType Type() {
		return type;
	}
	
	
	public void performAction(InventoryState invstate) {
		if(type == OptionType.Use) {
			System.out.println("Using!");
			
		} else if(type == OptionType.Eat) {
			float healamount = invstate.inventory.selectedSlot.getItem().HealValue();
			
			invstate.inventory.player.getStats().addHealth(healamount);
			invstate.inventory.selectedSlot.removeItem();
			invstate.displayOptions = false;
			
		} else if(type == OptionType.Drop) {
			
			invstate.inventory.selectedSlot.removeItem();
			invstate.displayOptions = false;
			
		//Cancel
		} else {
			invstate.displayOptions = false;
		}
		
	}
	
	
	
	public enum OptionType {
		Use, Drop, Eat, Cancel, Inventory, Equipment, Save, Stats;
	}
}
