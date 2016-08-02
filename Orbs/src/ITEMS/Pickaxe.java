package ITEMS;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Pickaxe extends Item {

	
	
	///////////// Constructors //////////////
	
	public Pickaxe() { initialize(); }

	public Pickaxe(Vector2D pos) { super(pos); initialize();}

	public Pickaxe(BufferedImage bi) { super(bi); initialize(); }

	public Pickaxe(int quantity) { super(quantity); initialize(); }

	public Pickaxe(String name) { super(name); initialize(); }

	
	
	
	///////////// Abstract Methods //////////////
	
	@Override
	public void initialize() {
		setName("Pickaxe");
		setID("Pickaxe");
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

	@Override
	public Item clone() {
		Item itm = new Pickaxe();
		itm.setName(name);
		itm.setAcquiredMessage(acquiredMessage);
		itm.setID(identifier);
		itm.setQuantity(quantity);
		itm.setSpecial(isSpecial(), requiredItm);
		
		return itm;
	}
}
