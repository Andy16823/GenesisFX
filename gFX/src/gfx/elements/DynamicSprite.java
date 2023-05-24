package gfx.elements;

import gfx.Game;
import gfx.RenderTarget;
import gfx.math.Rect;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DynamicSprite extends Sprite {
	private boolean _enableRendering = true;
	private boolean _isVisible;

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
		Rect stageRect = new Rect(0, 0, game.getStage().getWidth(), game.getStage().getHeight());
		
		if(stageRect.intersects(this.getBounds())) {
			if(_isVisible == false) {
				_isVisible = true;
			}
			if(_enableRendering) {
				super.render(game, g);
			}
		}
		else {
			if(_isVisible == true) {
				_isVisible = false;
			}
		}
//		if(this.getLocation().getX() >= 0 && this.getLocation().getY() >= 0 && this.getLocation().getX() <= game.getStage().getWidth() && this.getLocation().getY() <= game.getStage().getHeight()) {
//			if(_enableRendering) {
//				super.render(game, g);
//			}
//		}
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
	
	public boolean isVisible() {
		return _isVisible;
	}
	
	public Rect getBounds() {
		return new Rect(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
	}
}
