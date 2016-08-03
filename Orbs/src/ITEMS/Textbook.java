package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Textbook extends Item {

	public Textbook() {
		initialize();
	}

	public Textbook(Vector2D pos) {
		super(pos);
		initialize();
	}

	public Textbook(BufferedImage bi) {
		super(bi);
		initialize();
	}

	public Textbook(int quantity) {
		super(quantity);
		initialize();
	}

	public Textbook(String name) {
		super(name);
		initialize();
	}
	
	
	
	

	@Override
	public Item clone() {
		Item itm = new Textbook();
		itm.setName(name);
		itm.setAcquiredMessage(acquiredMessage);
		itm.setID(identifier);
		itm.setQuantity(quantity);
		itm.setSpecial(isSpecial(), requiredItm);
		
		return itm;
	}

	@Override
	public void initialize() {
		setName("Textbook");
		setID("Textbook");
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
