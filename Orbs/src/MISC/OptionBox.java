package MISC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MAIN.Assets;
import STATES.InventoryState;

/** This class represents an in-game box that can be used to display choices for the player. */
public class OptionBox extends Rectangle implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2485901171768364774L;

	//The position to display the box at.
	Vector2D position = new Vector2D();
	
	//The width and height of the box.
	int Width, Height;
	
	//The choices for the box to display.
	Option[] choices;
	
	//True/False if this box is currently open (being displayed on screen).
	public transient boolean showChoices, Open;
	
	//The selected option.
	public int selectedOption = 0, maxSelect = 0;
	
	//Optional Header
	public String header;
	
	
	public OptionBox(Vector2D pos, int w, int h) {
		position = pos;
		Width = w;
		Height = h;
	}
	
	public OptionBox addHeader(String header) {
		this.header = header;
		return this;
	}
	
	public OptionBox setChoices(Option[] choices) {
		this.choices = new Option[choices.length];
		for(int i = 0; i < choices.length; i++) {
			this.choices[i] = choices[i];
		}
		maxSelect = choices.length - 1;
		return this;
	}
	
	public int numChoices() { return choices.length; }
	
	
	@Override
	public void initialize() {
		setBounds((int)position.X, (int)position.Y, Width, Height);
	}

	@Override
	public void update(double time) {
		setBounds((int)position.X, (int)position.Y, Width, Height);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(Assets.optionBox, (int)position.X,(int)position.Y, Width, Height, null);
		
		
		if(showChoices) {
			if(header != null) {
				g.setFont(new Font("Arial", 1, 25));
				g.setColor(Color.black);
				g.drawString(header, position.X+20, position.Y+30);
			}
			
			
			if(choices != null) {
				if(header == null) {
					//Draw without the header
					//Temporary height for drawing the strings
					float tempY = position.Y+30;
					for(Option opt : choices) {
						g.setFont(new Font("Arial", 1, 18));
						g.setColor(Color.black);
		
						
						g.drawString(opt.Name(), position.X+35, tempY);
						tempY += 35;
					}
					
					/* Draw the selected choice dot. */
					float tempSelectY = position.Y+10;
					for(int i = 0; i < choices.length; i++) {
						if(selectedOption == i) {
							g.drawImage(Assets.optionClick, (int)position.X+5, (int)tempSelectY, 32, 32, null);
							break;
						}
						tempSelectY += 35;
					}
				} else {
					//Draw with the header
					float tempY = position.Y+75;
					for(Option opt : choices) {
						g.setFont(new Font("Arial", 1, 18));
						g.setColor(Color.black);
		
						
						g.drawString(opt.Name(), position.X+35, tempY);
						tempY += 35;
					}

					/* Draw the selected choice dot. */
					float tempSelectY = position.Y+53;
					for(int i = 0; i < choices.length; i++) {
						if(selectedOption == i) {
							g.drawImage(Assets.optionClick, (int)position.X+5, (int)tempSelectY, 32, 32, null);
							break;
						}
						tempSelectY += 35;
					}
				}
			}
		}
	}

}
