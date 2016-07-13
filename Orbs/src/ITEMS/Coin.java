package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Coin extends Item {
	

	public Coin() { initialize(); }

	public Coin(Vector2D pos) { super(pos); initialize(); }

	public Coin(BufferedImage bi) { super(bi); initialize(); }

	public Coin(int quantity) { super(quantity); initialize(); }

	public Coin(String name) { super(name); initialize(); }

	
	
	
	@Override
	public void initialize() {
		setName("Coin");
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
