package ENTITIES;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import visualje.Vector2D;

/** Represents anything that is not the environment in the world. This includes the player, NPCs, enemies, items, etc. */
public abstract class Entity {
	
	//The position of the entity
	public Vector2D position;
	
	//The size of the entity
	protected int size = 32;
	
	//The sprite for the entity
	protected BufferedImage sprite;
	
	/*
	 * The direction that the entity is facing.
	 * 0 = down
	 * 1 = right
	 * 2 = up
	 * 3 = left
	 */
	int facing = 0;
	
	
	/////////// Constructors ////////////
	public Entity() { position = new Vector2D(); }
	public Entity(Vector2D pos) { position = new Vector2D(pos.X, pos.Y); }
	public Entity(BufferedImage bi) { position = new Vector2D(); this.sprite = bi; }
	
	
	
	
	/////////// Abstract Methods ////////////
	
	public abstract void initialize();
	public abstract void update(double time);
	public abstract void draw(Graphics2D g);
	
	
	
	/////////// Setters ////////////
	
	/** Sets the direction of the entity to "i".
	 * 0 = down
	 * 1 = right
	 * 2 = up
	 * 3 = left*/
	public void setDirection(int i) { facing = i; }
	
	
	
	/////////// Setters ////////////
	
	/** Returns whether or not this NPC is next to the entity "ent" (either above, below, to the left, or to the right). The other
	 * entity must also be facing in the appropriate direction to be considered "next to" this entity. */
	public boolean isNextTo(Entity ent) {
		
		//This entity is to the left of the other entity
		if(position.X == ent.position.X - 1 && position.Y == ent.position.Y) {
			if(ent.facing == 3) {
				return true;
			}
		}
		
		//This entity is to the right of the other entity
		if(position.X == ent.position.X + 1 && position.Y == ent.position.Y) {
			if(ent.facing == 1) {
				return true;
			}
		}
		
		//This entity is above the other entity
		if(position.X == ent.position.X && position.Y == ent.position.Y - 1) {
			if(ent.facing == 2) {
				return true;
			}
		}
		
		//This entity is below the other entity
		if(position.X == ent.position.X && position.Y == ent.position.Y + 1) {
			if(ent.facing == 0) {
				return true;
			}
		}
		
		
		return false;
	}


}
