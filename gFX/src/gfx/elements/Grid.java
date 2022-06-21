package gfx.elements;

import java.util.Vector;

import gfx.Game;
import gfx.GameElement;
import gfx.RenderTarget;
import gfx.Toolkit;
import gfx.math.Vector2;
import javafx.scene.canvas.GraphicsContext;

public class Grid extends GameElement {
	private int cellsX;
	private int cellsY;
	private int cellWidth;
	private int cellHeight;
	private Vector<gfx.math.Rect> matrix;
	private boolean renderGrid;
	
	
	public Grid(String name, int cellsX, int cellsY, int cellWidth, int cellHeight) {
		super();
		this.setLocation(Vector2.zero());
		this.setName(name);
		this.cellsX = cellsX;
		this.cellsY = cellsY;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
		this.createMatrix();
	}

	@Override
	public void render(GraphicsContext g) {
		// TODO Auto-generated method stub
		if(this.renderGrid) {
			for(var rect : this.matrix) {
				double x = rect.getX() + this.getLocation().getX();
				double y = rect.getY() + this.getLocation().getY();
				if(Toolkit.isVisible(x + rect.getWidth(), y + rect.getHeight(), rect.getWidth(), rect.getHeight(), g.getCanvas().getWidth() + (rect.getWidth() *2 ), g.getCanvas().getHeight() + (rect.getHeight() * 2))) {
					g.strokeRect(x, y, rect.getWidth(), rect.getHeight());	
				}
			}
		}
	}

	@Override
	public void update(Game game, RenderTarget target) {
		// TODO Auto-generated method stub
	}
	
	public void createMatrix() {
		this.matrix = new Vector<>();
		for(int y = 0; y < this.cellsY; y++) {
			for(int x = 0; x < this.cellsX; x++) {
				this.matrix.add(new gfx.math.Rect(x * cellWidth, y * cellHeight, cellWidth, cellHeight));
			}
		}
	}
	
	public gfx.math.Rect getRect(double x, double y) {
		for(var rect : this.matrix) {
			double offsetX = rect.getX() + this.getLocation().getX();
			double offsetY = rect.getY() + this.getLocation().getY();
			
			if(rect.contains(offsetX, offsetY, x, y)) {
				var rect2 = new gfx.math.Rect(offsetX, offsetY, rect.getWidth(), rect.getHeight());
				return rect2;
			}
		}
		return null;
	}

	public int getCellsX() {
		return cellsX;
	}

	public void setCellsX(int cellsX) {
		this.cellsX = cellsX;
	}

	public int getCellsY() {
		return cellsY;
	}

	public void setCellsY(int cellsY) {
		this.cellsY = cellsY;
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}

	public int getCellHeight() {
		return cellHeight;
	}

	public void setCellHeight(int cellHeight) {
		this.cellHeight = cellHeight;
	}

	public Vector<gfx.math.Rect> getMatrix() {
		return matrix;
	}

	public void setMatrix(Vector<gfx.math.Rect> matrix) {
		this.matrix = matrix;
	}

	public boolean isRenderGrid() {
		return renderGrid;
	}

	public void setRenderGrid(boolean renderGrid) {
		this.renderGrid = renderGrid;
	}
	
}
