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
	
	//Whether or not the text box is open.
	boolean open;
	
	//The maximum number of characters that can fit on one line in the text box.
	final int MAX_LINE_LENGTH = 70;
	
	
	
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
	
	
	/** Removes all of the text slides from this text box. */
	public void clear() {
		text.removeAll(text);
		currentSlide = 0;
	}

	/////////// Getters /////////////
	
	/** Returns whether or not the text box is currently open. */
	public boolean isOpen() { return open; }
	
	
	/** Returns a list of all of the text slides that the text box is set to display. */
	public ArrayList<String> getTextSlides() { return text; }
	
	
	/////////// Abstract Methods /////////////

	public void initialize() {}
	
	
	public void update(double time) {}
	
	
	public void draw(Graphics2D g) {
		//If the text box is open...
		if(open == true && !text.isEmpty()) {
			//Draw the background of the text box
			g.setColor(Color.white);
			g.fillRect(0, Orbs.HEIGHT - 100, Orbs.WIDTH, 100);
		
			//Set the text attributes
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 15));
			
			
			//If the text is longer than one line
			if(text.get(currentSlide).length() > MAX_LINE_LENGTH) {
				
				int y = Orbs.HEIGHT - 80;
				String slideText = text.get(currentSlide);
				
				//Loop through each letter in the text slide
				for(int letter = 0; letter < slideText.length(); letter++) {
					
					//If the length of the entire text is longer than the amount allowed on one line...
					if(slideText.length() >= MAX_LINE_LENGTH) {
						
						//Draw the string up to the end of the line
						g.drawString(slideText.substring(0, MAX_LINE_LENGTH), 5, y);
						
						//Then shorten the amount of text that still needs to be written, and go to the next line.
						slideText = slideText.substring(MAX_LINE_LENGTH);
						y += 15;
					
					} else {
						
						//If the rest of the string is shorter than the maximum allowed on one line, then just draw up through the end.
						g.drawString(slideText.substring(0, slideText.length()), 5, y);
						
					}
					
				}
				
			} else {
				
				//If the entire slide of text is less than the maximum allowed, then just draw it on one line
				g.drawString(text.get(currentSlide), 5, Orbs.HEIGHT - 80);
				
			}
			
		}
	}
	
	
	
} //End of class
