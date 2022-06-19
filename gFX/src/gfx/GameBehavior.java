package gfx;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameBehavior {
	private GameElement parent;
	
	public abstract void onInit(Game game);
	public abstract void onUpdate(RenderTarget renderTarget);
	public abstract void beforeRender(GraphicsContext g);
	public abstract void afterRender(GraphicsContext g);
    
	public GameElement getParent() {
		return parent;
	}
	
	public void setParent(GameElement parent) {
		this.parent = parent;
	}
	
}
