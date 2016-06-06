package MANAGERS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ENTITIES.Entity;
import ENTITIES.NPC;
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
	
	
	/** Navigating the main menu. */
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
	
	
	/** Moving about the game world. */
	private void WorldStateActions(KeyEvent e) {
		
		/* MOVING THE GAME MAP */
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			worldState.getPlayer().setDirection(2);
			if(worldState.getWorld().canMoveUp()) {
				worldState.getWorld().position.Y++;
				for(Entity ent : worldState.getWorld().getEntities()) ent.position.Y++;
				worldState.getWorld().up = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			worldState.getPlayer().setDirection(0);
			if(worldState.getWorld().canMoveDown()) {
				worldState.getWorld().position.Y--; 
				for(Entity ent : worldState.getWorld().getEntities()) ent.position.Y--;
				worldState.getWorld().down = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			worldState.getPlayer().setDirection(1);
			if(worldState.getWorld().canMoveRight()) {
				worldState.getWorld().position.X--; 
				for(Entity ent : worldState.getWorld().getEntities()) ent.position.X--;
				worldState.getWorld().right = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			worldState.getPlayer().setDirection(3);
			if(worldState.getWorld().canMoveLeft()) {
				worldState.getWorld().position.X++; 
				for(Entity ent : worldState.getWorld().getEntities()) ent.position.X++;
				worldState.getWorld().left = true;
			}
		}
		
		
		/* INTERACTION */
		if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_C) {
			PlayerInteractions(e);
		}
	}
	
	
	/** Interacting with entities in the game world. */
	private void PlayerInteractions(KeyEvent e) {
		
		//First check if there is already a text box open
		for(Entity ent : worldState.getWorld().getEntities()) {
			
			//If a text box IS open, then just go through each slide as you normally would.
			if( ((NPC) ent).getTextBox().isOpen() ) {
				
				((NPC) ent).getTextBox().nextSlide();
				
			} else {
				
				//If a text box was not already open, then open one up.
				if(((NPC) ent).isNextTo(worldState.getPlayer())) {
					
					((NPC) ent).getTextBox().toggle();
					
				}
				
			}
		}
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		//Stop moving in all directions if the keys are not being held down.
		
		if(e.getKeyCode() == KeyEvent.VK_UP) worldState.getWorld().up = false;
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) worldState.getWorld().down = false;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) worldState.getWorld().right = false;
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) worldState.getWorld().left = false;
	}
}
