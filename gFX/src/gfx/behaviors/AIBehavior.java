package gfx.behaviors;

import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.Layer;
import gfx.RenderTarget;
import gfx.behaviors.BoxCollider;
import gfx.behaviors.Collider;
import gfx.math.Rect;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;

class Waypoint
{
    public Vector2 point; 
    public double offsetX;  
    public double offsetY; 
};

public class AIBehavior extends GameBehavior {
	private GameElement target;
	private BoxCollider collider;
	private boolean followTarget = true;
	private boolean checkCollision = false;
	private float minDist = 20f;
	private float speed = 1.5f;
	private String collisionLayer;
	private Rect nextRect;		
	private double offsetX = 0;
	private double offsetY = 0;
	
	public AIBehavior(GameElement target, float minDist, boolean follow) {
		this.target = target;
		this.minDist = minDist;
		this.followTarget = follow;
		this.collider = new BoxCollider();
	}
	

	@Override
	public void afterRender(GraphicsContext g) {
		// TODO Auto-generated method stub
//		Vector2 front = Vector2.towards((float) this.getParent().getRotation(),(float) this.getParent().getSize().getY(), this.getParent().getCenterLocation());
//		g.strokeLine(this.getParent().getCenterLocation().getX(), this.getParent().getCenterLocation().getY(), front.getX(), front.getY());
//		
//		if(this.nextRect != null) {
//			g.strokeRect(nextRect.getX(), nextRect.getY(), nextRect.getWidth(), nextRect.getHeight());
//		}

	}

	@Override
	public void beforeRender(GraphicsContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInit(Game arg0) {
		// TODO Auto-generated method stub

	}
		
	@Override
	public void onAttach(GameElement arg0) {
		// TODO Auto-generated method stub
		arg0.addBehavior(collider);
	}
	
	@Override
	public void onUpdate(Game g) {
		// recalculates the rect
		double nowOffsetX = g.getSelectedScene().getTransform().getX() - offsetX; 
		double nowOffsetY = g.getSelectedScene().getTransform().getY() - offsetY;
		if(this.nextRect != null) {
			this.nextRect.add(nowOffsetX, nowOffsetY);
			this.offsetX = g.getSelectedScene().getTransform().getX();
			this.offsetY = g.getSelectedScene().getTransform().getY();
		}
			
		// checks if a target is set and checks if the parent reachs the nextRect. If yes a new target get set
		if(target != null) {
			if(this.followTarget) {
				if(this.checkCollision) {
					if(Vector2.getDistance(this.getParent().getCenterLocation(), this.target.getCenterLocation()) > 30) {
						if(this.nextRect == null) {
							this.offsetX = g.getSelectedScene().getTransform().getX();
							this.offsetY =  g.getSelectedScene().getTransform().getY();
							this.nextRect = new Rect(this.getParent().getLocation().getX(), this.getParent().getLocation().getY(), this.getParent().getSize().getX(), this.getParent().getSize().getY());
						} else {
							if(this.nextRect.contains(this.getParent().getCenterLocation().getX() , this.getParent().getCenterLocation().getY())) {
								findPath(g);
							}
						}
						if(this.nextRect != null) {
							rotateAt(new Vector2(nextRect.getX() + (nextRect.getWidth() / 2), nextRect.getY() + (nextRect.getHeight() /2)));
							move();
							//System.out.println(this.getParent().getLocation().getX() + " -- " + this.getParent().getLocation().getY());
						}
					}	
				}	
				else {
					rotateAt(this.target.getCenterLocation());
					move();
				}
			}
		}		
	}
	
	
	public void findPath(Game game) {
		Rect topLeftRect = new Rect(this.nextRect.getX() - this.nextRect.getWidth(), this.nextRect.getY() - this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect topRect = new Rect(this.nextRect.getX(), this.nextRect.getY() - this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect topRightRect = new Rect(this.nextRect.getX() + this.nextRect.getWidth(), this.nextRect.getY() - this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect midRightRect = new Rect(this.nextRect.getX() + this.nextRect.getWidth(), this.nextRect.getY(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect bottRightRect = new Rect(this.nextRect.getX() + this.nextRect.getWidth(), this.nextRect.getY() + this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect bottRect = new Rect(this.nextRect.getX(), this.nextRect.getY() + this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect bottLeftRect = new Rect(this.nextRect.getX() - this.nextRect.getWidth(), this.nextRect.getY() + this.nextRect.getHeight(), this.nextRect.getWidth(), this.nextRect.getHeight());
		Rect midLeftRect = new Rect(this.nextRect.getX() - this.nextRect.getWidth(), this.nextRect.getY(), this.nextRect.getWidth(), this.nextRect.getHeight());
		double topdist = Vector2.getDistance(target.getCenterLocation(), new Vector2(topRect.getX(), topRect.getY()));
		double bottdist = Vector2.getDistance(target.getCenterLocation(), new Vector2(bottRect.getX(), bottRect.getY()));
		double diffy = Math.abs(topdist - bottdist);
		
		double leftdist = Vector2.getDistance(target.getCenterLocation(), new Vector2(midLeftRect.getX(), midLeftRect.getY()));
		double rightdist = Vector2.getDistance(target.getCenterLocation(), new Vector2(midRightRect.getX(), midRightRect.getY()));
		double diffx = Math.abs(leftdist - rightdist);
		
		Vector<Rect> rectsToCheck = new Vector<Rect>();
		rectsToCheck.add(topLeftRect);
		rectsToCheck.add(topRect);
		rectsToCheck.add(topRightRect);
		rectsToCheck.add(midRightRect);
		rectsToCheck.add(bottRightRect);
		rectsToCheck.add(bottRect);
		rectsToCheck.add(bottLeftRect);
		rectsToCheck.add(midLeftRect);
		
		Rect potNext = null;
		double potNextDist = 0;
		
		this.getCollider().setElements(game.getSelectedScene().getLayer(this.collisionLayer).getGameElements());
		for(var rect : rectsToCheck) {
			if(!this.collider.isCollision(rect)) {
				double dist = Vector2.getDistance(target.getCenterLocation(), new Vector2(rect.getX(), rect.getY()));
				double fieldValue = dist;
				
				if(diffx < rect.getWidth() && rect == midRightRect) {
					continue;
				}
				
				if(diffy < rect.getWidth() && rect == bottRect) {
					continue;
				}
				
				if(potNext == null) {
					potNext = rect;
					potNextDist = fieldValue;
				}
				else {
					if(fieldValue < potNextDist) {
						potNext = rect;
						potNextDist = fieldValue;
					}
				}
			}
		}
		if(potNext != null) {
			this.nextRect = potNext;
			this.offsetX = game.getSelectedScene().getTransform().getX();
			this.offsetY =  game.getSelectedScene().getTransform().getY();
		}
	}
	
    public float getDistance() {
        float xDist = (float) (this.target.getLocation().getX() - this.getParent().getCenterLocation().getX());
        float yDist = (float) (this.target.getLocation().getY() - this.getParent().getCenterLocation().getY());

        return (float) Math.sqrt((xDist * xDist) + (yDist * yDist));
    }
	
	private void move() {
		double rAngle = Math.toRadians(this.getParent().getRotation());
		float x = (float) (speed * Math.cos(rAngle));
        float y = (float) (speed * Math.sin(rAngle));
        this.getParent().getLocation().addX(x);
        this.getParent().getLocation().addY(y);
	}
		
	private void rotateAt(Vector2 dest) {
		double oX = this.getParent().getLocation().getX() + (this.getParent().getSize().getX() / 2);
        double oY = this.getParent().getLocation().getY() + (this.getParent().getSize().getY() / 2);
        float rAngel = (float) Math.atan2(dest.getY() - oY, dest.getX() - oX);
        this.getParent().setRotation(Math.toDegrees(rAngel));
	}
	
	public GameElement getTarget() {
		return target;
	}


	public void setTarget(GameElement target) {
		this.target = target;
	}


	public boolean isFollowTarget() {
		return followTarget;
	}


	public void setFollowTarget(boolean followTarget) {
		this.followTarget = followTarget;
	}


	public float getMinDist() {
		return minDist;
	}


	public void setMinDist(float minDist) {
		this.minDist = minDist;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public BoxCollider getCollider() {
		return collider;
	}


	public void setCollider(BoxCollider collider) {
		this.collider = collider;
	}
	
	public void enableCollisionDetection(String layerName) {
		this.collisionLayer = layerName;
		this.checkCollision = true;
	}


	public boolean isCheckCollision() {
		return checkCollision;
	}


	public void setCheckCollision(boolean checkCollision) {
		this.checkCollision = checkCollision;
	}


	public String getCollisionLayer() {
		return collisionLayer;
	}


	public void setCollisionLayer(String collisionLayer) {
		this.collisionLayer = collisionLayer;
	}
	
}
