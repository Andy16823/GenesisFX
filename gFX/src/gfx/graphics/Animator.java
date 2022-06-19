package gfx.graphics;

import java.util.Vector;

import javafx.scene.image.Image;

public class Animator {
	private Vector<Animation> animations;
	private Animation currentAnimation;
	private int currentFrame;
	private long lastFrame;
	private long frameTime;
	
	public Animator(long frameTime) {
		this.animations = new Vector<>();
		this.frameTime = frameTime;
	}
	
	public void addAnimation(Animation animation) {
		this.animations.add(animation);
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
