package gfx.behaviors;

import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import javafx.scene.canvas.GraphicsContext;

public abstract class Collider extends GameBehavior {
	private Vector<GameElement> elements;

	public Collider() {
		this.elements = new Vector<>(); 
	}
	
	public void addElements(Vector<GameElement> elements) {
		this.elements.addAll(elements);
	}
	
	public void addElement(GameElement element) {
		this.elements.add(element);
	}
	
	@Override
	public abstract void onInit(Game game);

	@Override
	public abstract void onUpdate(RenderTarget renderTarget);

	@Override
	public abstract void beforeRender(GraphicsContext g);

	@Override
	public abstract void afterRender(GraphicsContext g);
	
	public abstract boolean contains(double x, double y);
	
	public abstract boolean isCollision();
	public abstract boolean isCollision(double x, double y);
	public abstract GameElement getCollision();
	public abstract GameElement getCollision(double x, double y);

	public Vector<GameElement> getElements() {
		return elements;
	}

}
