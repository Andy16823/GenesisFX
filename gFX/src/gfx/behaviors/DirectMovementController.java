package gfx.behaviors;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class DirectMovementController extends GameBehavior {
    private Vector2 destination;
    private boolean moveDestination = true;
    private boolean renderDestination = false;

    public DirectMovementController(boolean moveDestination, boolean renderDestination) {
        super();
        this.moveDestination = moveDestination;
        this.renderDestination = renderDestination;
    }

    public DirectMovementController() {

    }

    /**
     * move the gameelement in direction of the destination, with speed n
     * @param speed the speed value
     */
    public void move(double speed) {
        // Rotate
    	double oX = this.getParent().getLocation().getX() + (this.getParent().getSize().getX() / 2);
    	double oY = this.getParent().getLocation().getY() + (this.getParent().getSize().getY() / 2);
        float rAngel = (float) Math.atan2(destination.getY() - oY, destination.getX() - oX);
        this.getParent().setRotation(Math.toDegrees(rAngel));

        // Moving
        float x = (float) (speed * Math.cos(rAngel));
        float y = (float) (speed * Math.sin(rAngel));
        this.getParent().getLocation().addX(x);
        this.getParent().getLocation().addY(y);
        
        if(this.moveDestination) {
            this.destination.addX(-x);
            this.destination.addY(-y);
        }
    }
    
    public void setDestination(Vector2 dest) {
        this.destination = dest;
    }
    
    public void rotateAt() {
        double oX = this.getParent().getLocation().getX() + (this.getParent().getSize().getX() / 2);
        double oY = this.getParent().getLocation().getY() + (this.getParent().getSize().getY() / 2);
        float rAngel = (float) Math.atan2(destination.getY() - oY, destination.getX() - oX);
        this.getParent().setRotation(Math.toDegrees(rAngel));
    }
    
    public float getDistance() {
        float xDist = (float) (this.destination.getX() - (this.getParent().getLocation().getX() + this.getParent().getSize().getX() / 2));
        float yDist = (float) (this.destination.getY() - (this.getParent().getLocation().getY() + this.getParent().getSize().getY() / 2));

        return (float) Math.sqrt((xDist * xDist) + (yDist * yDist));
    }
    
    public boolean hasDestination() {
        if(this.destination != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void clearDestination() {
    	this.destination = null;
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
        if(this.renderDestination) {
            if(this.destination != null) {
            	g.strokeOval(this.destination.getX() - 20, this.destination.getY() - 20, 40, 40);
            }
        }
	}

	@Override
	public void onAttach(GameElement element) {
		// TODO Auto-generated method stub
		
	}

}
