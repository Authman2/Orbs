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
	int MAX_LINE_LENGTH = 70;
	
	//Represents what the text box is showing up to while on a particular text slide.
	int textThrough = 0;
	
	
	
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
			textThrough = 0;
		} else {
			currentSlide++;
			textThrough = 0;
		}
	}
	
	
	/** Adds text for the text box to display. */
	public void addText(String t) { text.add(t); }
	
	
	/** Adds text for the text box at the specified index.*/
	public void addText(String t, int index) { text.add(index, t); }
	
	
	/** Sets the text at the particular location in the text box. */
	public void setText(String t, int index) { text.set(index, t); }
	
	
	/** Toggles the text box. If it was open, it will close. If it was closed, it will open. */
	public void toggle() { open = !open; }
	
	
	/** Removes all of the text slides from this text box. */
	public void clear() {
		text.removeAll(text);
		currentSlide = 0;
	}
	
	
	/** Set the current slide of the text box. */
	public void setCurrentSlide(int i) { currentSlide = i; }
	
	
	/** Removes the last slide from the text box. */
	public void removeLast() { text.remove(text.size() - 1); }
	
	
	/** Sets whether or not the text box is open. */
	public void setOpen(boolean b) { open = b; }
	
	
	/** Sets where the text box should display the letters up to. */
	public void setTextThrough(int i) { textThrough = i; }
	

	
	/////////// Getters /////////////
	
	/** Returns whether or not the text box is currently open. */
	public boolean isOpen() { return open; }
	
	
	/** Returns a list of all of the text slides that the text box is set to display. */
	public ArrayList<String> getTextSlides() { return text; }
	
	
	/** Checks if the text box is currently on its last text slide. */
	public boolean onLast() {
		if(currentSlide == text.size() - 1) return true;
		return false;
	}
	
	
	
	/////////// Abstract Methods /////////////

	public void initialize() {}
	
	
	public void update(double time) {}
	
	
	public void draw(Graphics2D g) {
		//If the text box is open...
		if(open == true && !text.isEmpty()) {
			//Draw the background of the text box
			g.setColor(Color.white);
			g.fillRoundRect(0, Orbs.HEIGHT - 100, Orbs.WIDTH, 78, 20, 20);
		
			//Set the text attributes
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 15));
			
			
			//If the text is longer than one line
			if(text.get(currentSlide).length() > MAX_LINE_LENGTH) {
				
				int y = Orbs.HEIGHT - 80;
				String slideText = text.get(currentSlide);
				
				//Loop through each character on the text slide
				for(int i = 0; i < text.get(currentSlide).length(); i++) {
					int howFar = MAX_LINE_LENGTH;	//A variable for how far it needs to display the text
					
					//Set howFar based on the length of each line.
					if(slideText.length() >= MAX_LINE_LENGTH) { howFar = MAX_LINE_LENGTH; }
					else { howFar = slideText.length(); }
					
					if(textThrough < howFar) {
						g.drawString(slideText.substring(0, textThrough), 5, y);
						textThrough++;
					} else {
						g.drawString(slideText.substring(0, howFar), 5, y);
					}
					slideText = slideText.substring(howFar);
					y += 15;
					
					if(textThrough >= howFar) { continue; } else { break; }
				}
				
				
			} else {
				
				//If the entire slide of text is less than the maximum allowed, then just draw it on one line
				//g.drawString(text.get(currentSlide), 5, Orbs.HEIGHT - 80);
				
				g.drawString(text.get(currentSlide).substring(0,textThrough), 5, Orbs.HEIGHT - 80);
				if(textThrough < text.get(currentSlide).length()) textThrough++;
				
			}
			
		}
	}
	
	
	
} //End of class
