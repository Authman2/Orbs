package STATES;

import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import MANAGERS.GameStateManager;
import MISC.TextBox;

//Not an actually drawn state, just used for saving data.
public class SaveState extends GameState {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6971942956258192224L;

	public static TextBox saveSuccessTextbox;
	public boolean saveSuccessful;
	
	public SaveState(GameStateManager gsm) {
		super(gsm);
		saveSuccessTextbox = new TextBox();
		saveSuccessTextbox.addText("You have successfully saved the game!");
	}

	public void SaveGame(Object t, String savename) {
		try {
			FileOutputStream fileOut = new FileOutputStream("/Users/adeouthman/Documents/AdeolasCodingStuff/" + savename + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			System.out.println("Saved!");
			saveSuccessful = true;
		} catch(IOException i) {
			saveSuccessful = false;
			i.printStackTrace();
		}
	}
	
	
	public boolean SaveSuccessful() { return saveSuccessful; }
	
	@Override
	public void initialize() {
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void update(double time) {
		if(SaveSuccessful()) {
			saveSuccessTextbox.Open = true;
			saveSuccessTextbox.update(time);
		} else {
			saveSuccessTextbox.Open = false;
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void draw(Graphics2D g) {
		if(SaveSuccessful()) {
			saveSuccessTextbox.Open = true;
			saveSuccessTextbox.draw(g);
		} else {
			saveSuccessTextbox.Open = false;
		}
	}

}
