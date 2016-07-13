package ITEMS;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;


/** "Orb" represents a special orb that the player must collect throughout the game. It is of type "Item," which is of
 * type "Entity," which basically just means that they are game objects that can be manipulated just like any other entity. */
public class Orb extends Item {

	/* This static boolean value determines whether or not the player has picked up at least ONE orb in the game. The scientist 
	 * will say something different to the player depending on whether or not he/she has collected an orb already and how many
	 * orbs have been collected. */
	public static boolean pickedUpFirstOrb = false;	
	
	
	
	//////////// Constructors //////////////
	
	public Orb() { initialize(); }
	public Orb(Vector2D pos) { super(pos); initialize(); }
	public Orb(BufferedImage bi) { super(bi); initialize(); }
	public Orb(int quantity) { super(quantity); initialize(); }
	public Orb(String name) { super(name); initialize(); }

	
	////////// Setters ///////////
	
	/** Tells the game that the player has picked up an orb for the first time. */
	public static void setFirstCollected() { pickedUpFirstOrb = true; }

	
	
	////////////Abstract Methods //////////////
	
	@Override
	public void initialize() {
		setName("Orb");
		setAcquiredMessage("You received an " + getName() + "!");
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
