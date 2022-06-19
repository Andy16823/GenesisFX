package gfx.math;

public class Mesh {
	private int cellsX;
	private int cellsY;
	private double cellWidth;
	private double cellHeight;
	
	public Mesh(int cellsX, int cellsY, double cellWidth, double cellHeight) {
		super();
		this.cellsX = cellsX;
		this.cellsY = cellsY;
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
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

	public double getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(double cellWidth) {
		this.cellWidth = cellWidth;
	}

	public double getCellHeight() {
		return cellHeight;
	}

	public void setCellHeight(double cellHeight) {
		this.cellHeight = cellHeight;
	}
	
}
