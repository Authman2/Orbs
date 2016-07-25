package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class BakeryReceipt extends Item {

	public BakeryReceipt() { initialize(); }

	public BakeryReceipt(Vector2D pos) { super(pos); initialize(); }

	public BakeryReceipt(BufferedImage bi) { super(bi); initialize(); }

	public BakeryReceipt(int quantity) { super(quantity); initialize(); }

	public BakeryReceipt(String name) { super(name); initialize(); }

	
	
	@Override
	public void initialize() {
		setName("Bakery Receipt");
		setID("Bakery Receipt");
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

}
