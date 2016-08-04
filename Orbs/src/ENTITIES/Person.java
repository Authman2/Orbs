package ENTITIES;

import java.awt.image.BufferedImage;

import ITEMS.Item;
import visualje.Vector2D;

public class Person extends NPC {

	//The item that this person will give the player.
	Item itemToGive;
	
	//The item that this person will take from the player.
	String itemToTake;
	
	//Whether or not this person will give the player an item
	boolean willGiveItem;
	
	//Whether or not this person will take an item from the player
	boolean willTakeItem;
	
	
	/////////// Constructors ////////////
	public Person() {}

	public Person(Vector2D pos) { super(pos); }

	public Person(BufferedImage sprite) { super(sprite); }
	
	
	
	/////////// Setters ////////////
	
	/** Set the item that this person should give the player. */
	public void setItemToGive(Item itm) { itemToGive = itm; }
	
	
	/** Set the item that this person should take from player. */
	public void setItemToTake(String name) { itemToTake = name; }
	
	
	/** Takes the item away from this person so that they do not accidently give the player more than one. */
	public void removeItemToGive() { itemToGive = null; }
	
	
	/** Takes the item away from this person so that they do not accidently give the player more than one. */
	public void removeItemToTake() { itemToTake = null; }
	
	
	/** Sets whether or not this person will give the player an item. */
	public void willGiveItem(boolean b) { this.willGiveItem = b; }
	
	
	/** Sets whether or not this person will give the player an item. */
	public void willTakeItem(boolean b) { this.willTakeItem = b; }
	
	
	
	/////////// Getters ////////////
	
	/** Returns the item that this person will give the player. */
	public Item getItemToGive() { return itemToGive; }
	
	
	/** Whether or not the person will give the player an item. */
	public boolean willGiveItem() { return this.willGiveItem; }
	
	
	/** Returns the item that this person will give the player. */
	public String getItemToTake() { return itemToTake; }
	
	
	/** Whether or not the person will give the player an item. */
	public boolean willTakeItem() { return this.willTakeItem; }
	
	
}
