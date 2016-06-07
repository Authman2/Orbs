package MISC;

import java.awt.image.BufferedImage;

import ENTITIES.Entity;
import visualje.Vector2D;

public abstract class Item extends Entity {
	
	//The item quantity. Initially set to 1.
	int quantity = 1;
	
	//The name of the item.
	String name;
	
	//The text box for when the player acquires an item.
	TextBox acquiredTextBox;
	
	//The text to display when the player acquires the item.
	String acquiredMessage;
	

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
	
	
	/** Sets the message to display for when the player acquires this item. */
	public void setAcquiredMessage(String message) { acquiredMessage = message; acquiredTextBox.addText(acquiredMessage); }
	
	
	
	///////////// Getters //////////////
	
	/** Returns the quantity of this item. */
	public int getQuantity() { return quantity; }
	
	
	/** Returns the name of this item. */
	public String getName() { return name; }
	
	
	/** Returns the text box that tells the player that he/she has acquired a new item. */
	public TextBox getTextBox() { return acquiredTextBox; }
}
