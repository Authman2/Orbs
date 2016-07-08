package ITEMS;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Hatchet extends Item {

	
	
	///////////// Constructors //////////////
	
	public Hatchet() { initialize(); }

	public Hatchet(Vector2D pos) { super(pos); initialize();}

	public Hatchet(BufferedImage bi) { super(bi); initialize(); }

	public Hatchet(int quantity) { super(quantity); initialize(); }

	public Hatchet(String name) { super(name); initialize(); }

	
	
	
	///////////// Abstract Methods //////////////
	
	@Override
	public void initialize() {
		setName("Hatchet");
		setAcquiredMessage("You received a(n) " + getName() + "!");
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
