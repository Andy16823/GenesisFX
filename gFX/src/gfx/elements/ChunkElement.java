package gfx.elements;

import gfx.GameElement;
import gfx.math.Vector2;

public class ChunkElement {
	private GameElement element;
	private Vector2 relativeLocation;
	
	public ChunkElement(GameElement element, Vector2 relativeLocation) {
		super();
		this.element = element;
		this.relativeLocation = relativeLocation;
	}
	
	public GameElement getElement() {
		return element;
	}
	public void setElement(GameElement element) {
		this.element = element;
	}
	public Vector2 getRelativeLocation() {
		return relativeLocation;
	}
	public void setRelativeLocation(Vector2 relativeLocation) {
		this.relativeLocation = relativeLocation;
	}
	
	
}
