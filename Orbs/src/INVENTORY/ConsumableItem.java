package INVENTORY;

import myproject.gos.main.Vector2D;

public class ConsumableItem extends Item {

	public ConsumableItem() {}
	public ConsumableItem(ItemType t) { super(t);}
	public ConsumableItem(ItemType t, Vector2D pos) { super(t, pos); }
	public ConsumableItem(ItemType t, int stack) { super(t, stack); }

	@Override
	public void initialize() {
		super.initialize();
		
		//Set all of the heal values for consumable items.
		if(this.Type() == ItemType.Apple) { healValue = 10; }
		if(this.Type() == ItemType.Orange) { healValue = 7; }
		if(this.Type() == ItemType.Fish) { healValue = 15; }
	}
	
	/** The amount that this food item will heal the player. */
	public float HealValue() { return this.healValue; }
}
