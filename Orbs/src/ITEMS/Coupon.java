package ITEMS;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Coupon extends Item {

	public Coupon() { initialize(); }

	public Coupon(Vector2D pos) { super(pos); initialize(); }

	public Coupon(BufferedImage bi) { super(bi); initialize(); }

	public Coupon(int quantity) { super(quantity); initialize(); }

	public Coupon(String name) { super(name); initialize(); }

	
	
	
	
	
	@Override
	public void initialize() {
		setName("Coupon");
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
