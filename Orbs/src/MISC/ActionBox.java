package MISC;

import java.awt.Color;
import java.awt.Graphics2D;

import MAIN.Orbs;

/** An ActionBox is something that requires the user to choose between Yes and No. It will usually be accompanied by a 
 * text box that asks the user a yes or no question. */
public class ActionBox {
	
	//The currently selected option
	int currentOption = 0;
	
	//Whether or not the action box is still open
	boolean open;
	
	

	//////////// Constructor ////////////
	
	public ActionBox() {}
	
	
	
	//////////// Getters ////////////
	
	/** Returns whether or not this action box is open. */
	public boolean isOpen() { return open; }
	
	
	/** Returns the current option. */
	public int getCurrentOption() { return currentOption; }
	
	
	
	/////////// Setters ////////////
	
	/** Toggles the action box. */
	public void toggle() { open = !open; }
	
	
	/** Sets the current option of the action box. */
	public void setCurrentOption(int i) { currentOption = i; }
	
	
	/** Sets whether or not the action box is open based on the parameter. */
	public void setOpen(boolean b) { open = b; }
	
	
	
	/////////// Abstract Methods /////////////
	
	public void initialize() {}
	
	
	public void update(double time) {}
	
	
	public void draw(Graphics2D g) {
		if(open == true) {
			//Draw the outline of the box
			g.setColor(Color.white);
			g.fillRoundRect(Orbs.WIDTH - 60, Orbs.HEIGHT - 150, 55, 50, 20, 20);
			
			//Draw the text options
			g.setColor(Color.black);
			g.drawString("YES", Orbs.WIDTH - 43, Orbs.HEIGHT - 130);
			g.drawString("NO", Orbs.WIDTH - 43, Orbs.HEIGHT - 110);
			
			//Draw the little arrow indicator
			if(currentOption == 0) { g.fillRect(Orbs.WIDTH - 53, Orbs.HEIGHT - 138, 7, 7); }
			else { g.fillRect(Orbs.WIDTH - 53, Orbs.HEIGHT - 118, 7, 7); }
		}
	}
}
