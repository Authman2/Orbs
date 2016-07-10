package ENTITIES;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import MISC.TextBox;
import visualje.Vector2D;

public class NPC extends Entity {

	//Each NPC has a text box, which will show when the player interacts with it.
	TextBox textBox;
	
	
	
	/////////// Constructors ///////////
	
	public NPC() { textBox = new TextBox(); }

	public NPC(Vector2D pos) { super(pos); textBox = new TextBox(); }

	public NPC(BufferedImage sprite) { this.sprite = sprite; textBox = new TextBox(); }
	
	
	
	/////////// Setters ///////////
	
	/** Sets the default sprite for this NPC. */
	public void setSprite(BufferedImage sprite) { this.sprite = sprite; }
	
	
	
	/////////// Getters ///////////
	
	/** Returns the text box for this NPC. */
	public TextBox getTextBox() { return textBox; }
	
	
	
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
		
		//Only draw anything if the NPC should render a sprite of some sort
		if(renderSprite) {
			//Drawing the NPC
			if(sprite == null) {
				g.setColor(Color.black);
				g.fillRect((int)position.X*size, (int)position.Y*size, size, size);
			} else {
				g.drawImage(sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
			
		//Drawing the NPC's text box
		if(textBox.isOpen()) textBox.draw(g);
		
	}

}
