package ITEMS;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class HazmatSuit extends Item {

	public HazmatSuit() { initialize(); }

	public HazmatSuit(Vector2D pos) { super(pos); initialize(); }

	public HazmatSuit(BufferedImage bi) { super(bi); initialize(); }

	public HazmatSuit(int quantity) { super(quantity); initialize(); }

	public HazmatSuit(String name) { super(name); initialize(); }

	
	
	
	
	
	
	////////////// Abstract Methods //////////////
	
	@Override
	public void initialize() {
		setName("Hazmat Suit");
		setID("Hazmat Suit");
		setAcquiredMessage("You received a " + getName() + "!");
		if(acquiredTextBox.isOpen()) acquiredTextBox.initialize();
	}

	@Override
	public void update(double time) {
		if(acquiredTextBox.isOpen()) acquiredTextBox.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect((int)position.X*size, (int)position.Y*size, size, size);
		
		if(acquiredTextBox.isOpen()) acquiredTextBox.draw(g);
	}

}
