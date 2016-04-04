package MISC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Assets;
import MOVEABLE.NPC;

public class TextBox implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2699903250748120800L;
	
	//The speech that the text box should display
	public ArrayList<String> speech = new ArrayList<String>();
	
	//The index in the speech list.
	public int speechIndex = 0;
	
	//Number of lines to draw
	int numLines = 1;
	
	//If an NPC is saying this text, use this npc object.
	NPC thisnpc;
	
	//Position and size of the textbox.
	public Vector2D position = new Vector2D(0,350);
	
	//The width, height, and amount of spacing from the boundaries.
	public int Width = 640, Height = 98, spacingW = 10, spacingH = 23;
	
	//If it is open
	public static boolean Open;
	
	
	
	//Constructor
	public TextBox() {}
	public TextBox(NPC c) { thisnpc = c; }
	public TextBox(Vector2D pos, int w, int h) { position = pos; Width = w; Height = h; }

	/** Add speech for this text box to display. */
	public void addText(String text) { speech.add(text); }
	
	/** Removes speech from this text box. */
	public void removeText(String text) { if(speech.contains(text)) { speech.remove(text); } }
	
	/** Removes all of the speech in this text box. */
	public void removeAllSpeech() { speech.removeAll(speech); }
	
	/** Go to the next line of speech in the list. Returns true if it successfully moved to the next text slide,
	 * false otherwise. */
	public boolean goToNext() {
		if(speechIndex + 1 < speech.size()) {
			speechIndex++;
			return true;
		} else {
			Open = false;
			speechIndex = 0;
			return false;
		}
	}
	
	/** Sets the number of lines for this text box to display. */
	public void setLineNum(int i) { numLines = i; }

	@Override
	public void initialize() {}

	@Override
	public void update(double time) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		//Draw text box image.
		g.drawImage(Assets.textBox, (int)position.X, (int)position.Y, Width, Height, null);
		
		
		if(!speech.isEmpty()) {
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 15));
			
			//Draw the text in the text box.
			if(numLines == 1)
				drawText(g);
			else 
				drawSpecificLines(g);
			
			if(speechIndex != speech.size()-1) {
				g.drawImage(Assets.textBoxClick, 600, 410, 32, 32, null);
			}
		}
	}
	
	/**Algorithm for drawing the text in a text box, line by line.*/
	private void drawText(Graphics2D g) {
		//If it is less than 92 characters long.
		if(speech.get(speechIndex).length() < 92) {
			if(thisnpc != null)
				g.drawString(thisnpc.Name() + ": " + speech.get(speechIndex), (int)position.X+spacingW, (int)position.Y+spacingH);	
			else
				g.drawString(speech.get(speechIndex), (int)position.X+spacingW, (int)position.Y+spacingH);
		} else {
			
			//The number of lines to draw, depending on the maximum number of characters allowed (92).
			int drawLines = speech.get(speechIndex).length()/92;
			
			//If the number of lines does not compute evenly, just draw an extra line of text.
			if(drawLines%92 != 0) {
				
				int tempY = (int)position.Y;
				int start = 0, end = 75;
				
				for(int i = 0; i < drawLines+1; i++) {
					//Only write the speaker's name if it is the first line.
					if(i == 0)
						if(thisnpc != null)
							g.drawString(thisnpc.Name() + ": " + speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
						else 
							g.drawString(speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
					else 
						g.drawString(speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
					
					//Move down the text box.
					tempY += 25;
					//Move on to the next part of the text
					start = end;
					if(end+end > speech.get(speechIndex).length())
						end = speech.get(speechIndex).length();
					else
						end = end+end;
				}
				
			} else {
				int tempY = (int)position.Y;
				int start = 0, end = 91;
				
				for(int i = 0; i < drawLines; i++) {
					if(i == 0)
						if(thisnpc != null)
							g.drawString(thisnpc.Name() + ": " + speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
						else 
							g.drawString(speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
					else 
						g.drawString(speech.get(speechIndex).substring(start, end), (int)position.X+spacingW, (int)tempY+spacingH);
					tempY += 25;
					start = end + 1;
					end += end;
				}
			}
			
		}
	}
	
	private void drawSpecificLines(Graphics2D g) {
		int tempY = (int)position.Y;
		
		for(int i = 0; i < numLines; i++) {
			g.drawString(speech.get(i), position.X+spacingW, tempY+spacingH);
			tempY += 35;
		}
	}
}
