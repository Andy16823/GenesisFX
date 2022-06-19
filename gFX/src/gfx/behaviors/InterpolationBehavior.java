package gfx.behaviors;

import gfx.Game;
import gfx.GameBehavior;
import gfx.GameElement;
import gfx.RenderTarget;
import javafx.scene.canvas.GraphicsContext;

public class InterpolationBehavior extends GameBehavior{
	private GameElement elementToFollow;
	private double power = 0.25;
	private boolean follow = false;
	private Game game;
	
	@Override
	public void onInit(Game game) {
		// TODO Auto-generated method stub
		this.game = game;
	}

	@Override
	public void onUpdate(RenderTarget renderTarget) {
		// TODO Auto-generated method stub
		System.out.println("here");
		if(this.elementToFollow != null) {
			if(this.follow) {
				this.rotateAt();
				double newX = this.getParent().getCenterLocation().getX() + (this.elementToFollow.getCenterLocation().getX() - this.getParent().getCenterLocation().getX()) * power;
				double newY = this.getParent().getCenterLocation().getY() + (this.elementToFollow.getCenterLocation().getY() - this.getParent().getCenterLocation().getY()) * power;
				this.getParent().getLocation().setX(newX);
				this.getParent().getLocation().setY(newY);
			}
		}
	}
	
	public void rotateAt() {
        double oX = this.getParent().getCenterLocation().getX();
        double oY = this.getParent().getCenterLocation().getY();
        float rAngel = (float) Math.atan2(this.elementToFollow.getCenterLocation().getY() - oY, this.elementToFollow.getCenterLocation().getX() - oX);
        this.getParent().setRotation(Math.toDegrees(rAngel));
    }

	@Override
	public void beforeRender(GraphicsContext g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRender(GraphicsContext g) {
		// TODO Auto-generated method stub
		
	}

	public GameElement getElementToFollow() {
		return elementToFollow;
	}

	public void setElementToFollow(GameElement elementToFollow) {
		this.elementToFollow = elementToFollow;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	

}
