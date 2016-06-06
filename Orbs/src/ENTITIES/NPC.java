package ENTITIES;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import MISC.TextBox;
import visualje.Vector2D;

public class NPC extends Entity {

	//Each NPC has a text box, which will show when the player interacts with it.
	TextBox textBox;
	
	//The default sprite for the NPC.
	BufferedImage defaultSprite;
	
	
	
	/////////// Constructors ///////////
	
	public NPC() { textBox = new TextBox(); }

	public NPC(Vector2D pos) { super(pos); textBox = new TextBox(); }

	public NPC(BufferedImage sprite) { this.defaultSprite = sprite; textBox = new TextBox(); }
	
	
	
	/////////// Setters ///////////
	
	/** Sets the default sprite for this NPC. */
	public void setSprite(BufferedImage sprite) { this.defaultSprite = sprite; }
	
	
	
	
	/////////// Getters ///////////
	
	/** Returns the text box for this NPC. */
	public TextBox getTextBox() { return textBox; }
	
	
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
	
	
	/////////// Abstract Methods ///////////
	
	@Override
	public void initialize() {
		if(textBox.isOpen()) textBox.initialize();
	}

	@Override
	public void update(double time) {
		if(textBox.isOpen()) textBox.update(time);
	}

	@Override
	public void draw(Graphics2D g) {
		
		//Drawing the NPC
		if(defaultSprite == null) {
			g.setColor(Color.black);
			g.fillRect((int)position.X*size, (int)position.Y*size, size, size);
		} else {
			g.drawImage(null, (int)position.X*size, (int)position.Y*size, size, size, null);
		}
		
		//Drawing the NPC's text box
		if(textBox.isOpen()) textBox.draw(g);
		
	}

}
