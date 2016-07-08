package ENTITIES;

import java.awt.image.BufferedImage;

import ITEMS.Item;
import visualje.Vector2D;

public class Person extends NPC {

	//The item that this person will give the player.
	Item itemToGive;
	
	
	
	/////////// Constructors ////////////
	public Person() {}

	public Person(Vector2D pos) { super(pos); }

	public Person(BufferedImage sprite) { super(sprite); }
	
	
	
	/////////// Setters ////////////
	
	/** Set the item that this person should give the player. */
	public void setItemToGive(Item itm) { itemToGive = itm; }
	
	
	/** Takes the item away from this person so that they do not accidently give the player more than one. */
	public void removeItemToGive() { itemToGive = null; }
	
	
	
	/////////// Getters ////////////
	
	/** Returns the item that this person will give the player. */
	public Item getItemToGive() { return itemToGive; }
	
	
}
