package MANAGERS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import STATES.MenuState;
import STATES.WorldState;

public class InputManager implements KeyListener {

	public MenuState menuState;
	public WorldState worldState;
	
	
	public GameStateManager gsm;
	

	
	public InputManager(GameStateManager gsm) {
		this.gsm = gsm;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		if(gsm.currentState == menuState) {
			
			MenuStateActions(e);
			
		}
		
		if(gsm.currentState == worldState) {
			
			WorldStateActions(e);
			
		}
	}
	
	private void MenuStateActions(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			menuState.selectedOption = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			menuState.selectedOption = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(menuState.selectedOption == 0) {
				gsm.currentState = gsm.gameStates[1];
			}
			if(menuState.selectedOption == 1) {
				System.exit(0);
			}
		}
	}
	
	
	private void WorldStateActions(KeyEvent e) {
		
		/* MOVING THE GAME MAP */
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			for(int i = 0; i < worldState.getWorld().getTileMap().length; i++) {
				for(int j = 0; j < worldState.getWorld().getTileMap()[0].length; j++) {
					worldState.getWorld().getTileMap()[i][j].position.Y++;
				}
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			for(int i = 0; i < worldState.getWorld().getTileMap().length; i++) {
				for(int j = 0; j < worldState.getWorld().getTileMap()[0].length; j++) {
					worldState.getWorld().getTileMap()[i][j].position.Y--;
				}
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(int i = 0; i < worldState.getWorld().getTileMap().length; i++) {
				for(int j = 0; j < worldState.getWorld().getTileMap()[0].length; j++) {
					worldState.getWorld().getTileMap()[i][j].position.X--;
				}
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(int i = 0; i < worldState.getWorld().getTileMap().length; i++) {
				for(int j = 0; j < worldState.getWorld().getTileMap()[0].length; j++) {
					worldState.getWorld().getTileMap()[i][j].position.X++;
				}
			}
		}
		
	}
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
