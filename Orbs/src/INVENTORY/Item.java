package INVENTORY;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Assets;
import MISC.Option;
import MISC.Option.OptionType;

public class Item implements IUD {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5850113809227085551L;

	//The position of the item.
	Vector2D position = new Vector2D();
	
	//Size
	final int SIZE = 38;
	
	//The stack sizes
	private int currentStack = 1;
	private final int maxStack = 64;
	
	//The amount to heal the player if this is a consumable item.
	public int healValue;
	
	//Can the item be stacked
	private boolean stackable;
	
	//Determines if the item is consumable.
	public boolean consumable;
	
	//The type of item
	private ItemType type;
	
	//Options for the item
	Option[] options;
	
	//The inventory
	public Inventory inventory;
	
	
	//Constructors
	public Item() {}
	public Item(ItemType t) { type = t; initialize(); }
	public Item(ItemType t, Vector2D pos) { type = t; position = pos; initialize(); }
	public Item(ItemType t, int stack) { type = t; currentStack = stack; initialize(); }
	
	
	/** Sets the position of the item. */
	public Item setPosition(Vector2D pos) { position = pos; return this; }
	
	/** Adds an amount to this item's current stack size. */
	public void addToStack(int amount) { if(currentStack < maxStack) currentStack += amount; }
	
	/** Sets the options that this item can have. */
	private void setOptions() {
		if(isFood()) {
			options = new Option[3];
			options[0] = new Option("Eat",OptionType.Eat);
			options[1] = new Option("Drop",OptionType.Drop);
			options[2] = new Option("Cancel",OptionType.Cancel);
		}
		if(isUtility()) {
			options = new Option[3];
			options[0] = new Option("Use",OptionType.Use);
			options[1] = new Option("Drop",OptionType.Drop);
			options[2] = new Option("Cancel",OptionType.Cancel);
		}
		if(isMisc()) {
			options = new Option[2];
			options[0] = new Option("Drop",OptionType.Drop);
			options[1] = new Option("Cancel",OptionType.Cancel);
		}
	}
	
	
	/** Returns the type of item this item is. i.e., it could be an Apple, an Orange, Money, etc. */
	public ItemType Type() { return type; }
	
	/** Returns true or false if the item can be stacked. */
	public boolean Stackable() { return stackable; }
	
	/** Returns the integer value of this item's current stack size. */
	public int CurrentStack() { return currentStack; }
	
	/** Returns whether or not this item is consumable. Only food and drink items are consumable. */
	public boolean Consumable() { return consumable; }
	
	/** Return true or false if this item has reached its maximum stack size. */
	public boolean isFull() { return currentStack == maxStack; }	
	
	/** Returns a short description about this item. */
	@Override
	public String toString() {
		String info = "";
		//Depending on type, set the info to describe it.
		if(type == ItemType.Apple) { info = "An apple. Yum!"; }
		if(type == ItemType.Orange) { info = "A juicy orange!"; }
		if(type == ItemType.Money) { info = currentStack + " coin(s)."; }
		if(type == ItemType.Fish) { info = "A hardy fish."; }
		if(type == ItemType.Hatchet) { info = "A sharp hatchet for cutting trees."; }
		return info;
	}
	
	/** Returns the name of the item. */
	public String itemName() {
		String name = "";
		//Depending on type, set the info to describe it.
		if(type == ItemType.Apple) { name = "Apple"; }
		if(type == ItemType.Orange) { name = "Orange"; }
		if(type == ItemType.Money) { name = "Coin"; }
		if(type == ItemType.Fish) { name = "Fish"; }
		if(type == ItemType.Hatchet) { name = "Hatchet"; }
		return name;
	}
	
	/** Returns all of the options associated with this item. */
	public Option[] getOptions() { return options; }
	
	
	//DETERMINES WHAT TYPE OF ITEM THIS IS
	/** Returns whether or not this is a food item. */
	public boolean isFood() { return (this.Type() == ItemType.Apple || this.Type() == ItemType.Orange || this.Type() == ItemType.Fish); }
	
	/** Returns whether or not this is a utility item. */
	public boolean isUtility() { return (this.Type() == ItemType.Hatchet); }
	
	/** Returns whether or not this is a miscellaneous item. */
	public boolean isMisc() { return (this.Type() == ItemType.Money); }
	
	
	
	//FOR CONSUMABLE ITEMS
	private void setHealValues() {
		//Set all of the heal values for consumable items.
		if(this.Type() == ItemType.Apple) { healValue = 10; }
		if(this.Type() == ItemType.Orange) { healValue = 7; }
		if(this.Type() == ItemType.Fish) { healValue = 15; }
	}
	/** The amount that this food item will heal the player. */
	public float HealValue() { return this.healValue; }
	
	
	
	
	
	@Override
	public void initialize() {
		//Depending on type, say whether or not the item can be stacked.
		if(type == ItemType.Apple) { stackable = false; }
		if(type == ItemType.Orange) { stackable = false; }
		if(type == ItemType.Money) { stackable = true; }
		if(type == ItemType.Fish) { stackable = false; }
		if(type == ItemType.Hatchet) { stackable = false; }
		//Only food is consumable
		if(isFood()) consumable = true; else consumable = false;
		
		setOptions();
		setHealValues();
	}
	@Override
	public void draw(Graphics2D g) {
		AffineTransform t = new AffineTransform();
		t.translate(position.X*SIZE+3, position.Y*SIZE+3);
		t.scale(1, 1);
		
		//Depending on type, draw that item.
		if(type == ItemType.Apple) { g.drawImage(Assets.apple, t, null); }
		if(type == ItemType.Orange) { g.drawImage(Assets.orange, t, null); }
		if(type == ItemType.Money) { g.drawImage(Assets.money_2, t, null); }
		if(type == ItemType.Fish) { g.drawImage(Assets.fish, t, null); }
		if(type == ItemType.Hatchet) { g.drawImage(Assets.hatchet, t, null); }
	}
	@Override
	public void update(double time) {
		//Only food is consumable
		if(isFood()) consumable = true; else consumable = false;
	}
	
	
	
	
	/** The different types that an item can be. */
	public enum ItemType {
		Apple, Orange, Money, Fish, Hatchet;
	}




	




	








	
	
}
