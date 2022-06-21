package gfx.graphics;

import java.util.Vector;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animation {
	private String name;
	private TextureAtlas animationSheet;
	private int startX;
	private int startY;
	private int frames;
	private Vector<Image> frameVector;
	
	public Animation(String name, int startX, int startY, int frames, TextureAtlas animationSheet) {
		this.name = name;
		this.startX = startX;
		this.startY = startY;
		this.frames = frames;
		this.animationSheet = animationSheet;
		this.frameVector = new Vector<>();
		for(int i = startX; i <= frames; i++) {
			frameVector.add(animationSheet.getTile(i, startY));
		}
		System.out.println(this.frameVector.size());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TextureAtlas getAnimationSheet() {
		return animationSheet;
	}

	public void setAnimationSheet(TextureAtlas animationSheet) {
		this.animationSheet = animationSheet;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}
	
	public Image getFrame(int i) {
		return this.frameVector.get(i);
	}
	
	public static Image createAnimationSheet(Vector<Image> images, double width, double height) {
		gfx.graphics.gfxImage image = new gfxImage((int)(images.size() * width), (int) height);
		GraphicsContext g = image.getGraphicsContex();
		int i = 0;
		for(var item : images) {
			g.drawImage(item, i * width, height, width, height);
			i++;
		}
		image.flush();
		return image;
	}
	
}
