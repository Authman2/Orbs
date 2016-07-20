package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

/** Used so that the player can pick up the "radio active" orb during one part of the game. */
public class Container extends Item {

	public Container() { initialize(); }

	public Container(Vector2D pos) { super(pos); initialize(); }

	public Container(BufferedImage bi) { super(bi); initialize(); }

	public Container(int quantity) { super(quantity); initialize(); }

	public Container(String name) { super(name); initialize();}

	
	
	
	@Override
	public void initialize() {
		setName("Container");
		setID("Container");
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
