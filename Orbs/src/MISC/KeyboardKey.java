package MISC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;

public class KeyboardKey implements IUD {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8394257481316445075L;
	Vector2D position;
	String Key;
	public KeyBoard keyboard;
	
	public KeyboardKey(Vector2D pos, String key, KeyBoard k) {
		position = pos;
		this.Key = key;
		keyboard = k;
	}
	public KeyboardKey(String key, KeyBoard k) {
		position  = new Vector2D();
		this.Key = key;
		keyboard = k;
	}
	
	public KeyboardKey setPosition(Vector2D pos) {
		position = pos;
		return this;
	}

	public String getKeyChar() { return Key; }
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect((int)position.X*32, (int)position.Y*32, 32, 32);
		
		if(keyboard.selectedKey == this) {
			g.setColor(Color.red);
			g.fillRect((int)position.X*32, (int)position.Y*32, 32, 32);
		}
		
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",1,15));
		g.drawString(Key,position.X*32+10,position.Y*32+15);
		
	}

}
