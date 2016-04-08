package MANAGERS;

import java.awt.Graphics2D;

import myproject.gos.main.IUD;
import myproject.gos.main.Vector2D;
import MISC.Option;
import MISC.Option.OptionType;
import MISC.OptionBox;
import STATES.StatsState;
import STATES.WorldState;

public class HUDManager implements IUD {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4243192530967794496L;

	//Menu
	public transient OptionBox menu = new OptionBox(new Vector2D(400,20), 170,155);
	
	//World state
	public WorldState worldState;
	public StatsState statsState;

	public HUDManager(WorldState ws) {
		worldState = ws;
	}
	


	@Override
	public void initialize() {
		menu.addHeader("Player Name: ");
		menu.setChoices(new Option[] {new Option("Inventory", OptionType.Inventory),
				  					  new Option("Equipment", OptionType.Equipment),
				  					  new Option("Stats", OptionType.Stats),
				  					  new Option("Save", OptionType.Save)});
		menu.header = null;
		menu.showChoices = true;
		menu.initialize();
	}
	
	@Override
	public void draw(Graphics2D g) {		
		if(menu.Open) {
			menu.draw(g);
		}
	}

	@Override
	public void update(double time) {
		
		if(menu.Open) {
			menu.showChoices = true;
			menu.maxSelect = 3;
			menu.update(time);
		}
		
	}

}
