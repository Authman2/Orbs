package ENTITIES;

import java.awt.Graphics2D;

import visualje.Vector2D;

/** Represents anything that is not the environment in the world. This includes the player, NPCs, enemies, items, etc. */
public abstract class Entity {
	
	//The position of the entity
	public Vector2D position;
	
	//The size of the entity
	int size = 32;
	
	
	
	/////////// Constructors ////////////
	public Entity() { position = new Vector2D(); }
	public Entity(Vector2D pos) { position = new Vector2D(pos.X, pos.Y); }
	
	
	/////////// Abstract Methods ////////////
	public abstract void initialize();
	public abstract void update(double time);
	public abstract void draw(Graphics2D g);
}
