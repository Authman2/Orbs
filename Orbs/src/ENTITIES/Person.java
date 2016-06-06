package ENTITIES;

import java.awt.image.BufferedImage;

import visualje.Vector2D;

public class Person extends NPC {

	
	/////////// Constructors ////////////
	public Person() {}

	public Person(Vector2D pos) { super(pos); }

	public Person(BufferedImage sprite) { super(sprite); }
	
}
