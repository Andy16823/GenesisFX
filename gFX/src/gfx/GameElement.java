package gfx;

import java.util.Vector;

import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameElement {
    private String name;
    private String tag;
    private Vector2 location;
    private Vector2 size;
    private boolean enabled = true;
    private Vector<GameBehavior> behaviors;
    private double rotation;

    public abstract void render(GraphicsContext g);
    public abstract void update(RenderTarget target);
    
    public GameElement() {
    	this.behaviors = new Vector<>();
    }
    
    public void init(Game game) {
    	for(GameBehavior behavior : this.behaviors) {
    		behavior.onInit(game);
    	}
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Vector2 getLocation() {
        return location;
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public Vector2 getCenterLocation() {
    	double x = this.getLocation().getX() + (this.getSize().getX() / 2);
    	double y = this.getLocation().getY() + (this.getSize().getY() / 2);
    	return new Vector2(x,y);
    }
    
    public void addBehavior(GameBehavior behavior) {
    	this.behaviors.add(behavior);
    	behavior.setParent(this);
    }
    
    public GameBehavior getBehavior(String className) {
    	for(GameBehavior behavior : this.behaviors) {
    		if(behavior.getClass().getName().equals(className)) {
    			return behavior;
    		}
    	}
    	return null;
    }
    
    public GameBehavior getBehavior2(String reference) {
    	for(GameBehavior behavior : this.behaviors) {
    		if(behavior.getClass().getSuperclass().getSimpleName().equals(reference)) {
    			return behavior;
    		}
    	}
    	return null;
    }
    
	public Vector<GameBehavior> getBehaviors() {
		return behaviors;
	}
	
	public void setBehaviors(Vector<GameBehavior> behaviors) {
		this.behaviors = behaviors;
	}
	
	public double getRotation() {
		return rotation;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
}
