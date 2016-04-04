package MISC;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import myproject.gos.main.ArrayConversion;
import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MANAGERS.GameStateManager;
import STATES.CreatePlayerState;

public class KeyBoard extends Rectangle implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6532021476570278680L;

	//Position of the keyboard
	public Vector2D position = new Vector2D(10,1);
	
	//Alphabet and Numbers
	String[] ann = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9",".",",","-","+","←","Done"};
	KeyboardKey[] keychoices = new KeyboardKey[ann.length];
	
	//This must be casted to an array of keyboard keys.
	public Object[][] keys;
	public KeyboardKey selectedKey;

	//The text box to display the name that the user is typing in.
	TextBox textBox = new TextBox();
	
	//Says if the text has been set.
	public static boolean textSet;
	
	//CP.State
	public CreatePlayerState createplayer;
	
	
	public KeyBoard() {
		
	}
	public KeyBoard(CreatePlayerState cps) {
		createplayer = cps;
	}
	
	@Override
	public void initialize() {
		setBounds((int)position.X, (int)position.Y, 400,400);
		textBox.addText("Choose a name for the player: " + createplayer.playerName);
		
		//Set the initial array.
		for(int i = 0; i < ann.length; i++) {
			keychoices[i] = new KeyboardKey(ann[i],this);
		}
				
		//Create the 2D array of keys
		keys = ArrayConversion.OneToTwo(keychoices, 6);
		
		for(int i = 0; i < keys.length; i++) {
			for(int j = 0; j < keys[0].length; j++) {
				//Set the position of each key.
				((KeyboardKey)keys[i][j]).setPosition(new Vector2D(position.X+i,position.Y+j));
			}
		}
		
		selectedKey = ((KeyboardKey)keys[0][0]);
	}

	@Override
	public void update(double time) {
		setBounds((int)position.X, (int)position.Y, 400,400);
		textBox.speech.set(0, "Choose a name for the player: " + createplayer.playerName);
		textBox.update(time);
		
		for(int i = 0; i < keys.length; i++) {
			for(int j = 0; j < keys[0].length; j++) {
				if(!textSet)
					((KeyboardKey)keys[i][j]).update(time);
			}
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		for(int i = 0; i < keys.length; i++) {
			for(int j = 0; j < keys[0].length; j++) {
				((KeyboardKey)keys[i][j]).draw(g);
			}
		}
		
		textBox.draw(g);
	}
	
	
	
	
}
