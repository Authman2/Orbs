package MISC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import MAIN.Orbs;

public class TextBox {
	
	//The text to display inside this text box.
	ArrayList<String> text;
	
	//The current text slide that is being looked at.
	int currentSlide;
	
	//Whether or not the text box is open
	boolean open;
	
	
	
	/////////// Constructor /////////////
	public TextBox() {
		text = new ArrayList<String>();
	}
	
	
	/////////// Setters /////////////
	
	/** Moves to the next slide in the text box if there is one. Otherwise it will just close the text box.s */
	public void nextSlide() {
		if(currentSlide >= text.size() - 1) {
			open = false;
			currentSlide = 0;
		} else {
			currentSlide++;
		}
	}
	
	
	/** Adds text for the text box to display. */
	public void addText(String t) { text.add(t); }
	
	
	/** Toggles the text box. If it was open, it will close. If it was closed, it will open. */
	public void toggle() { open = !open; }
	
	

	/////////// Getters /////////////
	
	/** Returns whether or not the text box is currently open. */
	public boolean isOpen() { return open; }
	
	
	
	
	/////////// Abstract Methods /////////////

	public void initialize() {}
	
	
	public void update(double time) {}
	
	
	public void draw(Graphics2D g) {
		//If the text box is open...
		if(open == true) {
			//Draw the background of the text box
			g.setColor(Color.white);
			g.fillRect(0, Orbs.HEIGHT - 100, Orbs.WIDTH, 100);
		
			//Draw the text
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 15));
			g.drawString(text.get(currentSlide), 5, Orbs.HEIGHT - 80);
		}
	}
	
	
	
} //End of class
