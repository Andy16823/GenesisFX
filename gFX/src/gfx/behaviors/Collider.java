package gfx.behaviors;

import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Rect;
import gfx.math.Vector2;
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
	public abstract void onUpdate(Game game);

	@Override
	public abstract void beforeRender(GraphicsContext g);

	@Override
	public abstract void afterRender(GraphicsContext g);
	
	public abstract boolean contains(double x, double y);
		
	public void setElements(Vector<GameElement> elements) {
		this.elements = elements;
	}

	public abstract boolean isCollision();
	public abstract boolean isCollision(double x, double y);
	public abstract boolean isCollision(Vector2[] ref);
	public abstract boolean isCollision(Vector2 ref);
	public abstract boolean isCollision(Vector<GameElement> elements);
	public abstract boolean isCollision(GameElement element);
	public abstract boolean isCollision(Rect rect);
	public abstract GameElement getCollision();
	public abstract GameElement getCollision(double x, double y);
	public abstract GameElement getCollision(Vector2[] ref);
	public abstract GameElement getCollision(Vector<GameElement> elements);
	public abstract Vector<Vector2> filterCoords(Vector2[] ref);

	public Vector<GameElement> getElements() {
		return elements;
	}

}
