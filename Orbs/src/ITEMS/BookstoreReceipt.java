package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class BookstoreReceipt extends Item {

	public BookstoreReceipt() {
		initialize();
	}

	public BookstoreReceipt(Vector2D pos) {
		super(pos);
		initialize();
	}

	public BookstoreReceipt(BufferedImage bi) {
		super(bi);
		initialize();
	}

	public BookstoreReceipt(int quantity) {
		super(quantity);
		initialize();
	}

	public BookstoreReceipt(String name) {
		super(name);
		initialize();
	}

	
	
	
	
	
	
	@Override
	public Item clone() {
		Item itm = new BookstoreReceipt();
		itm.setName(name);
		itm.setAcquiredMessage(acquiredMessage);
		itm.setID(identifier);
		itm.setQuantity(quantity);
		itm.setSpecial(isSpecial(), requiredItm);
		
		return itm;
	}

	@Override
	public void initialize() {
		setName("Bookstore Receipt");
		setID("Bookstore Receipt");
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
