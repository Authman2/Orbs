package ENTITIES;

import java.awt.Color;
import java.awt.Graphics2D;

import visualje.Vector2D;

public class Player extends Entity {
	

	public Player() {
		position = new Vector2D(8,6);
	}

	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(double time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect((int)position.X*size, (int)position.Y*size, size, size);
	}

}
