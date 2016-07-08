package ENTITIES;

import java.awt.image.BufferedImage;

import ITEMS.Item;
import visualje.Vector2D;

/** A SearchableEntity is something that exists in the game world that the player can interact with to find possibly find
 * items in. These are different from NPCs that might give the player an item because these are not necessarily people. The 
 * "c" in NPC denotes a character, or person. However, SearchableEntities may not be people. A SearchableEntity could be 
 * something like a tree, a painting, or a rock, to name a few, that the player can take a closer look at to see if it has an 
 * item. */
public class SearchableEntity extends NPC {

	
	//The item that this entity contains
	Item containedItem;
	
	//The name of this SearchableEntity
	String name = "";
	
	
	
	
	/////////// Constructors /////////////
	
	public SearchableEntity() { renderSprite = false; }
	
	public SearchableEntity(Item itm) { containedItem = itm; renderSprite = false; }

	public SearchableEntity(Vector2D pos) { super(pos); renderSprite = false; }

	public SearchableEntity(BufferedImage sprite) { super(sprite); renderSprite = false; }

	
	
	
	//////////// Getters ////////////////
	
	/** Returns the item contained within this SearchableEntity. Returns null if there is no item. */
	public Item getContainedItem() { return containedItem; }
	
	
	/** Returns the name of this SearchableEntity. */
	public String getName() { return name; }
	
	
	//////////// Setters ////////////////
	
	/** Tells the game what item is contained within this SearchableEntity for the player to pick up. */
	public void setContainedItem(Item itm) { containedItem = itm; }
	
	
	/** Removes the item from this SearchableEntity. This is usually because the player has already taken the item. */
	public void removeContainedItem() { containedItem = null; }
	
	
	/** Sets the name of this SearchableEntity. Examples include "tree" for a SearchableEntity that happens to be a tree, or
	 * "painting" for a SearchableEntity that happens to be a painting. */
	public void setName(String name) { this.name = name; }
	
	
	
	///////////// Abstract Methods ///////////////
	
	@Override
	public void initialize() {
		super.initialize();
		
		//There is no item in this tree
		if(containedItem == null) {
			
			textBox.addText("There are no items in this " + name + ".");
		
		//There is an item in this tree
		} else {
				
			textBox.addText("You search the " + name + " and find a(n) " + containedItem.getName() + "!");
		
		}
	}
}
