package ENTITIES;

import java.awt.image.BufferedImage;

import MISC.Item;
import visualje.Vector2D;

public class Tree extends NPC {

	
	//The item that this tree contains
	Item containedItem;
	
	
	
	
	/////////// Constructors /////////////
	
	public Tree() { renderSprite = false; }
	
	public Tree(Item itm) { containedItem = itm; renderSprite = false; }

	public Tree(Vector2D pos) { super(pos); renderSprite = false; }

	public Tree(BufferedImage sprite) { super(sprite); renderSprite = false; }

	
	
	
	//////////// Getters ////////////////
	
	/** Returns the item contained within this tree. Returns null if there is no item. */
	public Item getContainedItem() { return containedItem; }
	
	
	
	
	//////////// Setters ////////////////
	
	/** Tells the game what item is contained within this tree for the player to pick up. */
	public void setContainedItem(Item itm) { containedItem = itm; }
	
	
	/** Removes the item from this tree. This is usually because the player has already taken the item. */
	public void removeContainedItem() { containedItem = null; }
	
	
	
	///////////// Abstract Methods ///////////////
	
	@Override
	public void initialize() {
		super.initialize();
		
		//There is no item in this tree
		if(containedItem == null) {
			
			textBox.addText("There are no items in this tree.");
		
		//There is an item in this tree
		} else {
				
			textBox.addText("You received a(n) " + containedItem.getName() + "!");
		
		}
	}
}
