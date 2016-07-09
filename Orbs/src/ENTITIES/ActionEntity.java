package ENTITIES;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import MISC.ActionBox;
import visualje.Vector2D;

/** An ActionEntity is something that the player must decide what action to take after interacting with it. */
public class ActionEntity extends NPC {

	
	//The question that will be displayed in the text box of this entity. 
	String actionQuestion = "";
	
	
	//An action box that asks the user what to do
	ActionBox actionBox;
	
	
	//The name used to identify a particular action entity
	String name = "";
	
	
	
	///////////// Constructors //////////////
	
	public ActionEntity() { renderSprite = true; actionBox = new ActionBox(); }
	
	public ActionEntity(String message) { actionQuestion = message; textBox.addText(message); renderSprite = true; actionBox = new ActionBox(); }

	public ActionEntity(Vector2D pos) { super(pos); renderSprite = true; actionBox = new ActionBox(); }

	public ActionEntity(BufferedImage sprite) { super(sprite); renderSprite = true; actionBox = new ActionBox(); }

	
	
	//////////// Setters //////////////
	
	/** Sets the question that this ActionEntity's text box should display. */
	public void setActionQuestion(String question) { actionQuestion = question; textBox.addText(question); }
	
	
	/** Sets the name of the action entity. */
	public void setName(String n) { name = n; }
	
	
	//////////// Getters /////////////
	
	/** Returns the action box that this action entity has. */
	public ActionBox getActionBox() { return actionBox; }
	
	
	/** Returns the name of the action entity. */
	public String getName() { return name; }
	
	
	//////////// Abstract Methods ////////////
	
	@Override
	public void initialize() {
		super.initialize();
		if(actionBox.isOpen()) actionBox.initialize();
	}
	
	@Override
	public void update(double time) {
		super.update(time);
		if(actionBox.isOpen()) actionBox.update(time);
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		if(actionBox.isOpen()) actionBox.draw(g);
	}
	
}
