package ENTITIES;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import MISC.TextBox;
import visualje.Vector2D;

public class NPC extends Entity {

	//Each NPC has a text box, which will show when the player interacts with it.
	TextBox textBox;
	
	//The directional sprites (excluding the down position, which is assumed to be the default)
	BufferedImage up_sprite, left_sprite, right_sprite;
	
	
	
	/////////// Constructors ///////////
	
	public NPC() { textBox = new TextBox(); }

	public NPC(Vector2D pos) { super(pos); textBox = new TextBox(); }

	public NPC(BufferedImage sprite) { this.sprite = sprite; textBox = new TextBox(); }
	
	
	
	/////////// Setters ///////////
	
	/** Sets the default sprite for this NPC. */
	public void setDefaultSprite(BufferedImage sprite) { this.sprite = sprite; }
	
	/** Sets the sprite that this NPC should have for each direction. */
	public void setDirectionSprites(BufferedImage down, BufferedImage up, BufferedImage left, BufferedImage right) {
		this.sprite = down;
		this.up_sprite = up;
		this.left_sprite = left;
		this.right_sprite = right;
	}
	
	
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
				if(facing == 0)
					g.drawImage(sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				if(facing == 1)
					g.drawImage(right_sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				if(facing == 2)
					g.drawImage(up_sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
				if(facing == 3)
					g.drawImage(left_sprite, (int)position.X*size, (int)position.Y*size, size, size, null);
			}
		}
			
		//Drawing the NPC's text box
		//if(textBox.isOpen()) textBox.draw(g);
		
	}

}
