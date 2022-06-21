package gfx.behaviors;

import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class BoxCollider extends Collider {
	private boolean debugMode = false;
	
	public BoxCollider() { 
	}
	
	
	@Override
	public void onInit(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpdate(RenderTarget renderTarget) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeRender(GraphicsContext g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterRender(GraphicsContext g) {
		// TODO Auto-generated method stub
		if(this.debugMode) {
			Paint oldPaint = g.getStroke();
			g.setStroke(Color.BLUE);
			g.strokeRect(this.getParent().getLocation().getX(), this.getParent().getLocation().getY(), this.getParent().getSize().getX(), this.getParent().getSize().getY());
			g.setStroke(oldPaint);
		}
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		if(x > this.getParent().getLocation().getX() && x < (this.getParent().getLocation().getX() + this.getParent().getSize().getX()) && y > this.getParent().getLocation().getY() && y < (this.getParent().getLocation().getY() + this.getParent().getSize().getY())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCollision() {
		// TODO Auto-generated method stub
		for(GameElement element : this.getElements()) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				// Top left
				if(elementCollider.contains(this.getParent().getLocation().getX(), this.getParent().getLocation().getY())) {
					return true;
				}
				// Top right
				else if(elementCollider.contains(this.getParent().getLocation().getX() + this.getParent().getSize().getX(), this.getParent().getLocation().getY())) {
					return true;
				}
				// Bottom right
				else if(elementCollider.contains(this.getParent().getLocation().getX() + this.getParent().getSize().getX(), this.getParent().getLocation().getY() + this.getParent().getSize().getY())) {
					return true;
				}
				// Bottom left
				else if(elementCollider.contains(this.getParent().getLocation().getX(), this.getParent().getLocation().getY() + this.getParent().getSize().getY())) {
					return true;
				}
				// Center
				else if(elementCollider.contains(this.getParent().getCenterLocation().getX(), this.getParent().getCenterLocation().getY())) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public boolean isCollision(double x, double y) {
		// TODO Auto-generated method stub
		for(GameElement element : this.getElements()) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				// Top left
				if(elementCollider.contains(x, y)) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public GameElement getCollision() {
		// TODO Auto-generated method stub
		for(GameElement element : this.getElements()) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				// Top left
				if(elementCollider.contains(this.getParent().getLocation().getX(), this.getParent().getLocation().getY())) {
					return element;
				}
				// Top right
				else if(elementCollider.contains(this.getParent().getLocation().getX() + this.getParent().getSize().getX(), this.getParent().getLocation().getY())) {
					return element;
				}
				// Bottom right
				else if(elementCollider.contains(this.getParent().getLocation().getX() + this.getParent().getSize().getX(), this.getParent().getLocation().getY() + this.getParent().getSize().getY())) {
					return element;
				}
				// Bottom left
				else if(elementCollider.contains(this.getParent().getLocation().getX(), this.getParent().getLocation().getY() + this.getParent().getSize().getY())) {
					return element;
				}
				// Center
				else if(elementCollider.contains(this.getParent().getCenterLocation().getX(), this.getParent().getCenterLocation().getY())) {
					return element;
				}
			}
		}
		return null;
	}

	@Override
	public GameElement getCollision(double x, double y) {
		// TODO Auto-generated method stub
		for(GameElement element : this.getElements()) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				// Top left
				if(elementCollider.contains(x, y)) {
					return element;
				}
			}
		}
		return null;
	}


	public boolean isDebugMode() {
		return debugMode;
	}


	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}
	
}
