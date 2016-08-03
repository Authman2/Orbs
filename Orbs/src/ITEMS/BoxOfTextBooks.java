package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class BoxOfTextBooks extends Item {

	public BoxOfTextBooks() {
		initialize();
	}

	public BoxOfTextBooks(Vector2D pos) {
		super(pos);
		initialize();
	}

	public BoxOfTextBooks(BufferedImage bi) {
		super(bi);
		initialize();
	}

	public BoxOfTextBooks(int quantity) {
		super(quantity);
		initialize();
	}

	public BoxOfTextBooks(String name) {
		super(name);
		initialize();
	}
	
	
	

	@Override
	public Item clone() {
		Item itm = new BoxOfTextBooks();
		itm.setName(name);
		itm.setAcquiredMessage(acquiredMessage);
		itm.setID(identifier);
		itm.setQuantity(quantity);
		itm.setSpecial(isSpecial(), requiredItm);
		
		return itm;
	}

	@Override
	public void initialize() {
		setName("Box of Textbooks");
		setID("Box of Textbooks");
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
