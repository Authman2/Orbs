package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Water extends Item {

	
	//////////// Constructors /////////////
	
	public Water() { initialize(); }

	public Water(Vector2D pos) { super(pos); initialize(); }

	public Water(BufferedImage bi) { super(bi); initialize(); }

	public Water(int quantity) { super(quantity); initialize(); }

	public Water(String name) { super(name); initialize(); }

	
	
	/////////// Abstract Methods /////////////
	
	@Override
	public void initialize() {
		setName("Water");
		setAcquiredMessage("You received " + getName() + "!");
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
