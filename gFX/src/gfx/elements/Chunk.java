package gfx.elements;

import java.util.Map;
import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Rect;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class Chunk extends GameElement{
	private Vector<ChunkElement> elements;
	private double transformX;
	private double transformY;

	public Chunk(String name, Vector2 location, Vector2 size) {
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.elements = new Vector<>();
	}
	
	public void addElement(GameElement e) {
		double relX = e.getLocation().getX() - this.getLocation().getX();
		double relY = e.getLocation().getY() - this.getLocation().getY();
		
		this.elements.add(new ChunkElement(e, new Vector2(relX, relY)));
	}
	
	@Override
	public void render(Game game, GraphicsContext g) {
		// TODO Auto-generated method stub
		if(this.isEnabled()) {
			for(GameBehavior behavior : this.getBehaviors()) {
				behavior.beforeRender(g);
			}
			for(var e : elements) {
				if(e.getElement().isEnabled()) {
					for(GameBehavior behavior : e.getElement().getBehaviors()) {
						behavior.beforeRender(g);
					}
					e.getElement().render(game, g);
					for(GameBehavior behavior : e.getElement().getBehaviors()) {
						behavior.afterRender(g);
					}
				}
			}
			for(GameBehavior behavior : this.getBehaviors()) {
				behavior.afterRender(g);
			}
		}
	}

	@Override
	public void update(Game game, RenderTarget target) {
		// TODO Auto-generated method stub
		if(this.isEnabled()) {
			for(GameBehavior behavior : this.getBehaviors()) {
				behavior.onUpdate(game);
			}
			for(var e : elements) {
				if(e.getElement().isEnabled()) {
					e.getElement().update(game, target);
				}
			}
		}
	}
	
	
	
	
	@Override
	public void transformElement(double x, double y) {
		// TODO Auto-generated method stub
		super.transformElement(x, y);
		if(this.isEnabled()) {
			for(var e : elements) {
				e.getElement().setLocation(new Vector2(this.getLocation().getX() + e.getRelativeLocation().getX(),this.getLocation().getY() + e.getRelativeLocation().getY()));
			}
		}
	}
	
	

	public Vector<ChunkElement> getElements() {
		return this.elements;
	}
	
	public Rect getBounds() {
		return new Rect(this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
	}

}
