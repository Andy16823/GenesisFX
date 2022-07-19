package gfx.behaviors;

import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Rect;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class BoxCollider extends Collider {
	private boolean debugMode = false;
	
	public BoxCollider() { 
	}
	
	
	@Override
	public void onInit(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpdate(Game game) {
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
				if(this.isOverlapping(element)) {
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
				if(this.isOverlapping(element)) {
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

	@Override
	public void onAttach(GameElement element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isCollision(Vector<GameElement> elements) {
		for(GameElement element : elements) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				if(this.isOverlapping(element)) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public GameElement getCollision(Vector<GameElement> elements) {
		// TODO Auto-generated method stub
		for(GameElement element : elements) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				if(this.isOverlapping(element)) {
					return element;
				}
			}
		}
		return null;
	}
	
	public boolean isOverlapping(GameElement e) {
		Rectangle rect = new Rectangle(this.getParent().getLocation().getX(), this.getParent().getLocation().getY(), this.getParent().getSize().getX(), this.getParent().getSize().getY());   
		return rect.intersects(e.getLocation().getX(), e.getLocation().getY(), e.getSize().getX(), e.getSize().getY());
	}

	@Override
	public boolean isCollision(Vector2 ref) {
		// TODO Auto-generated method stub
		return this.isCollision(ref.getX(), ref.getY());
	}


	@Override
	public boolean isCollision(Vector2[] ref) {
		// TODO Auto-generated method stub
		for(var vec : ref) {
			if(this.isCollision(vec)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public GameElement getCollision(Vector2[] ref) {
		// TODO Auto-generated method stub
		for(var vec : ref) {
			GameElement e = this.getCollision(vec.getX(), vec.getY());
			if(e != null) {
				return e;
			}
		}
		return null;
	}


	@Override
	public Vector<Vector2> filterCoords(Vector2[] ref) {
		// TODO Auto-generated method stub
		Vector<Vector2> freeCords = new Vector<>();
		for(var vec : ref) {
			if(!this.isCollision(vec.getX(), vec.getY())) {
				freeCords.add(vec);
			}
		}
		return freeCords;
	}


	@Override
	public boolean isCollision(Rect rect) {
		// TODO Auto-generated method stub
		for(GameElement element : this.getElements()) {
			Collider elementCollider = (Collider) element.getBehavior2(Collider.class.getSimpleName());
			if(elementCollider != null) {
				if(elementCollider.contains(rect.getX(), rect.getY())) {
					return true;
				}
				else if(elementCollider.contains(rect.getX() + rect.getWidth(), rect.getY())) {
					return true;
				}
				else if(elementCollider.contains(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight())) {
					return true;
				}
				else if(elementCollider.contains(rect.getX(), rect.getY() + rect.getHeight())) {
					return true;
				}
				else if(elementCollider.contains(rect.getX() + (rect.getWidth() / 2), rect.getY() + (rect.getHeight() / 2))) {
					return true;
				}
			}
		}
		return false;
	}
	
}
