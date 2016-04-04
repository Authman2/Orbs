package MOVEABLE;

import java.io.Serializable;

public class PlayerStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527204201611277905L;
	private float health, maxHealth = 100;
	
	public PlayerStats() {
		
	}

	public void addHealth(float amount) { if(health + amount <= maxHealth) { health += amount; } else { health = maxHealth; } }
	public float Health() { return health; }
	
}
