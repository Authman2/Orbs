package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class SewingKit extends Item {

	public SewingKit() { initialize(); }

	public SewingKit(Vector2D pos) { super(pos); initialize(); }

	public SewingKit(BufferedImage bi) { super(bi); initialize(); }

	public SewingKit(int quantity) { super(quantity); initialize(); }

	public SewingKit(String name) { super(name); initialize(); }

	
	
	
	@Override
	public void initialize() {
		setName("Sewing Kit");
		setAcquiredMessage("You received a " + getName() + "!");
		if(acquiredTextBox.isOpen()) acquiredTextBox.initialize();
	}

	@Override
	public void update(double time) {
		if(acquiredTextBox.isOpen()) acquiredTextBox.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		if(acquiredTextBox.isOpen()) acquiredTextBox.draw(g);
	}

}
