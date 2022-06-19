package gfx.behaviors;

import java.awt.Toolkit;
import java.util.Vector;

import gfx.Game;
import gfx.GameBehavior;
import gfx.RenderTarget;
import gfx.elements.Sprite;
import gfx.graphics.Animation;
import gfx.graphics.TextureAtlas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimationBehavior extends GameBehavior {
	private Vector<Animation> animations;
	private Animation currentAnimation;
	private int currentFrame;
	private long lastFrame;
	private long frameTime;
	
	public AnimationBehavior(long frameTime) {
		this.animations = new Vector<>();
		this.frameTime = frameTime;
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

	}
	
	public void addAnimation(Animation animation) {
		this.animations.add(animation);
	}
	
	public void setFrame() {
		Sprite sprite = (Sprite) this.getParent();
		sprite.setSprite(this.nextFrame());
	}
	
	public Image nextFrame() {
		long now = System.currentTimeMillis();
		if(now > this.lastFrame + frameTime) {
			if(this.currentAnimation != null) {
				TextureAtlas tileSet = this.currentAnimation.getAnimationSheet();
				this.currentFrame++;
				if(this.currentFrame > this.currentAnimation.getFrames()) {
					this.currentFrame = 0;
				}
				this.lastFrame = now;
				Image nextImg = tileSet.getTile(this.currentAnimation.getStartX() + currentFrame, this.currentAnimation.getStartY());
				return nextImg;
			}			
		}
		return null;
	}
	
	public void playAnimation(String name) {
		this.currentAnimation = this.getAnimation(name);	
		if(this.currentAnimation != null && !this.currentAnimation.getName().equals(name)) {
			this.currentFrame = 0;
			this.lastFrame = System.currentTimeMillis();
		}
	}
	
	public Animation getAnimation(String name) {
		for(Animation animation : this.animations) {
			if(animation.getName().equals(name)) {
				return animation;
			}
		}
		return null;
	}

}
