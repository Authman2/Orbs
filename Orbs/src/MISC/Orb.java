package MISC;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;


/** "Orb" represents a special orb that the player must collect throughout the game. It is of type "Item," which is of
 * type "Entity," which basically just means that they are game objects that can be manipulated just like any other entity. */
public class Orb extends Item {

	
	//////////// Constructors //////////////
	
	public Orb() { initialize(); }
	public Orb(Vector2D pos) { super(pos); initialize(); }
	public Orb(BufferedImage bi) { super(bi); initialize(); }
	public Orb(int quantity) { super(quantity); initialize(); }
	public Orb(String name) { super(name); initialize(); }

	
	
	////////////Abstract Methods //////////////
	
	@Override
	public void initialize() {
		setName("Orb");
		setAcquiredMessage("You received a(n) " + getName() + "!");
		if(acquiredTextBox.open) acquiredTextBox.initialize();
	}

	@Override
	public void update(double time) {
		if(acquiredTextBox.open) acquiredTextBox.update(time);;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect((int)position.X*size, (int)position.Y*size, size, size);
		
		if(acquiredTextBox.open) acquiredTextBox.draw(g);
	}

}
