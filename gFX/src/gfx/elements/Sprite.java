package gfx.elements;

import gfx.GameBehavior;
import gfx.RenderTarget;
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
	
	@Override
	public void render(GraphicsContext g) {
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
	public void update(RenderTarget target) {
		// TODO Auto-generated method stub
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.onUpdate(target);
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
	
}
