package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Cake extends Item {

	public Cake() { initialize(); }

	public Cake(Vector2D pos) { super(pos); initialize(); }

	public Cake(BufferedImage bi) { super(bi); initialize(); }

	public Cake(int quantity) { super(quantity); initialize(); }

	public Cake(String name) { super(name); initialize(); }

	
	
	@Override
	public void initialize() {
		setName("Cake");
		setID("Cake");
		setAcquiredMessage("You received a " + getName() + "!");
		if(acquiredTextBox.isOpen()) acquiredTextBox.initialize();
	}

	@Override
	public void update(double time) {
		setAcquiredMessage("You received a " + getName() + "!");
		if(acquiredTextBox.isOpen()) acquiredTextBox.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		setAcquiredMessage("You received a " + getName() + "!");
		if(acquiredTextBox.isOpen()) acquiredTextBox.draw(g);
	}
	
	@Override
	public Item clone() {
		Item itm = new Cake();
		itm.setName(name);
		itm.setAcquiredMessage(acquiredMessage);
		itm.setID(identifier);
		itm.setQuantity(quantity);
		itm.setSpecial(isSpecial(), requiredItm);
		
		return itm;
	}

}
