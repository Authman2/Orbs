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
			if(worldState.getWorld().canMoveUp()) worldState.getWorld().position.Y++;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(worldState.getWorld().canMoveDown()) worldState.getWorld().position.Y--;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(worldState.getWorld().canMoveRight()) worldState.getWorld().position.X--;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(worldState.getWorld().canMoveLeft()) worldState.getWorld().position.X++;
		}
		
	}
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
