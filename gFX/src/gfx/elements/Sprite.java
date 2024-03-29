package gfx.elements;

import gfx.Game;
import gfx.GameBehavior;
import gfx.RenderTarget;
import gfx.math.Rect;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Sprite extends gfx.GameElement {
	private Image sprite;
	
	public Sprite(String name, Vector2 location, Vector2 size, Image sprite) {
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.sprite = sprite;
	}
	
	public Sprite(String name, Vector2 location, Image sprite) {
		this.setName(name);
		this.setLocation(location);
		this.setSize(new Vector2(sprite.getWidth(), sprite.getHeight()));
		this.sprite = sprite;
	}	
	
	@Override
	public void render(Game game, GraphicsContext g) {
		// TODO Auto-generated method stub
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.beforeRender(g);
		}
		if(sprite != null) {
			g.save();
			Rotate rotate = new Rotate(this.getRotation(), this.getCenterLocation().getX(), this.getCenterLocation().getY());
			g.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(), rotate.getTx(), rotate.getTy());
			g.drawImage(sprite, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
			g.restore();
		}		
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.afterRender(g);
		}
	}

	@Override
	public void update(Game game,RenderTarget target) {
		// TODO Auto-generated method stub
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.onUpdate(game);
		}
		
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		if(sprite != null) {
			this.sprite = sprite;
		}
	}
	
	public boolean containsPoint(double x, double y) {
		if(x > this.getLocation().getX() && x < (this.getLocation().getX() + this.getSize().getX()) && y > this.getLocation().getY() && y < (this.getLocation().getY() + this.getSize().getY())) {
			return true;
		}
		return false;
	}
	
	public void calculateFromHeight(double height) {
		double newWidth = (this.getSize().getX() / this.getSize().getY() * height);
		this.getSize().setX(newWidth);
		this.getSize().setY(height);
	}
	
	public double getSpriteResoulution() {
		return this.getSize().getY() / this.getSize().getX();
	}
	
	public Rect getBounds() {
		return new Rect(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
	}
	
}
