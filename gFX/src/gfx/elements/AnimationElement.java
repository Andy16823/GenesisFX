package gfx.elements;

import java.util.Optional;

import gfx.Game;
import gfx.GameBehavior;
import gfx.RenderTarget;
import gfx.behaviors.AnimationBehavior;
import gfx.graphics.Animation;
import gfx.graphics.TextureAtlas;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class AnimationElement extends Sprite {
	private Image sprite;
	private Animation animation;
	private AnimationBehavior animationBehavior;
	private boolean loop = false;
	private boolean autoDisable = true;
	private boolean lastFrameSet = false;
	private int lastFrame = 0;
	private long disapearTime = 20000;
	private long creationTime;
	
	public AnimationElement(String name, Vector2 location, Vector2 size, Animation animation, long frameTime) {
		super(name, location, size, null);
		this.setName(name);
		this.setLocation(location);
		this.setSize(size);
		this.sprite = null;
		this.animation = animation;
		this.animationBehavior = (AnimationBehavior) this.addBehavior(new AnimationBehavior(frameTime));
		this.animationBehavior.addAnimation(animation);
		this.animationBehavior.playAnimation(animation);
		this.creationTime = System.currentTimeMillis();
	}
		
	@Override
	public void render(Game game, GraphicsContext g) {
		// TODO Auto-generated method stub
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.beforeRender(g);
		}
		g.save();
		Rotate rotate = new Rotate(this.getRotation(), this.getCenterLocation().getX(), this.getCenterLocation().getY());
		g.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(), rotate.getTx(), rotate.getTy());
		g.drawImage(sprite, this.getLocation().getX(), this.getLocation().getY(), this.getSize().getX(), this.getSize().getY());
		g.restore();	
		for(GameBehavior behavior : this.getBehaviors()) {
			behavior.afterRender(g);
		}
	}

	@Override
	public void update(Game game,RenderTarget target) {
		// TODO Auto-generated method stub
		super.update(game, target);
		if(this.animationBehavior.getPlayCount() > 0) {
			if(!this.loop) {
				if(!this.lastFrameSet) {
					this.sprite = this.animation.getFrame(this.lastFrame);
					this.lastFrameSet = true;
				}
				if(this.autoDisable) {
					if(game.getTimer().getCurrentFrame() > this.creationTime + this.disapearTime) {
						this.setEnabled(false);
					}
				}
				return;
			}
		}
		this.animationBehavior.setFrame();
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

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public AnimationBehavior getAnimationBehavior() {
		return animationBehavior;
	}

	public void setAnimationBehavior(AnimationBehavior animationBehavior) {
		this.animationBehavior = animationBehavior;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public boolean isAutoDisable() {
		return autoDisable;
	}

	public void setAutoDisable(boolean autoDisable) {
		this.autoDisable = autoDisable;
	}

	public int getLastFrame() {
		return lastFrame;
	}

	public void setLastFrame(int lastFrame) {
		this.lastFrame = lastFrame;
	}

	public long getDisapearTime() {
		return disapearTime;
	}

	public void setDisapearTime(long disapearTime) {
		this.disapearTime = disapearTime;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public boolean isLastFrameSet() {
		return lastFrameSet;
	}
	
}
