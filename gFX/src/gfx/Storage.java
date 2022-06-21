package gfx;

import java.util.Vector;

public class Storage {
	private Game game;
	private Vector<GameElement> managedElements;
	
	public Storage(Game game) {
		this.managedElements = new Vector<GameElement>();
		this.game = game;
	}
	
	public void addManagedElement(GameElement element) {
		this.managedElements.add(element);
	}
	
	public void clearElements() {
		Vector<GameElement> elements = new Vector<GameElement>();
		for(var e : this.managedElements) {
			if(!e.isEnabled()) {
				for(var scene : game.getScenes()) {
					scene.removeElement(e);
				}
				elements.add(e);
			}
		}
		this.managedElements.removeAll(elements);
	}
	
}
