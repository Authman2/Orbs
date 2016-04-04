package STATES;

import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import MANAGERS.GameStateManager;

public class LoadState extends GameState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4432542937762612525L;

	public LoadState(GameStateManager gsm) {
		super(gsm);
	}
	
	//Make sure to cast this method to the type of object you want to load.
	public Object LoadGame(Object j, String savename) {
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream("/Users/adeouthman/Documents/AdeolasCodingStuff/" + savename + ".ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(fileIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			j = in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loaded!");
		
		return j;
	}

	@Override
	public void initialize() {}

	@Override
	public void update(double time) {}

	@Override
	public void draw(Graphics2D g) {}

	

}
