package INVENTORY;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Assets;

/* One inventory slot can contain an item. The inventory itself will be made up of a
 * collection of inventory slots. */
public class InventorySlot implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3564741635654014456L;

	//The position of the slot.
	Vector2D position;
	
	//The item contained within the slot, if there is one.
	Item item;
	
	//The inventory that this slot belongs to.
	Inventory inventory;
	
	//Size
	final int SIZE = 38;
	final float SCALE = 1.2f;
	
	public InventorySlot(float x, float y, Inventory inv) {
		position = new Vector2D(x,y);
		inventory = inv;
		if(item != null)
			item.inventory = inventory;
	}


	@Override
	public void draw(Graphics2D g) {
		AffineTransform t = new AffineTransform();
		t.translate(position.X*SIZE, position.Y*SIZE);
		t.scale(1.2, 1.2);
		
		//Draw the inventory slot background
		g.drawImage(Assets.inventorySlotBG, t, null);
		
		if(inventory.selectedSlot == this) {
			//Draw a red box around it if it is the selected slot.
			g.drawImage(Assets.selectedslotimg, t, null);
		}
		
		if(item != null) {
			item.draw(g);
		}
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void update(double time) {
		if(item != null) {
			item.setPosition(new Vector2D(position.X, position.Y));
			item.inventory = inventory;
			item.update(time);
		}
	}

	
	
	/** Returns true if this inventory slot has an item. */
	public boolean HasItem() { if(item == null) return false; else return true; }
	
	
	/** Sets this inventory slot's item. */
	public void setItem(Item itm) {	this.item = itm; }
	
	
	/** Returns the item that this inventory slot currently has. */
	public Item getItem() { return item; }
	
	
	/** Removes this inventory slot's item, and returns the item that was just removed. */
	public Item removeItem() { 
		Item n = new Item(item.Type(), item.CurrentStack());
		item = null; 
		return n; 
	}
	
}
