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
	
	//Whether or not the sprite should be rendered
	protected boolean renderSprite = true;
	
	//The direction the entity is facing in.
	public Direction direction;
	
	
	
	/////////// Constructors ////////////
	public Entity() { position = new Vector2D(); direction = Direction.South; }
	public Entity(Vector2D pos) { position = new Vector2D(pos.X, pos.Y);  direction = Direction.South; }
	public Entity(BufferedImage bi) { position = new Vector2D(); this.sprite = bi;  direction = Direction.South; }
	
	
	
	
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
	public void setDirection(Direction d) { this.direction = d; }
	
	
	
	/////////// Setters ////////////
	
	/** Returns the direction of this entity. */
	public Direction getDirection() { return direction; }
	
	
	/** Returns whether or not this entity is to the left of ent. */
	public boolean isLeftOf(Entity ent) {
		if(position.X == ent.position.X - 1 && position.Y == ent.position.Y) {
			if(ent.direction == Direction.West) return true;
		}
		return false;
	}
	
	
	/** Returns whether or not this entity is to the right of ent. */
	public boolean isRightOf(Entity ent) {
		if(position.X == ent.position.X + 1 && position.Y == ent.position.Y) {
			if(ent.direction == Direction.East) return true;
		}
		return false;
	}
	
	
	/** Returns whether or not this entity is above ent. */
	public boolean isAbove(Entity ent) {
		if(position.X == ent.position.X && position.Y == ent.position.Y - 1) {
			if(ent.direction == Direction.North) return true;
		}
		return false;
	}
	
	
	/** Returns whether or not this entity is below ent. */
	public boolean isBelow(Entity ent) {
		if(position.X == ent.position.X && position.Y == ent.position.Y + 1) {
			if(ent.direction == Direction.South) return true;
		}
		return false;
	}
	
	
	/** Returns whether or not this NPC is next to the entity "ent" (either above, below, to the left, or to the right). The other
	 * entity must also be facing in the appropriate direction to be considered "next to" this entity. */
	public boolean isNextTo(Entity ent) {
		
		//This entity is to the left of the other entity
		if(isLeftOf(ent)) {
			return true;
		}
		
		//This entity is to the right of the other entity
		if(isRightOf(ent)) {
			return true;
		}
		
		//This entity is above the other entity
		if(isAbove(ent)) {
			return true;
		}
		
		//This entity is below the other entity
		if(isBelow(ent)) {
			return true;
		}
		
		
		return false;
	}


}
