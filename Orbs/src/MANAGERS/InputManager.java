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
			worldState.getPlayer().setDirection(2);
			if(worldState.getWorld().canMoveUp()) worldState.getWorld().position.Y++; worldState.getWorld().up = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			worldState.getPlayer().setDirection(0);
			if(worldState.getWorld().canMoveDown()) worldState.getWorld().position.Y--; worldState.getWorld().down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			worldState.getPlayer().setDirection(1);
			if(worldState.getWorld().canMoveRight()) worldState.getWorld().position.X--; worldState.getWorld().right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			worldState.getPlayer().setDirection(3);
			if(worldState.getWorld().canMoveLeft()) worldState.getWorld().position.X++; worldState.getWorld().left = true;
		}
		
	}
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) worldState.getWorld().up = false;
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) worldState.getWorld().down = false;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) worldState.getWorld().right = false;
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) worldState.getWorld().left = false;
	}
}
