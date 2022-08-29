package gfx.elements;

import gfx.Game;
import gfx.RenderTarget;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DynamicSprite extends Sprite {
	private boolean _enableRendering = true;

	public DynamicSprite(String name, Vector2 location, Vector2 size, Image sprite) {
		super(name, location, size, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public DynamicSprite(String name, Vector2 location, Image sprite) {
		super(name, location, sprite);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void render(Game game, GraphicsContext g) {
		// TODO Auto-generated method stub
		if(this.getLocation().getX() >= 0 && this.getLocation().getY() >= 0 && this.getLocation().getX() <= game.getStage().getWidth() && this.getLocation().getY() <= game.getStage().getHeight()) {
			if(_enableRendering) {
				super.render(game, g);
			}
		}
	}

	@Override
	public void update(Game game, RenderTarget target) {
		// TODO Auto-generated method stub
		super.update(game, target);
	}
		
	public boolean isRendeingEnabled() {
		return _enableRendering;
	}
	
	public void enableRendering() {
		_enableRendering = true;
	}
 	
	public void disableRendering() {
		_enableRendering = false;
	}
}
