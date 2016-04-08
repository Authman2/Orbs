package INVENTORY;

import java.awt.Graphics2D;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MOVEABLE.Player;
import STATES.InventoryState;

public class Inventory implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 872883258114118686L;
	
	//The inventory state
	public InventoryState invstate;
	
	//The position of the inventory in the world space.
	Vector2D position;
	
	//The different slots
	public InventorySlot[][] slots;
	
	//The player (object created in the GameStateManager and InventoryState)
	public Player player;
	
	//The dimensions of the inventory
	public int Width = 0, Height = 0;
	
	//The selected slot for performing actions
	public InventorySlot selectedSlot;
	
	//True or False for if the inventory is open or not;
	public boolean Open;
	
	
	
	public Inventory(Vector2D pos, int w, int h, InventoryState inv) {
		position = pos;
		Width = w;
		Height = h;
		slots = new InventorySlot[Width][Height];
		invstate = inv;
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				slots[x][y] = new InventorySlot(position.X+x,position.Y+y, this);
				slots[x][y].inventory = this;
			}
		}
		initialize();
	}
	public Inventory(int w, int h, InventoryState inv) {
		position = new Vector2D();
		Width = w;
		Height = h;
		slots = new InventorySlot[Width][Height];
		invstate = inv;
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				slots[x][y] = new InventorySlot(position.X+x,position.Y+y, this);
				slots[x][y].inventory = this;
			}
		}
		initialize();
	}
	
	
	@Override
	public void initialize() {
		//Selected slot is the first slot.
		selectedSlot = slots[0][0];
		
	}

	@Override
	public void draw(Graphics2D g) {
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				slots[x][y].draw(g);
			}
		}
	}
	
	@Override
	public void update(double time) {
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				slots[x][y].inventory = this;
				slots[x][y].update(time);
			}
		}
	}
	
	
	/** Returns whether or not the inventory is open. */
	public boolean isOpen() { return Open; }
	/** Toggle the inventory. */
	public void Toggle() { Open = !Open; }
	/** Returns the inventory state. */
	public InventoryState getInventoryState() { return invstate; }
	
	/** Returns the first empty slot in the inventory as an array of ints. */
	public int[] nextEmpty() {
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				if(!slots[y][x].HasItem()) {
					return new int[] {y,x};
				}
			}
		}
		return null;
	}
	
	
	/** Adds an item to the inventory. 
	 * @param itm -- The item that you want to add to the inventory. */
	public void addItem(Item itm) {
		try {
			if(itm.Stackable() == true) {
				if(containsSameType(itm)) {
					slots[firstInstance(itm)[0]][firstInstance(itm)[1]].getItem().addToStack(itm.CurrentStack());
				} else {
					slots[nextEmpty()[0]][nextEmpty()[1]].setItem(itm);
				}
			} else {
				slots[nextEmpty()[0]][nextEmpty()[1]].setItem(itm);
			}
		} catch(Exception e) {
			System.err.println("No more inventory space.");
		}
	} 
	

	/** Checks if the inventory already contains an item of that type */
	public boolean containsSameType(Item itm) {
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				if(slots[y][x].HasItem()) {
					if(slots[y][x].getItem().Type() == itm.Type()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Returns the index of the first instance of that item in the inventory.
	 * @return An array of two integers for the y and x values, respectively. */
	public int[] firstInstance(Item itm) {
		for(int x = 0; x < Width; x++) {
			for(int y = 0; y < Height; y++) {
				if(slots[y][x].HasItem()) {
					if(slots[y][x].getItem().Type() == itm.Type()) {
						return new int[] {y,x};
					}
				}
			}
		}
		return null;
	}
	
//	
//	for(InventorySlot[] s : slots) {
//		for(InventorySlot slot : s) {
//			//Find the first slot that does not have an item and set the item for that slot.
//			if(slot.HasItem()) {
//				slot.setItem(itm);
//			//Else if it does have an item...
//			} else {
//				//If they are the same type of item...
//				if(slot.item.Type() == itm.Type()) {
//					//If the item is can be stacked...
//					if(slot.item.Stackable()) {
//						//If the stack is not full, then add it to the stack.
//						if(!slot.item.isFull()) { slot.item.addToStack(itm.CurrentStack()); } 
//						else { System.out.println("That item is already fully stacked."); }
//					} else {
//						//If it cannot be stacked, print error message.
//						System.out.println("This item is not stackable.");
//					}
//				} else {
//					//If they are not the same type of item, print this message.
//					System.out.println("These are not the same type of items, and cannot be stacked.");
//				}
//			}
//		}
//	}
}
