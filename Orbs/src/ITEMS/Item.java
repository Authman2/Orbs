package ITEMS;

import java.awt.image.BufferedImage;

import ENTITIES.Entity;
import MISC.TextBox;
import visualje.Vector2D;

public abstract class Item extends Entity {
	
	//The item quantity. Initially set to 1.
	int quantity = 1;
	
	//The name of the item.
	String name;
	
	//A specific ID used to keep track of individual items.
	String identifier;
	
	//The text box for when the player acquires an item.
	TextBox acquiredTextBox;
	
	//The text to display when the player acquires the item.
	String acquiredMessage;
	
	//Whether or not the player requires a special item to acquire this orb
	boolean special;
	
	//The item required to get this orb (optional)
	String requiredItm;
	
	

	//////////// Constructors //////////////
	
	public Item() { acquiredTextBox = new TextBox(); }
	public Item(Vector2D pos) { super(pos); acquiredTextBox = new TextBox(); }
	public Item(BufferedImage bi) { super(bi); acquiredTextBox = new TextBox(); }
	public Item(int quantity) { this.quantity = quantity; acquiredTextBox = new TextBox(); }
	public Item(String name) { this.name = name; acquiredTextBox = new TextBox(); }
	
	
	///////////// Setters //////////////
	
	/** Sets the quantity of this item to the value of "i". */
	public void setQuantity(int i) { quantity = i; }
	
	
	/** Sets the name of this item. */
	public void setName(String name) { this.name = name; }
	
	
	/** Sets the ID of this item. */
	public void setID(String id) { identifier = id; }
	
	
	/** Sets the message to display for when the player acquires this item. */
	public void setAcquiredMessage(String message) { acquiredMessage = message; acquiredTextBox.addText(acquiredMessage); }
	
	
	/** Sets whether or not this item is special and what item the player is required to have in order to get this item. */
	public void setSpecial(boolean b, String required) {
		special = b;
		requiredItm = required;
	}
	
	
	///////////// Getters //////////////
	
	/** ToString method. */
	public String toString() { return name; }
	
	
	/** Returns the quantity of this item. */
	public int getQuantity() { return quantity; }
	
	
	/** Returns the name of this item. */
	public String getName() { return name; }
	
	
	/** Returns the ID of this item. */
	public String getID() { return identifier; }
	
	
	/** Returns the text box that tells the player that he/she has acquired a new item. */
	public TextBox getTextBox() { return acquiredTextBox; }
	
	
	/** Returns the name of the required item to acquire this item. */
	public String getRequiredItem() { return requiredItm; }
	
	
	/** Returns whether or not this item requires the player to have another item to acquire it. */
	public boolean isSpecial() { return special; }
}
