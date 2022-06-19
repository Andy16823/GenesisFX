package gfx.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class TextureAtlas {
	private String name;
	private int cellsX;
	private int cellsY;
	private int cellWidth;
	private int cellHeight;
	private Image texture;
	
	public TextureAtlas(String name, int cellsX, int cellsY, int cellSize, Image texture) {
		this.cellsX = cellsX;
		this.cellsY = cellsY;
		this.cellWidth = cellSize;
		this.cellHeight = cellSize;
		this.name = name;
		this.texture = texture;
	}
	
	public TextureAtlas(String name, int cellWidth, int cellHeight, Image texture) {
		this.cellsX = (int) (texture.getWidth() / cellWidth);
		this.cellsY = (int) (texture.getHeight() / cellHeight);
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
		this.name = name;
		this.texture = texture;
	}
	
	public TextureAtlas(String name, int cellSize, Image texture) {
		this.cellsX = (int) (texture.getWidth() / cellSize);
		this.cellsY = (int) (texture.getHeight() / cellSize);
		this.cellWidth = cellSize;
		this.cellHeight = cellSize;
		this.name = name;
		this.texture = texture;
	}
	
	public Image getTile(int x, int y) {
		PixelReader reader = texture.getPixelReader();
        WritableImage image = new WritableImage(reader, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
        return image;
	}
}
